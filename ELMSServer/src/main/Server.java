package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import data.RMIServer;
 /** 
 * 
 * @author czq 
 * @version 2015年11月26日 下午3:27:46 
 */
public class Server {

	private JFrame frmElms;
	
	private RMIServer server;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
					window.frmElms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmElms = new JFrame();
		frmElms.setTitle("ELMS服务器端");
		frmElms.setBounds(100, 100, 450, 300);
		frmElms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElms.getContentPane().setLayout(null);
		
		server = new RMIServer();
		
		final JButton btnNewButton = new JButton("启动服务");
		btnNewButton.setBounds(71, 100, 116, 47);
		frmElms.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				server.startRMI();
				btnNewButton.setText("运行中");
			}
		});
		
		JButton btnNewButton_1 = new JButton("停止服务");
		btnNewButton_1.setBounds(248, 100, 116, 47);
		frmElms.getContentPane().add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				server.stopRMI();
				
			}
		});
	}
}
