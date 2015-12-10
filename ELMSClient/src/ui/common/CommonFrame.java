package ui.common;

import org.dom4j.Element;

import ui.config.ParseXML;
import ui.login.LoginFrame;
import ui.tools.MyFrame;

/**
*
*@author:xingcheng
*@version 2015年12月9日
*/
@SuppressWarnings("serial")
public class CommonFrame extends MyFrame{

	public CommonFrame(Element config) {
		super(config);
		
		CommonInitalPanel inital =new CommonInitalPanel(config.element("commonInitalPanel"),this);
		
		this.setContentPane(inital);

		this.setVisible(true);

	}
	public static void main(String[] args) {
		//
		ParseXML xmlReader = new ParseXML("xc.xml");
		new CommonFrame(xmlReader.getConfig("commonFrame"));
	}	
	
}
