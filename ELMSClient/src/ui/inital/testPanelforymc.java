package ui.inital;

import org.dom4j.Element;

import ui.config.ParseXML;
import ui.generalmanager.ConstSetPanel;
import ui.tools.MyFrame;

/** 
 * @author ymc 
 * @version 创建时间：2015年11月29日 下午3:09:02 
 *
 */
public class testPanelforymc extends MyFrame{

	public testPanelforymc(Element e) {
		super(e);
		
		InitalPanel initalPanel = new InitalPanel(e.element("initialpanel3") , this , null);

		

		this.setContentPane(initalPanel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		ParseXML parseXML = new ParseXML("ymc.xml");
		testPanelforymc test = new testPanelforymc(parseXML.getRoot());
	}

}
