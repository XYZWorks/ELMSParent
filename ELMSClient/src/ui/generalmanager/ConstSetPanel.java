package ui.generalmanager;

import org.dom4j.Element;

import ui.tools.MyButton;
import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.CompomentType;
/**
 * 制定常量界面
 * @author czq
 *
 */
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
	
	private MyButton modifyButton;
	private MyButton confirmButton;
	private MyButton cancelButton;
	
	private MyComboBox startCity;
	private MyComboBox arriveCity;
	
 
	public ConstSetPanel(Element config) {
		super(config);
		initLables(config.element(CompomentType.LABLES.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();
	}

	@Override
	protected void initButtons(Element e) {
		modifyButton = new MyButton(e.element("modify"));
		confirmButton = new MyButton(e.element("confirm"));
		cancelButton = new MyButton(e.element("cancel"));
		
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
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		startCity = new MyComboBox(e.element("startCity"));
		arriveCity = new MyComboBox(e.element("arriveCity"));
		
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
		
		this.add( confirmButton);
		this.add( cancelButton);
		this.add(modifyButton);
		
		this.add(startCity);
		this.add(arriveCity);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}

}