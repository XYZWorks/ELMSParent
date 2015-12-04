package ui.generalmanager;

import java.awt.CardLayout;

import org.dom4j.Element;

import blservice.personnelblservice.Personnelblservice;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addCompoment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}

}
