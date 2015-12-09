package ui.storemanager.outstore;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import bl.storebl.StoreController;
import config.StaticMessage;
import ui.storemanager.instore.FullInPanel;
import ui.storemanager.instore.InStoreTablePanel;

import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.PanelController;
import util.MyDate;
import vo.store.InStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月3日 下午11:36:37 
 *
 */
public class OutStorePanel extends MyPanel {

	StoreController bl;
	
	private MyPictureButton addButton;
	private MyPictureButton returnButton;
	
	
	private MyLabel nowDoc;
	

	

	 OutStoreTablePanel table;

	private PanelController controller;
	public OutStorePanel(Element config, StoreController bl, PanelController controller) {
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
	protected void initButtons(Element e) {
		addButton = new MyPictureButton(e.element("add"));
		returnButton = new MyPictureButton(e.element("return"));

	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLabels(Element e) {
		nowDoc = new MyLabel(e.element("nowDoc"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		MyDate date = MyDate.getNowTime();
		table = new OutStoreTablePanel(e.element("table"), bl, date);
		

	}

	

	@Override
	protected void addCompoment() {
		this.add(addButton);
		this.add(returnButton);
		this.add(nowDoc);
		this.add(table);
		
	}

	@Override
	protected void addListener() {
		addButton.addMouseListener(new MyJumpListener(addButton, "AddInStorePanel", controller));
		returnButton.addMouseListener(new MyJumpListener(returnButton, StaticMessage.MAIN_WINDOW, controller));
	}
	
	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

}
