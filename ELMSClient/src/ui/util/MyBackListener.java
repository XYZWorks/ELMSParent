package ui.util;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import ui.tools.MyCardLayOut;
import ui.tools.MyPictureButton;
 /** 
 * 返回按钮
 * @author czq 
 * @version 2015年12月24日 下午12:43:16 
 */
public class MyBackListener extends MyPictureButtonListener {
	private JPanel changePanel;
	private String backStr;
	private MyCardLayOut panelManager;
	public MyBackListener(MyPictureButton button , JPanel changePanel , String backStr) {
		super(button);
		this.backStr = backStr;
		this.changePanel = changePanel;
		this.panelManager = (MyCardLayOut) changePanel.getLayout();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		panelManager.show(changePanel, backStr);
	}
}
