package ui.courier;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;

import org.dom4j.Element;

import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPanelWithScroller;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyRadioButton;
import ui.tools.MyTextField;
import ui.tools.MyWhitePanel;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;

/**
 * 查询订单界面
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")

public class AddOrderPanel extends MyPanelWithScroller {

	// 白色矩形panel
	private MyWhitePanel senderInfoPanel;
	private MyWhitePanel receiverInfoPanel;
	private MyWhitePanel goodInfoPanel;

	// 订单号
	private MyPictureLabel orderBarCode;
	private MyLabel orderBarCodeLabel;

	// 日历
	private MyDatePicker DatePicker;

	// 寄件人信息
	private MyPictureLabel senderInfo;
	private MyLabel senderNameLabel;
	private MyLabel senderPhoneLabel;
	private MyLabel senderAddressLabel;
	private MyLabel senderUnitLabel;

	// 收件人信息
	private MyPictureLabel receiverInfo;
	private MyLabel receiverNameLabel;
	private MyLabel receiverPhoneLabel;
	private MyLabel receiverAddressLabel;
	private MyLabel receiverUnitLabel;

	// 货物信息
	private MyPictureLabel goodsInfo;
	private MyLabel goodNameLabel;
	private MyLabel goodWeightLabel;
	private MyLabel goodNumLabel;
	private MyLabel goodVolumLabel;// 体积
	private MyLabel goodPackLabel;// 包装形式
	private MyLabel orderFormLabel;// 快递形式

	// 预计送达时间
	private MyPictureLabel estimateTime;
	// 费用总计
	private MyPictureLabel cost;

	// textField
	private MyTextField senderNameText;
	private MyTextField senderPhoneText;
	private MyTextField senderAddressText;
	private MyTextField senderUnitText;

	private MyTextField receiverNameText;
	private MyTextField receiverPhoneText;
	private MyTextField receiverAddressText;
	private MyTextField receiverUnitText;

	private MyTextField goodNameText;
	private MyTextField goodNumText;
	private MyTextField goodWeightText;
	private MyTextField goodLongText;
	private MyTextField goodWidthText;
	private MyTextField goodHeightText;

	/*
	 * 单选框
	 */
	// 包装形式
	private MyRadioButton bag;// 快递袋
	private MyRadioButton carton;// 纸箱
	private MyRadioButton woodCase;// 木箱
	private ButtonGroup goodpackGroup;

	// 快递形式
	private MyRadioButton commonOrder;
	private MyRadioButton quickOrder;
	private MyRadioButton economicOrder;
	private ButtonGroup orderFormGroup;
	// 下拉框
	private MyComboBox senderCity;
	private MyComboBox senderArea;

	//寄件人 四种不同城市的地区
	private MyComboBox senderNanJingArea;
	private MyComboBox senderShangHaiArea;
	private MyComboBox senderGuangZhouArea;
	private MyComboBox senderBeiJingArea;
	
	private MyComboBox receiverCity;
	private MyComboBox receiverArea;

	private MyComboBox receiverNanJingArea;
	private MyComboBox receiverShangHaiArea;
	private MyComboBox receiverGuangZhouArea;
	private MyComboBox receiverBeiJingArea;
	
	// button
	private MyPictureButton confirm;
	private MyPictureButton cancel;

	public AddOrderPanel(Element config) {
		super(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initLables(config.element(CompomentType.LABELS.name()));
		initOtherCompoment(config);

		addCompoment();
		addListener();
		setVisible(true);
		repaint();

	}

	@Override
	protected void initWhitePanels(Element e) {
		senderInfoPanel = new MyWhitePanel(e.element("senderInfoPanel"));
		receiverInfoPanel = new MyWhitePanel(e.element("receiverInfoPanel"));
		goodInfoPanel = new MyWhitePanel(e.element("goodInfoPanel"));

	}

	@Override
	protected void initButtons(Element e) {

		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
	}

	@Override
	protected void initTextFields(Element e) {
		senderNameText = new MyTextField(e.element("senderNameText"));
		senderPhoneText = new MyTextField(e.element("senderPhoneText"));
		senderAddressText = new MyTextField(e.element("senderAddressText"));
		senderUnitText = new MyTextField(e.element("senderUnitText"));

		receiverNameText = new MyTextField(e.element("receiverNameText"));
		receiverPhoneText = new MyTextField(e.element("receiverPhoneText"));
		receiverAddressText = new MyTextField(e.element("receiverAddressText"));
		receiverUnitText = new MyTextField(e.element("receiverUnitText"));

		goodNameText = new MyTextField(e.element("goodNameText"));
		goodNumText = new MyTextField(e.element("goodNumText"));
		goodWeightText = new MyTextField(e.element("goodWeightText"));
		goodLongText = new MyTextField(e.element("goodLongText"));
		goodWidthText = new MyTextField(e.element("goodWidthText"));
		goodHeightText = new MyTextField(e.element("goodHeightText"));

	}

	@Override
	protected void initLables(Element e) {

		orderBarCode = new MyPictureLabel(e.element("orderBarCode"));
		orderBarCodeLabel = new MyLabel(e.element("orderBarCodeLabel"));

		// 寄件人信息

		senderInfo = new MyPictureLabel(e.element("senderInfo"));
		senderNameLabel = new MyLabel(e.element("senderNameLabel"));
		senderAddressLabel = new MyLabel(e.element("senderAddressLabel"));
		senderUnitLabel = new MyLabel(e.element("senderUnitLabel"));
		senderPhoneLabel = new MyLabel(e.element("senderPhoneLabel"));
		// 收件人信息

		receiverInfo = new MyPictureLabel(e.element("receiverInfo"));
		receiverNameLabel = new MyLabel(e.element("receiverNameLabel"));
		receiverPhoneLabel = new MyLabel(e.element("receiverPhoneLabel"));
		receiverAddressLabel = new MyLabel(e.element("receiverAddressLabel"));
		receiverUnitLabel = new MyLabel(e.element("receiverUnitLabel"));

		// 货物信息
		goodsInfo = new MyPictureLabel(e.element("goodsInfo"));
		goodNameLabel = new MyLabel(e.element("goodNameLabel"));
		goodWeightLabel = new MyLabel(e.element("goodWeightLabel"));
		goodNumLabel = new MyLabel(e.element("goodNumLabel"));
		goodVolumLabel = new MyLabel(e.element("goodVolumLabel"));
		goodPackLabel = new MyLabel(e.element("goodPackLabel"));
		orderFormLabel = new MyLabel(e.element("orderFormLabel"));

		estimateTime = new MyPictureLabel(e.element("estimateTime"));

		cost = new MyPictureLabel(e.element("cost"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		DatePicker = new MyDatePicker(e.element("DatePicker"));

		bag = new MyRadioButton(e.element("bag"));
		carton = new MyRadioButton(e.element("carton"));
		woodCase = new MyRadioButton(e.element("woodCase"));
		goodpackGroup = new ButtonGroup();

		commonOrder = new MyRadioButton(e.element("commonOrder"));
		quickOrder = new MyRadioButton(e.element("quickOrder"));
		economicOrder = new MyRadioButton(e.element("economicOrder"));
		orderFormGroup = new ButtonGroup();

		senderCity = new MyComboBox(e.element("senderCity"));
		senderArea = new MyComboBox(e.element("senderArea"));
		
		senderNanJingArea=new MyComboBox(e.element("senderArea"),"NanJing");
		senderBeiJingArea=new MyComboBox(e.element("senderArea"),"BeiJing");
		senderShangHaiArea=new MyComboBox(e.element("senderArea"),"ShangHai");
		senderGuangZhouArea=new MyComboBox(e.element("senderArea"),"GuangZhou");

		receiverCity = new MyComboBox(e.element("receiverCity"));
		receiverArea = new MyComboBox(e.element("receiverArea"));
		
		receiverNanJingArea=new MyComboBox(e.element("receiverArea"),"NanJing");
		receiverBeiJingArea=new MyComboBox(e.element("receiverArea"),"BeiJing");
		receiverShangHaiArea=new MyComboBox(e.element("receiverArea"),"ShangHai");
		receiverGuangZhouArea=new MyComboBox(e.element("receiverArea"),"GuangZhou");


	}

	@Override
	protected void addCompoment() {

		this.add(orderBarCode);
		this.add(orderBarCodeLabel);

		this.add(DatePicker);

		senderInfoPanel.add(senderInfo);
		senderInfoPanel.add(senderPhoneLabel);
		senderInfoPanel.add(senderNameLabel);
		senderInfoPanel.add(senderAddressLabel);
		senderInfoPanel.add(senderUnitLabel);
		senderInfoPanel.add(senderNameText);
		senderInfoPanel.add(senderPhoneText);
		senderInfoPanel.add(senderAddressText);
		senderInfoPanel.add(senderUnitText);

		senderInfoPanel.add(senderCity);
		senderInfoPanel.add(senderArea);
		
		senderInfoPanel.add(senderNanJingArea);
		senderInfoPanel.add(senderBeiJingArea);
		senderInfoPanel.add(senderGuangZhouArea);
		senderInfoPanel.add(senderShangHaiArea);
		
		
		receiverInfoPanel.add(receiverCity);
		receiverInfoPanel.add(receiverArea);
		
		receiverInfoPanel.add(receiverNanJingArea);
		receiverInfoPanel.add(receiverBeiJingArea);
		receiverInfoPanel.add(receiverGuangZhouArea);
		receiverInfoPanel.add(receiverShangHaiArea);

		receiverInfoPanel.add(receiverInfo);
		receiverInfoPanel.add(receiverNameLabel);
		receiverInfoPanel.add(receiverPhoneLabel);
		receiverInfoPanel.add(receiverAddressLabel);
		receiverInfoPanel.add(receiverUnitLabel);

		receiverInfoPanel.add(receiverNameText);
		receiverInfoPanel.add(receiverPhoneText);
		receiverInfoPanel.add(receiverAddressText);
		receiverInfoPanel.add(receiverUnitText);

		goodInfoPanel.add(goodsInfo);
		goodInfoPanel.add(goodNameLabel);
		goodInfoPanel.add(goodWeightLabel);
		goodInfoPanel.add(goodNumLabel);
		goodInfoPanel.add(goodVolumLabel);
		goodInfoPanel.add(goodPackLabel);
		goodInfoPanel.add(orderFormLabel);

		goodInfoPanel.add(goodNameText);
		goodInfoPanel.add(goodNumText);
		goodInfoPanel.add(goodWeightText);
		goodInfoPanel.add(goodLongText);
		goodInfoPanel.add(goodWidthText);
		goodInfoPanel.add(goodHeightText);

		goodpackGroup.add(bag);
		goodpackGroup.add(carton);
		goodpackGroup.add(woodCase);

		goodInfoPanel.add(bag);
		goodInfoPanel.add(carton);
		goodInfoPanel.add(woodCase);

		orderFormGroup.add(commonOrder);
		orderFormGroup.add(quickOrder);
		orderFormGroup.add(economicOrder);

		goodInfoPanel.add(commonOrder);
		goodInfoPanel.add(quickOrder);
		goodInfoPanel.add(economicOrder);

		this.add(confirm);
		this.add(cancel);
		
		this.add(estimateTime);
		this.add(cost);

		this.add(senderInfoPanel);
		this.add(receiverInfoPanel);
		this.add(goodInfoPanel);

	}

	
	@Override
	protected void addListener() {

		confirm.addMouseListener(new ConfirmListener(confirm) {

			@Override
			protected void saveToSQL() {
				// TODO Auto-generated method stub

			}

			@Override
			protected boolean checkDataValid() {
				// TODO 检查必填项目是否正确

				return true;
			}

			@Override
			protected void reInitial() {
				setAllTextFieldEmpty();
			}
		});

		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				System.out.println("reset!");
				setAllTextFieldEmpty();
			}
		});
		
		addSenderCityComboxListener(senderCity);
		addReceiverCityComboxListener(receiverCity);
	}

	public void addSenderCityComboxListener(final MyComboBox city) {
		city.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(final ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					int index = city.getSelectedIndex();
						//寄件人 所有对应栏的地区加载框全部设为不可见
						setAllSenderComboboxUnvisible();
						switch (index) {
						//默认
						case 0:
							setChoseComboboxVisible(senderArea);
							break;
						// 南京
						case 1:
							setChoseComboboxVisible(senderNanJingArea);
							break;
						// 北京
						case 2:
							setChoseComboboxVisible(senderBeiJingArea);
							break;
						// 广州
						case 3:
							setChoseComboboxVisible(senderGuangZhouArea);
							break;
						// 上海
						default:
							setChoseComboboxVisible(senderShangHaiArea);
							break;
					   }
				}
			}
		});	
	}

	
	public void addReceiverCityComboxListener(final MyComboBox city) {
		city.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(final ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					//收件人 把所有对应栏的地区加载框全部设为不可见
					setAllReceiverComboboxUnvisible();
					int index = city.getSelectedIndex();
					switch (index) {
					//默认
					case 0:
						setChoseComboboxVisible(receiverArea);
						break;
					// 南京
					case 1:
						setChoseComboboxVisible(receiverNanJingArea);
						break;
					// 北京
					case 2:
						setChoseComboboxVisible(receiverBeiJingArea);
						break;
					// 广州
					case 3:
						setChoseComboboxVisible(receiverGuangZhouArea);
						break;
					// 上海
					default:
						setChoseComboboxVisible(receiverShangHaiArea);
						break;
				   }
					repaint();
				}	
			}	
		});	
	}



	protected void setAllSenderComboboxUnvisible(){
			senderArea.setVisible(false);
			senderNanJingArea.setVisible(false);
			senderBeiJingArea.setVisible(false);
			senderGuangZhouArea.setVisible(false);
			senderShangHaiArea.setVisible(false);
	}
	protected void setAllReceiverComboboxUnvisible(){
			receiverArea.setVisible(false);
			receiverNanJingArea.setVisible(false);
			receiverBeiJingArea.setVisible(false);
			receiverGuangZhouArea.setVisible(false);
			receiverShangHaiArea.setVisible(false);
	}

	
	protected void setChoseComboboxVisible(MyComboBox area){
		area.setVisible(true);
	}
	

	public void setAllTextFieldEmpty() {
		senderNameText.setText("");
		senderPhoneText.setText("");
		senderAddressText.setText("");
		senderUnitText.setText("");

		receiverNameText.setText("");
		receiverPhoneText.setText("");
		receiverAddressText.setText("");
		receiverUnitText.setText("");

		goodNameText.setText("");
		goodNumText.setText("");
		goodWeightText.setText("");
		goodLongText.setText("");
		goodWidthText.setText("");
		goodHeightText.setText("");
	}

	

}
