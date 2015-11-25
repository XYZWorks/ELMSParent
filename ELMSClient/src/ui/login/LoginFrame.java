package ui.login;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import ui.config.UserfulMethod;
import ui.tools.MyButton;
import ui.tools.MyCheckBox;
import ui.tools.MyFrame;
import ui.tools.MyOptionPane;
import ui.tools.MyPanel;
import ui.tools.MyPasswordField;
import ui.tools.MyTextField;
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
	
	private MyPanel mainpanel;
	
	private MyButton closeButton;
	
	private MyButton login;
	
	private MyButton checkOrder;
	
	private MyCheckBox rememberMe;
	
	private MyTextField userName;
	
	private MyPasswordField password;
	
	private UserMesblservice bl;
	
	private LoginFrame frame;
	
	public LoginFrame() {
		super(497 ,411);
		bl = BusinessLogicDataFactory.getFactory().getUserMesBusinessLogic();
		

		mainpanel = new MyPanel("login\\bg");
		this.setBackground(new Color(0, 0, 0, 0));
		closeButton = new MyButton(455, 36 , 489 , 69);
		login = new MyButton(3 ,358 , 492 , 411);
		checkOrder = new MyButton(213 , 316, 285 , 333);
		userName = new MyTextField(179 ,185 , 353 - 179, 216 - 185);
		rememberMe = new MyCheckBox(284,287,293,296);
		password = new MyPasswordField(179 , 241 , 353 - 179 , 272 - 241);
		
		this.frame = this;
		this.setContentPane(mainpanel);
		setLocation();
		addListener();
		
		this.validate();
		this.repaint();
		this.mainpanel.repaint();
		this.setVisible(true);
	}
	
	private void setLocation(){
		
		mainpanel.setLayout(null);
		mainpanel.add(userName);
		mainpanel.add(password);
		mainpanel.add(checkOrder);
		mainpanel.add(login);
		mainpanel.add(closeButton);
//		checkOrder.setBounds(400, 450, 450, 100);
//		mainpanel.add(checkOrder);
		
		
	}
	
	private void  addListener(){
		login.addMouseListener(new MyLoginListener());
		
		closeButton.addMouseListener(new MyCloseListener());
	}
	
class MyLoginListener extends MouseAdapter{
	@Override
	 public void mouseClicked(MouseEvent e) {
		String id = userName.getText();
		String passwords = new String(password.getPassword());
		ResultMessage result;
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
		if( result== ResultMessage.SUCCESS){
			//TODO 
			System.out.println("登录成功！");
		}else{
			new MyOptionPane(frame, "用户名或密码错误，请您重新输入");
		}
		
	}
	
	@Override
   public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
   public void mouseExited(MouseEvent e) {
		
		
	}
}

class MyCloseListener extends MouseAdapter{
	@Override
	 public void mouseClicked(MouseEvent e) {
		frame.dispose();
		System.exit(0);
		
	}
	
	@Override
    public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
    public void mouseExited(MouseEvent e) {
		
		
	}
}

public static void main(String[] args) {
//	ParseXML xmlReader = new ParseXML("loginframe");
	new LoginFrame();
}	
}
