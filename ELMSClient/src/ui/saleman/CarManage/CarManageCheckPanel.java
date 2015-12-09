package ui.saleman.CarManage;

import javax.swing.JPanel;

import org.dom4j.Element;

import blservice.DTManageblservice.DTManageblservice;
import ui.tools.CheckDocPanel;
 /** 
 * 车辆信息管理查看界面
 * @author czq 
 * @version 2015年12月8日 下午8:15:22 
 */
@SuppressWarnings("serial")
public class CarManageCheckPanel extends CheckDocPanel{

	public CarManageCheckPanel(Element config, JPanel changePanel, String checkDocName , String addDocName, DTManageblservice dtManageblservice) {
		super(config, changePanel , checkDocName , addDocName);

	}

	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		messageTable = new CarMesTable(e.element(tableStr));
		addDocPanel = new CarManageAddPanel(e.element(addDocPanelStr), changePanel , checkDocPanelStr, messageTable);
		
	}

	
	@Override
	protected void addListener() {
		super.addListener();
		
		
		
	}

	@Override
	protected void initialDifferComp(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addDifferComp() {
		// TODO Auto-generated method stub
		
	}

}
