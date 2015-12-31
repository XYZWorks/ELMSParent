package ui.saleman.SendGoodDoc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.saleman.PayDoc.PaySmallTable;
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
import vo.transport.SendGoodDocVO;
import bl.BusinessLogicDataFactory;
import blservice.orderblservice.Orderblservice;
import blservice.transportblservice.Transportblservice;

/**
 * 派送单增加界面
 * 
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class SendGoodDocAddPanel extends AddDocPanel implements DocPanelForApproval {

	private MyWhitePanel whitePanel;

	private MyPictureLabel addSendGoodDoc;

	private MyLabel id;
	private MyDatePicker date;
	private MyLabel sendMan;

	private MyTextField idT;
	private MyTextField sendManT;

	private MyPictureButton addOneOrder;
	private MyLabel newOrder;
	private MyTextField orderCode;

	private SendSmallTable ordersTable;

	Transportblservice bl;

	public SendGoodDocAddPanel(Element config, JPanel changePanel, String checkDocPanelStr, MyTablePanel messageTable) {
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

		sendManT = new MyTextField(e.element("sendMan"));
		orderCode = new MyTextField(e.element("order"));

	}

	@Override
	protected void initLabels(Element e) {
		addSendGoodDoc = new MyPictureLabel(e.element("addSendGoodDoc"));
		id = new MyLabel(e.element("id"));
		sendMan = new MyLabel(e.element("sendMan"));
		newOrder = new MyPictureLabel(e.element("order"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		date = new MyDatePicker(e.element("datepicker"));
		ordersTable = new SendSmallTable(e.element("table"));
	}

	@Override
	protected void addCompoment() {
		whitePanel.add(addSendGoodDoc);
		whitePanel.add(sendMan);
		whitePanel.add(sendManT);
		whitePanel.add(id);
		whitePanel.add(idT);
		this.add(whitePanel);
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
						if (alreadyCode.size() != 0) {
							for (int i = 0; i < alreadyCode.size(); i++) {
								if (alreadyCode.get(i).equals(temp)) {
									new TipsDialog("该订单已在收款单里，请不要重复添加");
									break;
								}
							}
						}
						new TipsDialog("成功新增订单", Color.BLUE);
					}
				
			}
			}
		});
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String id;
			MyDate myDate;
			String sendMan;
			ArrayList<String> orderBarCode;
			SendGoodDocVO vo;

			@Override
			protected boolean checkDataValid() {
				id = idT.getText();
				myDate = date.getMyDate();
				sendMan = sendManT.getText();
				orderBarCode = ordersTable.getOrderbarCodes();
				SimpleDataFormat[] datas = { new SimpleDataFormat(id, DataType.ID, "ID"),
						};
				return UserfulMethod.dealWithData(datas);
			}

			@Override
			protected void updateMes() {
				messageTable.addOneData(vo, 1);
			}

			@Override
			protected boolean saveToSQL() {
				result = bl.add(vo = new SendGoodDocVO(id, myDate, sendMan, orderBarCode));
				if (result == ResultMessage.SUCCESS) {
					new TipsDialog("成功生成送货单~", Color.GREEN);
					return true;
				} else {
					new TipsDialog("送货单可能单据ID重复或数据库问题，未能保存成功", Color.RED);
					return false;
				}
			}

			@Override
			protected void reInitial() {

				myInit();
			}

		});
		cancel.addMouseListener(new CancelListener(cancel) {
			@Override
			public void resetMes() {
				myInit();
			}
		});

	}

	void myInit() {
		idT.setText("ZCD" + MyDate.getDatePart(MyDate.getNowTime())
				+ UserfulMethod.toSeven(bl.getDayDocCount(DocType.loadDoc)));
		sendManT.setText("");
		orderCode.setText("");
	}

	@Override
	public void setAllCompUneditOrUnVisiable() {
		idT.setEditable(false);
		sendManT.setEditable(false);
//		orderBarCodeT.setEditable(false);
//		sendCityB.setEnabled(false);
		orderCode.setEditable(false);
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
		SendGoodDocVO vo = (SendGoodDocVO) o;
		idT.setText(vo.ID);
		//sendCityB.setSelectedItem(vo.sendCity.getName());
		sendManT.setText(vo.sendMan);
		//orderBarCodeT.setText(vo.orderBarCode);
		
	}
}
