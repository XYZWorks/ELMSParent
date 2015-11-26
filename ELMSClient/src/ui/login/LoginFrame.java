package ui.login;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import org.dom4j.Element;

import ui.config.ParseXML;
import ui.config.UserfulMethod;
import ui.inital.mainFrame;
import ui.tools.MyButton;
import ui.tools.MyCheckBox;
import ui.tools.MyFrame;
import ui.tools.MyOptionPane;
import ui.tools.MyPanel;
import ui.tools.MyPasswordField;
import ui.tools.MyTextField;
import util.AccountType;
import util.FormatMes;
import util.ResultMessage;
import vo.account.AccountVO;
import bl.BusinessLogicDataFactory;
import blservice.usermesblservice.UserMesblservice;

/** 
 * 
 * @author czq 
 * @version 2015年11月22日 下午11:50:27 
 */
@SuppressWarnings("serial")
public class LoginFrame extends MyFrame{
	
	private LoginPanel mainpanel;
	
	private MyButton closeButton;
	
	private MyButton login;
	
	private MyButton checkOrder;
	
	private MyCheckBox rememberMe;
	
	private MyTextField userName;
	
	private MyPasswordField password;
	
	private UserMesblservice bl;
	
	private LoginFrame frame;
	
	private Element config;
	
	public LoginFrame(Element config) {
		super(config);
		this.config = config;
		bl = BusinessLogicDataFactory.getFactory().getUserMesBusinessLogic();
		mainpanel = new LoginPanel();
		this.setBackground(new Color(0, 0, 0, 0));

		initButtons(config.element("buttons"));
		initOtherCom(config);
		config.attributeValue("width");
		this.frame = this;
		this.setContentPane(mainpanel);
		addCom();
		addListener();
		
		this.validate();
		this.repaint();
		this.mainpanel.repaint();
		this.setVisible(true);
	}
	
	private void initButtons(Element config){
		login = new MyButton(config.element("login"));
		checkOrder = new MyButton(config.element("checkOrder"));
		closeButton = new MyButton(config.element("close"));
	}
	
	private void initCheckBox(Element config){
		
	}
	
	private void initTextField(Element config){
		
		
	}
	
	private void initOtherCom(Element config){
		userName = new MyTextField(179 ,185 , 353 - 179, 216 - 185);
		rememberMe = new MyCheckBox(284,287,293,296);
		password = new MyPasswordField(179 , 241 , 353 - 179 , 272 - 241);
	}
	
	private void addCom(){
		
		mainpanel.setLayout(null);
		mainpanel.add(userName);
		mainpanel.add(password);
		mainpanel.add(checkOrder);
		mainpanel.add(login);
		mainpanel.add(closeButton);
		mainpanel.add(rememberMe);

		
		
	}
	
	private void  addListener(){
		login.addMouseListener(new MyLoginListener());		
		closeButton.addMouseListener(new MyCloseListener());
		checkOrder.addMouseListener(new MyCheckOrderListener());
		
	}

	
	
	
	
	
	
	
	
	
	
class MyLoginListener extends MouseAdapter{
	@Override
	 public void mouseClicked(MouseEvent e) {
//		mainpanel.bg
		mainpanel.changeBG(6);
		
		String id = userName.getText();
		String passwords = new String(password.getPassword());
		AccountType result;
		FormatMes format;
		format = UserfulMethod.checkID(id);
		if(format == FormatMes.ILEGAL_CHAR){
			new MyOptionPane(frame , "用户名有非法字符，请您重新输入~" , JOptionPane.INFORMATION_MESSAGE);
			userName.setText("");
			return;
		} else if(format == FormatMes.WRONG_LENGTH){
			new MyOptionPane(frame ,"用户名长度不足，请您重新输入~" , JOptionPane.INFORMATION_MESSAGE);
			return;
			
		}
		 result= bl.login(new AccountVO(id, passwords, null));
		if( result== null){
			new MyOptionPane(frame, "用户名或密码错误，请您重新输入");
		}else{
			System.out.println("登录成功，用户类型为 " + result.name());
			new mainFrame(config.getParent() , result);
		}
		
	}
	
	@Override
   public void mouseEntered(MouseEvent e) {
		mainpanel.changeBG(5);
		
	}

	@Override
   public void mouseExited(MouseEvent e) {
		mainpanel.changeBG(0);
		
	}
}

class MyCloseListener extends MouseAdapter{
	@Override
	 public void mouseClicked(MouseEvent e) {
		frame.dispose();
		System.exit(0);
		mainpanel.changeBG(4);
	}
	
	@Override
    public void mouseEntered(MouseEvent e) {
		mainpanel.changeBG(5);
		
	}

	@Override
    public void mouseExited(MouseEvent e) {
		
		
	}

}
class MyCheckOrderListener extends MouseAdapter{
	@Override
	 public void mouseClicked(MouseEvent e) {
		
		
	}
	
	@Override
   public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
   public void mouseExited(MouseEvent e) {
		
		
	}
}


public static void main(String[] args) {
	ParseXML xmlReader = new ParseXML();
	new LoginFrame(xmlReader.getConfig("loginframe"));
}	
}
