package ui.user;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import blservice.accountblservice.Accountblservice;
 /** 
 * 查找、修改、删除界面
 * @author czq 
 * @version 2015年12月2日 下午7:12:08 
 */
@SuppressWarnings("serial")
public class ModifyAccountPanel extends MyPanel{
	
	Accountblservice bl;
	/**
	 * 账户信息表格
	 */
	private AccountMesTablePanel table;
	
	private MyPictureButton modifyButton;
	private MyPictureButton deleteButton;
	
	private MyLabel newName;
	private MyLabel newPassword;
	private MyLabel newType;
	
	private MyTextField newNameT;
	private MyTextField newPassT;
	private MyComboBox newTypeC;
	
	private boolean isModify = false;
	
	public ModifyAccountPanel(Element config , Accountblservice bl) {
		super(config);
		this.bl = bl;
		initLables(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();
		
		setModifyCompVisiable(false);
	}
	
	private void setModifyCompVisiable(boolean flag){
		isModify = flag;
		newName.setVisible(flag);
		newNameT.setVisible(flag);
		newPassT.setVisible(flag);
		newPassword.setVisible(flag);
		newType.setVisible(flag);
		newTypeC.setVisible(flag);
	}
	
	
	@Override
	protected void initButtons(Element e) {
		modifyButton = new MyPictureButton(e.element("modify"));
		deleteButton = new MyPictureButton(e.element("delete"));
	}

	@Override
	protected void initTextFields(Element e) {
		newNameT = new MyTextField(e.element("name"));
		newPassT = new MyTextField(e.element("password")); 
		
		
	}

	@Override
	protected void initLables(Element e) {
		newName = new MyLabel(e.element("name"));
		newPassword = new MyLabel(e.element("password"));
		newType = new MyLabel(e.element("type"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		table = new AccountMesTablePanel(e.element("table"), bl);
		newTypeC = new MyComboBox(e.element("type"));
	}

	@Override
	protected void addCompoment() {
		add(deleteButton);
		add(modifyButton);
		add(table);
		add(newName);
		add(newNameT);
		add(newPassT);
		add(newPassword);
		add(newType);
		add(newTypeC);
	}

	@Override
	protected void addListener() {
		modifyButton.addMouseListener(new MyModifyAccountListener(modifyButton));
		deleteButton.addMouseListener(new MyDeleteAccountListener(deleteButton));
	}
	
	
	class MyModifyAccountListener extends MyPictureButtonListener{

		public MyModifyAccountListener(MyPictureButton button) {
			super(button);
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			if(isModify){
				
			}else{
				int row = table.getSelectedRow();
				if(row == -1){
//					new MyOptionPane(parent, message)
					return;
				}
				setModifyCompVisiable(true);
				modifyButton.setText("确认");
			}
			
			
		}
	}
	
	class MyDeleteAccountListener extends MyPictureButtonListener{

		public MyDeleteAccountListener(MyPictureButton button) {
			super(button);
			
			
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			int row = table.getTable().getSelectedRow();
			 
			if(row != -1){
				bl.delete((String)table.getTable().getValueAt(row, 0));
				table.removeRow(row);
			}else{
				
			}
		}
	}
	
	
	
	public void setTableData() {
		table.reinitial();
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}
	
}
