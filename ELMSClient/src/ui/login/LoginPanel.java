package ui.login;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import ui.config.GraphicsUtils;
 /** 
 * 
 * @author czq 
 * @version 2015年11月25日 下午8:28:55 
 */
@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	
	private Image nowbg;
	
	private Image bg;

	private Image bgcheckorder1;

	private Image bgcheckorder2;

	private Image bgclose1;

	private Image bgclose2;

	private Image bglogin1;
	private Image bglogin2;
	
	private final String pre = "login//";
	
	public LoginPanel() {
		bg = GraphicsUtils.getImage(pre +"bg");
		bgcheckorder1 = GraphicsUtils.getImage(pre + "bg-checkorder-1");
		bgcheckorder2 = GraphicsUtils.getImage(pre + "bg-checkorder-2");
		bgclose1 = GraphicsUtils.getImage(pre + "bg-close-1");
		bgclose2 = GraphicsUtils.getImage(pre + "bg-close-2");
		bglogin1 = GraphicsUtils.getImage(pre + "bg-login-1");
		bglogin2 = GraphicsUtils.getImage(pre + "bg-login-2");
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
	
	public void changeBG(int pic){
		switch (pic) {
		case 1:
			nowbg = bgcheckorder1;
			repaint();
			break;
		case 2:
			nowbg = bgcheckorder2;
			repaint();
			break;
		case 3:
			nowbg = bgclose1;
			repaint();
			break;
		case 4:
			nowbg = bgclose2;
			repaint();
			break;
		case 5:
			nowbg = bglogin1;
			repaint();
			break;
		case 6:
			nowbg = bglogin2;
			repaint();
			break;
		default:
			nowbg = bg;
			repaint();
			break;
		}
	}
	
}
