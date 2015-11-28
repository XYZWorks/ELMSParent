package ui.tools;

import java.security.KeyStore.PrivateKeyEntry;

import javax.swing.Icon;
import javax.swing.JLabel;

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
	
	private Icon nowPanel;
	private Icon normal;
	private Icon entered;
	private Icon clicked;
	
	public MySideBarButton(Element e) {
		
		nowPanel = GraphicsUtils.sideBarNow;
		normal = GraphicsUtils.sideBarNormal;
		entered = GraphicsUtils.sideBarEntered;
		clicked = GraphicsUtils.sideBarClicked;
		
		this.setIcon(normal);
		this.setBounds(Integer.parseInt(e.attributeValue("x")),
				Integer.parseInt(e.attributeValue("y")),
				Integer.parseInt(e.attributeValue("width")),
				Integer.parseInt(e.attributeValue("height")));

		this.setFont(GraphicsUtils.getFont(e.addAttribute("fontname", "size")));

		this.setText(e.attributeValue("text"));
		this.repaint();
		this.setVisible(true);
	}
	
	public void setMyIcon(ButtonState state) {
		if(state == null){
			this.setIcon(nowPanel);
			return;
		}
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
	
}
