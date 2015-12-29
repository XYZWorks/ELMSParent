package ui.tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
/** 
 * 所有Frame父类
 * @author czq 
 * @version 2015年11月22日 下午11:50:38 
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame{

	private static Point start = new Point();
	
	public MyFrame(Element config) {
		super();
		//除去边框
		this.setUndecorated(true);
		this.setSize(Integer.parseInt(config.attributeValue("width")), Integer.parseInt(config.attributeValue("height")));
		this.setLayout(null);
		this.setResizable(false);
		this.moveFrame();
		setBackground(new Color(255, 0, 0, 0));
		this.setIconImage(GraphicsUtils.getImage("element//icon"));
		//居中放置
		this.setLocationRelativeTo(null);
		
		
	}
	
	/**
	 * 拖动界面
	 */
	private void moveFrame(){
		this.addMouseListener(new MouseAdapter() {
			
			 @Override
			public void mousePressed(MouseEvent e) {
				 start.x = e.getX();
				 start.y = e.getY();
			 }
			
			
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			
			 @Override
			public void mouseDragged(MouseEvent e) {
					 Point p = getLocation();
					 
					 setLocation( p.x + e.getX() -start.x , p.y + e.getY() - start.y);
			 }
		});
		
		
	}
	
	
}
