package ui.storemanager.instore;

import java.util.ArrayList;

import org.dom4j.Element;

import bl.storebl.StoreController;
import ui.storemanager.StoreManagerController;
import ui.table.MyTablePanel;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.PanelController;
import ui.util.TipsDialog;
import util.City;
import util.ResultMessage;
import vo.store.InStoreDocVO;

/**
 * @author ymc
 * @version 创建时间：2015年12月6日 下午2:27:17
 *
 */
public class AddInStorePanel extends MyPanel {

	MyPictureButton confirmButton;
	MyPictureButton returnButton;

	MyLabel title;
	MyLabel IDL;
	MyLabel dateL;
	MyLabel sendCityL;
	MyLabel locInfoL;
	
	MyTextField IDT;
	MyDatePicker picker;
	MyComboBox sendCityC;
	
	AddLocTablePanel locInfoTable;
	
	StoreController bl;
	PanelController controller;

	public AddInStorePanel(Element config, StoreController bl, StoreManagerController controller) {
		
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
		confirmButton = new MyPictureButton(e.element("confirm"));
		returnButton = new MyPictureButton(e.element("return"));

	}

	@Override
	protected void initTextFields(Element e) {
		IDT = new MyTextField(e.element("ID"));
		
	}

	@Override
	protected void initLabels(Element e) {
		title = new MyLabel(e.element("title"));
		IDL = new MyLabel(e.element("ID"));
		dateL = new MyLabel(e.element("date"));
		sendCityL = new MyLabel(e.element("sendCity"));
		locInfoL = new MyLabel(e.element("locInfo"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		picker = new MyDatePicker(e.element("DatePicker"));
		sendCityC = new MyComboBox(e.element("sendCityC"));
		locInfoTable = new AddLocTablePanel(e.element("table"));

	}

	@Override
	protected void addCompoment() {
		add(IDL);
		add(IDT);
		add(confirmButton);
		add(dateL);
		add(locInfoL);
		add(locInfoTable);
		add(picker);
		add(returnButton);
		add(sendCityC);
		add(sendCityL);
		add(title);

	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new AddInStoreListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "InStorePanel", controller));


	}
	
	class AddInStoreListener extends ConfirmListener{

		InStoreDocVO vo = new InStoreDocVO();
		public AddInStoreListener(MyPictureButton button) {
			super(button);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void reInitial() {
			IDT.setText("");
			locInfoTable.resetData();
			
		}

		@Override
		protected boolean checkDataValid() {
			vo.ID = IDT.getText();
			vo.date = picker.getMyDate();
			vo.loc = City.toCity((String)sendCityC.getSelectedItem());
			vo.orders = locInfoTable.getOrders();
			vo.location = locInfoTable.getLocations();
			//TODO
			return true;
		}

		@Override
		protected void saveToSQL() {
			
			ResultMessage result = bl.generate(vo);
			
			if(result ==ResultMessage.SUCCESS){
				reInitial();
				new TipsDialog("生成入库单成功");
			}
				
			
			
		}

		
		
	}

}
