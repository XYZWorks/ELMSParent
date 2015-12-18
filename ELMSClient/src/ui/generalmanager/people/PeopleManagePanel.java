package ui.generalmanager.people;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import blservice.personnelblservice.Personnelblservice;
import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.table.MyTable;
import ui.tools.MyComboBox;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;

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
	
	private MyPictureButton addButton;
	
	public PeopleManagePanel(Element config , CardLayout panelManager ,Personnelblservice bl) {
		super(config);
		this.bl = bl;
		this.panelManager = panelManager;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		repaint();
		
		addpeople.setVisible(false);
		
		setVisible(true);
	}

	@Override
	protected void initButtons(Element e) {
		search = new MyPictureButton(e.element("search"));
		addButton = new MyPictureButton(e.element("add"));
	}

	@Override
	protected void initTextFields(Element e) {
		searchT = new MyTextField(e.element("search"));
		
	}

	@Override
	protected void initLabels(Element e) {
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		searchway = new MyComboBox(e.element("search"));
		addpeople = new AddPeoplePanel(e.element("addPeople"), this, bl);
		peopleMesTable = new PeopleMesPanel(e.element("peopleMes"), bl);
	}
	
	

	@Override
	protected void addCompoment() {
		add(addpeople);
		add(peopleMesTable);
		
		add(search);
		add(searchT);
		add(searchway);
		add(addButton);
	}

	@Override
	protected void addListener() {
		search.addMouseListener(new MySearchListener(search));
		addButton.addMouseListener(new MyAddButtonListener(addButton));
	}

	@Override
	protected void initWhitePanels(Element e) {
		
	}
	
	void changeADDPanel( boolean flag){
		addpeople.setVisible(flag);
		
		addButton.setVisible(!flag);
		search.setVisible(!flag);
		searchT.setVisible(!flag);
		searchway.setVisible(!flag);
		peopleMesTable.setVisible(!flag);
		
		peopleMesTable.myInit();
	}
	
	class MyAddButtonListener extends MyPictureButtonListener{

		public MyAddButtonListener(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent   e) {
			super.mouseClicked(e);
			
			changeADDPanel(true);
		}
		
		
	}
	
	
	
	class MySearchListener extends MyPictureButtonListener{

		public MySearchListener(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
			String input = searchT.getText();
			
			String temp = (String) searchway.getSelectedItem();
			if(temp.equals("按姓名查找")){
				
				checkByName(input);
			}else if(temp.equals("按ID查找")){
				if(UserfulMethod.dealWithData( new SimpleDataFormat(input, DataType.ID, "ID"))){
					checkByID(input);
				
			}else{
				if(UserfulMethod.dealWithData( new SimpleDataFormat(input, DataType.ID, "ID"))){
					checkByInst(input);
				}	
			}
			
			
		}
		
		
		
	}
	
	private void checkByID(String ID){
		peopleMesTable.changeMes(bl.getPeopleByID(ID));;
	}
	private void checkByInst(String ID) {
		peopleMesTable.changeMes(bl.getPeopleByInst(ID));
	}
	private void checkByName(String name) {
		peopleMesTable.changeMes(bl.getPeopleByName(name));
	}
}
}
