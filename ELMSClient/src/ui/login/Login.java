package ui.login;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.io.PushbackInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.awt.AWTUtilities;

/**
 *
 * @zr 
 * @version 2015年11月22日 上午9:47:58
 */
public class Login extends JFrame{
	private JTextField username;
	private JPasswordField password;
	
	/*private JPanel background=new JPanel(){
		
		private String backgroundImageURL=FreeUtil.getImageURL("background.png");
		private TexturePaint paint=FreeUtil.createTexturepaint(backgroundImageURL);
		
		@Override
		
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2d=(Graphics2D)g;
			g2d.setClip(paint);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
	};*/
	
	public void LoginMainFrame(){
	}
	
	
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setBounds(500,500,500,375);
		AWTUtilities.setWindowOpaque(frame, false);
		//设置窗口完全透明
		
		JPanel pane = new JPanel(){
		
			public void paint(Graphics g){
				super.paint(g);
				
				g.setColor(Color.LIGHT_GRAY);
				g.fill3DRect(10, 10, 100, 100, true);
			}
			
		};
		
		frame.setContentPane(pane);
		frame.setVisible(true);
		 
	
	}
}
