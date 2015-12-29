package main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.config.ParseXML;
import ui.login.LoginFrame;

 /** 
 * 程序入口
 * @author czq 
 * @version 2015年11月17日 下午8:37:52 
 */
public class AXIS {
	
	public AXIS() {
//		try {
//			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
//			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//			
//			UIManager.put("RootPane.setupButtonVisible" ,false);
//			UIManager.put("RootPane.frameBorder", new EmptyBorder(0, 0, 0, 0));
//			UIManager.put("RootPaneUI", UIManager.getDefaults().get("RootPaneUI"));
//			UIManager.put("RootPane.frameBorder", UIManager.getDefaults().get("RootPane.frameBorder"));
//			//取消美化包所使用的美化~
//			UIManager.put("RootPaneUI", UIManager.getDefaults().get("RootPane"));
//		}catch(Exception e){
//			
//		}
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ParseXML xmlReader = new ParseXML("UIConfig.xml");
				new LoginFrame(xmlReader.getConfig("loginframe"));
			}
			
		});
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new AXIS();
	}
}
