package ui.tools;

import java.awt.event.MouseEvent;

import ui.util.MyPictureButtonListener;
import ui.util.PanelController;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月5日 上午10:14:37 
 *
 */
public class MyJumpListener extends MyPictureButtonListener{
	protected PanelController controller;
	
	protected MyCardLayOut layout;
	
	protected String toPanel;
	
	protected Boolean isVisable;
	
	public MyJumpListener(MyPictureButton button, String toPanel, PanelController controller,boolean isVisable) {
		super(button);
		this.toPanel = toPanel;
		if(controller!=null){
			this.controller = controller;
			this.layout = controller.getCardLayout();
		}
		this.isVisable = isVisable;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		super.mouseClicked(e);
		
		layout.show(controller.getChangePanel(), toPanel);
//		if(toPanel.equals(StaticMessage.MAIN_WINDOW)){
			controller.setAllButtonVisable(isVisable);
			controller.setAllButtonUnClicked();
			if(isVisable)
				controller.setTheRelatedButton(toPanel);
//		}
//		System.out.println("jump to "+ toPanel);
	}
}