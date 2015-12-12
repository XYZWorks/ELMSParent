package ui.storemanager.storeshow;

import org.dom4j.Element;

import bl.storebl.StoreController;
import ui.storemanager.StoreManagerController;
import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanelWithScroller;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月12日 上午10:27:55 
 *
 */
public class StoreSingleShowPanel extends MyPanelWithScroller {
	
	StoreController bl;
	
	private MyPictureButton confirmButton;
	private MyPictureButton returnButton;
	
	
	private MyLabel centerL;
	private MyLabel storeNumL;
	private MyLabel center;
	private MyLabel storeNum;
	
	
	
	StoreManagerController controller;
	public StoreSingleShowPanel(Element config, StoreController bl, StoreManagerController controller) {
		super(config);
		this.bl = bl;
		this.controller = controller;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));

		initOtherCompoment(config);
		addCompoment();
		addListener();
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub

	}


	public void getInfo(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

}
