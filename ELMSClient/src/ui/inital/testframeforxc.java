package ui.inital;

import org.dom4j.Element;

import ui.config.ParseXML;
import ui.tools.MyFrame;
import util.AccountType;
 /** 
 * 
 * @author czq 
 * @version 2015年11月26日 上午11:13:35 
 */
public class testframeforxc extends MyFrame {
	
		public static void main(String[] args) {
			ParseXML xml = new ParseXML("xc.xml");
			testframeforxc test = new testframeforxc(xml.getRoot(), null);
		}
//		private MyPanel panel;
		
		/**
		 * 
		 * @param e
		 * @param type 用户类型
		 */
		public testframeforxc(Element e , AccountType type) {
			super(e);
			
			
			/**
			 * 整个过程中不动的界面，底色
			 */
			InitalPanel initalPanel = new InitalPanel(e.element("initialpanel") , this ,null);

			this.setContentPane(initalPanel);

			this.setVisible(true);

		}
	
}
