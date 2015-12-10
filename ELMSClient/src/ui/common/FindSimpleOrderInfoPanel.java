package ui.common;

import org.dom4j.Element;

import com.eltima.components.ui.m;

import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MySearchBox;
import ui.tools.MyWhitePanel;
import ui.util.CompomentType;

/**
 * 查询订单
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class FindSimpleOrderInfoPanel extends MyPanel {
	private MyWhitePanel white;
	
	//标题栏：物流信息
	private MyPictureLabel transferInfo;
	
	//左右两边的物流线
	private MyLabel LineLeft;
	private MyLabel LineRight;
	
	//物流的10个状态点
	private MyLabel Load1;
	private MyLabel arriveZZ2;
	private MyLabel inStore3;
	private MyLabel outStore4;
	private MyLabel five;
	private MyLabel six;
	private MyLabel seven;
	private MyLabel eight;
	private MyLabel nine;
	private MyLabel ten;
	
	//显示订单号 
	private MyLabel BarCode;
	private MyLabel BarCodeText;
	
	//选择日期
	private MyDatePicker DatePicker;
	
	//搜索栏
	private MySearchBox searchBox;
	
	public FindSimpleOrderInfoPanel(Element config) {
		super(config);
//		this.orderblservice=orderblservice;
//		this.strategyblService=strategyblService;
		
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
		white=new MyWhitePanel(e.element("WhitePanel"));

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
		BarCode=new MyLabel(e.element("BarCode"));
		BarCodeText=new MyLabel(e.element("BarCodeText"));
		
		transferInfo=new MyPictureLabel(e.element("transferInfo"));
		
		LineLeft=new MyLabel(e.element("LineLeft"));
		LineRight=new MyLabel(e.element("LineRight"));
		
		Load1=new MyLabel(e.element("One"));
		arriveZZ2=new MyLabel(e.element("Two"));
		inStore3=new MyLabel(e.element("Three"));
		outStore4=new MyLabel(e.element("Four"));
		five=new MyLabel(e.element("Five"));
		six=new MyLabel(e.element("Six"));
		seven=new MyLabel(e.element("Seven"));
		eight=new MyLabel(e.element("Eight"));
		nine=new MyLabel(e.element("Nine"));
		ten=new MyLabel(e.element("Ten"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		DatePicker = new MyDatePicker(e.element("DatePicker"));
		searchBox=new MySearchBox(e.element("searchBox"));
	}

	@Override
	protected void addCompoment() {
		white.add(transferInfo);
		
		white.add(LineLeft);
		white.add(LineRight);
		
		white.add(Load1);
		white.add(arriveZZ2);
		white.add(inStore3);
		white.add(outStore4);
		white.add(five);
		white.add(six);
		white.add(seven);
		white.add(eight);
		white.add(nine);
		white.add(ten);
		
		this.add(white);
		this.add(BarCode);
		this.add(BarCodeText);
		this.add(DatePicker);
		this.add(searchBox);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}

	
}
