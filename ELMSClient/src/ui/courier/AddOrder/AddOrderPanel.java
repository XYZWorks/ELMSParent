package ui.courier.AddOrder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import org.dom4j.Element;

import po.order.GoodMes;
import po.order.OtherOrderMes;
import po.order.PeopleMes;
import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
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
import ui.util.DocPanelForApproval;
import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.order.OrderVO;
import vo.strategy.ConstVO;
import vo.strategy.EstiDateVO;
import blservice.orderblservice.Orderblservice;
import blservice.strategyblservice.StrategyblService;

/**
 * 查询订单界面
 * 
 * @author xingcheng
 * 
 */
@SuppressWarnings("serial")
public class AddOrderPanel extends MyPanelWithScroller implements DocPanelForApproval{

	// bl
	private Orderblservice orderblservice;
	private StrategyblService strategyblService;

	private ConstVO constVO;
	private EstiDateVO estiDateVO;

	// 白色矩形panel
	private MyWhitePanel senderInfoPanel;
	private MyWhitePanel receiverInfoPanel;
	private MyWhitePanel goodInfoPanel;

	// 订单号
	private MyPictureLabel orderBarCode;

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

	// 预计送达时间label
	private MyPictureLabel estimateTime;
	private MyLabel estimateTimeText;
	
	// 费用总计label
	private MyPictureLabel cost;
	private MyLabel costText;
	
	// 费用double
	private double total;

	// textField
	MyTextField orderBarCodeText;

	MyTextField senderNameText;
	MyTextField senderPhoneText;
	MyTextField senderAddressText;
	MyTextField senderUnitText;

	MyTextField receiverNameText;
	MyTextField receiverPhoneText;
	MyTextField receiverAddressText;
	MyTextField receiverUnitText;

	MyTextField goodNameText;
	MyTextField goodNumText;

	MyTextField goodWeightText;
	private MyLabel KG;

	MyTextField goodLongText;
	MyTextField goodWidthText;
	MyTextField goodHeightText;

	private MyLabel Long;
	private MyLabel Width;
	private MyLabel Height;

	/*
	 * 单选框
	 */
	// 包装形式
	private MyRadioButton bag;// 快递袋
	private MyRadioButton carton;// 纸箱
	private MyRadioButton woodCase;// 木箱
	private ButtonGroup goodpackGroup;
	private String packChose;
	private double packMoney;

	// 快递形式
	private MyRadioButton commonOrder;
	private MyRadioButton quickOrder;
	private MyRadioButton economicOrder;
	private ButtonGroup orderFormGroup;
	private String FormChose;
	private double formMoney;
	private int[]ratios;

	// 下拉框 四种不同城市的地区
	private MyComboBox senderCity;
	private MyComboBox senderArea;

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

	// 判断寄件人、收件人的城市是否已经选择
	private int senderChose = 0;
	private int receiverChose = 0;

	// 对寄件人、收件人 城市、地区 字符串的保留
	private String senderCityString = null;
	private String senderAreaString = null;

	private String receiverCityString;
	private String receiverAreaString;

	// button
	private MyPictureButton confirm;
	private MyPictureButton cancel;

