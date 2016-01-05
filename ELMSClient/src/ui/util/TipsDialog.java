package ui.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.apache.poi.hssf.util.HSSFColor.BLUE;

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
	
	private final static int MAX_TIMES = 100;
	
	private final static int PAUSE_TIME = 1000;
	
	private int nowTime = 1;
	private String text = "";
	private static Rectangle bounds = new Rectangle(990, 600, 300, 100);
	
	private static final Image red = GraphicsUtils.getImage("element//TipsDialog-Wrong");
	private static final Image green = GraphicsUtils.getImage("element//TipsDialog-Right");
	
	private Image bg = red;
	
	private final  MyLabel label = new MyLabel() {
		@Override
		public void paintComponent(Graphics g){
			
			GraphicsUtils.setAlpha(g, nowTime/(double)MAX_TIMES);
			g.drawImage(bg, 0, 0, null);
			g.setFont(new Font("华文细黑", Font.PLAIN, 18));
			if(text.length() > 10){
				g.drawString(text.substring(0, 9), 96, 53);
				g.drawString(text.substring(9), 96, 73);
			}else{
				g.drawString(text, 96, 60);
			}
			
			super.paintComponent(g);
		}
		
	};
	
	/**
	 * 构造器1 ， 使用默认颜色和字体
	 * @param message
	 */
	public TipsDialog(String message) {
		this(message , Color.red);
		//System.out.println("tipsDialog！");
    }
	
	public TipsDialog(String message , Color color) {
		this(message, color, GraphicsUtils.getFont(null));
    }
	
	public TipsDialog(String message , Color color , Font font) {
		this(message, color, font, false);
       
    }
	
	/**
	 * 构造器2，可以设置所在frame的位置和大小
	 * @param message
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public TipsDialog(String message,int x,int y,int width,int height){
		this(message);
		bounds=new Rectangle(x, y, width, height);
		
	}
	
	
	/**
	 * 
	 * @param message
	 * @param color
	 * @param font
	 * @param isCenter 消息是否放在图片中间（叠在图上面）
	 */
	public TipsDialog(String message , Color color , Font font , boolean isCenter) {
		super(parent);
		setUndecorated(true);
//		label.setBackground(new Color(0f, 0f, 0f, 0.75f));
//		label.setIcon(GraphicsUtils.getIcon("element//close"));
		if(color.equals(Color.GREEN)||color.equals(Color.BLUE)){
			bg = green;
		}
		
		setBackground(new Color(0f, 0f, 0f, 0f));
		//label.setForeground(Color.WHITE);
		label.setBackground(new Color(0f, 0f, 0f, 0f));
		label.setFont(font);
		text = message;
//        label.setText(message);
		
		bounds = new Rectangle(parent.getX() + 792, parent.getY() +  553, 299, 139);
        setBounds(bounds);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
    	label.setVerticalTextPosition(SwingConstants.CENTER);
        
//        if(isCenter){
//        	label.setHorizontalTextPosition(SwingConstants.CENTER);
//        	label.setVerticalTextPosition(SwingConstants.CENTER);
//        }
   
        
        new Thread(new Runnable() {
			@Override
			public void run() {
				initGUI();
				
			}
		}).start();
       
        
        
    }
	
	
	
	private void initGUI() {
		
		setBounds(bounds);
		label.setBounds(0 , 0 , (int) bounds.getWidth() ,  (int)bounds.getHeight());
		//add(label);
		getContentPane().setBackground(new Color(0f, 0f, 0f, 0f));
		getContentPane().add(label);
		
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
	
	/**
	 * 初始化提示框父指针
	 * @param parent
	 */
	public static void setFrame(JFrame parent){
	
		TipsDialog.parent = parent;
	}



	
	
}
