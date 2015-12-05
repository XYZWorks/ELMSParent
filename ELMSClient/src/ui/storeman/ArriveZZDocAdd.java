package ui.storeman;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import blservice.transportblservice.Transportblservice;
import blservice.transportblservice.transportblservice_Driver;
import config.StaticMessage;
import ui.tools.MyComboBox;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.PanelController;
import util.City;
import util.GoodsState;
import util.MyDate;

/**
 *   到达单
 * @author xingcheng
 *
 */
public class ArriveZZDocAdd extends MyPanel{
	
	private MyPictureButton confirmButton;
	private MyPictureButton returnButton;
	
	private MyLabel IDL;
	private MyLabel dateL;
	private MyLabel centerL;	
	private MyLabel sendCityL;
	private MyLabel goodStateL;
	private MyLabel ordersL;
	private MyLabel tip;
	
	private MyTextField IDT;
	private MyTextField dateT;
	private MyTextField centerT;
	private MyComboBox sendCityC;
	private MyComboBox goodStateC;
	private MyTextField ordersT;
	
	PanelController controller;
	Transportblservice bl;
	public ArriveZZDocAdd(Element config,Transportblservice bl,PanelController controller) {
		super(config);
		this.bl = bl;
		this.controller = controller;
		initLables(config.element(CompomentType.LABELS.name()));
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
		dateT = new MyTextField(e.element("date"));
		centerT = new MyTextField(e.element("center"));
		
		ordersT = new MyTextField(e.element("orders"));

		
	}

	@Override
	protected void initLables(Element e) {
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
		sendCityC = new MyComboBox(e.element("sendCityC"));
		goodStateC = new MyComboBox(e.element("goodStateC"));
	}

	@Override
	protected void addCompoment() {
		add(confirmButton);
		add(returnButton);
		add(IDL);
		add(IDT);
		add(centerL);
		add(centerT);
		add(dateL);
		add(dateT);
		add(goodStateC);
		add(goodStateL);
		add(sendCityC);
		add(sendCityL);
		add(tip);
		add(ordersL);
		add(ordersT);
		
		
	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new MyAddListener(confirmButton, bl));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "ArriveZZPanel", controller));
		
	}
	class MyAddListener extends MyPictureButtonListener{

		public MyAddListener(MyPictureButton button,Transportblservice bl) {
			super(button);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
			String ID = IDT.getText();
			MyDate myDate = MyDate.getDate(dateT.getText());
			City sendCity = City.toCity(sendCityC.getSelectedItem().toString());
			GoodsState goodsState = GoodsState.toGoodState(goodStateC.getSelectedItem().toString());
			
		}
	}
}
