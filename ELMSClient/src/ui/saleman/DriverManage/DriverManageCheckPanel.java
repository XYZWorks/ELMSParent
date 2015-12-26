package ui.saleman.DriverManage;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import blservice.DTManageblservice.DTManageblservice;
import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.CheckDocPanel;
import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPictureButton;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;

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
	/**
	 * 确认修改的按钮 如果点击确认修改 则更新所有改动数据
	 */
	private MyPictureButton confirm;

	/**
	 * 取消修改的按钮 如果点击取消 则撤销本次的所有改动
	 */
	private MyPictureButton cancel;
	
	
	
	
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
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		
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
		
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				// TODO 重新读取数据

			}
		});

		confirm.addMouseListener(new ConfirmListener(confirm) {

			@Override
			protected boolean saveToSQL() {
	     	//TODO
				return true;
			}

			@Override
			protected boolean checkDataValid() {
				return true;
			}

			@Override
			protected void reInitial() {
			}

			@Override
			protected void updateMes() {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	protected void addDifferComp() {
		add(searchWay);
		add(title);
		add(delete);
		add(modify);
		add(confirm);
		add(cancel);
		
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
