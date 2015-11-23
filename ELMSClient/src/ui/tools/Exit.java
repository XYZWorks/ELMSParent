package ui.tools;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/*
 * 退出按钮
 * 
 */
public class Exit extends JLabel{

		Image next = new ImageIcon("").getImage();//设置退出按钮
		Boolean mouseContained = false;
		Boolean mouseClicked = false;
		
	public Exit(){
		
		this.setBounds(1080-30,0 , 30, 30);
		this.addMouseListener(new ExitListener());
	}

	public boolean isMouseClicked(){
		return mouseClicked;
	}
	
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		/*
		 * 下面这几行代码是java2D的黑魔法，上边是开启抗锯齿，下边是开启图片最高质量渲染，还有一个没用到，
			是开启文字抗锯齿
			代码是
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
			很多人都不知道的哦
		*/
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
		
		//重绘是定制界面很常用的手段，监听里改变一个bool或者直接换一张原图片，然后重绘
//		if(!mouseContained){
//			this.setBounds(1000-55,10 , 50, 50);
//			g2d.drawImage(next, -2,2, this.getWidth()-5,this.getWidth()-5,null);
//		}
//		else {
//			this.setBounds(1000-60, 5, 60, 60);
//			g2d.setStroke(new BasicStroke(2.0f));
//			g2d.setColor(Color.white);
//			g2d.drawOval(5, 5, this.getWidth()-10, this.getHeight()-10);
//			g2d.drawImage(next, 5, 5, this.getWidth()-10,this.getWidth()-10,null);									
//			g2d.setStroke(new BasicStroke(1.0f));
//		}
//		

	}

	class ExitListener implements MouseListener{
 
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//comfirm to exit!!
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
			//改变状态，重绘. 变色，变大
			
			mouseContained = true;
			repaint();
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			//重绘，变小
			mouseContained = false;
			repaint();
		}


		
	}
		
	

}
