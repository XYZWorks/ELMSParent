package AXIS.ELMSParent;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class initalPanel {
	private Exit exit=new Exit();
	private Min min=new min();
	
	public initalPanel(){
	Image workingBackground=new ImageIcon("").getImage();
	add(exit);
	add(min);
	
	}
	public void paint Component(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(workingBackground,0,0,1080,720,null);
		
		//paint 状态栏
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("状态栏", Font.BOLD, 30));
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		
	}
}
