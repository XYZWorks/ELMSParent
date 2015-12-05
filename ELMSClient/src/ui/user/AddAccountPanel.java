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
	
	private MyLabel accountID;
	private MyLabel name;
	private MyLabel staffTypeLabel;
	private MyLabel passwordLabel;
	
	private MyTextField accountIDField;
	private MyTextField nameField;
	private MyTextField passwordField;
	
	private MyComboBox staffTypeBox;
	
	private MyPictureButton addAccount;
	
	private Accountblservice bl;
	
	
	public AddAccountPanel(Element config , Accountblservice bl) {
		super(config);
		this.bl = bl;
		initLables(config.element(CompomentType.LABELS.name()));
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
	protected void initLables(Element e) {
		accountID = new MyLabel(e.element("accountID"));
		name = new MyLabel(e.element("name"));
		passwordLabel = new MyLabel(e.element("password"));
		staffTypeLabel = new MyLabel(e.element("staffType"));
		
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
		addAccount.addMouseListener(new MyAddAccountListener(addAccount));
		
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
