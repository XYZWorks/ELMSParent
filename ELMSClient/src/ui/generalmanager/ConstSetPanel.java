package ui.generalmanager;

import org.dom4j.Element;

import ui.tools.MyButton;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyTextField;
import ui.util.CompomentType;

@SuppressWarnings("serial")
public class ConstSetPanel extends MyPanel{
	
	private MyLabel transportWay;
	private MyLabel plane;
	private MyLabel train;
	private MyLabel truck;

	private MyLabel instanceInCity;
	
	private MyLabel packageCost;
	private MyLabel paper;
	private MyLabel wood;
	private MyLabel plastic;
	
	private MyLabel ratios;
	
	private MyTextField instance;
	private MyTextField planeCost;
	private MyTextField trainCost;
	private MyTextField truckCost;
	private MyTextField paperCost;
	private MyTextField woodCost;
	private MyTextField plasticCost;
	
	private MyButton confirm;
	private MyButton cancel;
	
 
	public ConstSetPanel(Element config) {
		super(config);
		initLables(config.element(CompomentType.LABLES.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		addCompoment();
		addListener();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyButton(e.element("confirm"));
		cancel = new MyButton(e.element("cancel"));
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTextFields(Element e) {
		instance = new MyTextField(e.element("instance"));
		planeCost = new MyTextField(e.element("planeCost"));
		trainCost = new MyTextField(e.element("trainCost"));
		truckCost = new MyTextField(e.element("truckCost"));
		paperCost = new MyTextField(e.element("paperCost"));
		woodCost = new MyTextField(e.element("woodCost"));
		plasticCost = new MyTextField(e.element("plasticCost"));		
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLables(Element e) {
		transportWay = new MyLabel(e.element("transportWay"));
		plane = new MyLabel(e.element("plane"));
		train = new MyLabel(e.element("train"));
		truck = new MyLabel(e.element("truck"));

		instanceInCity = new MyLabel(e.element("instanceInCity"));
		
		packageCost = new MyLabel(e.element("packageCost"));
		paper = new MyLabel(e.element("paper"));
		wood = new MyLabel(e.element("wood"));
		plastic = new MyLabel(e.element("plastic"));
		
		ratios = new MyLabel(e.element("ratios"));
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addCompoment() {
		this.add(transportWay);
		this.add(plane);
		this.add(train);
		this.add(truck);

		this.add(instanceInCity);
		
		this.add(packageCost);
		this.add(paper);
		this.add(wood);
		this.add(plastic);
		
		this.add(ratios);
		
		this.add(instance);
		this.add( planeCost);
		this.add( trainCost);
		this.add( truckCost);
		this.add( paperCost);
		this.add(woodCost);
		this.add(plasticCost);
		
		this.add( confirm);
		this.add( cancel);		
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}

}