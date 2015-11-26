package ui.careerChoose;

import org.dom4j.Element;

import ui.tools.MyFrame;

/**
*
*@author:xingcheng
*@version 2015年11月25日
*/

@SuppressWarnings("serial")
public class CareerFrame extends MyFrame{
	private CareerInitalPanel inital;
	private CareerJump careerPanel;
	private Element config;
	
	

	public CareerFrame(Element config){
		super(config);
		this.config = config;
		
	}

}
