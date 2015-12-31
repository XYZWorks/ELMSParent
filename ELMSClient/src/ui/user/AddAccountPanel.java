package ui.user;

import java.awt.Color;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyComboBox;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.AccountType;
import util.ResultMessage;
import vo.account.AccountVO;
import blservice.accountblservice.Accountblservice;
 /** 
 * 增加账户界面
 * @author czq 
 * @version 2015年12月2日 下午7:11:27 
 */
@SuppressWarnings("serial")
public class AddAccountPanel extends MyPanel{
	
	private MyPictureLabel accountID;
	private MyPictureLabel name;
	private MyPictureLabel staffTypeLabel;
	private MyPictureLabel passwordLabel;
	
	private MyTextField accountIDField;
	private MyTextField nameField;
	private MyTextField passwordField;
	
	private MyComboBox staffTypeBox;
	
	private MyPictureButton addAccount;
	
	private Accountblservice bl;
	
	
	public AddAccountPanel(Element config , Accountblservice bl) {
		super(config);
		this.bl = bl;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();
	}

	@Override
	protected void initButtons(Element e) {
		addAccount = new MyPictureButton(e.element("addAccount"));
		
	}

	@Override
	protected void initTextFields(Element e) {
		accountIDField = new MyTextField(e.element("accountID"));
		nameField = new MyTextField(e.element("name"));
		passwordField = new MyTextField(e.element("password"));
		
		
	}

	@Override
	protected void initLabels(Element e) {
		accountID = new MyPictureLabel(e.element("accountID"));
		name = new MyPictureLabel(e.element("name"));
		passwordLabel = new MyPictureLabel(e.element("password"));
		staffTypeLabel = new MyPictureLabel(e.element("staffType"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		staffTypeBox = new MyComboBox(e.element("staffBox"));
		
	}

	@Override
	protected void addCompoment() {
		add(accountID);
		add(accountIDField);
		add(addAccount);
		add(name);
		add(nameField);
		add(passwordField);
		add(passwordLabel);
		
		add(staffTypeBox);
		add(staffTypeLabel);
	}

	@Override
	protected void addListener() {
		addAccount.addMouseListener(new ConfirmListener(addAccount) {
			String id;
			String name;
			AccountType type;
			String password;
			AccountVO vo;
			@Override
			protected void updateMes() {
				
				
			}
			
			@Override
			protected boolean saveToSQL() {
				result = bl.add(vo = new AccountVO(id, name, type, password));
				if(result == ResultMessage.SUCCESS){
					new TipsDialog("成功新增账户", Color.GREEN);
					return true;
					
				}else{
					new TipsDialog("未能新增账户");
					return false;
				}
				
			}
			
			@Override
			protected void reInitial() {
				accountIDField.setText("");
				nameField.setText("");
				passwordField.setText("");
				staffTypeBox.setSelectedIndex(0);
				
			}
			
			@Override
			protected boolean checkDataValid() {
				id = accountIDField.getText();
				name = nameField.getText();
				password = passwordField.getText();
				type = AccountType.getType(((String) staffTypeBox.getSelectedItem()));
				
				SimpleDataFormat[] datas = {new SimpleDataFormat(id, DataType.ID, "ID") , new SimpleDataFormat(password, DataType.ID, "密码")};
				return UserfulMethod.dealWithData(datas);
			}
		});
		
	}
	
	
	class MyAddAccountListener extends MyPictureButtonListener{

		public MyAddAccountListener(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
//			UserfulMethod.checkID(accountID.getText());
			ResultMessage mes;
			mes = bl.add(new AccountVO(
					accountIDField.getText(),
					nameField.getText(),
					AccountType.getType(((String) staffTypeBox.getSelectedItem())),
					passwordField.getText()));
			
			System.out.println(AccountType.manager.name());
//			if(mes == ResultMessage.SUCCESS){
//				new MyOptionPane(parent, message)
//			}
			
		}
		
		
		
		
		
	}


	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}
	
}
