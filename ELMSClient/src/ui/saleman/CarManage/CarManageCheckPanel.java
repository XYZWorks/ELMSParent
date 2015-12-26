package ui.saleman.CarManage;

import java.awt.Color;
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
 * 车辆信息管理查看界面
 * @author czq 
 * @version 2015年12月8日 下午8:15:22 
 */
@SuppressWarnings("serial")
public class CarManageCheckPanel extends CheckDocPanel{
	DTManageblservice bl;
	
	/**
	 * 查找方式
	 */
	MyComboBox searchWay;
	private MyLabel title;
	private MyPictureButton delete;
	private MyPictureButton modify;
	
	CarMesTable myTable;
	CarManageAddPanel myAddPanel;
	
	public CarManageCheckPanel(Element config, JPanel changePanel, String checkDocName , String addDocName, DTManageblservice dtManageblservice) {
		super(config, changePanel , checkDocName , addDocName);
		this.bl = dtManageblservice;
		myTable = (CarMesTable) messageTable;
		//注意必须先传bl然后才能初始化table，否则将报空指针异常
		myTable.bl = bl;
		myAddPanel = (CarManageAddPanel) addDocPanel;
		myAddPanel.bl = this.bl;
		
		initTableContent();
	}

	

	
	@Override
	protected void addListener() {
		super.addListener();
		delete.addMouseListener(new MyPictureButtonListener(delete){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(myTable.getSelectedRow() == -1){
					new TipsDialog("请选择一条信息", Color.GREEN);
				}
				
				result = 
						bl.delCar((String) myTable.getValueAt(myTable.getSelectedRow(), 0));
						
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
	public void mySearch() {
		if(searchWay.getSelectedIndex() == 0){
			new TipsDialog("請選擇查找方式");
			return;
		}
		
		String type = (String) searchWay.getSelectedItem();
		String text = searchBox.getMyText();
		
		if(type.equals("ID")){
			if(UserfulMethod.dealWithData(new SimpleDataFormat(text, DataType.ID, "ID"))){
				myTable.searchID(text);
			}
		}else{
			if(UserfulMethod.dealWithData(new SimpleDataFormat(text, DataType.PlateNum, "车牌号"))){
				myTable.searchPlateNum(text);
			}
			
		}
		
	}
	
	
	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		messageTable = new CarMesTable(e.element(tableStr), bl);
		addDocPanel = new CarManageAddPanel(e.element(addDocPanelStr), changePanel , checkDocPanelStr, messageTable ,bl);
		
	}
	@Override
	protected void initialDifferComp(Element e) {
		searchWay = new MyComboBox(e.element("searchWay"));
		title = new MyLabel(e.element("title"));
		delete=new MyPictureButton(e.element("delete"));
		modify=new MyPictureButton(e.element("modify"));
	}

	@Override
	protected void addDifferComp() {
		add(searchWay);
		add(title);
		add(delete);
		add(modify);
		datePicker.setVisible(false);
	}

	

}
