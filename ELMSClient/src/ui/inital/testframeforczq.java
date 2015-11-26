package ui.inital;

import org.dom4j.Element;

import ui.config.ParseXML;
import ui.tools.MyFrame;
 /** 
 * 
 * @author czq 
 * @version 2015年11月26日 上午11:13:20 
 */
public class testframeforczq extends MyFrame{
	public static void main(String[] args) {
		ParseXML xml = new ParseXML();
		testframeforczq ads = new testframeforczq(xml.getRoot());
	}
	
	public testframeforczq(Element e) {
		super(e);
		
		
		/**
		 * 整个过程中不动的界面，底色
		 */
		InitalPanel initalPanel = new InitalPanel(e.element("initialpanel") , this);

		this.setContentPane(initalPanel);

		this.setVisible(true);
	}
}
