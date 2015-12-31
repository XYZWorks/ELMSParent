package ui.storemanager.outstore;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.saleman.PayDoc.PaySmallTable;
import ui.storemanager.StoreManagerController;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.tools.MyWhitePanel;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.DocPanelForApproval;
import ui.util.MyBackListener;
import ui.util.PanelController;
import ui.util.TipsDialog;
import util.City;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import util.TransferWay;
import vo.store.OutStoreDocVO;
import bl.storebl.StoreController;

/**
 * @author ymc
 * @version 创建时间：2015年12月9日 下午8:00:05
 *
 */
@SuppressWarnings("serial")
public class AddOutStorePanel extends MyPanel implements DocPanelForApproval {
	private MyWhitePanel whitePanel;

	MyPictureButton confirmButton;
	MyPictureButton returnButton;
	MyPictureButton cancelButton;

	MyPictureLabel title;
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

	private MyPictureButton addOneOrder;
	private MyLabel newOrder;
	private MyTextField orderCode;
	/**
	 * 接收单上放置的订单号表
	 */
	private PaySmallTable ordersTable;

	public AddOutStorePanel(Element config, StoreController bl, StoreManagerController controller) {

		super(config);
		this.bl = bl;
		this.controller = controller;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initOtherCompoment(config);
		addCompoment();
		// 为了单据审批
		if (controller == null) {
			return;
		}

		addListener();
	}

	@Override
	protected void initWhitePanels(Element e) {
		whitePanel = new MyWhitePanel(e.element("whitePanel"));
	}

	@Override
	protected void initButtons(Element e) {
		confirmButton = new MyPictureButton(e.element("confirm"));
		returnButton = new MyPictureButton(e.element("return"));
		addOneOrder = new MyPictureButton(e.element("addOrder"));
		cancelButton = new MyPictureButton(e.element("cancelButton"));
	}

	@Override
	protected void initTextFields(Element e) {
		IDT = new MyTextField(e.element("ID"));
		if (controller != null) {
			IDT.setText("CKD" + MyDate.getDatePart(MyDate.getNowTime())
					+ UserfulMethod.toSeven(bl.getDayDocCount(DocType.outStoreDoc)));
		}
		IDT.setEditable(false);

		transferDocT = new MyTextField(e.element("transferDoc"));
		orderCode = new MyTextField(e.element("order"));
	}

	@Override
	protected void initLabels(Element e) {
		title = new MyPictureLabel(e.element("title"));
		IDL = new MyLabel(e.element("ID"));
		dateL = new MyLabel(e.element("date"));
		sendCityL = new MyLabel(e.element("sendCity"));
		shipWayL = new MyLabel(e.element("shipWay"));

		transferDocL = new MyLabel(e.element("transferDoc"));
		newOrder = new MyPictureLabel(e.element("order"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		picker = new MyDatePicker(e.element("DatePicker"));
		sendCityC = new MyComboBox(e.element("sendCityC"));
		shipWayC = new MyComboBox(e.element("shipWayC"));
		ordersTable = new PaySmallTable(e.element("table"));

	}

	@Override
	protected void addCompoment() {
		whitePanel.add(title);

		whitePanel.add(IDL);
		whitePanel.add(IDT);

		whitePanel.add(dateL);

		whitePanel.add(sendCityC);
		whitePanel.add(sendCityL);

		whitePanel.add(shipWayC);
		whitePanel.add(transferDocT);
		whitePanel.add(shipWayL);
		whitePanel.add(transferDocL);

		this.add(whitePanel);
		add(picker);
		add(cancelButton);
		add(confirmButton);
		add(returnButton);
		
		add(ordersTable);
		add(orderCode);
		add(newOrder);
		add(addOneOrder);
		
		confirmButton.setLocation(500, 460);
		cancelButton.setLocation(650, 460);
	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new AddOutStoreListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "OutStorePanel", controller, true));
		cancelButton.addMouseListener(new CancelListener(cancelButton) {

			@Override
			public void resetMes() {
				transferDocT.setText("");

			}
		});
	}

	class AddOutStoreListener extends ConfirmListener {
		OutStoreDocVO out;

		public AddOutStoreListener(MyPictureButton button) {
			super(button);
		}

		@Override
		protected void reInitial() {
			orderT.setText("");
			IDT.setText("CKD" + MyDate.getDatePart(MyDate.getNowTime())
					+ UserfulMethod.toSeven(bl.getDayDocCount(DocType.outStoreDoc)));

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
			// System.out.println((String) sendCityC.getSelectedItem());
			City loc = City.toCity((String) sendCityC.getSelectedItem());
			// System.out.println((String) shipWayC.getSelectedItem());
			TransferWay shipWay = TransferWay.getTransferWay((String) shipWayC.getSelectedItem());
			String transferDoc = transferDocT.getText();
			String ID = IDT.getText();
			MyDate date = picker.getMyDate();
			SimpleDataFormat[] datas = new SimpleDataFormat[orders.size() + 1];
			datas[0] = new SimpleDataFormat(transferDoc, DataType.ID, "中转单");
			for (int i = 1; i < orders.size() + 1; i++) {
				datas[i] = new SimpleDataFormat(orders.get(i - 1), DataType.BarCode, "订单号");
			}
			out = new OutStoreDocVO(ID, date, orders, loc, transferDoc, shipWay);
			return UserfulMethod.dealWithData(datas);

		}

		@Override
		protected boolean saveToSQL() {
			if (bl.generate(out) == ResultMessage.SUCCESS) {

				// reInitial();

				new TipsDialog("生成成功");
				bl.updateStore(out.loc, out.shipWay, out.ID, out.type);
			}
			return true;

		}

	}

	@Override
	public void setAllCompUneditOrUnVisiable() {
		orderT.setEditable(false);
		transferDocT.setEditable(false);
		IDT.setEditable(false);
		sendCityC.setEnabled(false);
		shipWayC.setEnabled(false);

		confirmButton.setVisible(false);
		returnButton.setVisible(false);

	}

	@Override
	public void addBackButton(JPanel changePanel, String backStr) {
		MyPictureButton back = new MyPictureButton();
		add(back);
		back.addMouseListener(new MyBackListener(back, changePanel, backStr));

	}

	@Override
	public void setMessage(Object o) {
		if (o == null) {
			return;
		}
		OutStoreDocVO vo = (OutStoreDocVO) o;
		IDT.setText(vo.ID);
		orderT.setText(UserfulMethod.orderArrayToString(vo.orders));
		transferDocT.setText(vo.transferDoc);
		picker.setTime(vo.date);
		sendCityC.setSelectedItem(vo.loc.getName());
		shipWayC.setSelectedItem(vo.shipWay.getStoreLocation());
	}
}
