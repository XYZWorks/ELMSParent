package ui.courier;

import org.dom4j.Element;

import blservice.orderblservice.Orderblservice;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyLabel;
import ui.tools.MyPanelWithScroller;
import ui.tools.MyPictureLabel;
import ui.tools.MyWhitePanel;
import ui.util.CompomentType;

@SuppressWarnings("serial")
public class FindFullOrderInfoPanel extends MyPanelWithScroller{
	//private MyPictureButton returnToPrevious;
	
	//bl
	private Orderblservice orderblservice;
	
	//白色矩形panel
	private MyWhitePanel senderInfoPanel;
	private MyWhitePanel receiverInfoPanel;
	private MyWhitePanel goodInfoPanel;
	//private MyWhitePanel estimateTimePanel;
	//private MyWhitePanel costPanel;
	//显示 物流信息面板
	private MyWhitePanel transferInfoPanel;

	//订单号
	private MyPictureLabel orderBarCode;
	private MyLabel orderBarCodeLabel;
	
	//日历
	private MyDatePicker DatePicker;
	
	//寄件人信息
	private MyPictureLabel senderInfo;
	private MyLabel senderNameLabel;
	private MyLabel senderPhoneLabel;
	private MyLabel senderAddressLabel;
	private MyLabel senderUnitLabel;
	
	private MyLabel senderNameText;
	private MyLabel senderPhoneText;
	private MyLabel senderAddressText;
	private MyLabel senderUnitText;

	//收件人信息
	private MyPictureLabel receiverInfo;
	private MyLabel receiverNameLabel;
	private MyLabel receiverPhoneLabel;
	private MyLabel receiverAddressLabel;
	private MyLabel receiverUnitLabel;
	
	private MyLabel receiverNameText;
	private MyLabel receiverPhoneText;
	private MyLabel receiverAddressText;
	private MyLabel receiverUnitText;
	
	
	//货物信息
	private MyPictureLabel goodsInfo;
	private MyLabel goodNameLabel;
	private MyLabel goodWeightLabel;
	private MyLabel goodNumLabel;
	private MyLabel goodVolumLabel;// 体积
	private MyLabel goodPackLabel;//包装形式
	private MyLabel orderFormLabel;//快递形式
	
	private MyLabel goodNameText;
	private MyLabel goodWeightText;
	private MyLabel goodLongText;
	private MyLabel goodWidthText;
	private MyLabel goodHeightText;
	
	//物流信息
	private MyPictureLabel transferInfo;
	
	//预计送达时间
	private MyPictureLabel estimateTime;
	
	//费用总计
	private MyPictureLabel cost;
	
	//包装形式
	private MyLabel goodPack;
	//快递形式
	private MyLabel orderForm;
	
	
	

	public FindFullOrderInfoPanel(Element config,Orderblservice orderblservice) {
		super(config);
		this.orderblservice=orderblservice;
		
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		setVisible(true);
		//System.out.println("couriermainpanel has existed!!");
	}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTextFields(Element e) {
	}

	@Override
	protected void initLabels(Element e) {
		orderBarCode=new MyPictureLabel(e.element("orderBarCode"));
		orderBarCodeLabel=new MyLabel(e.element("orderBarCodeLabel"));
		
		//寄件人信息
		senderInfo=new MyPictureLabel(e.element("senderInfo"));
		senderNameLabel=new MyLabel(e.element("senderNameLabel"));
		senderAddressLabel=new MyLabel(e.element("senderAddressLabel"));
		senderUnitLabel=new MyLabel(e.element("senderUnitLabel"));
		senderPhoneLabel=new MyLabel(e.element("senderPhoneLabel"));
		
		senderNameText=new MyLabel(e.element("senderNameText"));
		senderPhoneText=new MyLabel(e.element("senderPhoneText"));
		senderAddressText=new MyLabel(e.element("senderAddressText"));
		senderUnitText=new MyLabel(e.element("senderUnitText"));
		
		//收件人信息
		receiverInfo=new MyPictureLabel(e.element("receiverInfo"));
		receiverNameLabel=new MyLabel(e.element("receiverNameLabel"));
		receiverPhoneLabel=new MyLabel(e.element("receiverPhoneLabel"));
		receiverAddressLabel=new MyLabel(e.element("receiverAddressLabel"));
		receiverUnitLabel=new MyLabel(e.element("receiverUnitLabel"));
		
		receiverNameText=new MyLabel(e.element("receiverNameText"));
		receiverPhoneText=new MyLabel(e.element("receiverPhoneText"));
		receiverAddressText=new MyLabel(e.element("receiverAddressText"));
		receiverUnitText=new MyLabel(e.element("receiverUnitText"));
		
		
		//货物信息
		goodsInfo=new MyPictureLabel(e.element("goodsInfo"));
		goodNameLabel=new MyLabel(e.element("goodNameLabel"));
		goodWeightLabel=new MyLabel(e.element("goodWeightLabel"));
		goodNumLabel=new MyLabel(e.element("goodNumLabel"));
		goodVolumLabel=new MyLabel(e.element("goodVolumLabel"));
		goodPackLabel=new MyLabel(e.element("goodPackLabel"));
		orderFormLabel=new MyLabel(e.element("orderFormLabel"));
		
		goodNameText=new MyLabel(e.element("goodNameText"));
		goodWeightText=new MyLabel(e.element("goodWeightText"));
		goodLongText=new MyLabel(e.element("goodLongText"));
		goodWidthText=new MyLabel(e.element("goodWidthText"));
		goodHeightText=new MyLabel(e.element("goodHeightText"));

		//流转信息
		transferInfo=new MyPictureLabel(e.element("transferInfo"));
		
		//预计时间
		estimateTime=new MyPictureLabel(e.element("estimateTime"));
		
		
		//费用
		cost=new MyPictureLabel(e.element("cost"));
		
	}

	@Override
	protected void initWhitePanels(Element e) {
		senderInfoPanel=new MyWhitePanel(e.element("senderInfoPanel"));
		receiverInfoPanel=new MyWhitePanel(e.element("receiverInfoPanel"));
		goodInfoPanel=new MyWhitePanel(e.element("goodInfoPanel"));
//		estimateTimePanel=new MyWhitePanel(e.element("estimateTimePanel"));
//		costPanel=new MyWhitePanel(e.element("costPanel"));
		transferInfoPanel=new MyWhitePanel(e.element("transferInfoPanel"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		DatePicker=new MyDatePicker(e.element("DatePicker"));
	
	}

	@Override
	protected void addCompoment() {
		this.add(senderInfoPanel);
		this.add(receiverInfoPanel);
		this.add(goodInfoPanel);
//		this.add(estimateTimePanel);
//		this.add(costPanel);
		this.add(transferInfoPanel);
	
		
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
		goodInfoPanel.add(goodWeightText);
		goodInfoPanel.add(goodLongText);
		goodInfoPanel.add(goodWidthText);
		goodInfoPanel.add(goodHeightText);
		
		transferInfoPanel.add(transferInfo);
		
		
		this.add(estimateTime);
		this.add(cost);
		
//		estimateTimePanel.add(estimateTime);
//		estimateTimePanel.add(estimateTimeLabel);
//		
//		costPanel.add(cost);
//		costPanel.add(costLabel);
		
		
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}


}
