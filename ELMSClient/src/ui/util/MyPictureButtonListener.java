package ui.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.tools.MyPictureButton;
import util.ResultMessage;

/**
 * 按钮监听抽象父类
 * 
 * @author czq
 * @version 2015年11月29日 下午2:50:15
 */
public class MyPictureButtonListener extends MouseAdapter {
	private MyPictureButton button;
	
	protected ResultMessage result;
	
	public MyPictureButtonListener(MyPictureButton button) {
		this.button = button;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		button.setMyIcon(ButtonState.MOUSE_CLICKED);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		button.setMyIcon(ButtonState.MOUSE_ENTERED);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		button.setMyIcon(ButtonState.NORMAL);
	}

}
