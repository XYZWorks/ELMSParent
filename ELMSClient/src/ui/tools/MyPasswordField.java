package ui.tools;

import java.awt.Color;

import javax.swing.JPasswordField;
 /** 
 * 
 * @author czq 
 * @version 2015年11月22日 下午8:25:46 
 */
@SuppressWarnings("serial")
public class MyPasswordField extends JPasswordField{
	public MyPasswordField() {
		this.setOpaque(true);
		this.setForeground(Color.black);
		
		this.setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	public MyPasswordField(int x , int y , int width , int height) {
		this.setBounds(x, y , width , height);
		this.setForeground(Color.black);
		
		this.setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
}
