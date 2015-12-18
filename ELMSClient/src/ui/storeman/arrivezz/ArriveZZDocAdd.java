package ui.storeman.arrivezz;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.management.relation.RelationNotification;

import org.dom4j.Element;

import blservice.transportblservice.Transportblservice;
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
import ui.util.MyPictureButtonListener;
import ui.util.PanelController;
import ui.util.TipsDialog;
import util.City;
import util.GoodsState;
import util.MyDate;
import util.ResultMessage;
import vo.transport.ArriveZZDocVO;

/**
 * 到达单
 * 
 * @author 
 *
 */
public class ArriveZZDocAdd extends MyPanel {

	
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
			
			return true;
		}

		@Override
		protected boolean saveToSQL() {
			String ID = IDT.getText();
			String zzID = centerT.getText();
			MyDate myDate = picker.getMyDate();
			City sendCity = City.toCity(sendCityC.getSelectedItem().toString());
			GoodsState goodsState = GoodsState.toGoodState(goodStateC.getSelectedItem().toString());
			
			ArrayList<String> orders = UserfulMethod.stringToArray(ordersT.getText());
		
			
			ResultMessage result = bl.add(new ArriveZZDocVO(ID, myDate, zzID, sendCity, goodsState, orders));
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
}
