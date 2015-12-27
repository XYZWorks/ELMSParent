package ui.login;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import ui.config.GraphicsUtils;
import ui.tools.MyPictureButton;
 /** 
 * 
 * @author czq 
 * @version 2015年11月25日 下午8:28:55 
 */
@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	MyPictureButton modifyPort;
	
	private Image nowbg;
	
	private Image bg;

	
	
	private final String pre = "login//";
	
	public LoginPanel() {
		bg = GraphicsUtils.getImage(pre +"bg");
		
		setOpaque(true);
		setBackground(new Color(0, 0, 0));
		nowbg = bg;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)  
	{  
		GraphicsUtils.setAlpha(g, 0);
		super.paintComponent(g);
		GraphicsUtils.setAlpha(g, 1);
		g.drawImage(nowbg, 0,0, null);
//		g.setColor(Color.red);
//		g.fillRect(0, 0, getWidth(), getHeight());
	    
	    
	   
	} 
	
	
	}
	

