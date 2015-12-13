package ui.storeman.storeshow;

import org.dom4j.Element;

import bl.storebl.StoreController;
import ui.storemanager.storeshow.StoreSingleShowPanel;
import ui.tools.MyJumpListener;
import ui.util.PanelController;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月13日 下午3:14:57 
 *
 */
public class StoreManSingleShowPanel extends StoreSingleShowPanel {

	public StoreManSingleShowPanel(Element config, StoreController bl, PanelController controller) {
		super(config, bl, controller);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new ShowListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "StoreShowPanel", controller,true));
	}
}
