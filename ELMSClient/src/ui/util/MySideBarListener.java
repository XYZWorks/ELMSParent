package ui.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.tools.MySideBarButton;
 /** 
 * 
 * @author czq 
 * @version 2015年11月29日 下午2:32:36 
 */
public class MySideBarListener extends MouseAdapter{
	
	private MySideBarButton button;
	
	private PanelController controller;
	
	public MySideBarListener(MySideBarButton button , PanelController controller) {
		this.button = button;
		this.controller = controller;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		controller.setAllButtonUnClicked();
		button.setMyIcon(null);
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
