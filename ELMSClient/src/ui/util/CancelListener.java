package ui.util;

import java.awt.event.MouseEvent;

import ui.tools.MyPictureButton;
 /** 
 * 各种单据取消时监听按钮
 * @author czq 
 * @version 2015年12月5日 下午7:16:10 
 */
public abstract class CancelListener extends MyPictureButtonListener{

	public CancelListener(MyPictureButton button) {
		super(button);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {	
		super.mouseClicked(e);
		resetMes();
	}
	public abstract void resetMes();

	
	@Override
	public void mouseClicked(MouseEvent e) {
		resetMes();
	}
}
