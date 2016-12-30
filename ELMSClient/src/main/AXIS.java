package main;

import java.awt.EventQueue;

import javax.swing.UIManager;

import ui.config.ParseXML;
import ui.login.LoginFrame;

 /** 
 * 程序入口
 * @author czq 
 * @version 2015年11月17日 下午8:37:52 
 * 
 * Last edited on Dec 30th 2016
 */
public class AXIS {
	
	public AXIS() {
	  
	  
	  
		try {
		  Object temp = UIManager.getDefaults().get("RootPaneUI");
      org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
      //取消美化包所使用的美化~   
      /*
       * 如果在Windows平台下下述temp改成null，否则为temp
       */
      //Use system config to change the style
      ParseXML globalConfig = new ParseXML("globalConfig.xml");
      String isInWindows = globalConfig.getConfig("platform").attributeValue("inWindows");
      if (isInWindows.equalsIgnoreCase("true")  ) {
        temp = null;
        System.out.println("Application opened in Windows Mode");
      }
      UIManager.put("RootPaneUI", temp);
		}catch(Exception e){
			 e.printStackTrace();
		}
		
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
