package ui.util;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.tools.MySideBarButton;
 /** 
 * 左边条按钮监听实现类
 * @author czq 
 * @version 2015年11月29日 下午2:32:36 
 */
public class MySideBarListener extends MouseAdapter{
	
	private MySideBarButton button;
	
	private PanelController controller;
	
	private CardLayout panelManager;
	/**
	 * 该左边条按钮对应的panel名称
	 */
	private String itsPanel;
	
	public MySideBarListener(MySideBarButton button , PanelController controller , String itsPanel) {
		this.button = button;
		this.controller = controller;
		this.panelManager = controller.panelManager;
		this.itsPanel = itsPanel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		controller.setAllButtonUnClicked(); 
		controller.setAllButtonVisable(true);
		button.setMyIcon(null);
		panelManager.show(controller.changePanel, itsPanel);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(button.getClicked()){
			return;
		}
		button.setMyIcon(ButtonState.MOUSE_CLICKED);
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(button.getClicked()){
			return;
		}
		button.setMyIcon(ButtonState.MOUSE_ENTERED);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(button.getClicked()){
			return;
		}
		button.setMyIcon(ButtonState.NORMAL);
	}
}
