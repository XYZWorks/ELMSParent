package ui.saleman.ArriveYYDoc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.saleman.LoadDoc.LoadDocOrders;
import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
import ui.util.DocPanelForApproval;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.City;
import util.GoodsState;
import util.MyDate;
import util.ResultMessage;
import vo.transport.ArriveYYDocVO;
import blservice.transportblservice.Transportblservice;

/**
 * 接收单增加界面
 * 
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class ArriveYYDocAddPanel extends AddDocPanel implements DocPanelForApproval{

	private MyLabel id;
	private MyDatePicker date;
	private MyLabel ZZID;
	private MyLabel sendCity;
	private MyLabel goodState;
	private MyLabel newOrder;

	private MyTextField order;
	private MyTextField idT;
	private MyTextField ZZIDT;
	private MyComboBox sendCityB;;
	private MyComboBox goodStateB;

	private MyPictureButton addOneOrder;
	/**
	 * 接收单上放置的订单号表
	 */
	private LoadDocOrders ordersTable;

	Transportblservice bl;

	public ArriveYYDocAddPanel(Element config, JPanel changePanel,
			String checkDocPanelStr, MyTablePanel messageTable) {
		super(config, changePanel, checkDocPanelStr, messageTable);
	}

	@Override
	protected void initWhitePanels(Element e) {
	}

	@Override
	protected void initButtons(Element e) {
		addOneOrder = new MyPictureButton(e.element("addOrder"));

	}

	@Override
	protected void initTextFields(Element e) {
		idT = new MyTextField(e.element("id"));
		ZZIDT = new MyTextField(e.element("ZZID"));
		order = new MyTextField(e.element("order"));
	}

	@Override
	protected void initLabels(Element e) {
		id = new MyPictureLabel(e.element("id"));
		ZZID = new MyPictureLabel(e.element("ZZID"));
		sendCity = new MyPictureLabel(e.element("sendCity"));
		goodState = new MyPictureLabel(e.element("goodState"));
		newOrder = new MyPictureLabel(e.element("order"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		date = new MyDatePicker(e.element("datepicker"));
		sendCityB = new MyComboBox(e.element("sendCity"));
		ordersTable = new LoadDocOrders(e.element("table"));
		goodStateB = new MyComboBox(e.element("goodState"));
	}

	@Override
	protected void addCompoment() {
		add(ZZID);
		add(ZZIDT);
		add(sendCity);
		add(sendCityB);
		add(goodState);
		add(date);
		add(id);
		add(idT);
		add(newOrder);
		add(addOneOrder);
		
		add(goodStateB);
		add(order);
		add(ordersTable);
	}

	@Override
	protected void addListener() {

		addOneOrder.addMouseListener(new MyPictureButtonListener(addOneOrder) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String temp = order.getText();
				if (UserfulMethod.dealWithData(new SimpleDataFormat(temp,
						DataType.ID, "订单号"))) {
					ordersTable.addAOrder(temp);
					new TipsDialog("成功新增订单", Color.BLUE);
				}
			}
		});
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String ZZID;
			City sendCity;
			MyDate myDate;
			String ID;
			GoodsState goodState;
			ArrayList<String> orderBarCodes;
			ArriveYYDocVO vo;
			@Override
			protected boolean saveToSQL() {
				result = bl.add(vo = new ArriveYYDocVO(ID, myDate, ZZID, sendCity, goodState,
						orderBarCodes)) ;
				if(result == ResultMessage.SUCCESS){
					new TipsDialog("成功新增接收单", Color.GREEN);
					return true;
				}else{
					System.out.println(result);
					new TipsDialog("未成功增加接收单", Color.RED);
					return false;
				}
				
			}

			@Override
			protected void reInitial() {
				reinit();
			}

			@Override
			protected boolean checkDataValid() {
				ZZID = ZZIDT.getText();
				sendCity = City.toCity((String) sendCityB.getSelectedItem());
				myDate = date.getMyDate();
				ID = idT.getText();
				goodState = GoodsState.toGoodState((String) goodStateB
						.getSelectedItem());
				orderBarCodes = ordersTable.getOrderbarCodes();
				SimpleDataFormat[] datas = {new SimpleDataFormat(ID, DataType.ID, "ID") ,
						new SimpleDataFormat(ZZID, DataType.ID, "中转中心编号")
						};
				return UserfulMethod.dealWithData(datas);
			}

			@Override
			protected void updateMes() {
				messageTable.addOneData(vo, 1);

			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				reinit();

			}
		});
	}
	private void reinit(){
		idT.setText("");ZZIDT.setText("");order.setText("");
		
		ordersTable.clearOrders();
	}

	@Override
	public void setAllCompUneditOrUnVisiable() {
		idT.setEditable(false);
		ZZIDT.setEditable(false);
		sendCityB.setEditable(false);
		sendCityB.setEnabled(false);
		goodStateB.setEnabled(false);
		goodStateB.setEditable(false);
		
		order.setVisible(false);
		addOneOrder.setVisible(false);
		confirm.setVisible(false);
		cancel.setVisible(false);
	}

	@Override
	public void addBackButton(JPanel changePanel , String backString) {
	}

	@Override
	public void setMessage(Object o) {
		if(o == null){
			return;
		}
		ArriveYYDocVO vo = (ArriveYYDocVO) o;
		idT.setText(vo.ID);
		ZZIDT.setText(vo.ZZID);
		sendCityB.setSelectedItem(vo.sendCity.getName());
		goodStateB.setSelectedItem(vo.goodState.getName());
		for (String orders : vo.orderBarCodes) {
			ordersTable.addAOrder(orders);
		}
		
	}
}
