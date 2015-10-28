package ui.mainui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import util.ResultMessage;
import vo.AccountVO;
import bl.userbl.UserMesBusinessServiceImpl;
import blservice.accountblservice.AccountblService_Stub;
import blservice.accountblservice.Accountblservice;
import blservice.usermesblservice.UserMesblservice;
import blservice.usermesblservice.UserMesblservice_Stub;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;
 /** * @author czq @version 创建时间：2015年10月26日 上午11:23:44 * 简单说明 */
public class AddOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JPasswordField passwordField_1;
	JLabel ResultMes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrder frame = new AddOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddOrder() {
		setTitle("LogIn\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0	, 0, 200, 200));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(112, 5, 10, 10);
		contentPane.add(panel);
		
		JLabel lblid = new JLabel("账号");
		lblid.setBounds(88, 76, 68, 24);
		contentPane.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(187, 78, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		label = new JLabel("密码");
		label.setBounds(88, 143, 54, 15);
		contentPane.add(label);
		
		JButton button = new JButton("登录");
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String account = textField.getText();
				String key = new String(passwordField_1.getPassword());
				
				UserMesblservice bl = new UserMesBusinessServiceImpl();
				change(bl.login(new AccountVO(account,key))) ;
				
				
				
			}
		});
		button.setBounds(177, 206, 93, 23);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("快递物流管理系统");
		label_1.setBounds(173, 22, 120, 15);
		contentPane.add(label_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(187, 140, 66, 21);
		contentPane.add(passwordField_1);
		
		 ResultMes = new JLabel("");
		ResultMes.setBounds(173, 239, 214, 15);
		contentPane.add(ResultMes);
	}
	
	private void change(ResultMessage result){
		if(result == ResultMessage.SUCCESS){
			ResultMes.setText("登录成功！");
		}else{
			ResultMes.setText("账户或密码错误");
		}
	}
	
	
}
