package ui.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ui.config.GraphicsUtils;
import ui.tools.MyLabel;
/** 
 * 提示框
 * @author czq 
 * @version 2015年12月5日 下午7:16:54 
 */
@SuppressWarnings("serial")
public class TipsDialog extends JDialog{
	
	/**
	 * 
	 */
	private static JFrame parent;
	
	
	private final String message;
	
	private final int MAX_TIMES = 100;
	
	private final int PAUSE_TIME = 1000;
	
	private int nowTime = 1;
	
	private final static Rectangle bounds = new Rectangle(900, 600, 200, 100);
	
	
	private final  MyLabel label = new MyLabel() {
		@Override
		public void paintComponent(Graphics g){
			
			GraphicsUtils.setAlpha(g, nowTime/(double)MAX_TIMES);
			
			super.paintComponent(g);
		}
		
	};
	
	/**
	 * 构造器1 ， 使用默认颜色和字体
	 * @param message
	 */
	public TipsDialog(String message) {
		this(message , Color.red);
    }
	
	public TipsDialog(String message , Color color) {
		this(message, color, GraphicsUtils.getFont(null));
    }
	
	public TipsDialog(String message , Color color , Font font) {
		super(parent);
		label.setIcon(GraphicsUtils.getIcon("element\\close"));
        this.message = message;
        label.setText(message);
        new Thread(new Runnable() {
			@Override
			public void run() {
				initGUI();
				
			}
		}).start();
       
    }
	
	
	
	
	private void initGUI() {
		setUndecorated(true);
		setBounds(bounds);
		label.setBounds(0 , 0 , (int) bounds.getWidth() ,  (int)bounds.getHeight());
		add(label);
		
		this.setVisible(true);
		while( nowTime < MAX_TIMES){
			
			nowTime++;
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			label.repaint();
		}
		
		try {
			Thread.sleep(PAUSE_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while( nowTime > 0){
			nowTime--;
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			label.repaint();
			
		}
		
		dispose();
		
	}
	
	public static void setFrame(JFrame parent){
		TipsDialog.parent = parent;
	}



	
	
}
