package ui.courier;

import org.dom4j.Element;

import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyRadioButton;
import ui.tools.MyTextField;
import ui.util.CompomentType;

/**
 * 查询订单界面
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class AddOrderPanel extends MyPanel{
	//寄件人信息
	private MyPictureLabel senderInfo;
	private MyLabel senderNameLabel;
	private MyLabel senderPhoneLabel;
	private MyLabel senderAddressLabel;
	private MyLabel senderUnitLabel;

	//收件人信息
	private MyPictureLabel receiverInfo;
	private MyLabel receiverNameLabel;
	private MyLabel receiverPhoneLabel;
	private MyLabel receiverAddressLabel;
	private MyLabel receiverUnitLabel;
	
	//货物信息
	private MyPictureLabel goodsInfo;
	private MyLabel goodNameLabel;
	private MyLabel goodWeightLabel;
	private MyLabel goodNumLabel;
	private MyLabel goodVolumLabel;// 体积
	private MyLabel orderForm;
	
	//预计送达时间
	private MyPictureLabel estimateTime;
	private MyLabel estimateTimeLabel;
	
	//费用总计
	private MyPictureLabel cost;
	private MyLabel costLabel;
	
	
	//textField
	private MyTextField senderNameText;
	private MyTextField senderPhoneText;
	private MyTextField senderAddressText;
	private MyTextField senderUnitText;
	
	private MyTextField receiverNameText;
	private MyTextField receiverPhoneText;
	private MyTextField receiverAddressText;
	private MyTextField receiverUnitText;
	
	private MyTextField goodNameText;
	private MyTextField goodWeightText;
	private MyTextField goodLongText;
	private MyTextField goodWidthText;
	private MyTextField goodHeightText;
	
	/*
	 * 单选框
	 */
	//包装形式
	private MyRadioButton bag;//快递袋
	private MyRadioButton carton;//纸箱
	private MyRadioButton woodCase;//木箱
	
	//快递形式
	private MyRadioButton commonOrder;
	private MyRadioButton quickOrder;
	private MyRadioButton economicOrder;
	
	//下拉框
	private MyComboBox senderCity;
	private MyComboBox senderArea;
	private MyComboBox receiverCity;
	private MyComboBox receiverArea;
	
	//button
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	
	public AddOrderPanel(Element config){
		super(config);
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLables(config.element(CompomentType.LABLES.name()));
		addCompoment();
		addListener();
		setVisible(true);
		//System.out.println("couriermainpanel has existed!!");
	}

	@Override
	protected void initButtons(Element e) {
		confirm=new MyPictureButton(e.element("comfirm"));
		cancel=new MyPictureButton(e.element("cancel"));
	}

	@Override
	protected void initTextFields(Element e) {
		senderNameText=new MyTextField(e.element("senderNameText"));
		senderPhoneText=new MyTextField(e.element("senderPhoneText"));
		senderAddressText=new MyTextField(e.element("senderAddressText"));
		senderUnitText=new MyTextField(e.element("senderUnitText"));
		
		receiverNameText=new MyTextField(e.element("receiverNameText"));
		receiverPhoneText=new MyTextField(e.element("receiverPhoneText"));
		receiverAddressText=new MyTextField(e.element("receiverAddressText"));
		receiverUnitText=new MyTextField(e.element("receiverUnitText"));
		
		goodNameText=new MyTextField(e.element("goodNameText"));
		goodWeightText=new MyTextField(e.element("goodWeightText"));
		goodLongText=new MyTextField(e.element("goodLongText"));
		goodWidthText=new MyTextField(e.element("goodWidthText"));
		goodHeightText=new MyTextField(e.element("goodHeightText"));
		
		
	}

	@Override
	protected void initLables(Element e) {
		senderInfo=new MyPictureLabel(e.element("senderInfo"));
		senderNameLabel=new MyLabel(e.element("senderNameLabel"));
		senderAddressLabel=new MyLabel(e.element("senderAddressLabel"));
		senderUnitLabel=new MyLabel(e.element("senderUnitLabel"));
		
		//收件人信息
		receiverInfo=new MyPictureLabel(e.element("receiverInfo"));
		receiverNameLabel=new MyLabel(e.element("receiverNameLabel"));
		receiverPhoneLabel=new MyLabel(e.element("receiverPhoneLabel"));
		receiverAddressLabel=new MyLabel(e.element("receiverAddressLabel"));
		receiverUnitLabel=new MyLabel(e.element("receiverUnitLabel"));
		
		//货物信息
		goodsInfo=new MyPictureLabel(e.element("goodsInfo"));
		goodNameLabel=new MyLabel(e.element("goodNameLabel"));
		goodWeightLabel=new MyLabel(e.element("goodWeightLabel"));
		goodNumLabel=new MyLabel(e.element("goodNumLabel"));
		goodVolumLabel=new MyLabel(e.element("goodVolumLabel"));
		orderForm=new MyLabel(e.element("orderForm"));

		estimateTime=new MyPictureLabel(e.element("estimateTime"));
		estimateTimeLabel=new MyLabel(e.element("estimateTimeLabel"));
		
		cost=new MyPictureLabel(e.element("cost"));
		costLabel=new MyLabel(e.element("costLabel"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		bag=new MyRadioButton(e.element("bag"));
		carton=new MyRadioButton(e.element("carton"));
		woodCase=new MyRadioButton(e.element("woodCase"));
		
		commonOrder=new MyRadioButton(e.element("commonOrder"));
		quickOrder=new MyRadioButton(e.element("quickOrder"));
		economicOrder=new MyRadioButton(e.element("economicOrder"));
		
		senderCity=new MyComboBox(e.element("senderCity"));
		senderArea=new MyComboBox(e.element("senderArea"));
		
		receiverCity=new MyComboBox(e.element("receiverCity"));
		receiverArea=new MyComboBox(e.element("receiverArea"));
		

	}

	@Override
	protected void addCompoment() {
		this.add(senderInfo);
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		
		this.add();
		this.add();
		this.add();
		this.add();
		this.add();
		
		
		
		
		private MyPictureLabel ;
		private MyLabel senderNameLabel;
		private MyLabel senderPhoneLabel;
		private MyLabel senderAddressLabel;
		private MyLabel senderUnitLabel;

		//收件人信息
		private MyPictureLabel receiverInfo;
		private MyLabel receiverNameLabel;
		private MyLabel receiverPhoneLabel;
		private MyLabel receiverAddressLabel;
		private MyLabel receiverUnitLabel;
		
		//货物信息
		private MyPictureLabel goodsInfo;
		private MyLabel goodNameLabel;
		private MyLabel goodWeightLabel;
		private MyLabel goodNumLabel;
		private MyLabel goodVolumLabel;// 体积
		private MyLabel orderForm;
		
		//预计送达时间
		private MyPictureLabel estimateTime;
		private MyLabel estimateTimeLabel;
		
		//费用总计
		private MyPictureLabel cost;
		private MyLabel costLabel;
		
		
		//textField
		private MyTextField senderNameText;
		private MyTextField senderPhoneText;
		private MyTextField senderAddressText;
		private MyTextField senderUnitText;
		
		private MyTextField receiverNameText;
		private MyTextField receiverPhoneText;
		private MyTextField receiverAddressText;
		private MyTextField receiverUnitText;
		
		private MyTextField goodNameText;
		private MyTextField goodWeightText;
		private MyTextField goodLongText;
		private MyTextField goodWidthText;
		private MyTextField goodHeightText;
		
		/*
		 * 单选框
		 */
		//包装形式
		private MyRadioButton bag;//快递袋
		private MyRadioButton carton;//纸箱
		private MyRadioButton woodCase;//木箱
		
		//快递形式
		private MyRadioButton commonOrder;
		private MyRadioButton quickOrder;
		private MyRadioButton economicOrder;
		
		//下拉框
		private MyComboBox senderCity;
		private MyComboBox senderArea;
		private MyComboBox receiverCity;
		private MyComboBox receiverArea;
		
		//button
		private MyPictureButton confirm;
		private MyPictureButton cancel;
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}

}
