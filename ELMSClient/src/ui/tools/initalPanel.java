package ui.tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.config.GraphicsUtils;

public class initalPanel extends JPanel{
	private Exit exit=new Exit();
	private Min min=new Min();
	
	public initalPanel(){
		
		this.add(exit);
		this.add(min);
		paint();
		System.out.println("enter");
	}
	
@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		System.out.println("work!!");
		g2d.drawImage(GraphicsUtils.getImage("workingBackground"),0,0,1080,720,null);
		
		//paint 状态栏
//		g2d.setColor(Color.WHITE);
//		g2d.setFont(new Font("状态栏", Font.BOLD, 30));
//		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
//				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//		
		
	}
}
