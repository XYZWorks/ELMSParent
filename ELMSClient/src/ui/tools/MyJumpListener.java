package ui.tools;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import config.StaticMessage;
import ui.util.MyPictureButtonListener;
import ui.util.PanelController;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月5日 上午10:14:37 
 *
 */
public class MyJumpListener extends MyPictureButtonListener{
	private PanelController controller;
	
	private CardLayout layout;
	
	private String toPanel;
	public MyJumpListener(MyPictureButton button, String toPanel, PanelController controller) {
		super(button);
		this.toPanel = toPanel;
		this.controller = controller;
		this.layout = controller.getCardLayout();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		super.mouseClicked(e);
		
		layout.show(controller.getChangePanel(), toPanel);
//		if(toPanel.equals(StaticMessage.MAIN_WINDOW)){
			controller.setAllButtonVisable(false);
			controller.setAllButtonUnClicked();
//		}
	}
}