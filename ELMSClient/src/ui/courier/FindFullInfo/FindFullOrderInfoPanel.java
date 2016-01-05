package ui.courier.FindFullInfo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.dom4j.Element;

import po.order.GoodMes;
import po.order.OtherOrderMes;
import po.order.PeopleMes;
import po.order.TransferDocs;
import ui.courier.CourierController;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyOptionPane;
import ui.tools.MyPanelWithScroller;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextArea;
import ui.tools.MyWhitePanel;
import ui.util.CompomentType;
import ui.util.DocPanelForApproval;
import ui.util.MyBackListener;
import ui.util.TipsDialog;
import util.DocType;
import util.ResultMessage;
import vo.order.OrderSimpleInfoVO;
import vo.order.OrderVO;
import blservice.orderblservice.Orderblservice;
import main.AXIS;

@SuppressWarnings("serial")
public class FindFullOrderInfoPanel extends MyPanelWithScroller implements DocPanelForApproval {

	// bl
	private Orderblservice orderblservice;
	private CourierController controller;

	// 白色矩形panel
	private MyWhitePanel senderInfoPanel;
	private MyWhitePanel receiverInfoPanel;
	private MyWhitePanel goodInfoPanel;
	private MyWhitePanel transferInfoPanel;// 显示 物流信息面板

	// 订单号
	private MyPictureLabel orderBarCode;
	private MyLabel orderBarCodeLabel;
	private String BarCode;

	// 返回键
	private MyPictureButton returnToPrevious;

	// 日历
	private MyDatePicker DatePicker;

	// 删除
	private MyPictureButton delete;

	// 寄件人信息
	private MyPictureLabel senderInfo;
	private MyLabel senderNameLabel;
	private MyLabel senderPhoneLabel;
	private MyLabel senderUnitLabel;
	private MyLabel senderAddressLabel;

	private MyLabel senderNameText;
	private MyLabel senderPhoneText;
	private MyLabel senderUnitText;
	private MyTextArea senderAddressText;

	// 收件人信息
	private MyPictureLabel receiverInfo;
	private MyLabel receiverNameLabel;
	private MyLabel receiverPhoneLabel;
	private MyLabel receiverAddressLabel;
	private MyLabel receiverUnitLabel;

	private MyLabel receiverNameText;
	private MyLabel receiverPhoneText;
	private MyLabel receiverUnitText;
	private MyTextArea receiverAddressText;

	// 货物信息
	private MyPictureLabel goodsInfo;
	private MyLabel goodNameLabel;
	private MyLabel goodWeightLabel;
	private MyLabel goodNumLabel;
	private MyLabel goodVolumLabel;// 体积

	private MyLabel goodNameText;
	private MyLabel goodNumText;
	private MyLabel goodWeightText;
	private MyLabel goodLongText;
	private MyLabel goodWidthText;
	private MyLabel goodHeightText;

	// 预计送达时间
	private MyPictureLabel estimateTime;
	private MyLabel estimateTimeText;

	// 费用总计
	private MyPictureLabel cost;
	private MyLabel costText;

	// 包装形式
	private MyLabel goodPackLabel;
	private MyLabel goodPackText;
	// 快递形式
	private MyLabel orderFormLabel;
	private MyLabel orderFormText;

	// 标题栏：物流信息
	private MyPictureLabel transferInfo;
	// 左右两边的物流线
	private MyPictureLabel LineLeft;
	private MyPictureLabel LineRight;

	// 物流的10个状态点
	private MyLabel one;
	private MyLabel two;
	private MyLabel three;
	private MyLabel four;
	private MyLabel five;
	private MyLabel six;
	private MyLabel seven;
	private MyLabel eight;
	private MyLabel nine;
	private MyLabel ten;

	private MyLabel oneText;
	private MyLabel twoText;
	private MyLabel threeText;
	private MyLabel fourText;
	private MyLabel fiveText;
	private MyLabel sixText;
	private MyLabel sevenText;
	private MyLabel eightText;
	private MyLabel nineText;
	private MyLabel tenText;

	// 从逻辑层得到的数据
	private OrderVO orderVO;
	private PeopleMes sender;
	private PeopleMes receiver;
	private GoodMes goodMes;
	private OtherOrderMes otherMes;
	private TransferDocs transferDocs;

	private ArrayList<String> transfer;

