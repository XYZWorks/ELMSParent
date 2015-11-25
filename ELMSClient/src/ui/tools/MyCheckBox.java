package ui.tools;

import javax.swing.JCheckBox;

import org.dom4j.Element;
 /** 
 * 
 * @author czq 
 * @version 2015年11月22日 下午11:25:50 
 */
@SuppressWarnings("serial")
public class MyCheckBox extends JCheckBox{
	public MyCheckBox() {
		this.setOpaque(true);
		this.setVisible(true);
	}

	public MyCheckBox(int x1, int x2, int y1,  int y2) {
		super();
		this.setBounds(x1 , y1 , x2 - x1 , y2 - y1);
		this.setVisible(true);
	}

	public MyCheckBox(Element element) {
		this.setBounds(Integer.parseInt(config.attributeValue("x")) , Integer.parseInt(config.attributeValue("y")) , Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height")));
		this.setVisible(true);
	}
}
