package ui.inital;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.dom4j.Element;

import ui.config.ParseXML;
import ui.tools.MyFrame;
 /** 
 * 
 * @author czq 
 * @version 2015年11月26日 上午11:13:20 
 */
@SuppressWarnings("serial")
public class testframeforczq extends MyFrame{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		ParseXML xml = new ParseXML();
		testframeforczq ads = new testframeforczq(xml.getRoot());
	}
	
	public testframeforczq(Element e) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		super(e);
		
		
		/**
		 * 整个过程中不动的界面，底色
		 */
		InitalPanel initalPanel = new InitalPanel(e.element("initialpanel") , this , null);

		this.setContentPane(initalPanel);
		
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		
		
		this.setVisible(true);
	}
}
