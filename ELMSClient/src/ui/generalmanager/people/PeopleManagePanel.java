package ui.generalmanager.people;

import java.awt.CardLayout;

import org.dom4j.Element;

import blservice.personnelblservice.Personnelblservice;
import ui.table.MyTable;
import ui.tools.MyPanel;

/**
 * 人员管理，主要进入人员查看界面
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class PeopleManagePanel extends MyPanel{
	
	private CardLayout panelManager;
	
	private Personnelblservice bl;
	
	private MyTable peopleMesTable;
	/**
	 * 增加人员界面
	 */
	private AddPeoplePanel addpeople;
	
	public PeopleManagePanel(Element config , CardLayout panelManager ,Personnelblservice bl) {
		super(config);
		this.bl = bl;
		this.panelManager = panelManager;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLables(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		addpeople = new AddPeoplePanel(e.element("addPeople"), panelManager);
		
	}
	
//	private void initTable(){
//		columnName
//		
//		
//		
//	}
	

	@Override
	protected void addCompoment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

}