	public AddOrderPanel(Element config, Orderblservice orderblservice, StrategyblService strategyblService) {
		super(config);
		this.orderblservice = orderblservice;
		this.strategyblService = strategyblService;
		
		constVO = strategyblService.getConst();
		ratios=constVO.ratios;
		
		estiDateVO=strategyblService.getEstiDateVO();
		
		System.out.println("estiDate:  "+estiDateVO==null);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initLabels(config.element(CompomentType.LABELS.name()));
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
		orderBarCodeText = new MyTextField(e.element("orderBarCodeText"));
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
	protected void initLabels(Element e) {

		orderBarCode = new MyPictureLabel(e.element("orderBarCode"));

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
		KG = new MyLabel(e.element("KG"));
		Long = new MyLabel(e.element("Long"));
		Width = new MyLabel(e.element("Width"));
		Height = new MyLabel(e.element("Height"));

		goodNumLabel = new MyLabel(e.element("goodNumLabel"));
		goodVolumLabel = new MyLabel(e.element("goodVolumLabel"));
		goodPackLabel = new MyLabel(e.element("goodPackLabel"));
		orderFormLabel = new MyLabel(e.element("orderFormLabel"));

		estimateTime = new MyPictureLabel(e.element("estimateTime"));
		estimateTimeText=new MyLabel(e.element("estimateTimeText"));

		cost = new MyPictureLabel(e.element("cost"));
		costText=new MyLabel(e.element("costText"));
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

		senderNanJingArea = new MyComboBox(e.element("senderArea"), "NanJing");
		senderBeiJingArea = new MyComboBox(e.element("senderArea"), "BeiJing");
		senderShangHaiArea = new MyComboBox(e.element("senderArea"), "ShangHai");
		senderGuangZhouArea = new MyComboBox(e.element("senderArea"), "GuangZhou");

		receiverCity = new MyComboBox(e.element("receiverCity"));
		receiverArea = new MyComboBox(e.element("receiverArea"));

		receiverNanJingArea = new MyComboBox(e.element("receiverArea"), "NanJing");
		receiverBeiJingArea = new MyComboBox(e.element("receiverArea"), "BeiJing");
		receiverShangHaiArea = new MyComboBox(e.element("receiverArea"), "ShangHai");
		receiverGuangZhouArea = new MyComboBox(e.element("receiverArea"), "GuangZhou");

	}

	@Override
	protected void addCompoment() {

		this.add(orderBarCode);
		this.add(orderBarCodeText);

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
		goodInfoPanel.add(KG);
		goodInfoPanel.add(goodLongText);
		goodInfoPanel.add(goodWidthText);
		goodInfoPanel.add(goodHeightText);
		goodInfoPanel.add(Long);
		goodInfoPanel.add(Width);
		goodInfoPanel.add(Height);

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

		this.add(estimateTimeText);
		this.add(estimateTime);
		
		//注意添加的顺序：显示在最上面的最先添加进入面板 costText显示在cost上面
		this.add(costText);
		this.add(cost);

		this.add(senderInfoPanel);
		this.add(receiverInfoPanel);
		this.add(goodInfoPanel);

	}

	@Override
	protected void addListener() {
		// 确认提交订单的监听
		confirm.addMouseListener(new ConfirmListener(confirm) {

			@Override
			protected boolean saveToSQL() {
				// 所有的数据经过了检测，包装vo传给 bl
				String senderADDRESS = senderCityString + senderAreaString + senderAddressText.getText();
				String receiverADDRESS = receiverCityString + receiverAreaString + receiverAddressText.getText();

				PeopleMes sender = new PeopleMes(senderNameText.getText(), senderPhoneText.getText(),
						senderUnitText.getText(), senderADDRESS);
				PeopleMes receiver = new PeopleMes(receiverNameText.getText(), receiverPhoneText.getText(),
						receiverUnitText.getText(), receiverADDRESS);

				GoodMes goodMes = new GoodMes(Integer.parseInt(goodNumText.getText()), goodNameText.getText(),
						Integer.parseInt(goodWeightText.getText()), Integer.parseInt(goodLongText.getText()),
						Integer.parseInt(goodWidthText.getText()), Integer.parseInt(goodHeightText.getText()));

				OtherOrderMes otherMes = new OtherOrderMes(packChose, FormChose,DatePicker.getMyDate(),
						Integer.parseInt(estimateTime.getText()), total, null, null);

				
				// 订单的构造器
				// String iD, DocType type, MyDate date, DocState state,
				// PeopleMes sender, PeopleMes receiver, GoodMes goodMes,
				// OtherOrderMes otherMes, TransferDocs transferDocs
				OrderVO order = new OrderVO(orderBarCodeText.getText(), DocType.order, DatePicker.getMyDate(),
						DocState.wait, sender, receiver, goodMes, otherMes, null);
				ResultMessage result=orderblservice.add(order);
				if(result==ResultMessage.FAIL){
					return false;
				}
				
				return true;
			
			}

			@Override
			protected boolean checkDataValid() {
				// 检查订单所有属性是否填写完整
//				 checkDataValid checkDataValid = new checkDataValid();
				// return checkDataValid.isValid();
				
				SimpleDataFormat[] datas = {
						new SimpleDataFormat(orderBarCodeText.getText(),DataType.BarCode,"订单号"),//订单号格式是否正确
						new SimpleDataFormat(senderPhoneText.getText(),DataType.phone,"寄件人电话"),
						new SimpleDataFormat(receiverPhoneText.getText(),DataType.phone,"收件人电话"),
						//正数
						new SimpleDataFormat(goodNumText.getText(),DataType.PositiveNum,"货物数量"),
						new SimpleDataFormat(goodLongText.getText(),DataType.PositiveNum,"货物长度"),
						new SimpleDataFormat(goodWidthText.getText(),DataType.PositiveNum,"货物宽度"),
						new SimpleDataFormat(goodHeightText.getText(),DataType.PositiveNum,"货物高度"),
						new SimpleDataFormat(goodWeightText.getText(),DataType.PositiveNum,"货物重量"),
						
				};
				
				
				return UserfulMethod.dealWithData(datas);
			}

			@Override
			protected void reInitial() {
				setAllTextFieldEmpty();
			}

			@Override
			protected void updateMes() {
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

		bag.addActionListener(new goodPackListener());
		carton.addActionListener(new goodPackListener());
		woodCase.addActionListener(new goodPackListener());

		commonOrder.addActionListener(new orderFormListener());
		quickOrder.addActionListener(new orderFormListener());
		economicOrder.addActionListener(new orderFormListener());
		goodWeightText.addFocusListener(new goodWeightListener());

	}

	/**
	 * 根据选择的包装费用和快递形式来计算运费
	 */
	public void calCost() {
		if ((senderCityString != null) && (receiverCityString != null) && (!goodWeightText.getText().equals(""))&&packMoney!=0&&FormChose!=null) {
			//标准快递算法
			double goodweight = Double.parseDouble(goodWeightText.getText());
			double miles = getMiles();
			double transferCost = miles / 1000 * 23 * goodweight;
			total = packMoney + transferCost;
		 
			//System.out.println("Before-total" + total);
			//经济快递
			if (FormChose.equals("economicOrder")) {
				total=total/ratios[1]*ratios[0];
			} else if (FormChose.equals("quickOrder")) {
				total=total/ratios[1]*ratios[2];
			}
			//System.out.println("After-total" + total);
			
			// 测试各项数据的准确性
//			System.out.println("miles" + miles);
//			System.out.println("goodweight" + goodweight);
//			System.out.println("transferCost" + transferCost);
//			System.out.println("total" + total);

			// 四舍五入总价 保留两位小数
			String result = String.format("%.2f", total);
			//System.out.println("result:" + result);

			// 绘制cost label
			costText.setForeground(new Color(255, 138, 0));
			costText.setText(result);

		}
	}

	public double getMiles() {
		// 单位：km
		double miles = 0;

//		System.out.println("senderChose" + senderChose);
//		System.out.println("receiverChose" + receiverChose);

		if ((senderChose == receiverChose) && (senderChose != 0)) {
			// 同城的营业厅距离30km
			miles = 30;
		} else {
			// 让senderchose比receiverChose小
			if (senderChose > receiverChose) {
				int tmp;
				tmp = receiverChose;
				receiverChose = senderChose;
				senderChose = tmp;
			}
			// 如果寄件人在南京
			if (senderChose == 1) {
				switch (receiverChose) {
				case 2:
					miles = constVO.mileInBN;// 南京＋北京
					break;
				case 3:
					miles = constVO.mileInNG;// 南京+广州
					break;
				case 4:
					miles = constVO.mileInNS;// 南京＋上海
					break;
				}
			}
			// 如果寄件人在北京
			else if (senderChose == 2) {
				switch (receiverChose) {
				case 3:
					miles = constVO.mileInBG;// 北京+广州
					break;
				case 4:
					miles = constVO.mileInBS;// 北京＋上海
					break;
				}
			} else if ((senderChose == 3) && (receiverChose == 4)) {
				miles = constVO.mileINSG;// 上海＋广州
			}
		}

		return miles;
	}

	/**
	 * 对名字为goodWeightText的textfield增加监听 每次输入新的值就重新调用计算总价的方法
	 */
	class goodWeightListener implements FocusListener {

		@Override
		public void focusLost(FocusEvent e) {
			// 监听 计算运费
			calCost();
		}

		@Override
		public void focusGained(FocusEvent e) {
		}
	}

	/**
	 * 监听 包装形式 每次重新调用计算总价的方法
	 */
	class goodPackListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (bag.isSelected()) {
				packChose = "bag";
				packMoney = constVO.plasticBag;

			} else if (woodCase.isSelected()) {
				packChose = "woodCase";
				packMoney = constVO.woodBox;

			} else if (carton.isSelected()) {
				packChose = "carton";
				packMoney = constVO.paperBox;
			}
			calCost();
		}
	}

	/**
	 * 监听 快递方式 每次重新调用计算总价的方法
	 */
	class orderFormListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (commonOrder.isSelected()) {
				FormChose = "commonOrder";
			} else if (economicOrder.isSelected()) {
				FormChose = "economicOrder";
			} else if (quickOrder.isSelected()) {
				FormChose = "quickOrder";
			}
			calCost();
		}
	}

