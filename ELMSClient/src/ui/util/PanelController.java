package ui.util;

import ui.tools.MyPanel;
 /** 
 * 界面跳转控制器父类
 * @author czq 
 * @version 2015年11月26日 下午3:08:33 
 */
public abstract class PanelController {
	
	protected MyPanel mainPanel;
	
	public PanelController(MyPanel initialPanel) {
		super();
		this.mainPanel = initialPanel;
	}
	
	
	
	
}