	public FindFullOrderInfoPanel(Element config, Orderblservice orderblservice, CourierController controller) {
		super(config);

		this.orderblservice = orderblservice;
		this.controller = controller;

		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));

		addCompoment();
		addListener();
		setVisible(true);

	}

	@Override
	protected void initButtons(Element e) {
		delete = new MyPictureButton(e.element("delete"));
		returnToPrevious = new MyPictureButton(e.element("returnToPrevious"));
	}

	@Override
	protected void initTextFields(Element e) {
	}

	@Override
	protected void initLabels(Element e) {
		orderBarCode = new MyPictureLabel(e.element("orderBarCode"));
		orderBarCodeLabel = new MyLabel(e.element("orderBarCodeLabel"));
		orderBarCodeLabel.setForeground(new Color(26,188,156));
		// 寄件人信息
		senderInfo = new MyPictureLabel(e.element("senderInfo"));
		senderNameLabel = new MyLabel(e.element("senderNameLabel"));
		senderAddressLabel = new MyLabel(e.element("senderAddressLabel"));
		senderUnitLabel = new MyLabel(e.element("senderUnitLabel"));
		senderPhoneLabel = new MyLabel(e.element("senderPhoneLabel"));

		senderNameText = new MyLabel(e.element("senderNameText"));
		senderPhoneText = new MyLabel(e.element("senderPhoneText"));
		senderUnitText = new MyLabel(e.element("senderUnitText"));
		senderAddressText = new MyTextArea(e.element("senderAddressText"));

		// 收件人信息
		receiverInfo = new MyPictureLabel(e.element("receiverInfo"));
		receiverNameLabel = new MyLabel(e.element("receiverNameLabel"));
		receiverPhoneLabel = new MyLabel(e.element("receiverPhoneLabel"));
		receiverAddressLabel = new MyLabel(e.element("receiverAddressLabel"));
		receiverUnitLabel = new MyLabel(e.element("receiverUnitLabel"));

		receiverNameText = new MyLabel(e.element("receiverNameText"));
		receiverPhoneText = new MyLabel(e.element("receiverPhoneText"));
		receiverUnitText = new MyLabel(e.element("receiverUnitText"));
		receiverAddressText = new MyTextArea(e.element("receiverAddressText"));

		// 货物信息
		goodsInfo = new MyPictureLabel(e.element("goodsInfo"));
		goodNameLabel = new MyLabel(e.element("goodNameLabel"));
		goodWeightLabel = new MyLabel(e.element("goodWeightLabel"));
		goodNumLabel = new MyLabel(e.element("goodNumLabel"));
		goodVolumLabel = new MyLabel(e.element("goodVolumLabel"));

		goodNameText = new MyLabel(e.element("goodNameText"));
		goodNumText = new MyLabel(e.element("goodNumText"));
		goodWeightText = new MyLabel(e.element("goodWeightText"));
		goodLongText = new MyLabel(e.element("goodLongText"));
		goodWidthText = new MyLabel(e.element("goodWidthText"));
		goodHeightText = new MyLabel(e.element("goodHeightText"));

		// 其他信息
		goodPackLabel = new MyLabel(e.element("goodPackLabel"));
		orderFormLabel = new MyLabel(e.element("orderFormLabel"));
		goodPackText = new MyLabel(e.element("goodPackText"));
		orderFormText = new MyLabel(e.element("orderFormText"));

		// 预计时间
		estimateTime = new MyPictureLabel(e.element("estimateTime"));
		estimateTimeText = new MyLabel(e.element("estimateTimeText"));

		// 费用
		cost = new MyPictureLabel(e.element("cost"));
		costText = new MyLabel(e.element("costText"));

		// 流转信息
		transferInfo = new MyPictureLabel(e.element("transferInfo"));
		transferInfo = new MyPictureLabel(e.element("transferInfo"));

		LineLeft = new MyPictureLabel(e.element("LineLeft"));
		LineRight = new MyPictureLabel(e.element("LineRight"));

		one = new MyLabel(e.element("One"));
		two = new MyLabel(e.element("Two"));
		three = new MyLabel(e.element("Three"));
		four = new MyLabel(e.element("Four"));
		five = new MyLabel(e.element("Five"));
		six = new MyLabel(e.element("Six"));
		seven = new MyLabel(e.element("Seven"));
		eight = new MyLabel(e.element("Eight"));
		nine = new MyLabel(e.element("Nine"));
		ten = new MyLabel(e.element("Ten"));

		oneText = new MyLabel(e.element("OneText"));
		twoText = new MyLabel(e.element("TwoText"));
		threeText = new MyLabel(e.element("ThreeText"));
		fourText = new MyLabel(e.element("FourText"));
		fiveText = new MyLabel(e.element("FiveText"));
		sixText = new MyLabel(e.element("SixText"));
		sevenText = new MyLabel(e.element("SevenText"));
		eightText = new MyLabel(e.element("EightText"));
		nineText = new MyLabel(e.element("NineText"));
		tenText = new MyLabel(e.element("TenText"));

	}

	@Override
	protected void initWhitePanels(Element e) {
		senderInfoPanel = new MyWhitePanel(e.element("senderInfoPanel"));
		receiverInfoPanel = new MyWhitePanel(e.element("receiverInfoPanel"));
		goodInfoPanel = new MyWhitePanel(e.element("goodInfoPanel"));
		transferInfoPanel = new MyWhitePanel(e.element("transferInfoPanel"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		DatePicker = new MyDatePicker(e.element("DatePicker"));

	}

	@Override
	protected void addCompoment() {
		this.add(senderInfoPanel);
		this.add(receiverInfoPanel);
		this.add(goodInfoPanel);
		this.add(transferInfoPanel);

		this.add(orderBarCode);
		this.add(orderBarCodeLabel);

		this.add(returnToPrevious);

		this.add(DatePicker);

		this.add(delete);

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
		goodInfoPanel.add(goodNumText);
		goodInfoPanel.add(goodWeightText);
		goodInfoPanel.add(goodLongText);
		goodInfoPanel.add(goodWidthText);
		goodInfoPanel.add(goodHeightText);
		goodInfoPanel.add(orderFormText);
		goodInfoPanel.add(goodPackText);

		transferInfoPanel.add(transferInfo);

		transferInfoPanel.add(LineLeft);
		transferInfoPanel.add(LineRight);

		transferInfoPanel.add(one);
		transferInfoPanel.add(two);
		transferInfoPanel.add(three);
		transferInfoPanel.add(four);
		transferInfoPanel.add(five);
		transferInfoPanel.add(six);
		transferInfoPanel.add(seven);
		transferInfoPanel.add(eight);
		transferInfoPanel.add(nine);
		transferInfoPanel.add(ten);

		transferInfoPanel.add(oneText);
		transferInfoPanel.add(twoText);
		transferInfoPanel.add(threeText);
		transferInfoPanel.add(fourText);
		transferInfoPanel.add(fiveText);
		transferInfoPanel.add(sixText);
		transferInfoPanel.add(sevenText);
		transferInfoPanel.add(eightText);
		transferInfoPanel.add(nineText);
		transferInfoPanel.add(tenText);

		this.add(estimateTimeText);
		this.add(estimateTime);

		this.add(costText);
		this.add(cost);

	}

	@Override
	protected void addListener() {
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = JOptionPane.showConfirmDialog(null, "确认删除订单", "提示", JOptionPane.YES_NO_OPTION);
				if (x == JOptionPane.YES_OPTION) {
					ResultMessage result = orderblservice.del(BarCode);
					// 是否是删除失败就显示 fail
					if (result == ResultMessage.FAIL) {
						new TipsDialog("货物已经装车  订单无法删除");
						return;
					} else if (result == ResultMessage.SUCCESS) {
						TipsDialog Delete = new TipsDialog("订单删除成功");
						controller.getCardLayout().show(controller.getChangePanel(), "showInfoPanel");
					}
				}
			}
		});

		returnToPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.getCardLayout().show(controller.getChangePanel(), "showInfoPanel");
			}
		});
	}

	public void readInfo(String BarCode) {
		this.BarCode = BarCode;
		orderBarCodeLabel.setText(BarCode);
		// System.out.println("barcode"+BarCode);

		getData(BarCode);
		readData();
	}

	public void getData(String BarCode) {
		if (orderblservice != null) {
			orderVO = orderblservice.getFullInfo(BarCode);
		}

		sender = orderVO.sender;
		receiver = orderVO.receiver;
		goodMes = orderVO.goodMes;
		otherMes = orderVO.otherMes;
		transferDocs = orderVO.transferDocs;
		transfer = transferDocs.getAllDocs();
	}

	public void readData() {
		// 读取收件人信息
		senderNameText.setText(sender.getName());
		senderPhoneText.setText(sender.getPhone());
		senderAddressText.setText(sender.getAddress());
		senderUnitText.setText(sender.getCompany());

		// 读取寄件人信息
		receiverNameText.setText(receiver.getName());
		receiverPhoneText.setText(receiver.getPhone());
		receiverAddressText.setText(receiver.getAddress());
		receiverUnitText.setText(receiver.getCompany());

		// 读取货物信息
		goodNameText.setText(goodMes.getGoodName());
		goodNumText.setText(String.valueOf(goodMes.getGoodNum()));
		goodWeightText.setText(String.valueOf(goodMes.getGoodWeight()) + "kg");
		goodLongText.setText("长" + String.valueOf(goodMes.getGoodLong()) + "cm");
		goodWidthText.setText("宽" + String.valueOf(goodMes.getGoodWidth()) + "cm");
		goodHeightText.setText("高" + String.valueOf(goodMes.getGoodHeight()) + "cm");

		// 读取其他信息
		goodPackText.setText(otherMes.getGoodPack());
		orderFormText.setText(otherMes.getOrderForm());

		costText.setForeground(new Color(255, 138, 0));
		costText.setText(String.valueOf(otherMes.getOrderCost()));

		estimateTimeText.setForeground(new Color(26, 188, 156));
		estimateTimeText.setText(String.valueOf(otherMes.getOrderEestiTime()));

		// 读取流转信息
		if (orderblservice != null) {
			setTransferInfo();
		}

	}

	public void setTransferInfo() {
		// 依次读取物流信息：地点＋时间
		ArrayList<OrderSimpleInfoVO> info = orderblservice.getSimpleInfo(BarCode);
		int length = info.size();

		MyLabel[] place = { one, two, three, four, five, six, seven, eight, nine, ten };
		MyLabel[] time = { oneText, twoText, threeText, fourText, fiveText, sixText, sevenText, eightText, nineText,
				tenText };
		for (int i = 0; i < length; i++) {
			// 详细信息的单据号
			// String transferCode=transfer.get(i);
			// 复用简易信息里的时间和地点
			// place[i].setText(transferCode+processPlace(info.get(i).place,
			// info.get(i).type, i));
			place[i].setText(processPlace(info.get(i).place, info.get(i).type, i));

			time[i].setText(processTime(info.get(i).time));
		}

		// 如果流转信息不超过5个，右边栏点点不会出现
		if (length <= 5) {
			LineRight.setVisible(false);
		} else {
			LineRight.setVisible(true);
		}

	}

	private String processPlace(String place, DocType type, int i) {
		String result = null;
		switch (type) {
		// 装车单
		case loadDoc:
			result = "快件已被成功装车，送往" + place + "中转中心";
			break;
		// 中转中心到达单
		case arriveZZDoc:
			result = "快递已到达[" + place + "中转中心]";
			break;
		// 入库单
		case inStoreDoc:
			result = "快递已入库[" + place + "中转中心]";
			break;
		// 出库单
		case outStoreDoc:
			result = "快递已出库[" + place + "中转中心]";
			break;
		// 接受单
		case arriveYYDoc:
			result = "快件已到达[" + place + "营业厅]";
			break;
		// 派送单
		case sendGoodDoc:
			result = "快递正在被快递员：" + place + " 派送";
			break;
		case transferDoc:
			result = "快递已从[" + place + "]出发 ";
			break;
		default:
			break;
		}
		return result;
	}

	private String processTime(String time) {
		String[] origin = time.split("-");
		// 转化格式：年－月－日 时：分：秒
		String after = origin[0] + "-" + origin[1] + "-" + origin[2] + " " + origin[3] + ":" + origin[4] + ":"
				+ origin[5];
		return after;
	}

	@Override
	public void setAllCompUneditOrUnVisiable() {
		// 启用新的返回键
		returnToPrevious.setVisible(false);

	}

	@Override
	public void addBackButton(JPanel changePanel, String backStr) {
		MyPictureButton back = new MyPictureButton();
		back.addMouseListener(new MyBackListener(back, changePanel, backStr));
		add(back);
	}

	@Override
	public void setMessage(Object o) {
		orderVO = (OrderVO) o;
		getData(null);
		readData();
	}
}
