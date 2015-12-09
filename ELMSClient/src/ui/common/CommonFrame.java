package ui.common;

import org.dom4j.Element;

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
		
		CommonInitalPanel inital =new CommonInitalPanel(config.element(""),this);
		
		this.setContentPane(inital);

		this.setVisible(true);

	}
}
