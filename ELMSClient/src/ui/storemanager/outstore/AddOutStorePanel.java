package ui.storemanager.outstore;

import java.util.ArrayList;

import org.dom4j.Element;

import bl.storebl.StoreController;
import ui.config.UserfulMethod;
import ui.storemanager.StoreManagerController;
import ui.storemanager.instore.InStorePanel;
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
import util.MyDate;
import util.ResultMessage;
import util.TransferWay;
import vo.store.OutStoreDocVO;

/**
 * @author ymc
 * @version 创建时间：2015年12月9日 下午8:00:05
 *
 */
@SuppressWarnings("serial")
public class AddOutStorePanel extends MyPanel {

	MyPictureButton confirmButton;
	MyPictureButton returnButton;

	MyLabel title;
	MyLabel IDL;
	MyLabel dateL;
	MyLabel sendCityL;
	MyLabel orderL;
	MyLabel shipWayL;
	MyLabel transferDocL;

	MyTextField IDT;
	MyDatePicker picker;
	MyComboBox sendCityC;
	MyComboBox shipWayC;

	MyTextField transferDocT;
	MyTextField orderT;

	StoreController bl;
	PanelController controller;

	public AddOutStorePanel(Element config, StoreController bl, StoreManagerController controller) {

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
		orderT = new MyTextField(e.element("order"));
		transferDocT = new MyTextField(e.element("transferDoc"));
	}

	@Override
	protected void initLabels(Element e) {
		title = new MyLabel(e.element("title"));
		IDL = new MyLabel(e.element("ID"));
		dateL = new MyLabel(e.element("date"));
		sendCityL = new MyLabel(e.element("sendCity"));
		orderL = new MyLabel(e.element("order"));
		shipWayL = new MyLabel(e.element("shipWay"));

		transferDocL = new MyLabel(e.element("transferDoc"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		picker = new MyDatePicker(e.element("DatePicker"));
		sendCityC = new MyComboBox(e.element("sendCityC"));
		shipWayC = new MyComboBox(e.element("shipWayC"));

	}

	@Override
	protected void addCompoment() {
		add(IDL);
		add(IDT);
		add(confirmButton);
		add(dateL);
		add(orderL);
		add(orderT);
		add(picker);
		add(returnButton);
		add(sendCityC);
		add(sendCityL);
		add(title);
		add(shipWayC);
		add(transferDocT);
		add(shipWayL);
		add(transferDocL);

	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new AddOutStoreListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "OutStorePanel", controller,true));

	}

	class AddOutStoreListener extends ConfirmListener {
		OutStoreDocVO out;
		public AddOutStoreListener(MyPictureButton button) {
			super(button);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void reInitial() {
			orderT.setText("");
			IDT.setText("");
			transferDocT.setText("");

		}

		@Override
		protected void updateMes() {
			OutStorePanel outPanel = (OutStorePanel) controller.getPanelMap().get("OutStorePanel");
			outPanel.table.updateTableMes();

		}

		@Override
		protected boolean checkDataValid() {
			
			
			ArrayList<String> orders = UserfulMethod.stringToArray(orderT.getText());
			City loc = City.toCity((String) sendCityC.getSelectedItem());
			TransferWay shipWay = TransferWay.getTransferWay((String) shipWayC.getSelectedItem());
			String transferDoc = transferDocT.getText();
			String ID = IDT.getText();
			MyDate date = picker.getMyDate();
			
			out = new OutStoreDocVO(ID, date, orders, loc, transferDoc, shipWay);
			return true;
		}

		@Override
		protected void saveToSQL() {
			if(bl.generate(out)==ResultMessage.SUCCESS){
				
				reInitial();
				
				new TipsDialog("生成出库单成功");
			}

		}

	}
}
