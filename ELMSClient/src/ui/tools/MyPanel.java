package ui.tools;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import ui.config.GraphicsUtils;
 /** 
 * 有背景图的panel
 * @author czq 
 * @version 2015年11月22日 下午8:25:12 
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel{
	
	Image bg;
	
	
	
	public MyPanel(String picture) {
		bg = GraphicsUtils.getImage(picture);
		
		repaint();
	}
	
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);   
	    g.drawImage(bg, 0,0, null);
	    g.drawim
	   
	} 
	
}
