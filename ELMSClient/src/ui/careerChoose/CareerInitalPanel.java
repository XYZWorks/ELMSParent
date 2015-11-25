package ui.careerChoose;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.mainui.Exit;
import ui.mainui.Min;
import ui.tools.MyPanel;
/**
* 不同职业的主页 背景初始
*@author:xingcheng
*@version 2015年11月25日
*/
public class CareerInitalPanel extends MyPanel{
		private Exit exit=new Exit();
		private Min min=new Min();
		
		public CareerInitalPanel(){
			
			this.add(exit);
			this.add(min);
			repaint();
		}
		
	@Override
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(GraphicsUtils.getImage("???背景?????????"),0,0,1080,720,null);
			
			//paint 状态栏 日期
//			g2d.setColor(Color.WHITE);
//			g2d.setFont(new Font("状态栏", Font.BOLD, 30));
//			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
//					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//			
			
		}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLables(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addCompoment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}
	}