	/**
	 * 收件人的城市选择 combobox的监听 控制城市对应区域的跳转
	 * 
	 * @param city
	 */
	public void addSenderCityComboxListener(final MyComboBox city) {
		city.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(final ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int index = city.getSelectedIndex();
					senderChose = index;
					// 寄件人 所有对应栏的地区加载框全部设为不可见
					setAllSenderComboboxUnvisible();
					switch (index) {
					// 默认
					case 0:
						setChoseComboboxVisible(senderArea);
						break;
					// 南京
					case 1:
						setChoseComboboxVisible(senderNanJingArea);
						senderCityString = "南京市";

						// 给对应的地区 加监听
						senderNanJingArea.addItemListener(new ItemListener() {
							@Override
							public void itemStateChanged(final ItemEvent e) {
								if (e.getStateChange() == ItemEvent.SELECTED) {
									senderAreaString = (String) senderNanJingArea.getSelectedItem();
									//System.out.println("senderAreaString" + senderAreaString);
								}
							}
						});
						break;
					// 北京
					case 2:
						setChoseComboboxVisible(senderBeiJingArea);
						senderCityString = "北京市";

						senderBeiJingArea.addItemListener(new ItemListener() {
							@Override
							public void itemStateChanged(final ItemEvent e) {
								if (e.getStateChange() == ItemEvent.SELECTED) {
									senderAreaString = (String) senderBeiJingArea.getSelectedItem();
									//System.out.println("senderAreaString" + senderAreaString);
								}
							}
						});
						break;
					// 广州
					case 3:
						setChoseComboboxVisible(senderGuangZhouArea);
						senderCityString = "广州市";

						senderGuangZhouArea.addItemListener(new ItemListener() {
							@Override
							public void itemStateChanged(final ItemEvent e) {
								if (e.getStateChange() == ItemEvent.SELECTED) {
									senderAreaString = (String) senderGuangZhouArea.getSelectedItem();
									//System.out.println("senderAreaString" + senderAreaString);
								}
							}
						});
						break;
					// 上海
					default:
						setChoseComboboxVisible(senderShangHaiArea);
						senderCityString = "上海市";

						senderShangHaiArea.addItemListener(new ItemListener() {
							@Override
							public void itemStateChanged(final ItemEvent e) {
								if (e.getStateChange() == ItemEvent.SELECTED) {
									senderAreaString = (String) senderShangHaiArea.getSelectedItem();
									//System.out.println("senderAreaString" + senderAreaString);
								}
							}
						});
						break;
					}

					System.out.println("sendercity:" + senderCityString);

					setTime();
					calCost();
					// repaint();
				}
			}
		});
	}

	/**
	 * 寄件人的城市选择 combobox的监听 控制城市对应区域的跳转
	 * 
	 * @param city
	 */
	public void addReceiverCityComboxListener(final MyComboBox city) {
		city.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(final ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					// 收件人 把所有对应栏的地区加载框全部设为不可见
					setAllReceiverComboboxUnvisible();
					int index = city.getSelectedIndex();
					receiverChose = index;
					switch (index) {
					// 默认
					case 0:
						setChoseComboboxVisible(receiverArea);
						break;
					// 南京
					case 1:

						setChoseComboboxVisible(receiverNanJingArea);
						receiverCityString = "南京市";
						// 给对应的地区 加监听
						receiverNanJingArea.addItemListener(new ItemListener() {
							@Override
							public void itemStateChanged(final ItemEvent e) {
								if (e.getStateChange() == ItemEvent.SELECTED) {
									receiverAreaString = (String) receiverNanJingArea.getSelectedItem();
									//System.out.println("receiverAreaString" + receiverAreaString);
								}
							}
						});
						break;

					// 北京
					case 2:
						setChoseComboboxVisible(receiverBeiJingArea);
						receiverCityString = "北京市";

						receiverBeiJingArea.addItemListener(new ItemListener() {
							@Override
							public void itemStateChanged(final ItemEvent e) {
								if (e.getStateChange() == ItemEvent.SELECTED) {
									receiverAreaString = (String) receiverBeiJingArea.getSelectedItem();
								//	System.out.println("receiverAreaString" + receiverAreaString);
								}
							}
						});
						break;
					// 广州
					case 3:
						setChoseComboboxVisible(receiverGuangZhouArea);
						receiverCityString = "广州市";

						receiverGuangZhouArea.addItemListener(new ItemListener() {
							@Override
							public void itemStateChanged(final ItemEvent e) {
								if (e.getStateChange() == ItemEvent.SELECTED) {
									receiverAreaString = (String) receiverGuangZhouArea.getSelectedItem();
									//System.out.println("receiverAreaString" + receiverAreaString);
								}
							}
						});
						break;
					// 上海
					default:
						setChoseComboboxVisible(receiverShangHaiArea);
						receiverCityString = "上海市";

						receiverShangHaiArea.addItemListener(new ItemListener() {
							@Override
							public void itemStateChanged(final ItemEvent e) {
								if (e.getStateChange() == ItemEvent.SELECTED) {
									receiverAreaString = (String) receiverShangHaiArea.getSelectedItem();
									//System.out.println("receiverAreaString" + receiverAreaString);
								}
							}
						});
						break;
					}

				//	System.out.println("recevierCityString" + receiverCityString);
					setTime();
					calCost();
					// repaint();
				}
			}
		});
	}

	

	/**
	 * 根据选择的收件、寄件城市来估计时间
	 */
	public void setTime() {
		if ((senderChose != 0) && (receiverChose != 0)) {
			double time = 0;
			
			System.out.println("senderChose"+senderChose);
			System.out.println("receiverChose"+receiverChose);
			
			if (senderChose == receiverChose) {
				// 同城的营业厅距离30km
				time=estiDateVO.dayInSameCity ;
			} else {
				// 让senderchose比receiverChose小
				if (senderChose > receiverChose) {
					int tmp;
					tmp = receiverChose;
					receiverChose = senderChose;
					senderChose = tmp;
				}
				// 如果寄件人在南京
				if (senderChose == 1) {
					switch (receiverChose) {
					case 2:
						time = estiDateVO.dayInBN;// 南京＋北京
						break;
					case 3:
						time = estiDateVO.dayInNG;// 南京+广州
						break;
					case 4:
						time = estiDateVO.dayInNS;// 南京＋上海
						break;
					}
				}
				// 如果寄件人在北京
				else if (senderChose == 2) {
					switch (receiverChose) {
					case 3:
						time = estiDateVO.dayInBG;// 北京+广州
						break;
					case 4:
						time = estiDateVO.dayInBS;// 北京＋上海
						break;
					}
				} else if ((senderChose == 3) && (receiverChose == 4)) {
					time = estiDateVO.dayInSG;// 上海＋广州
				}
			}
			
			String result = String.format("%.2f", time);
			System.out.println("time:" + result);

			estimateTimeText.setForeground(new Color(26, 188, 156));
			estimateTimeText.setText(result);
		}
	}

	
	/**
	 * 设置 收件人 所有不同城市区域的选择框不可见
	 */
	protected void setAllSenderComboboxUnvisible() {
		senderArea.setVisible(false);
		senderNanJingArea.setVisible(false);
		senderBeiJingArea.setVisible(false);
		senderGuangZhouArea.setVisible(false);
		senderShangHaiArea.setVisible(false);
	}

	/**
	 * 设置 收件人 所有不同城市区域的选择框不可见
	 */
	protected void setAllReceiverComboboxUnvisible() {
		receiverArea.setVisible(false);
		receiverNanJingArea.setVisible(false);
		receiverBeiJingArea.setVisible(false);
		receiverGuangZhouArea.setVisible(false);
		receiverShangHaiArea.setVisible(false);
	}

	/**
	 * 设置 选择的选择框可见
	 * 
	 * @param area
	 */
	protected void setChoseComboboxVisible(MyComboBox area) {
		area.setVisible(true);
	}

	/**
	 * 清空文本框
	 */
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

	@Override
	public void setAllCompUneditOrUnVisiable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBackButton(JPanel changePanel, String backStr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMessage(Object vo) {
		// TODO Auto-generated method stub
		
	}

}

