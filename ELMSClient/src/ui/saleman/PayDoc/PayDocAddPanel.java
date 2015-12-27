package ui.saleman.PayDoc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import bl.BusinessLogicDataFactory;
import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.saleman.LoadDoc.LoadDocOrders;
import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
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
import util.MyDate;
import util.ResultMessage;
import vo.transport.PayDocVO;
import blservice.orderblservice.Orderblservice;
import blservice.transportblservice.Transportblservice;

/**
 * 收款单增加界面
 * 
 * @author czq
 * @version 2015年12月8日 下午8:30:34
 */
@SuppressWarnings("serial")
public class PayDocAddPanel extends AddDocPanel implements DocPanelForApproval {

	private MyWhitePanel whitePanel;

	private MyPictureLabel payInfo;

	private MyLabel id;
	private MyDatePicker date;
	private MyLabel YYID;
	private MyLabel courierName;

	private MyPictureLabel money;
	private MyLabel moneyText;
	private double moneyTotal;

	private MyTextField idT;
	private MyTextField YYIDT;
	// private MyTextField moneyT;
	private MyTextField courierNameT;

	private MyPictureButton addOneOrder;
	private MyLabel newOrder;
	private MyTextField orderCode;
	/**
	 * 接收单上放置的订单号表
	 */
	private PaySmallTable ordersTable;

	public Transportblservice bl;

	public PayDocAddPanel(Element config, JPanel changePanel, String checkDocPanelStr, MyTablePanel messageTable) {
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
		YYIDT = new MyTextField(e.element("YYID"));
		// moneyT = new MyTextField(e.element("money"));
		courierNameT = new MyTextField(e.element("courierName"));
		orderCode = new MyTextField(e.element("order"));
	}

	@Override
	protected void initLabels(Element e) {
		payInfo = new MyPictureLabel(e.element("payInfo"));
		id = new MyLabel(e.element("id"));
		YYID = new MyLabel(e.element("YYID"));
		money = new MyPictureLabel(e.element("money"));
		moneyText = new MyLabel(e.element("moneyText"));
		courierName = new MyLabel(e.element("courierName"));
		newOrder = new MyPictureLabel(e.element("order"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		date = new MyDatePicker(e.element("datepicker"));
		ordersTable = new PaySmallTable(e.element("table"));
	}

	@Override
	protected void addCompoment() {
		whitePanel.add(payInfo);
		whitePanel.add(YYID);
		whitePanel.add(YYIDT);
		whitePanel.add(courierName);
		whitePanel.add(courierNameT);
		whitePanel.add(date);
		whitePanel.add(id);
		whitePanel.add(idT);

		this.add(whitePanel);

		add(moneyText);
		add(money);

		add(date);
		add(ordersTable);
		add(orderCode);
		add(newOrder);
		add(addOneOrder);

		confirm.setLocation(500, 460);
		cancel.setLocation(650, 460);
	}

	@Override
	protected void addListener() {
		addOneOrder.addMouseListener(new MyPictureButtonListener(addOneOrder) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String temp = orderCode.getText();
				if (UserfulMethod.dealWithData(new SimpleDataFormat(temp, DataType.BarCode, "订单号"))) {
					// 判断订单是否存在
					Orderblservice orderblservice = BusinessLogicDataFactory.getFactory().getOrderBussinessLogic();
					if (orderblservice.getFullInfo(temp) == null) {
						new TipsDialog("该订单不存在，请重新输入");
					} else {

						// 避免同一个订单反复加在收款单里
						ArrayList<String> alreadyCode = ordersTable.getOrderbarCodes();
						boolean isExist = false;
						if (alreadyCode.size() != 0) {
							for (int i = 0; i < alreadyCode.size(); i++) {
								if (alreadyCode.get(i).equals(temp)) {
									new TipsDialog("该订单已在收款单里，请不要重复添加");
									isExist = true;
									break;
								}
							}
						}
						if (isExist == false) {
							ordersTable.addAOrder(temp);
							moneyTotal = ordersTable.getMoneyTotal();
							moneyText.setText(String.valueOf(moneyTotal));
							new TipsDialog("成功新增订单", Color.BLUE);

						}

					}
				}
			}
		});
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String YYID;
			String courierName;
			MyDate myDate;
			String ID;
			String money;
			ArrayList<String> orders;
			PayDocVO vo;

			@Override
			protected void updateMes() {
				messageTable.addOneData(vo, 1);
			}

			@Override
			protected boolean saveToSQL() {

				result = bl
						.addOnePay(vo = new PayDocVO(ID, Integer.parseInt(money), YYID, myDate, courierName, orders));
				if (result == ResultMessage.SUCCESS) {
					new TipsDialog("成功新增付款单", Color.GREEN);
					return true;
				} else {
					new TipsDialog("ID重复或数据库错误，增加付款单失败，请重试", Color.RED);
					System.out.println(result);
					return false;
				}

			}

			@Override
			protected void reInitial() {
				myInit();

			}

			@Override
			protected boolean checkDataValid() {
				YYID = YYIDT.getText();
				courierName = courierNameT.getText();
				myDate = date.getMyDate();
				ID = idT.getText();
				money = moneyText.getText();
				orders = ordersTable.getOrderbarCodes();
				SimpleDataFormat[] datas = { new SimpleDataFormat(YYID, DataType.ID, "营业厅ID"),
						new SimpleDataFormat(money, DataType.PositiveNum, "金额"),
						new SimpleDataFormat(ID, DataType.ID, "ID") };
				return UserfulMethod.dealWithData(datas);
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				myInit();

			}
		});

	}

	private void myInit() {
		YYIDT.setText("");
		idT.setText("");
		moneyText.setText("");
		ordersTable.clearOrders();
		courierNameT.setText("");
	}

	@Override
	public void setAllCompUneditOrUnVisiable() {
		YYIDT.setEditable(false);
		idT.setEditable(false);
		// moneyT.setEditable(false);
		courierNameT.setEditable(false);

		date.setVisible(false);
		orderCode.setVisible(false);
		addOneOrder.setVisible(false);
		confirm.setVisible(false);
		cancel.setVisible(false);
		date.setVisible(false);
	}

	@Override
	public void setMessage(Object o) {
		if (o == null) {
			return;
		}
		PayDocVO vo = (PayDocVO) o;
		YYIDT.setText(vo.YYID);
		idT.setText(vo.ID);
		// moneyT.setText(String.valueOf(vo.money));
		courierNameT.setText(vo.courierName);
		date.setTime(vo.date);
		for (String orders : vo.orders) {
			ordersTable.addAOrder(orders);
		}
	}

	@Override
	public void addBackButton(JPanel changePanel, String backStr) {
	}

}
