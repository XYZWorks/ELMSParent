package ui.storeman;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import blservice.transportblservice.Transportblservice;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.PanelController;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月5日 下午5:05:44 
 *
 */
public class AddTransportPanel extends MyPanel {

	private MyPictureButton confirmButton;
	private MyPictureButton returnButton;
	//	单据类型 ID 日期 航班号/车次/车牌号 出发 货柜号 监装员 订单号集合
	private MyLabel title;
	private MyLabel IDL;
	private MyLabel dateL;
	private MyLabel numberL;
	private MyLabel sendCityL;
	private MyLabel containerL;
	private MyLabel ordersL;
	private MyLabel LoadManNameL;
	private MyLabel tip;

	private MyTextField IDT;
	private MyTextField numberT;
	private MyTextField LoadManNameT;
	
	private MyTextField containerT;
	private MyTextField ordersT;
	
	private MyComboBox sendCityC;
	private MyDatePicker picker;
	PanelController controller;
	Transportblservice bl;

	public AddTransportPanel(Element config, Transportblservice bl, PanelController controller) {
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
		
		numberT = new MyTextField(e.element("number"));

		ordersT = new MyTextField(e.element("orders"));

	}

	@Override
	protected void initLables(Element e) {
		title = new MyLabel(e.element("title"));
		IDL = new MyLabel(e.element("ID"));
		dateL = new MyLabel(e.element("date"));
		numberL = new MyLabel(e.element("number"));
		sendCityL = new MyLabel(e.element("sendCity"));
		containerL = new MyLabel(e.element("container"));
		ordersL = new MyLabel(e.element("orders"));
		tip = new MyLabel(e.element("tip"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		picker = new MyDatePicker(e.element("DatePicker"));
//		picker = new MyDatePicker(100 ,200 ,400 , 400);
		picker.setVisible(true);
		sendCityC = new MyComboBox(e.element("sendCityC"));
		
	}

	@Override
	protected void addCompoment() {
		add(picker);
		add(confirmButton);
		add(returnButton);
		add(IDL);
		add(IDT);
		add(numberL);
		add(numberT);
		add(dateL);
		
		add(containerT);
		add(containerL);
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
		returnButton.addMouseListener(new MyJumpListener(returnButton, "ArriveZZPanel", controller));

	}

	class MyAddListener extends MyPictureButtonListener {

		public MyAddListener(MyPictureButton button, Transportblservice bl) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);

		}

		private void showSuccess() {
			System.out.println("add suc"); 
		}
	}

}
