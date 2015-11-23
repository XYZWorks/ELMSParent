package ui.tools;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import config.StaticMessage;
 /** 
 * 
 * @author czq 
 * @version 2015年11月22日 下午8:25:12 
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel{
	
	ImageIcon bg;
	
	public MyPanel() {
		// TODO Auto-generated constructor stub
	}
	
	public MyPanel(String picture) {
		bg = new ImageIcon(StaticMessage.imagePath + picture);
		repaint();
	}
	
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);   
	    System.out.println("paint");
	    g.drawImage(bg.getImage(), 0, 0, null);
	} 
	
}
