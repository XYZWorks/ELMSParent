package ui.initial;

import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

import org.dom4j.Element;

import ui.config.ParseXML;
import ui.tools.MyFrame;
import util.AccountType;
import vo.account.AccountVO;
 /** 
 * 
 * @author czq 
 * @version 2015年11月26日 上午11:13:20 
 */
@SuppressWarnings("serial")
public class testframeforczq extends MyFrame{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		ParseXML xml = new ParseXML();
		 new testframeforczq(xml.getRoot());
	}
	
	public testframeforczq(Element e) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		super(e);
		
		try {
//			System.setProperty("sun.java2d.noddraw", "true");
//			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//			UIManager.put("RootPane.setupButtonVisible" ,false);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * 整个过程中不动的界面，底色
		 */
		InitialPanel initalPanel = new InitialPanel(e.element("initialpanel") , this , new AccountVO("1111111", "1213", AccountType.financeman, "1213"));

		this.setContentPane(initalPanel);
		
//		try
//	    {
////	        BeautyEyeLNFHelper.launchBeautyEyeLNF();
//	       ;
//	        UIManager.setLookAndFeel( BeautyEyeLNFHelper.getBeautyEyeLNFWindowsPlatform());
//	    }
//	    catch(Exception ex)
//	    {
//	    }
	
		
		
		this.setVisible(true);
	}
}
