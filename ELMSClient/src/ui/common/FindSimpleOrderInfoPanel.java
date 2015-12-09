package ui.common;

import org.dom4j.Element;

import com.eltima.components.ui.m;

import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyWhitePanel;
import ui.util.CompomentType;

/**
 * 查询订单
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class FindSimpleOrderInfoPanel extends MyPanel {
	private MyWhitePanel background;
	private MyLabel verticalLine;
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
		background=new MyWhitePanel(e.element("Background"));

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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addCompoment() {
		background.add(Load1);
		background.add(arriveZZ2);
		background.add(inStore3);
		background.add(outStore4);
		background.add(five);
		background.add(six);
		background.add(seven);
		background.add(eight);
		background.add(nine);
		background.add(ten);
		
		this.add(background);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}

	
}
