package ui.generalmanager;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyComboBox;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.tools.MyWhitePanel;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
import ui.util.TextFieldsManage;
import ui.util.TipsDialog;
import util.ResultMessage;
import vo.strategy.ConstVO;
import blservice.strategyblservice.StrategyblService;

/**
 * 制定常量界面
 * 
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class ConstSetPanel extends MyPanel implements TextFieldsManage {

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

	private StrategyblService bl;

	private ConstVO consts;

	private MyWhitePanel instanceP;
	private MyWhitePanel transportP;
	private MyWhitePanel packageP;
	private MyWhitePanel ratioP;

	public ConstSetPanel(Element config, StrategyblService bl) {
		super(config);
		this.bl = bl;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
		initConst();
		checkConstPanel();
	}

	private void initConst() {
		consts = bl.getConst();
		startCity.setSelectedIndex(0);
		arriveCity.setSelectedIndex(0);
		if (consts != null) {
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
	private void checkConstPanel() {
		confirmButton.setVisible(false);
		cancelButton.setVisible(false);
		modifyButton.setVisible(true);
		allowTextFieldToModify(false);
	}

	/**
	 * 进入修改常量界面
	 */
	private void modifyConstPanel() {
		confirmButton.setVisible(true);
		cancelButton.setVisible(true);
		modifyButton.setVisible(false);
		allowTextFieldToModify(true);

	}

	class MyModifyButtonListner extends MyPictureButtonListener {

		public MyModifyButtonListner(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			modifyConstPanel();
		}
	}

	class MyConfirmButtonListner extends ConfirmListener {
		String instancec;
		String planec;
		String trainc;
		String carc;
		String woodc;
		String plasticc;
		String paperc;
		String fastc;
		String normalc;
		String ecnomicc;
		int tempI;
		public MyConfirmButtonListner(MyPictureButton button) {
			super(button);
		}

		@Override
		protected boolean checkDataValid() {
			instancec = instance.getText();
			planec = planeCost.getText();
			trainc = trainCost.getText();
			carc = truckCost.getText();
			woodc = woodCost.getText();
			plasticc = planeCost.getText();
			paperc = paperCost.getText();
			fastc = fastT.getText();
			normalc = normalT.getText();
			ecnomicc = ecnomicT.getText();
			tempI =  saveInstance(
					(String) startCity.getSelectedItem(),
					(String) arriveCity.getSelectedItem());
			if(tempI != -1 ){
				SimpleDataFormat[] datas = {
						new SimpleDataFormat(instancec, DataType.PositiveNum, "距离"),
						new SimpleDataFormat(planec, DataType.PositiveNum, "飞机运费"),
						new SimpleDataFormat(trainc, DataType.PositiveNum, "火车运费"),
						new SimpleDataFormat(carc, DataType.PositiveNum, "汽车运费"), 
						new SimpleDataFormat(woodc, DataType.PositiveNum, "木箱"),
						new SimpleDataFormat(plasticc, DataType.PositiveNum, "塑料袋"),
						new SimpleDataFormat(paperc, DataType.PositiveNum, "纸箱"),
						new SimpleDataFormat(fastc, DataType.PositiveNum, "次晨特快"),
						new SimpleDataFormat(normalc, DataType.PositiveNum, "标准快递"),
						new SimpleDataFormat(ecnomicc, DataType.PositiveNum, "经济快递"),};
				return UserfulMethod.dealWithData(datas);
			}else{
				SimpleDataFormat[] datas = {
						new SimpleDataFormat(planec, DataType.PositiveNum, "飞机运费"),
						new SimpleDataFormat(trainc, DataType.PositiveNum, "火车运费"),
						new SimpleDataFormat(carc, DataType.PositiveNum, "汽车运费"), 
						new SimpleDataFormat(woodc, DataType.PositiveNum, "木箱"),
						new SimpleDataFormat(plasticc, DataType.PositiveNum, "塑料袋"),
						new SimpleDataFormat(paperc, DataType.PositiveNum, "纸箱"),
						new SimpleDataFormat(fastc, DataType.PositiveNum, "次晨特快"),
						new SimpleDataFormat(normalc, DataType.PositiveNum, "标准快递"),
						new SimpleDataFormat(ecnomicc, DataType.PositiveNum, "经济快递"),};
				return UserfulMethod.dealWithData(datas);
			}
			

			
		}

		@Override
		protected boolean saveToSQL() {
			
			switch (tempI) {
			case 0:consts.mileInBN = Integer.parseInt(instancec);break;
			case 1:consts.mileInBS = Integer.parseInt(instancec);break;
			case 2:consts.mileInBG = Integer.parseInt(instancec);break;
			case 3:consts.mileInNS = Integer.parseInt(instancec);break;
			case 4:consts.mileInNG = Integer.parseInt(instancec);break;
			case 5:consts.mileINSG = Integer.parseInt(instancec);break;
			default:break;
			}
			
			
			
			
			consts.plane = Double.valueOf(planec);
			consts.train = Double.valueOf(trainc);
			consts.truck = Double.valueOf(carc);
			consts.paperBox = Integer.parseInt(paperc);
			consts.woodBox = Integer.parseInt(woodc);
			consts.plasticBag = Integer.parseInt(plasticc);
			int[] temp = {Integer.parseInt(fastc) , Integer.parseInt(normalc) , Integer.parseInt(ecnomicc)};
			consts.ratios = temp;
			result = bl.setConst(consts); 
			if(result == ResultMessage.SUCCESS){
				new TipsDialog("保存常量成功！" , Color.GREEN);
				return true;
			}else{
				new TipsDialog("保存常量失败");
				return false;
			}
			

		}

		@Override
		protected void reInitial() {
			checkConstPanel();
			initConst();
		}

		@Override
		protected void updateMes() {
			// TODO Auto-generated method stub

		}
	}

	class MyCancelButtonListner extends MyPictureButtonListener {

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

	class MyCityListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (((String) startCity.getSelectedItem())
					.equals((String) arriveCity.getSelectedItem())) {
				instance.setText("0");
				return;
			}

			instance.setText(String.valueOf(instanceBetweenCity(
					(String) startCity.getSelectedItem(),
					(String) arriveCity.getSelectedItem())));

		}

	}

	// 下面为一些初始化代码

	/*
	 * @see ui.tools.MyPanel#initButtons(org.dom4j.Element)
	 */
	@Override
	protected void initButtons(Element e) {
		modifyButton = new MyPictureButton(e.element("modify"));
		confirmButton = new MyPictureButton(e.element("confirm"));
		cancelButton = new MyPictureButton(e.element("cancel"));

	}

	/*
	 * @see ui.tools.MyPanel#initTextFields(org.dom4j.Element)
	 */
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
	protected void initLabels(Element e) {
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
		this.add(planeCost);
		this.add(trainCost);
		this.add(truckCost);
		this.add(paperCost);
		this.add(woodCost);
		this.add(plasticCost);

		this.add(confirmButton);
		this.add(cancelButton);
		this.add(modifyButton);

		this.add(startCity);
		this.add(arriveCity);

		this.add(fast);
		add(fastT);
		add(ecnomic);
		add(ecnomicT);
		add(normal);
		add(normalT);

		add(instanceP);
		add(transportP);
		add(ratioP);
		add(packageP);

	}

	@Override
	protected void addListener() {
		modifyButton.addMouseListener(new MyModifyButtonListner(modifyButton));
		confirmButton
				.addMouseListener(new MyConfirmButtonListner(confirmButton));
		cancelButton.addMouseListener(new MyCancelButtonListner(cancelButton));
		MyCityListener aListener = new MyCityListener();
		startCity.addItemListener(aListener);
		arriveCity.addItemListener(aListener);
	}

	private int instanceBetweenCity(String start, String end) {

		for(int i = 0 ; i < 2 ; i++){
			switch (start) {
			case "北京":
				switch (end) {
				case "南京":
					return consts.mileInBN;
				case "上海":
					return consts.mileInBS;
				case "广州":
					return consts.mileInBG;
				}
			case "南京":
				switch (end) {
				case "上海":
					return consts.mileInNS;
				case "广州":
					return consts.mileInNG;
				}
			case "上海":
				switch (end) {
				case "广州":
					return consts.mileINSG;
				}
			}
			String temp = start;
			start = end;
			end = temp;
		}
		return -1;
	}
	private int saveInstance(String start, String end) {
		for(int i = 0 ; i < 2 ; i++){
			switch (start) {
			case "北京":
				switch (end) {
				case "南京":
					return 0;
				case "上海":
					return 1;
				case "广州":
					return 2;
				}
			case "南京":
				switch (end) {
				case "上海":
					return 3;
				case "广州":
					return 4;
				}
			case "上海":
				switch (end) {
				case "广州":
					return 5;
				}
			}
			String temp = start;
			start = end;
			end = temp;
		}
		return -1;

	}
	@Override
	protected void initWhitePanels(Element e) {
		instanceP = new MyWhitePanel(e.element("instance"));
		packageP = new MyWhitePanel(e.element("package"));
		transportP = new MyWhitePanel(e.element("transport"));
		ratioP = new MyWhitePanel(e.element("ratio"));
	}

}