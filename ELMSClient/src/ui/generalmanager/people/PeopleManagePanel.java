package ui.generalmanager.people;

import java.awt.Color;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyCardLayOut;
import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MySearchBox;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.ResultMessage;
import blservice.personnelblservice.Personnelblservice;

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
	
	private MyCardLayOut panelManager;
	
	private Personnelblservice bl;
	
	PeopleMesPanel peopleMesTable;
	/**
	 * 增加人员界面
	 */
	private AddPeoplePanel addpeople;
	
	
	public PeopleManagePanel(Element config , MyCardLayOut panelManager ,Personnelblservice bl) {
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
		modify.addMouseListener(new MyPictureButtonListener(modify){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int row = peopleMesTable.getSelectedRow();
				if( row == -1){
					new TipsDialog("请选择一行信息");
				}else{
					changeADDPanel(true);
					addpeople.setModifyState(true, (String) peopleMesTable.getValueAt(row, 1));
				}
				
			}
		});
		delete.addMouseListener(new MyPictureButtonListener(delete){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int row = peopleMesTable.getSelectedRow();
				if( row == -1){
					new TipsDialog("请选择一行信息");
				}else{
					
					result = bl.delPeople((String) peopleMesTable.getValueAt(row, 1));
					if(result == ResultMessage.SUCCESS){
						peopleMesTable.removeRow(peopleMesTable.getSelectedRow());
						new TipsDialog("成功删除数据", Color.GREEN);
					}else{
						new TipsDialog("未成功删除数据");
						System.err.println(result);
					}
				
					
					
				}
				
			}
			
			
		});
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
			addpeople.setModifyState(false, null);
		}
		
		
	}
	
	
	
	class MySearchListener extends MyPictureButtonListener{

		public MySearchListener(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
			String input = searchBox.getMyText();
			
			String temp = (String) searchway.getSelectedItem();
			if(temp.equals("按姓名查找")){
				peopleMesTable.searchName(input);
			}else if(temp.equals("按ID查找")){
				if(UserfulMethod.dealWithData( new SimpleDataFormat(input, DataType.ID, "ID")))
					peopleMesTable.searchID(input);
				
			}else{
				if(UserfulMethod.dealWithData( new SimpleDataFormat(input, DataType.ID, "ID"))){
					peopleMesTable.searchInstID(input);
				}	
			}
			
			
		}
		
		
		
	}
	
}

