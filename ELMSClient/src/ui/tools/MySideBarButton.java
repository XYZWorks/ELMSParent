package ui.tools;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.util.ButtonState;
 /** 
 * 左边条Button
 * @author czq 
 * @version 2015年11月28日 下午3:27:24 
 */
@SuppressWarnings("serial")
public class MySideBarButton extends JLabel{
	
	private static Icon nowPanel;
	private static Icon normal;
	private static Icon entered;
	private static Icon clicked;
	
	private boolean isClicked = false;
	
	//加载的4张图片始终相等 所以使用静态常量
	static{
		nowPanel = GraphicsUtils.getIcon("element//sidebar-now");
		normal = GraphicsUtils.getIcon("element//sidebar");
		entered = GraphicsUtils.getIcon("element//sidebar-enter");
		clicked = GraphicsUtils.getIcon("element//sidebar-clicked");
	}
	
	public MySideBarButton(Element e) {
//		super(e.attributeValue("text"), normal, JLabel.CENTER);
		this.setIcon(normal);
		try{
		this.setBounds(Integer.parseInt(e.attributeValue("x")),
								Integer.parseInt(e.attributeValue("y")),
								Integer.parseInt(e.attributeValue("width")), Integer.parseInt(e.attributeValue("height")));
		}
		catch(Exception nullex){
			this.setBounds(Integer.parseInt(e.attributeValue("x")),
					Integer.parseInt(e.attributeValue("y")),
					232 ,40);
		}

		this.setFont(GraphicsUtils.getFont(null));
		this.setForeground(Color.WHITE);
		this.setText(e.attributeValue("text"));
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.repaint();
		this.setVisible(true);
	}
	
	public void setMyIcon(ButtonState state) {
		if(state == null){
			this.setIcon(nowPanel);
			isClicked = true;
			return;
		}
		
		isClicked = false;
		switch (state) {
		case NORMAL:
			this.setIcon(normal);
			break;
		case MOUSE_ENTERED:
			this.setIcon(entered);
			break;
		case MOUSE_CLICKED:
			this.setIcon(clicked);
			break;
		default:
			break;
		}

	}
	
//	public void setClicked(boolean isClicked){
//		this.isClicked = isClicked;
//	}
	public boolean getClicked(){
		return isClicked;
	}
}
