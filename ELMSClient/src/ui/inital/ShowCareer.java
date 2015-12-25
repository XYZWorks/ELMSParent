package ui.inital;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.tools.MyButton;

/**
*右上角显示 职业身份 解析accountvo
*@author:xingcheng
*@version 2015年11月26日
*/
@SuppressWarnings("serial")
public class ShowCareer extends MyButton{

	public ShowCareer(Element config) {
		super(config);
		this.setIcon(GraphicsUtils.getIcon(""));
		this.setVisible(true);
	}
	
}
