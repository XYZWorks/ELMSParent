package ui.generalmanager.people;

import java.awt.CardLayout;

import org.dom4j.Element;

import blservice.personnelblservice.Personnelblservice;
import ui.table.MyTable;
import ui.tools.MyComboBox;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CompomentType;

/**
 * 人员管理，主要进入人员查看界面
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class PeopleManagePanel extends MyPanel{
	
	
	private MyPictureButton search;
	private MyTextField searchT;
	private MyComboBox searchway;
	
	private CardLayout panelManager;
	
	private Personnelblservice bl;
	
	private PeopleMesPanel peopleMesTable;
	/**
	 * 增加人员界面
	 */
	private AddPeoplePanel addpeople;
	
	public PeopleManagePanel(Element config , CardLayout panelManager ,Personnelblservice bl) {
		super(config);
		this.bl = bl;
		this.panelManager = panelManager;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLables(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		repaint();
		
		addpeople.setVisible(false);
		
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initButtons(Element e) {
		search = new MyPictureButton(e.element("search"));
		
	}

	@Override
	protected void initTextFields(Element e) {
		searchT = new MyTextField(e.element("search"));
		
	}

	@Override
	protected void initLables(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		searchway = new MyComboBox(e.element("search"));
		addpeople = new AddPeoplePanel(e.element("addPeople"), panelManager);
		peopleMesTable = new PeopleMesPanel(e.element("peopleMes"), bl);
	}
	
//	private void initTable(){
//		columnName
//		
//		
//		
//	}
	

	@Override
	protected void addCompoment() {
		add(addpeople);
		add(peopleMesTable);
		
		add(search);
		add(searchT);
		add(searchway);
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
