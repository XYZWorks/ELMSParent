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
@SuppressWarnings("serial")
public class testframeforxc extends MyFrame {
	
		public static void main(String[] args) {
			ParseXML xml = new ParseXML();
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
			
			try {
				org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/**
			 * 整个过程中不动的界面，底色
			 */
			InitalPanel2 initalPanel = new InitalPanel2(e.element("initialpanel") , this ,null);
			
//			try {
//			//	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//			} catch (ClassNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (InstantiationException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IllegalAccessException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (UnsupportedLookAndFeelException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
			this.setContentPane(initalPanel);

			this.setVisible(true);

		}
	
}
