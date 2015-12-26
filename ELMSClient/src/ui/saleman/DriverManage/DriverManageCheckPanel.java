package ui.saleman.DriverManage;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.CheckDocPanel;
import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPictureButton;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.ResultMessage;
import blservice.DTManageblservice.DTManageblservice;

/**
 * 司机信息查看界面
 * 
 * @author czq
 * @version 2015年12月8日 下午8:18:26
 */
@SuppressWarnings("serial")
public class DriverManageCheckPanel extends CheckDocPanel {
	private DTManageblservice bl;

	/**
	 * 查找方式
	 */
	private MyComboBox searchWay ;
	private MyPictureButton delete;
	private MyPictureButton modify;
	
	
	
	private enum searchWays {
		name, id, instid
	};

	private MyLabel title;
	private DriverMesPanel myTable;
	private DriverManageAddPanel myAddPanel;

	public DriverManageCheckPanel(Element config, JPanel changePanel,
			String checkDocName, String addDocName,
			DTManageblservice dtManageblservice) {
		super(config, changePanel, checkDocName, addDocName);
		this.bl = dtManageblservice;
		myTable = (DriverMesPanel) messageTable;
		// 注意必须先传bl然后才能初始化table，否则将报空指针异常
		myTable.bl = this.bl;
		myAddPanel = (DriverManageAddPanel) addDocPanel;
		myAddPanel.bl = this.bl;
		initTableContent();
	}

	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		messageTable = new DriverMesPanel(e.element(tableStr));
		addDocPanel = new DriverManageAddPanel(e.element(addDocPanelStr),
				changePanel, checkDocPanelStr, messageTable);

	}

	@Override
	protected void initialDifferComp(Element e) {
		searchWay = new MyComboBox(e.element("searchWay"));
		title = new MyLabel(e.element("title"));
		delete=new MyPictureButton(e.element("delete"));
		modify=new MyPictureButton(e.element("modify"));
		
	}

	@Override
	protected void addListener() {
		addDoc.addMouseListener(new MyPictureButtonListener(addDoc) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				jumpToADD();
			}
		});
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					mySearch();
				}

			}
		});

		search.addMouseListener(new MyPictureButtonListener(search) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				mySearch();
			}
		});

		delete.addMouseListener(new MyPictureButtonListener(delete){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(myTable.getSelectedRow() == -1){
					new TipsDialog("请选择一条信息", Color.GREEN);
				}
				
				result = 
						bl.delDriver((String) myTable.getValueAt(myTable.getSelectedRow(), 0));
						
						if (result == ResultMessage.SUCCESS) {
							new TipsDialog("删除成功" , Color.green);
							myTable.removeRow(myTable.getSelectedRow());
						}else{
							new TipsDialog("数据库或网络故障");
						}
				
			}
			
			
		});
		modify.addMouseListener(new MyPictureButtonListener(modify){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(myTable.getSelectedRow() == -1){
					new TipsDialog("请选择一条数据", Color.GREEN);
					return;
				}
				
				addDocPanel.setAddOrModify(false, (String) myTable.getValueAt(myTable.getSelectedRow(), 0));
				panelManager.show(changePanel, addDocPanelStr);
			}

		});
	}

	@Override
	protected void addDifferComp() {
		add(searchWay);
		add(title);
		add(delete);
		add(modify);
		
		datePicker.setVisible(false);
	}

	private void mySearch() {
		if (searchWay.getSelectedIndex() == 0) {
			new TipsDialog("请选择查找方式");
			return;
		}
		if (getWays() == searchWays.id) {
			if (UserfulMethod.dealWithData(new SimpleDataFormat(searchBox
					.getMyText(), DataType.ID, "ID"))) {
				messageTable.searchID(searchBox.getMyText());
			}
		} else if (getWays() == searchWays.instid) {
			if (UserfulMethod.dealWithData(new SimpleDataFormat(searchBox
					.getMyText(), DataType.ID, "机构ID"))) {
				myTable.searchInstID(searchBox.getMyText());
			}
		} else {
			myTable.searchName(searchBox.getMyText());
		}
	}

	private searchWays getWays() {
		switch ((String) searchWay.getSelectedItem()) {
		case "按ID查找":

			return searchWays.id;
		case "按机构ID查找":

			return searchWays.instid;
		case "按姓名查找":

			return searchWays.name;
		default:
			System.err.println("查找方式输入错误！！！");
			return searchWays.id;
		}

	}

}
