package ui.generalmanager.institution;

import java.awt.CardLayout;

import org.dom4j.Element;

import blservice.personnelblservice.Personnelblservice;
import ui.tools.MyPanel;

/**
 * 机构管理
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class InstManagePanel extends MyPanel{
	
	private InstTablePanel table;
	
	private CardLayout panelManager;
	
	private Personnelblservice bl;
	
	private final static String AddInstStr = "ADD_INST";
	
	public InstManagePanel(Element config , CardLayout panelManager , Personnelblservice bl) {
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

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

}
