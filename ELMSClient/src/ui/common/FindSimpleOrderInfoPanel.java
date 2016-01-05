package ui.common;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.dom4j.Element;
import blservice.orderblservice.Orderblservice;
import ui.config.UserfulMethod;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureLabel;
import ui.tools.MySearchBox;
import ui.tools.MyWhitePanel;
import ui.util.CompomentType;
import ui.util.TipsDialog;
import util.DocType;
import util.FormatMes;
import util.ResultMessage;
import vo.order.OrderSimpleInfoVO;

/**
 * 查询订单
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class FindSimpleOrderInfoPanel extends MyPanel {
	
	
	private MyPanel my;
	
	private MyPanel parent;

	private MyWhitePanel white;

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

	private MySearchBox searchBox;

	// 显示订单号
	private String orderBarCode;// 传入的订单号
	private MyLabel BarCode;// 显示三个字“订单号”
	private MyLabel BarCodeText;// label绘制出订单号

	
	
	// 选择日期
	private MyDatePicker DatePicker;

	// bl
	private Orderblservice orderblservice;

	
	
	public FindSimpleOrderInfoPanel(Element config, MyPanel parent, String BarCodeText,Orderblservice orderblservice) {

		super(config);
		//对自己的引用
		my=this;
		this.parent = parent;
		this.orderblservice=orderblservice;
		this.orderBarCode = BarCodeText;
		
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initLabels(config.element(CompomentType.LABELS.name()));
		initOtherCompoment(config);

		addCompoment();

		addListener();
	
		readInfo();

		addListener();	
		setVisible(true);
		validate();
		repaint();

	}

	
	@Override
	protected void initWhitePanels(Element e) {
		white = new MyWhitePanel(e.element("WhitePanel"));

	}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLabels(Element e) {
		BarCode = new MyLabel(e.element("BarCode"));
		BarCodeText = new MyLabel(e.element("BarCodeText"));
		// 显示传入的orderBarCode
		BarCodeText.setText(orderBarCode);

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
	protected void initOtherCompoment(Element e) {

		DatePicker = new MyDatePicker(e.element("DatePicker"));
		searchBox = new MySearchBox(e.element("searchBox"));
	}

	@Override
	protected void addCompoment() {
		white.add(transferInfo);

		white.add(LineLeft);
		white.add(LineRight);

		white.add(one);
		white.add(two);
		white.add(three);
		white.add(four);
		white.add(five);
		white.add(six);
		white.add(seven);
		white.add(eight);
		white.add(nine);
		white.add(ten);

		white.add(oneText);
		white.add(twoText);
		white.add(threeText);
		white.add(fourText);
		white.add(fiveText);
		white.add(sixText);
		white.add(sevenText);
		white.add(eightText);
		white.add(nineText);
		white.add(tenText);

		this.add(white);
		this.add(BarCode);
		this.add(BarCodeText);
		this.add(DatePicker);
		this.add(searchBox);

		parent.add(this);

	}

	@Override
	protected void addListener() {
		searchBox.addKeyListener(new SearchBoxListener());// TODO Auto-generated
															// method stub

	}

	public void readInfo() {
		// 依次读取物流信息：地点＋时间
		
		System.out.println("readInfoBegin");
		
		ArrayList<OrderSimpleInfoVO> info = orderblservice.getSimpleInfo(orderBarCode);
		int length = info.size();

		System.out.println("length"+length);
		MyLabel[] place = { one, two, three, four, five, six, seven, eight, nine, ten };
		MyLabel[] time = { oneText, twoText, threeText, fourText, fiveText, sixText, sevenText, eightText, nineText,
				tenText };
		for (int i = 0; i < length; i++) {
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
			result = "快件已被成功装车，送往"+place+"中转中心";
			break;
		// 中转中心到达单
		case arriveZZDoc:
			result = "快递已到达["+place+"中转中心]";
			break;
		// 入库单
		case inStoreDoc:
			result = "快递已入库["+place+"中转中心]";
			break;
		// 出库单
		case outStoreDoc:
			result = "快递已出库["+place+"中转中心]";
			break;
		// 接受单
		case arriveYYDoc:
			result = "快件已到达[" +place+"营业厅]";
			break;
		// 派送单
		case sendGoodDoc:
			result = "快递正在被快递员："+place+" 派送";
			break;
		default:
			break;
		}
		return result;
	}

	private String processTime(String time) {
		String[] origin = time.split("-");
		// 转化格式：年－月－日 时：分：秒
		String after = origin[0] + "-" + origin[1] + "-" + origin[2] + "  " + origin[3] + ":" + origin[4] + ":"
				+ origin[5];
		return after;
	}

	class SearchBoxListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				//TipsDialog wrongLength = new TipsDialog("订单号是10位哦～", 670, 95, 235, 45);

				 //获得输入的条形码
				 orderBarCode=searchBox.getMyText();
				 //判断条形码格式是否正确
				 FormatMes result=UserfulMethod.checkBarCode(orderBarCode);
				 if(result==FormatMes.WRONG_LENGTH){
				 TipsDialog wrongLength=new TipsDialog("订单号是10位哦～");
				 }
				 else if(result==FormatMes.ILEGAL_CHAR){
				 TipsDialog ilegalChar=new TipsDialog("订单号是10位数字,输入了非法字符");
				 }
				 else if(result==FormatMes.CORRECT){
					 if(orderblservice.checkBarCode(orderBarCode)==ResultMessage.NOT_EXIST){
						 TipsDialog notExist=new TipsDialog("此订单号不存在");
					 }
					 else if(orderblservice.checkBarCode(orderBarCode)==ResultMessage.hasExist){
						 BarCodeText.setText(orderBarCode);
						 readInfo();
						 my.repaint();
					 }
							 
				 }
			}
		}
	}

}
