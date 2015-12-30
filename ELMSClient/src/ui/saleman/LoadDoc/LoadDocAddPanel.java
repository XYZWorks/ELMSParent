package ui.saleman.LoadDoc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.storeman.transport.TransportOrders;
import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.tools.MyWhitePanel;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
import ui.util.DocPanelForApproval;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.City;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.transport.LoadDocVO;
import blservice.transportblservice.Transportblservice;

/**
 * 装车单增加界面
 * 
 * @author czq
 * @version 2015年12月8日 下午8:27:23
 */
@SuppressWarnings("serial")
public class LoadDocAddPanel extends AddDocPanel implements DocPanelForApproval {

	private MyWhitePanel whitePanel;

	private MyPictureLabel loadInfo;
	
	private MyLabel id;
	private MyDatePicker date;
	private MyLabel YYID;
	private MyLabel loadDocID;
	private MyLabel arriveCity;
	private MyLabel carID;
	private MyLabel supervisor;
	private MyLabel escort;
	private MyLabel newOrder;

	private MyTextField idT;
	private MyTextField YYIDT;
	private MyTextField loadDocT;
	private MyComboBox arriveCityB;;
	private MyTextField supervisorT;
	private MyTextField carT;
	private MyTextField escortT;
	private MyTextField orderCode;

	private MyPictureButton addOneOrder;
	/**
	 * 装车单上放置的订单号表
	 */
	private LoadDocOrders ordersTable;

	Transportblservice bl;

	public LoadDocAddPanel(Element config, JPanel changePanel, String checkDocPanelStr, MyTablePanel messageTable) {
		super(config, changePanel, checkDocPanelStr, messageTable);
	}

	@Override
	protected void initWhitePanels(Element e) {
		whitePanel = new MyWhitePanel(e.element("whitePanel"));
	}

	@Override
	protected void initButtons(Element e) {
		addOneOrder = new MyPictureButton(e.element("addOrder"));

	}

	@Override
	protected void initTextFields(Element e) {

		idT = new MyTextField(e.element("id"));
		idT.setEditable(false);

		YYIDT = new MyTextField(e.element("YYID"));
		loadDocT = new MyTextField(e.element("loadDoc"));
		carT = new MyTextField(e.element("car"));
		supervisorT = new MyTextField(e.element("supervisor"));
		escortT = new MyTextField(e.element("escort"));
		orderCode = new MyTextField(e.element("order"));
	}

	@Override
	protected void initLabels(Element e) {
		loadInfo = new MyPictureLabel(e.element("loadInfo"));

		id = new MyLabel(e.element("id"));
		YYID = new MyLabel(e.element("YYID"));
		loadDocID = new MyLabel(e.element("loadDoc"));
		arriveCity = new MyLabel(e.element("arriveCity"));
		carID = new MyLabel(e.element("car"));
		supervisor = new MyLabel(e.element("supervisor"));
		escort = new MyLabel(e.element("escort"));
		newOrder = new MyPictureLabel(e.element("order"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		date = new MyDatePicker(e.element("datepicker"));
		arriveCityB = new MyComboBox(e.element("arrive"));
		ordersTable = new LoadDocOrders(e.element("table"));
	}

	@Override
	protected void addCompoment() {
		whitePanel.add(loadInfo);
		whitePanel.add(YYIDT);
		whitePanel.add(arriveCity);
		whitePanel.add(arriveCityB);
		whitePanel.add(carID);
		whitePanel.add(carT);
		whitePanel.add(escort);
		whitePanel.add(escortT);
		whitePanel.add(id);
		whitePanel.add(idT);
		whitePanel.add(YYID);
		whitePanel.add(loadDocID);
		whitePanel.add(loadDocT);
		whitePanel.add(supervisor);
		whitePanel.add(supervisorT);
		
		this.add(whitePanel);
		add(date);
		add(orderCode);
		add(newOrder);
		add(addOneOrder);
		add(ordersTable);
		
		confirm.setLocation(500, 520);
		cancel.setLocation(650, 520);
	}

	@Override
	protected void addListener() {
		addOneOrder.addMouseListener(new MyPictureButtonListener(addOneOrder) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String temp = orderCode.getText();
				if (UserfulMethod.dealWithData(new SimpleDataFormat(temp, DataType.ID, "订单号"))) {
					ordersTable.addAOrder(temp);
					new TipsDialog("成功新增订单", Color.BLUE);
				}
			}
		});
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String id;
			MyDate myDate;
			String yyID;
			String loadDocID;
			City arriveCity;
			String carID;
			String supervisor;
			String escort;
			ArrayList<String> orderBarCodes;
			LoadDocVO vo;

			@Override
			protected void updateMes() {
				messageTable.addOneData(vo, 1);
			}

			@Override
			protected boolean saveToSQL() {
				if (bl.add(vo = new LoadDocVO(id, myDate, yyID, loadDocID, arriveCity, carID, supervisor, escort,
						orderBarCodes)) == ResultMessage.SUCCESS) {
					new TipsDialog("成功新增装车单", Color.GREEN);
					return true;
				} else {
					new TipsDialog("ID重复或数据库错误，增加装车单失败，请重试", Color.RED);
					return false;
				}

			}

			@Override
			protected void reInitial() {

				reinit();
			}

			@Override
			protected boolean checkDataValid() {
				id = idT.getText();
				yyID = YYIDT.getText();
				loadDocID = loadDocT.getText();
				carID = carT.getText();
				myDate = date.getMyDate();
				arriveCity = City.toCity((String) arriveCityB.getSelectedItem());
				supervisor = supervisorT.getText();
				escort = escortT.getText();
				orderBarCodes = ordersTable.getOrderbarCodes();
				SimpleDataFormat[] dataForTest = { new SimpleDataFormat(id, DataType.ID, "ID"),
						new SimpleDataFormat(yyID, DataType.ID, "汽运编号"),
						new SimpleDataFormat(loadDocID, DataType.ID, "装车单"),
						new SimpleDataFormat(carID, DataType.ID, "车辆ID") };
				return UserfulMethod.dealWithData(dataForTest);
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				reinit();
			}
		});
	}

	
	void reinit(){
		idT.setText("ZCD"+MyDate.getDatePart(MyDate.getNowTime())+UserfulMethod.toSeven(bl.getDayDocCount(DocType.loadDoc)));

		YYIDT.setText("");loadDocT.setText("");carT.setText("");
		supervisorT.setText("");escortT.setText("");orderCode.setText("");
		
		ordersTable.clearOrders();
	}

	@Override
	public void setAllCompUneditOrUnVisiable() {
		idT.setEditable(false);
		YYIDT.setEditable(false);
		loadDocT.setEditable(false);
		carT.setEditable(false);
		supervisorT.setEditable(false);
		escortT.setEditable(false);
		loadDocT.setEditable(false);

		arriveCityB.setEnabled(false);
		orderCode.setVisible(false);
		addOneOrder.setVisible(false);
		confirm.setVisible(false);
		cancel.setVisible(false);

	}

	@Override
	public void addBackButton(JPanel changePanel, String backStr) {
	}

	@Override
	public void setMessage(Object o) {
		if (o == null) {
			return;
		}
		LoadDocVO vo = (LoadDocVO) o;
		idT.setText(vo.ID);
		YYIDT.setText(vo.YYID);
		loadDocT.setText(vo.loadDocID);
		carT.setText(vo.loadDocID);
		supervisorT.setText(vo.supervisor);
		escortT.setText(vo.escort);
		for (String orders : vo.orderBarCodes) {
			ordersTable.addAOrder(orders);
		}
	}
}
