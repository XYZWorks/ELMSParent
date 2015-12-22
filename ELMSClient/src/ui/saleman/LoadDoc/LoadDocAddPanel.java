package ui.saleman.LoadDoc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
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
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.City;
import util.MyDate;
import util.ResultMessage;
import vo.transport.LoadDocVO;
import blservice.transportblservice.Transportblservice;
 /** 
 * 装车单增加界面
 * @author czq 
 * @version 2015年12月8日 下午8:27:23 
 */
@SuppressWarnings("serial")
public class LoadDocAddPanel extends AddDocPanel{
	
	
	
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
		super(config , changePanel , checkDocPanelStr,  messageTable);
		// TODO Auto-generated constructor stub
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
		YYIDT = new MyTextField(e.element("YYID"));
		loadDocT = new MyTextField(e.element("loadDoc"));
		carT = new MyTextField(e.element("car"));
		supervisorT = new MyTextField(e.element("supervisor"));
		escortT= new MyTextField(e.element("escort"));
		orderCode = new MyTextField(e.element("order"));
	}

	@Override
	protected void initLabels(Element e) {
		id = new MyPictureLabel(e.element("id"));
		YYID = new MyPictureLabel(e.element("YYID"));
		loadDocID = new MyPictureLabel(e.element("loadDoc"));
		arriveCity = new MyPictureLabel(e.element("arriveCity"));
		carID = new MyPictureLabel(e.element("car"));
		supervisor = new MyPictureLabel(e.element("supervisor"));
		escort = new MyPictureLabel(e.element("escort"));
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
		add(YYID);add(YYIDT);add(arriveCity);add(arriveCityB);add(carID);add(carT);add(date);add(escort);add(escortT);add(id);add(idT);
		add(loadDocID);add(loadDocT);add(supervisor);add(supervisorT);add(orderCode);add(newOrder);add(addOneOrder);add(ordersTable);
	}

	@Override
	protected void addListener() {
		addOneOrder.addMouseListener(new MyPictureButtonListener(addOneOrder){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String temp = orderCode.getText();
				if(UserfulMethod.dealWithData(new SimpleDataFormat(temp, DataType.ID, "订单号"))){
					ordersTable.addAOrder(temp);
					new TipsDialog("成功新增订单" , Color.BLUE);
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
				if(bl.add(vo = new LoadDocVO(id, myDate, yyID, loadDocID, arriveCity, carID, supervisor, escort, orderBarCodes)) == ResultMessage.SUCCESS){
					new TipsDialog("成功新增装车单" , Color.GREEN);
					return true;
				}else{
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
				SimpleDataFormat[] dataForTest = { new SimpleDataFormat(id, DataType.ID , "ID") , new SimpleDataFormat(yyID, DataType.ID , "汽运编号") , new SimpleDataFormat(loadDocID, DataType.ID , "装车单") , new SimpleDataFormat(carID, DataType.ID , "车辆ID")   };
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
	
	private void reinit(){
		idT.setText("");YYIDT.setText("");loadDocT.setText("");carT.setText("");
		supervisorT.setText("");escortT.setText("");orderCode.setText("");
		
		
		ordersTable.clearOrders();
	}
}
