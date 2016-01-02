package ui.generalmanager.people;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.CheckDocPanel;
import ui.tools.MyComboBox;
import ui.tools.MyPictureButton;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.ResultMessage;
import blservice.personnelblservice.Personnelblservice;
 /** 
 * 
 * @author czq 
 * @version 2016年1月2日 下午4:30:19 
 */
@SuppressWarnings("serial")
public class PeopleCheckPanel extends CheckDocPanel{
	
	
	PeopleMesPanel myTable;
	PeopleAddPanel addPanel;
	private MyPictureButton modify;
	private MyPictureButton delete;
	private Personnelblservice bl;
	private MyComboBox searchway;
	public PeopleCheckPanel(Element config, JPanel changePanel,
			String checkDocName, String addDocName , Personnelblservice bl) {
		super(config, changePanel, checkDocName, addDocName);
		this.bl = bl;
		myTable = (PeopleMesPanel) messageTable;
		myTable.bl = this.bl;
		addPanel = (PeopleAddPanel) addDocPanel;
		addPanel.bl = this.bl;
		myTable.myInit();
	}

	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		
		messageTable = new PeopleMesPanel(e.element("peopleMes"),0);
		addDocPanel = new PeopleAddPanel(e.element("PeopleManagePanelAddPanel"), changePanel, checkDocPanelStr, messageTable);
	}

	@Override
	protected void initialDifferComp(Element e) {
		modify = new MyPictureButton(e.element("modify"));
		delete = new MyPictureButton(e.element("delete"));
		searchway = new MyComboBox(e.element("searchWay"));
	}

	@Override
	protected void addDifferComp() {
		add(searchway);add(modify);add(delete);
		datePicker.setVisible(false);
		
	}
	
	@Override
	protected void addListener() {
		addDoc.addMouseListener(new MyPictureButtonListener(addDoc){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				addPanel.setModifyState(false, null);
				jumpToADD();
			}
		});
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					mySearch();
				}
				
			}
		});
		
		search.addMouseListener(new MyPictureButtonListener(search){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				mySearch();
			}
		});
		modify.addMouseListener(new MyPictureButtonListener(modify){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int row = myTable.getSelectedRow();
				if( row == -1){
					new TipsDialog("请选择一行信息");
				}else{
					addPanel.setModifyState(true, (String) myTable.getValueAt(row, 1));
					jumpToADD();
				}
				
			}
		});
		delete.addMouseListener(new MyPictureButtonListener(delete){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int row = myTable.getSelectedRow();
				if( row == -1){
					new TipsDialog("请选择一行信息");
				}else{
					
					result = bl.delPeople((String) myTable.getValueAt(row, 1));
					if(result == ResultMessage.SUCCESS){
						myTable.removeRow(myTable.getSelectedRow());
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
	public void mySearch() {
		String input = searchBox.getMyText();
		
		if(input.equals("")){
			myTable.showAllMessages();
			return;
		}
		
		
		String temp = (String) searchway.getSelectedItem();
		if(temp.equals("按姓名查找")){
			myTable.searchName(input);
		}else if(temp.equals("按ID查找")){
			if(UserfulMethod.dealWithData( new SimpleDataFormat(input, DataType.ID, "ID")))
				myTable.searchID(input);
			
		}else{
			if(UserfulMethod.dealWithData( new SimpleDataFormat(input, DataType.ID, "ID"))){
				myTable.searchInstID(input);
			}	
		}
	}
	
	

		
		
	
}
