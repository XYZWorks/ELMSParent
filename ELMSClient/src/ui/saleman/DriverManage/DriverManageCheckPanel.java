package ui.saleman.DriverManage;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.CheckDocPanel;
import ui.tools.MyComboBox;
import blservice.DTManageblservice.DTManageblservice;
 /** 
 * 司机信息查看界面
 * @author czq 
 * @version 2015年12月8日 下午8:18:26 
 */
@SuppressWarnings("serial")
public class DriverManageCheckPanel extends CheckDocPanel{
DTManageblservice bl;
	
	/**
	 * 查找方式
	 */
	MyComboBox searchWay;
	
	DriverMesPanel myTable;
	public DriverManageCheckPanel(Element config, JPanel changePanel , String checkDocName , String addDocName, DTManageblservice dtManageblservice) {
		super(config, changePanel , checkDocName , addDocName);
		this.bl = dtManageblservice;
		myTable = (DriverMesPanel) messageTable;
		//注意必须先传bl然后才能初始化table，否则将报空指针异常
		myTable.bl = bl;
		initTableContent();
	}

	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		messageTable = new DriverMesPanel(e.element(tableStr));
		addDocPanel = new DriverManageAddPanel(e.element(addDocPanelStr), changePanel , checkDocPanelStr, messageTable, bl);
		
	}

	@Override
	protected void initialDifferComp(Element e) {
		searchWay = new MyComboBox(e.element("searchWay"));
		
	}


	@Override
	protected void addListener() {
		super.addListener();		
	}

	@Override
	protected void addDifferComp() {
		add(searchWay);
		
	}

}
