package ui.generalmanager;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.tools.MyComboBox;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.TextFieldsManage;
import blservice.strategyblservice.StrategyblService;
/**
 * 制定常量界面
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class ConstSetPanel extends MyPanel implements TextFieldsManage{
	
	private MyPictureLabel transportWay;
	private MyPictureLabel plane;
	private MyPictureLabel train;
	private MyPictureLabel truck;

	private MyPictureLabel instanceInCity;
	
	private MyPictureLabel packageCost;
	private MyPictureLabel paper;
	private MyPictureLabel wood;
	private MyPictureLabel plastic;
	
	private MyPictureLabel ratios;
	
	private MyTextField instance;
	private MyTextField planeCost;
	private MyTextField trainCost;
	private MyTextField truckCost;
	private MyTextField paperCost;
	private MyTextField woodCost;
	private MyTextField plasticCost;
	
	private MyPictureButton modifyButton;
	private MyPictureButton confirmButton;
	private MyPictureButton cancelButton;
	
	private MyComboBox startCity;
	private MyComboBox arriveCity;
	
	//常量获得与修改 TODO
	private StrategyblService bl;
	
	
	public ConstSetPanel(Element config) {
		super(config);
		initLables(config.element(CompomentType.LABLES.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();
		checkConstPanel();
	}
	
	
	
	
	/**
	 * 进入查看常量界面
	 */
	private void  checkConstPanel() {
		confirmButton.setVisible(false);
		cancelButton.setVisible(false);
		modifyButton.setVisible(true);
		allowTextFieldToModify(false);
	}
	/**
	 * 进入修改常量界面
	 */
	private void modifyConstPanel(){
		confirmButton.setVisible(true);
		cancelButton.setVisible(true);
		modifyButton.setVisible(false);
		allowTextFieldToModify(true);
		
	}
	
	

	class MyModifyButtonListner extends MyPictureButtonListener{

		public MyModifyButtonListner(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			modifyConstPanel();
		}
	}
	
	class MyConfirmButtonListner extends MyPictureButtonListener{

		public MyConfirmButtonListner(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			//TODO 将数据保存起来
			
			checkConstPanel();
		}
	}
	
	class MyCancelButtonListner extends MyPictureButtonListener{

		public MyCancelButtonListner(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			checkConstPanel();
		}
	}
	
	@Override
	public void allowTextFieldToModify(boolean flag) {
		instance.setEditable(flag);
		planeCost.setEditable(flag);
		trainCost.setEditable(flag);
		truckCost.setEditable(flag);
		paperCost.setEditable(flag);
		woodCost.setEditable(flag);
		plasticCost.setEditable(flag);
		
	}
	
	
	
	
	
	//下面为一些初始化代码
	
	
	
	
	@Override
	protected void initButtons(Element e) {
		modifyButton = new MyPictureButton(e.element("modify"));
		confirmButton = new MyPictureButton(e.element("confirm"));
		cancelButton = new MyPictureButton(e.element("cancel"));
		
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
		transportWay = new MyPictureLabel(e.element("transportWay"));
		plane = new MyPictureLabel(e.element("plane"));
		train = new MyPictureLabel(e.element("train"));
		truck = new MyPictureLabel(e.element("truck"));

		instanceInCity = new MyPictureLabel(e.element("instanceInCity"));
		
		packageCost = new MyPictureLabel(e.element("packageCost"));
		paper = new MyPictureLabel(e.element("paper"));
		wood = new MyPictureLabel(e.element("wood"));
		plastic = new MyPictureLabel(e.element("plastic"));
		
		ratios = new MyPictureLabel(e.element("ratios"));
		
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
		modifyButton.addMouseListener(new MyModifyButtonListner(modifyButton));
		confirmButton.addMouseListener(new MyConfirmButtonListner(confirmButton));
		cancelButton.addMouseListener(new MyCancelButtonListner(cancelButton));
	}
}