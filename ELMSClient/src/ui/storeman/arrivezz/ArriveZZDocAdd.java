package ui.storeman.arrivezz;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.DocPanelForApproval;
import ui.util.MyBackListener;
import ui.util.PanelController;
import ui.util.TipsDialog;
import util.City;
import util.GoodsState;
import util.MyDate;
import util.ResultMessage;
import vo.transport.ArriveZZDocVO;
import blservice.transportblservice.Transportblservice;

/**
 * 到达单
 * 
 * @author 
 *
 */
@SuppressWarnings("serial")
public class ArriveZZDocAdd extends MyPanel implements DocPanelForApproval{

	
	private MyPictureButton confirmButton;
	private MyPictureButton returnButton;

	private MyLabel title;
	private MyLabel IDL;
	private MyLabel dateL;
	private MyLabel centerL;
	private MyLabel sendCityL;
	private MyLabel goodStateL;
	private MyLabel ordersL;
	private MyLabel tip;

	private MyTextField IDT;
	
	private MyTextField centerT;
	private MyComboBox sendCityC;
	private MyComboBox goodStateC;
	private MyTextField ordersT;

	private MyDatePicker picker;
	PanelController controller;
	Transportblservice bl;
	

	public ArriveZZDocAdd(Element config, Transportblservice bl, PanelController controller) {
		super(config);

		this.bl = bl;
		this.controller = controller;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));

		initOtherCompoment(config);
		addCompoment();
		//单据审批界面传进来的是空指针= =
		if(controller == null){
			return;
		}
		
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
		
		centerT = new MyTextField(e.element("center"));

		ordersT = new MyTextField(e.element("orders"));

	}

	@Override
	protected void initLabels(Element e) {
		title = new MyLabel(e.element("title"));
		IDL = new MyLabel(e.element("ID"));
		dateL = new MyLabel(e.element("date"));
		centerL = new MyLabel(e.element("center"));
		sendCityL = new MyLabel(e.element("sendCity"));
		goodStateL = new MyLabel(e.element("goodState"));
		ordersL = new MyLabel(e.element("orders"));
		tip = new MyLabel(e.element("tip"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		picker = new MyDatePicker(e.element("DatePicker"));
//		picker = new MyDatePicker(100 ,200 ,400 , 400);
		picker.setVisible(true);
		sendCityC = new MyComboBox(e.element("sendCityC"));
		goodStateC = new MyComboBox(e.element("goodStateC"));
	}

	@Override
	protected void addCompoment() {
		add(picker);
		add(confirmButton);
		add(returnButton);
		add(IDL);
		add(IDT);
		add(centerL);
		add(centerT);
		add(dateL);
		
		add(goodStateC);
		add(goodStateL);
		add(sendCityC);
		add(sendCityL);
		add(tip);
		add(title);
		add(ordersL);
		add(ordersT);
		

	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new MyAddListener(confirmButton, bl));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "ArriveZZPanel", controller,true));

	}

	class MyAddListener extends ConfirmListener {
		ArriveZZDocVO vo;
		public MyAddListener(MyPictureButton button, Transportblservice bl) {
			super(button);
		}


		@Override
		protected void reInitial() {
			IDT.setText("");
			centerT.setText("");
			ordersT.setText("");
	
			
		}

		private void showSuccess() {
//			System.out.println("add suc"); 
			new TipsDialog("生成到达单成功");
			
		}

		@Override
		protected boolean checkDataValid() {
			String ID = IDT.getText();
			String zzID = centerT.getText();
			MyDate myDate = picker.getMyDate();
			City sendCity = City.toCity(sendCityC.getSelectedItem().toString());
			GoodsState goodsState = GoodsState.toGoodState(goodStateC.getSelectedItem().toString());
			
			ArrayList<String> orders = UserfulMethod.stringToArray(ordersT.getText());
			SimpleDataFormat[] datas = new SimpleDataFormat[orders.size()+1];
			datas[0] = new SimpleDataFormat(zzID, DataType.ID, "中转中心编号");
			for (int i = 1; i < orders.size()+1; i++) {
				datas[i] = new SimpleDataFormat(orders.get(i-1), DataType.BarCode, "订单号");
			}
			vo = new ArriveZZDocVO(ID, myDate, zzID, sendCity, goodsState, orders);
			return UserfulMethod.dealWithData(datas);
		}

		@Override
		protected boolean saveToSQL() {

			
			ResultMessage result = bl.add(vo);
			if(result ==ResultMessage.SUCCESS)
				showSuccess();
			return true;
		}


		@Override
		protected void updateMes() {
			ArriveZZPanel aPanel = (ArriveZZPanel) controller.getPanelMap().get("ArriveZZPanel");
			aPanel.arriveZZTablePanel.updateTableMes();
		}
	}

	@Override
	public void setAllCompUneditOrUnVisiable() {
		IDT.setEditable(false);
		centerT.setEditable(false);
		goodStateC.setEnabled(false);
		sendCityC.setEnabled(false);
		ordersT.setEnabled(false);
		
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
		if(o == null){
			return;
		}
		ArriveZZDocVO vo = (ArriveZZDocVO) o;
		IDT.setText(vo.ID);
		centerT.setText(vo.zZID);
		goodStateC.setSelectedItem(vo.goodState.getName());
		sendCityC.setSelectedItem(vo.sendCity.getName());
		picker.setTime(vo.date);
		ordersT.setText(UserfulMethod.orderArrayToString(vo.orderBarCodes));
		
	}
}
