package ui.util;

import java.awt.Button;
import java.awt.event.MouseEvent;

import ui.tools.MyPictureButton;
 /** 
 * 主界面按钮监听类
 * @author czq 
 * @version 2015年11月29日 下午5:19:04 
 */
public class MyMainPanelButtonListener extends MyPictureButtonListener{
	
	private final String panelName;
	private PanelController controller;
	
	
	public MyMainPanelButtonListener(MyPictureButton button , String panelName , PanelController controller) {
		super(button);
		this.panelName = panelName;
		this.controller = controller;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		controller.jumpToWindow(panelName);
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		button.setMyIcon(ButtonState.MOUSE_CLICKED);
		
	}
	
}
