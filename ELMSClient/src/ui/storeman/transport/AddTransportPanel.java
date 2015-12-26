package ui.storeman.transport;

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
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.transport.TransferDocVO;
import blservice.transportblservice.Transportblservice;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月5日 下午5:05:44 
 *
 */
@SuppressWarnings("serial")
public class AddTransportPanel extends MyPanel implements DocPanelForApproval{

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
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));

		initOtherCompoment(config);
		addCompoment();
		
		if(controller == null){
			return;
		}
		
		addListener();
	}

	@Override
	protected void initWhitePanels(Element e) {


	}

	@Override
	protected void initButtons(Element e) {
		confirmButton = new MyPictureButton(e.element("confirm"));
		returnButton = new MyPictureButton(e.element("return"));

	}

	@Override
	protected void initTextFields(Element e) {
		IDT = new MyTextField(e.element("ID"));
		
		if(controller != null){
			IDT.setText("ZZD"+MyDate.getDatePart(MyDate.getNowTime())+UserfulMethod.toSeven(bl.getDayDocCount(DocType.transferDoc)));
		}
		IDT.setEditable(false);

		containerT = new MyTextField(e.element("container"));
		numberT = new MyTextField(e.element("number"));
		LoadManNameT = new MyTextField(e.element("LoadManName"));
		ordersT = new MyTextField(e.element("orders"));

	}

	@Override
	protected void initLabels(Element e) {
		title = new MyLabel(e.element("title"));
		IDL = new MyLabel(e.element("ID"));
		dateL = new MyLabel(e.element("date"));
		numberL = new MyLabel(e.element("number"));
		sendCityL = new MyLabel(e.element("sendCity"));
		containerL = new MyLabel(e.element("container"));
		ordersL = new MyLabel(e.element("orders"));
		tip = new MyLabel(e.element("tip"));
		LoadManNameL = new MyLabel(e.element("LoadManName"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		picker = new MyDatePicker(e.element("DatePicker"));
//		picker = new MyDatePicker(100 ,200 ,400 , 400);
//		picker.setVisible(true);
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
		add(LoadManNameL);
		add(LoadManNameT);
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
		confirmButton.addMouseListener(new MyAddListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "TransportPanel", controller,true));

	}

	class MyAddListener extends ConfirmListener {
		TransferDocVO vo ;
		public MyAddListener(MyPictureButton button) {
			super(button);
		}
		
		@Override
		protected boolean checkDataValid() {
			String ID = IDT.getText();
			int container = 0;
			try{
				container = Integer.parseInt(containerT.getText());
			}
			catch(NumberFormatException e){
				
			}
			String number = numberT.getText();
			String loadManName = LoadManNameT.getText();
			
			MyDate myDate = picker.getMyDate();
		
			City sendCity = City.toCity(sendCityC.getSelectedItem().toString());
			
			ArrayList<String> orders = UserfulMethod.stringToArray(ordersT.getText());	
			SimpleDataFormat[] datas = new SimpleDataFormat[orders.size()+1];
			datas[0] = new SimpleDataFormat(container+"", DataType.PositiveNum, "货柜号");
			for (int i = 1; i < orders.size()+1; i++) {
				datas[i] = new SimpleDataFormat(orders.get(i-1), DataType.BarCode, "订单号");
			}
			vo = new TransferDocVO(ID,myDate,number,sendCity,container,loadManName,orders);
			return UserfulMethod.dealWithData(datas);
		}

		@Override
		protected boolean saveToSQL() {
			
			
			ResultMessage r = bl.add(vo);
			
			if(r ==ResultMessage.SUCCESS)
				new TipsDialog("生成中转单成功");
			return true;
		}


		@Override
		protected void reInitial() {
			IDT.setText("ZZD"+MyDate.getDatePart(MyDate.getNowTime())+UserfulMethod.toSeven(bl.getDayDocCount(DocType.transferDoc)));

			containerT.setText("");
			numberT.setText("");
			LoadManNameT.setText("");
			ordersT.setText("");
		}

		@Override
		protected void updateMes() {

			TransportPanel tPanel = (TransportPanel) controller.getPanelMap().get("TransportPanel");
			tPanel.table.updateTableMes();

		}
	}

	@Override
	public void setAllCompUneditOrUnVisiable() {
		IDT.setEditable(false);;
		numberT.setEditable(false);;
		LoadManNameT.setEditable(false);;
		
		containerT.setEditable(false);
		ordersT.setEditable(false);;
		
		sendCityC.setEnabled(false);
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
		TransferDocVO vo = (TransferDocVO) o;
		IDT.setText(vo.ID);
		containerT.setText(String.valueOf(vo.containerNum));
		LoadManNameT.setText(vo.loadManName);
		
		numberT.setText(String.valueOf(vo.containerNum));
		sendCityC.setSelectedItem(vo.sendCity.getName());
		picker.setTime(vo.date);
		ordersT.setText(UserfulMethod.orderArrayToString(vo.orderBarCode));
		
	}

}
