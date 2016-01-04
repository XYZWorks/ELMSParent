//package ui;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//@SuppressWarnings("serial")
//public class ChangeDialog extends JDialog {
//	
//	private JLabel currentPort;
//	
//	private JLabel newPort;
//	
//	private JTextField newPortTxt;
//	
//	private JButton btnSubmit;
//	
//	private JButton btnCancel;
//	
//	@SuppressWarnings("unused")
//	private JPanel panel;
//	
//	private ServerUI mainFrame;
//	
//	private static final int WIDTH = 300;
//	
//	private static final int HEIGHT = 200;
//	
//	public ChangeDialog(ServerUI mainFrame, JPanel panel) {
//		super(mainFrame, true);
//		((JComponent) this.getContentPane()).setOpaque(true);
//		this.panel = panel;
//		this.mainFrame = mainFrame;
//		this.createUI();
//		this.initLabels();
//		this.initButtons();
//		this.initTextFields();
//		setVisible(true);
//	}
//	
//	private void createUI() {
//		this.setTitle("更改端口");
//		this.setLayout(null);
//		this.setSize(WIDTH, HEIGHT);
//		this.setLocation(mainFrame.getX() + (mainFrame.getWidth()-WIDTH)/2 ,
//				mainFrame.getY() + (mainFrame.getHeight()-HEIGHT)/2);
//		this.setResizable(false);
//	}
//	
//	private void initLabels() {
//		
//		currentPort = new JLabel("当前端口：   " + mainFrame.getPort());
//		currentPort.setBounds(20, 20, 300, 25);
//		this.getContentPane().add(currentPort);
//		
//		newPort = new JLabel("请输入新的端口：");
//		newPort.setBounds(20, 65, 200, 25);
//		this.getContentPane().add(newPort);
//	}
//	
//	private void initTextFields() {
//		newPortTxt = new JTextField();
//		newPortTxt.setBounds(150, 65, 100, 25);
//		this.getContentPane().add(newPortTxt);
//	}
//	
//	private void initButtons() {
//		btnSubmit = new JButton("提交");
//		btnSubmit.setBounds(90, 120, 75, 25);
//		btnSubmit.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if(newPortTxt.getText().equals("")) {
//					JOptionPane.showMessageDialog(null, "输入的端口为空！");
//					newPortTxt.setText("");
//					return;
//				}
//				boolean valid = true;
//				char[] input = newPortTxt.getText().toCharArray();
//				for(int i = 0; i < input.length; i++) {
//					if(input[i] < '0' || input[i] >'9') {
//						valid = false;
//					}
//				}
//				if(!valid) {
//					JOptionPane.showMessageDialog(null, "输入的端口含有非法字符！");
//					newPortTxt.setText("");
//					return;
//				}
//				if(newPortTxt.getText().length() > 5) {
//					JOptionPane.showMessageDialog(null, "输入的端口非法！");
//					newPortTxt.setText("");
//					return;
//				}
//				int port = Integer.parseInt(newPortTxt.getText());
//				if(port < 1000 || port >= 65536) {
//					JOptionPane.showMessageDialog(null, "输入的端口非法！");
//					newPortTxt.setText("");
//					return;
//				}
//				mainFrame.setPort(port);
//				JOptionPane.showMessageDialog(null, "端口更改成功！");
//				ChangeDialog.this.dispose();
//				mainFrame.updateInfo();
//			}
//			
//		});
//		this.getContentPane().add(btnSubmit);
//		
//		
//		btnCancel = new JButton("取消");
//		btnCancel.setBounds(175, 120, 75, 25);
//		btnCancel.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				ChangeDialog.this.dispose();
//			}
//			
//		});
//		this.getContentPane().add(btnCancel);
//	}
//
//}
