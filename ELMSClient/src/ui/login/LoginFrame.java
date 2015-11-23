package ui.login;

import ui.tools.MyButton;
import ui.tools.MyCheckBox;
import ui.tools.MyFrame;
import ui.tools.MyPanel;
import ui.tools.MyPasswordField;
import ui.tools.MyTextField;
/** 
 * 
 * @author czq 
 * @version 2015年11月22日 下午11:50:27 
 */
@SuppressWarnings("serial")
public class LoginFrame extends MyFrame{
	
	private MyPanel mainpanel;
	
	private MyButton closeButton;
	
	private MyButton login;
	
	private MyButton checkOrder;
	
	private MyCheckBox rememberMe;
	
	private MyTextField userName;
	
	private MyPasswordField password;
	
	
	public LoginFrame() {
		super(600 ,400);
		mainpanel = new MyPanel("login.png");
		closeButton = new MyButton();
		login = new MyButton();
		checkOrder = new MyButton();
		userName = new MyTextField();
		rememberMe = new MyCheckBox();
		password = new MyPasswordField();
		this.setContentPane(mainpanel);
		setLocation();
		this.validate();
		this.setVisible(true);
	}
	
	private void setLocation(){
		
		mainpanel.setLayout(null);
		
//		checkOrder.setBounds(400, 450, 450, 100);
//		mainpanel.add(checkOrder);
		
		
	}
	
	
	
}
