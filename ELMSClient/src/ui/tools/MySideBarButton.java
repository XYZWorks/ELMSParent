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
	
	private static Icon nowPanel;
	private static Icon normal;
	private static Icon entered;
	private static Icon clicked;
	
	static{
		nowPanel = GraphicsUtils.getIcon("element//sidebar-now");
		normal = GraphicsUtils.getIcon("element//sidebar");
		entered = GraphicsUtils.getIcon("element//sidebar-enter");
		clicked = GraphicsUtils.getIcon("element//sidebar-clicked");
	}
	
	public MySideBarButton(Element e) {
		
		this.setIcon(normal);
		this.setBounds(Integer.parseInt(e.attributeValue("x")),
				Integer.parseInt(e.attributeValue("y")),
				232 ,40);

		this.setFont(GraphicsUtils.getFont(null));
		
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
