package ui.storemanager.instore;

import org.dom4j.Element;

import bl.storebl.StoreController;
import ui.storemanager.StoreManagerController;
import ui.table.MyTablePanel;
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
 * @version 创建时间：2015年12月6日 下午3:37:55 
 *
 */
public class FullInPanel extends MyPanel {
	
	MyPictureButton returnButton;
	
	MyLabel title;
	MyLabel IDL;
	MyLabel dateL;
	MyLabel sendCityL;
	MyLabel locInfoL;
	
	MyLabel IDshow;
	MyLabel dateshow;
	MyLabel sendCityshow;
	
	ShowLocTablePanel locInfoTable;
	
	StoreController bl;
	PanelController controller;
	InStoreDocVO vo = null;
	
	public FullInPanel(Element config, StoreController bl, StoreManagerController controller) {
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
		returnButton = new MyPictureButton(e.element("return"));

	}

	@Override
	protected void initTextFields(Element e) {
		

	}

	@Override
	protected void initLabels(Element e) {
		title = new MyLabel(e.element("title"));
		IDL = new MyLabel(e.element("ID"));
		dateL = new MyLabel(e.element("date"));
		sendCityL = new MyLabel(e.element("sendCity"));
		locInfoL = new MyLabel(e.element("locInfo"));
		
		IDshow = new MyLabel(e.element("IDshow"));
		dateshow = new MyLabel(e.element("dateshow"));
		sendCityshow = new MyLabel(e.element("sendCityshow"));
		
	}

	
	@Override
	protected void initOtherCompoment(Element e) {
		locInfoTable = new ShowLocTablePanel(e.element("table"));
	}

	@Override
	protected void addCompoment() {
		add(IDL);
		add(IDshow);
		add(dateL);
		add(dateshow);
		add(locInfoL);
		add(locInfoTable);
		add(returnButton);
		add(sendCityL);
		add(sendCityshow);
		add(title);

	}

	@Override
	protected void addListener() {
		returnButton.addMouseListener(new MyJumpListener(returnButton, "InStorePanel", controller,true));
	}

	public void setInStoreVO(InStoreDocVO vo) {
		this.vo = vo;
		initValue();
	}

	private void initValue() {
		IDshow.setText(vo.ID);
		dateshow.setText(MyDate.toString(vo.date));
		sendCityshow.setText(vo.loc.getName());
		locInfoTable.orders = vo.orders;
		locInfoTable.locs = vo.location;
		locInfoTable.reset();
		
	}

}
