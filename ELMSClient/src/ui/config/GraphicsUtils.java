package ui.config;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import config.StaticMessage;
 /** 
 * 存放UI层一些可用的静态方法
 * @author czq 
 * @version 2015年11月23日 上午10:52:51 
 */
public class GraphicsUtils {

		
		
		public static final Image getImage(String fileName){
			Image image = null;
			try {
				image = ImageIO.read(new File(StaticMessage.imagePath + fileName + ".png"));
			} catch (IOException e) {
				System.err.println("图片读取出错");
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

	

	

	
}
