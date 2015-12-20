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
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MySearchBox;
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

	private MyComboBox searchway;
	private MySearchBox searchBox;
	
	private MyPictureButton search;
	private MyPictureButton add;
	private MyPictureButton modify;
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	private MyPictureButton delete;
	
	private MyLabel title;
	
	private boolean isModify = false;
	
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
		add = new MyPictureButton(e.element("add"));
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		modify = new MyPictureButton(e.element("modify"));
		delete = new MyPictureButton(e.element("delete"));
	}

	@Override
	protected void initTextFields(Element e) {
//		search = new MyTextField(e.element("search"));
		
	}

	@Override
	protected void initLabels(Element e) {
		title = new MyLabel(e.element("title"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		searchway = new MyComboBox(e.element("search"));
		addpeople = new AddPeoplePanel(e.element("addPeople"), this, bl);
		peopleMesTable = new PeopleMesPanel(e.element("peopleMes"), bl);
		searchBox = new MySearchBox(e.element("searchBox"));
	}
	
	

	@Override
	protected void addCompoment() {
		add(addpeople);
		add(peopleMesTable);
//		add(title);
		add(search);
		add(searchBox);
		add(searchway);
		add(add);
		add(modify);
		add(delete);
		add(confirm);
		add(cancel);
	}

	@Override
	protected void addListener() {
		search.addMouseListener(new MySearchListener(search));
		add.addMouseListener(new MyAddButtonListener(add));
	}

	@Override
	protected void initWhitePanels(Element e) {
		
	}
	
	void changeADDPanel( boolean flag){
		addpeople.setVisible(flag);
		
		add.setVisible(!flag);
		search.setVisible(!flag);
		searchBox.setVisible(!flag);
		searchway.setVisible(!flag);
		peopleMesTable.setVisible(!flag);
		confirm.setVisible(flag);
		cancel.setVisible(flag);
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
			
			String input = searchBox.getText();
			
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
