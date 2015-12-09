package ui.saleman.CarManage;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import blservice.DTManageblservice.DTManageblservice;
import ui.tools.CheckDocPanel;
import ui.tools.MyComboBox;
import ui.tools.MySearchBox;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
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
	
	CarMesTable myTable;
	
	public CarManageCheckPanel(Element config, JPanel changePanel, String checkDocName , String addDocName, DTManageblservice dtManageblservice) {
		super(config, changePanel , checkDocName , addDocName);
		this.bl = dtManageblservice;
		myTable = (CarMesTable) messageTable;
		//注意必须先传bl然后才能初始化table，否则将报空指针异常
		myTable.bl = bl;
		initTableContent();
	}

	

	
	@Override
	protected void addListener() {
		super.addListener();
		search.addMouseListener(new MyPictureButtonListener(search){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(searchWay.getSelectedIndex() == 0){
					new TipsDialog("請選擇查找方式");
					return;
				}
				
				
				//TODO searchbox數據檢查
				
				
				String type = (String) searchWay.getSelectedItem();
				if(type.equals("ID")){
					myTable.checkByIDOrPlate(searchBox.getMyText(), 0);
				}else{
					myTable.checkByIDOrPlate(searchBox.getMyText(), 1);
				}
			}
		});
		
		
	}
	
	
	
	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		messageTable = new CarMesTable(e.element(tableStr), bl);
		addDocPanel = new CarManageAddPanel(e.element(addDocPanelStr), changePanel , checkDocPanelStr, messageTable);
		
	}
	@Override
	protected void initialDifferComp(Element e) {
		searchWay = new MyComboBox(e.element("searchWay"));
		
	}

	@Override
	protected void addDifferComp() {
		add(searchWay);
	}

	

}
