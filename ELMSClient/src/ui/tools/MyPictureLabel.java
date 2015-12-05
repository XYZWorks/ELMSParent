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
	
	
public MyPictureLabel(String str) {
		
		
		super();
			
			
			ButtonOrLabelPicture pics = GraphicsUtils.getButtonLabelPic("rectangle");
			normal = pics.getNormal();
			this.setText(str);
			this.setIcon(normal);
			this.setHorizontalTextPosition(JLabel.CENTER);
			this.setVerticalTextPosition(JLabel.CENTER);
		
	}
	
	
	public MyPictureLabel(Element config) {
		
		
		super(config);
		
		//一个label－>一张图片的加载
		if(config.attributeValue("one")!= null){
			this.setIcon(GraphicsUtils.getIcon(config.attributeValue("one")));
		}
		
		//一个label->三张图片的加载
		if(config.attributeValue("type")!= null){
			
			
			ButtonOrLabelPicture pics = GraphicsUtils.getButtonLabelPic(config.attributeValue("type"));
			normal = pics.getNormal();
			
			this.setIcon(normal);
			this.setHorizontalTextPosition(JLabel.CENTER);
			this.setVerticalTextPosition(JLabel.CENTER);
		}
		
	}

}
