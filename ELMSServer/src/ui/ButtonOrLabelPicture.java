package ui;

import javax.swing.Icon;

/** 
 * 用来构造map的一组图
 * @author czq 
 * @version 2015年11月30日 下午7:59:00 
 */

public class ButtonOrLabelPicture {
	
	private Icon normal;
	
	private Icon clicked;
	
	private Icon enter;
	
	public ButtonOrLabelPicture(String normal, String enter , String clicked )  {
		this.normal = GraphicsUtils.getIcon(normal);
		this.clicked = GraphicsUtils.getIcon(clicked);
		this.enter = GraphicsUtils.getIcon(enter);
	}

	public Icon getNormal() {
		return normal;
	}

	public Icon getClicked() {
		return clicked;
	}

	public Icon getEnter() {
		return enter;
	}
	
	
	
	
}
