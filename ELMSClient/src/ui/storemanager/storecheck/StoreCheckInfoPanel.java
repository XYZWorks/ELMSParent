package ui.storemanager.storecheck;

import org.dom4j.Element;

import bl.storebl.StoreController;
import ui.storemanager.storeshow.StoreSingleShowPanel;
import ui.tools.MyJumpListener;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.PanelController;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月13日 下午3:54:03 
 *
 */
public class StoreCheckInfoPanel extends StoreSingleShowPanel {

	public StoreCheckInfoPanel(Element config, StoreController bl, PanelController controller) {
		super(config, bl, controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initButtons(Element e) {
		confirmButton = new MyPictureButton(e.element("confirm"));
		returnButton = new MyPictureButton(e.element("return"));

	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLabels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addCompoment() {
		add(confirmButton);
		add(returnButton);

	}

	@Override
	protected void addListener() {
		returnButton.addMouseListener(new MyJumpListener(returnButton, "StoreCheckPanel", controller,true));

	}

}
