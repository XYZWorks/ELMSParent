package ui.tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.config.GraphicsUtils;


/*
 * 退出按钮
 * 
 */
public class Exit extends JLabel{

//		Image next = new ImageIcon("").getImage();//设置退出按钮
		Boolean mouseContained = false;
		Boolean mouseClicked = false;
		
	public Exit(){
		this.setBounds(1050,0 , 30, 30);
		this.addMouseListener(new ExitListener());
		this.setVisible(true);
	}

//	public boolean isMouseClicked(){
//		return mouseClicked;
//	}
	
	@Override
	public void paintComponent(Graphics g) {
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

		if(!mouseContained){
			System.out.println("---------");
			g2d.drawImage(GraphicsUtils.getImage("closeGrey"),0,0,null);
		}
		else {
			System.out.println("---------");
			g2d.drawImage(GraphicsUtils.getImage("closeGreen"),0,0,null);
		}
	}
	
	class ExitListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			//弹窗
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			mouseContained=true;
			repaint();
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			mouseContained=false;
			repaint();
		}

	}
		
	

}
