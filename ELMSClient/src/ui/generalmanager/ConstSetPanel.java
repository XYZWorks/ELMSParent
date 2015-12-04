package ui.generalmanager;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import vo.strategy.ConstVO;
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
	
	private MyPictureLabel ecnomic;
	private MyPictureLabel normal;
	private MyPictureLabel fast;
	
	private MyTextField ecnomicT;
	private MyTextField normalT;
	private MyTextField fastT;
	
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
	
	private ConstVO consts;
	
	
	
	
	public ConstSetPanel(Element config , StrategyblService bl) {
		super(config);
		this.bl = bl;
		initLables(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();
		initConst();
		checkConstPanel();
	}
	
	private void initConst(){
		consts = bl.getConst();
		if(consts!=null){
			instance.setText("0");
			planeCost.setText(String.valueOf(consts.plane));
			trainCost.setText(String.valueOf(consts.train));
			truckCost.setText(String.valueOf(consts.truck));
			plasticCost.setText(String.valueOf(consts.plasticBag));
			paperCost.setText(String.valueOf(consts.paperBox));
			woodCost.setText(String.valueOf(consts.woodBox));
			ecnomicT.setText(String.valueOf(consts.ratios[0]));
			normalT.setText(String.valueOf(consts.ratios[1]));
			fastT.setText(String.valueOf(consts.ratios[2]));
		}
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
			checkAndSaveMes();
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
			initConst();
		}
	}
	
	private void checkAndSaveMes(){
		//TODO
	}
	
	
	public void allowTextFieldToModify(boolean flag) {
		instance.setEditable(flag);
		planeCost.setEditable(flag);
		trainCost.setEditable(flag);
		truckCost.setEditable(flag);
		paperCost.setEditable(flag);
		woodCost.setEditable(flag);
		plasticCost.setEditable(flag);
		fastT.setEditable(flag);
		ecnomicT.setEditable(flag);
		normalT.setEditable(flag);
		
		
	}
	
	
	
	class MyCityListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if( ((String)startCity.getSelectedItem() ).equals((String)arriveCity.getSelectedItem())){
				instance.setText("0");
				return;
			}
			
			instance.setText(String.valueOf(instanceBetweenCity( ( String)startCity.getSelectedItem(), ( String)arriveCity.getSelectedItem())));
			
		}
		
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
		fastT = new MyTextField(e.element("fast"));
		normalT = new MyTextField(e.element("normal"));
		ecnomicT = new MyTextField(e.element("ecnomic"));
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
		fast = new MyPictureLabel(e.element("fast"));
		normal = new MyPictureLabel(e.element("normal"));
		ecnomic = new MyPictureLabel(e.element("ecnomic"));
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
		
		this.add(fast);
		add(fastT);
		add(ecnomic);
		add(ecnomicT);
		add(normal);
		add(normalT);
	}

	@Override
	protected void addListener() {
		modifyButton.addMouseListener(new MyModifyButtonListner(modifyButton));
		confirmButton.addMouseListener(new MyConfirmButtonListner(confirmButton));
		cancelButton.addMouseListener(new MyCancelButtonListner(cancelButton));
		MyCityListener aListener = new MyCityListener();
		startCity.addItemListener(aListener);
		arriveCity.addItemListener(aListener);
	}

	
	private int instanceBetweenCity(String start , String end){
		
		switch (start) {
		case "北京":
				switch (end) {
				case "南京":
					return consts.mileInBN;
				case "上海":
					
					return consts.mileInBS;
				case "广州":
	
					return consts.mileInBG;
				default:
					return 0;
				}
		case "南京":
			switch (end) {
			case "北京":
				return consts.mileInBN;
			case "上海":
				
				return consts.mileInNS;
			case "广州":

				return consts.mileInNG;
			default:
				return 0;
			}
		case "上海":
			switch (end) {
			case "北京":
				return consts.mileInBS;
			case "南京":
				
				return consts.mileInNS;
			case "广州":

				return consts.mileINSG;
			default:
				return 0;
			}
		case "广州":
			switch (end) {
			case "北京":
				return consts.mileInBG;
			case "上海":
				
				return consts.mileINSG;
			case "南京":

				return consts.mileInNG;
			default:
				return 0;
			}
		default:
			return 0;
		}
		
	}
	
	
}