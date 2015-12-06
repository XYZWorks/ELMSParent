package ui.courier;

import java.awt.Dimension;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPanelWithScroller;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyRadioButton;
import ui.tools.MyScrollerPane;
import ui.tools.MyTextField;
import ui.tools.MyWhitePanel;
import ui.util.CompomentType;

import ui.util.MyPictureButtonListener;
import ui.util.ConfirmListener;

import ui.util.PanelController;

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

	private JPanel changePanel;
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
	private MyLabel estimateTimeLabel;

	// 费用总计
	private MyPictureLabel cost;
	private MyLabel costLabel;

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

	// 快递形式
	private MyRadioButton commonOrder;
	private MyRadioButton quickOrder;
	private MyRadioButton economicOrder;

	// 下拉框
	private MyComboBox senderCity;
	private MyComboBox senderArea;
	private MyComboBox receiverCity;
	private MyComboBox receiverArea;

	// button
	private MyPictureButton confirm;
	private MyPictureButton cancel;

	public AddOrderPanel(Element config, JPanel changePanel) {
		super(config);
		this.changePanel = changePanel;
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
		goodNumText=new MyTextField(e.element("goodNumText"));
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
		estimateTimeLabel = new MyLabel(e.element("estimateTimeLabel"));

		cost = new MyPictureLabel(e.element("cost"));
		costLabel = new MyLabel(e.element("costLabel"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		DatePicker = new MyDatePicker(e.element("DatePicker"));

		bag = new MyRadioButton(e.element("bag"));
		carton = new MyRadioButton(e.element("carton"));
		woodCase = new MyRadioButton(e.element("woodCase"));

		commonOrder = new MyRadioButton(e.element("commonOrder"));
		quickOrder = new MyRadioButton(e.element("quickOrder"));
		economicOrder = new MyRadioButton(e.element("economicOrder"));

		senderCity = new MyComboBox(e.element("senderCity"));
		senderArea = new MyComboBox(e.element("senderArea"));

		receiverCity = new MyComboBox(e.element("receiverCity"));
		receiverArea = new MyComboBox(e.element("receiverArea"));

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
		receiverInfoPanel.add(receiverCity);
		receiverInfoPanel.add(receiverArea);
		
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
		
		goodInfoPanel.add(bag);
		goodInfoPanel.add(carton);
		goodInfoPanel.add(woodCase);

		goodInfoPanel.add(commonOrder);
		goodInfoPanel.add(quickOrder);
		goodInfoPanel.add(economicOrder);
		
		this.add(confirm);
		this.add(cancel);
		
		this.add(senderInfoPanel);
		this.add(receiverInfoPanel);
		this.add(goodInfoPanel);
		


	}

	@Override
	protected void addListener() {
		
		confirm.addMouseListener(new MyPictureButtonListener(confirm));
		cancel.addMouseListener(new MyPictureButtonListener(cancel));
		confirm.addMouseListener(new ConfirmListener(confirm) {
			
			@Override
			protected void saveToSQL() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected boolean checkDataValid() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			protected void reInitial() {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

	@Override
	protected void initWhitePanels(Element e) {
		senderInfoPanel=new MyWhitePanel(e.element("senderInfoPanel"));
		receiverInfoPanel=new MyWhitePanel(e.element("receiverInfoPanel"));
		goodInfoPanel=new MyWhitePanel(e.element("goodInfoPanel"));

	}

}
