package ui.tools;

import javax.swing.JFrame;
 /** 
 * 
 * @author czq 
 * @version 2015年11月22日 下午11:50:38 
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	
	
	
	public MyFrame(int width , int height) {
		super();
		this.setUndecorated(true);
		
		this.setBounds(300, 400, width, height);
		this.setLocationRelativeTo(null);
//		this.setVisible(true);
	}
}
