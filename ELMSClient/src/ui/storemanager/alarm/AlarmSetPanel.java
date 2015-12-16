package ui.storemanager.alarm;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import bl.storebl.StoreController;
import config.StaticMessage;
import ui.storemanager.StoreManagerController;
import ui.storemanager.storecheck.StoreCheckInfoPanel;
import ui.storemanager.storeshow.StoreShowPanel;
import ui.tools.MyJumpListener;
import ui.tools.MyPictureButton;
import ui.util.PanelController;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月3日 上午11:48:39 
 *
 */
public class AlarmSetPanel extends StoreShowPanel {
	public AlarmSetPanel(Element config ,StoreController bl, StoreManagerController controller) {
		super(config, bl, controller);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new SingleShowListener(confirmButton, "AlarmSetSinglePanel", controller));
		returnButton.addMouseListener(new MyJumpListener(returnButton, StaticMessage.MAIN_WINDOW, controller,false));


	}
	
	 class SingleShowListener extends MyJumpListener{

		public SingleShowListener(MyPictureButton button, String toPanel, PanelController controller) {
			super(button, toPanel, controller,false);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			AlarmSetSinglePanel tmp  = (AlarmSetSinglePanel) controller.getPanelMap().get("AlarmSetSinglePanel");
			tmp.getInfo(cityC.getSelectedItem().toString(),storeC.getSelectedItem().toString());
		}
	}

}
