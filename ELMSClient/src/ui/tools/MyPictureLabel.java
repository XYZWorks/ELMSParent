package ui.tools;

import javax.swing.Icon;
import javax.swing.JLabel;

import org.dom4j.Element;

import ui.config.ButtonOrLabelPicture;
import ui.config.GraphicsUtils;
 /** 
 * 
 * @author czq 
 * @version 2015年11月30日 下午8:17:44 
 */
@SuppressWarnings("serial")
public class MyPictureLabel extends MyLabel{
	
	private Icon normal;
	
	
	public MyPictureLabel(Element config) {
		super(config);
		if(config.attributeValue("type")!= null){
			ButtonOrLabelPicture pics = GraphicsUtils.getButtonLabelPic(Integer.parseInt(config.attributeValue("type")));
			normal = pics.getNormal();
			
			this.setIcon(normal);
			this.setHorizontalTextPosition(JLabel.CENTER);
			this.setVerticalTextPosition(JLabel.CENTER);
		}
		
	}

}
