package ui.tools;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * 
 * @author czq
 * @version 2015年11月16日 下午7:35:33
 */
@SuppressWarnings("serial")
public class MyButton extends JLabel {
	
	public MyButton() {
		this.setOpaque(true);
		this.setVisible(true);
	}
	
	public MyButton(String text) {
		super.setText(text);
		this.setOpaque(true);
		this.setVisible(true);
	}
	
	public MyButton(int x1 , int y1 , int x2 , int y2){
		this.setBounds(x1, y1, x2 - x1, y2 - y1);
		this.setOpaque(false);
		this.setVisible(true);
	}
	
}
