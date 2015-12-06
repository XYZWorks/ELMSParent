package ui.storemanager.instore;

import org.dom4j.Element;

import bl.storebl.StoreController;
import blservice.storeblservice.StoreblService;
import blservice.transportblservice.Transportblservice;
import config.StaticMessage;
import ui.storeman.arrivezz.ArriveZZTablePanel;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.PanelController;
import util.MyDate;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月3日 下午11:36:57 
 *
 */
public class InStorePanel extends MyPanel {
	
	StoreController bl;
	
	private MyPictureButton addButton;
	private MyPictureButton returnButton;
	private MyPictureButton fullButton;
	
	private MyLabel nowDoc;
	
	private MyPanel fullInPanel;
	

	private InStoreTablePanel table;

	private PanelController controller;
	public InStorePanel(Element config, StoreController bl, PanelController controller) {
		super(config);
		this.bl = bl;
		this.controller = controller;
		initLables(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));

		initOtherCompoment(config);
		addCompoment();
		addListener();

	}

	@Override
	protected void initButtons(Element e) {
		fullButton = new MyPictureButton(e.element("full"));
		addButton = new MyPictureButton(e.element("add"));
		returnButton = new MyPictureButton(e.element("return"));

	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLables(Element e) {
		nowDoc = new MyLabel(e.element("nowDoc"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		MyDate date = MyDate.getNowTime();
		table = new InStoreTablePanel(e.element("table"), bl, date);
		fullInPanel = new FullInPanel(e.element("FullInPanel"),bl);

	}

	

	@Override
	protected void addCompoment() {
		this.add(fullButton);
		this.add(addButton);
		this.add(returnButton);
		this.add(nowDoc);
		this.add(table);
		controller.getChangePanel().add(fullInPanel,"FullInPanel");
	}

	@Override
	protected void addListener() {
		addButton.addMouseListener(new MyJumpListener(addButton, "AddInStorePanel", controller));
		returnButton.addMouseListener(new MyJumpListener(returnButton, StaticMessage.MAIN_WINDOW, controller));
		fullButton.addMouseListener(new MyJumpListener(fullButton, "FullInPanel", controller));
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}
}
