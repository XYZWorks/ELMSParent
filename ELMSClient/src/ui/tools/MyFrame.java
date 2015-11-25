package ui.tools;

import javax.swing.JFrame;

import org.dom4j.Element;

import ui.mainui.mainFrame;
 /** 
 * 
 * @author czq 
 * @version 2015年11月22日 下午11:50:38 
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	
//	public static void main(String[] args) {
//		MyFrame frame = new MyFrame(900, 600);
//		MyPanel panel = new MyPanel("bg.png");
//		frame.setContentPane(panel);
//		MyButton button = new MyButton(" Hello World! ");
//		panel.add(button);
//		
//		frame.setVisible(true);
//		
//
//	}
	
	
	
	
	public MyFrame(Element config) {
		super();
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 400, width, height);
		this.setLocationRelativeTo(null);
//		this.setVisible(true);
	}
}
