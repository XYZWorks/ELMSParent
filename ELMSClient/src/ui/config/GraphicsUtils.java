package ui.config;
import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.dom4j.Element;

import config.StaticMessage;
 /** 
 * 存放UI层一些可用的静态方法
 * @author czq 
 * @version 2015年11月23日 上午10:52:51 
 */
public class GraphicsUtils {
	/**
	 * 用来存储一组按钮的图片，这组图片可以被反复使用，只需要在xml文件中注明类型即可
	 */
	private static Map<String, ButtonOrLabelPicture> labelPictureMap = new HashMap<String, ButtonOrLabelPicture>(30);
	
	
	static{
		labelPictureMap.put("rectangle", new ButtonOrLabelPicture("element//rectangle", "element//rectangle-enter", "element//rectangle-clicked"));
		/**
		 * 日历图
		 */
		labelPictureMap.put("calendar", new ButtonOrLabelPicture("element//calendar", "element//calendar-enter", "element//calendar-clicked"));
		
		labelPictureMap.put("confirm", new ButtonOrLabelPicture("element//confirm", "element//confirm-enter", "element//confirm-clicked"));
		
		labelPictureMap.put("cancel", new ButtonOrLabelPicture("element//cancel", "element//cancel-enter", "element//cancel-clicked"));

		
	}
	
	public static final ButtonOrLabelPicture getButtonLabelPic(String type){
		ButtonOrLabelPicture pics  = labelPictureMap.get(type);
		if(pics == null){
			return labelPictureMap.get(1);
		}
		return pics;
		
	}
	
	
		public static final Font getFont(Element config){
			Font font;
			if(config == null){
				return new Font("华文细黑", Font.PLAIN, 20);
			}
			try {
				font = new Font(config.attributeValue("name"), Font.PLAIN, Integer.parseInt(config.attributeValue("size")));
				return font;
			} catch (Exception e) {
				return new Font("华文细黑", Font.PLAIN, 20);
			}
			
		}
	
	
		public static final Icon getIcon(String fileName){
			Icon image = null;
			image = new ImageIcon(getImage(fileName));
			return image;
		}
		
		public static final Image getImage(String fileName){
			Image image = null;
			try {
				image = ImageIO.read(new File(StaticMessage.IMAGE_PATH + fileName + ".png"));
			} catch (IOException e) {
				System.err.println("图片读取出错");
				System.err.println("图片路径为：" + StaticMessage.IMAGE_PATH + fileName + ".png" );
				e.printStackTrace();
			}
			return image;
		}

		/**
		 * 透明度设定
		 * 
		 * @param g
		 * @param d
		 */
		final static public void setAlpha(Graphics g, double d) {
			AlphaComposite alphacomposite = AlphaComposite
					.getInstance(3, (float) d);
			((Graphics2D) g).setComposite(alphacomposite);
		}

		final static public void setAlpha(Graphics2D g2d, double d) {
			AlphaComposite alphacomposite = AlphaComposite
					.getInstance(3, (float) d);
			g2d.setComposite(alphacomposite);
		}

		/**
		 * 检测长度是否合格
		 * @param s
		 * @return
		 */
		public static final boolean isLengthValid(String s){
		
			
			
		return true;
		
		}
	

	

	
}
