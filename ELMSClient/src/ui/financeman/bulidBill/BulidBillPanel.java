package ui.financeman.bulidBill;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.City;
import util.MyDate;
import util.ResultMessage;
import vo.DTManage.CarVO;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;
import vo.statistic.BillVO;
import blservice.statisticblservice.Statisticblservice;

/**
 * 期初建账主界面
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class BulidBillPanel extends MyPanel {
	// 均为默认权限，包内可访问
	Statisticblservice bl;
	JPanel changePanel;
	CardLayout panelManager;
	/**
	 * 账单 = =
	 */
	BillVO bill = new BillVO("", MyDate.getNowTime());
	ArrayList<InstVO> instVOs = new ArrayList<>();;
	ArrayList<CarVO> carVOs = new ArrayList<>();
	ArrayList<PersonVO> personVOs = new ArrayList<>();

	MainTable mainTable;
	AddCar addCar;
	AddPeople addPeople;
	AddInst addInst;

	private MyPictureButton confirm;
	private MyPictureButton cancel;
	private MyPictureButton add;

	private MyLabel title;
	private MyPictureLabel newInst;
	private MyPictureLabel user;
	private MyPictureLabel time;
	private MyPictureLabel message;

	private MyDatePicker datePicker;
	private MyTextField name;

	final static String bulidBillStr = "BulidBillPanel";
	final static String addInstStr = "AddInstStrPanel";
	final static String addPeopleStr = "AddPeoplePanel";
	final static String addCarStr = "AddCarPanel";

	public BulidBillPanel(Element config, Statisticblservice bl,
			JPanel changePanel) {
		super(config);
		this.changePanel = changePanel;
		this.panelManager = (CardLayout) changePanel.getLayout();
		this.bl = bl;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
		panelManager.show(changePanel, bulidBillStr);
		
		myinit();
	}
	/**
	 * 进行账单读取
	 */
	private void myinit() {
		ArrayList<BillVO> vos = bl.getBills();
		if(vos != null && !vos.isEmpty()){
			bill = vos.get(vos.size() - 1);
			String[][] data = new String[bill.instituations.size()][5];
			String instid;
			InstVO vo;
			for (int i = 0 ; i < data.length ; i ++) {
				vo = bill.instituations.get(i);
				data[i][0] = vo.ID;
				data[i][1] = vo.location.getName();
				data[i][2] = vo.type.getName();
			}
			
			
			
		}
		
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		add = new MyPictureButton(e.element("add"));
		 
	}

	@Override
	protected void initTextFields(Element e) {
		name = new MyTextField(e.element("name"));
	}

	@Override
	protected void initLabels(Element e) {
		newInst = new MyPictureLabel(e.element("newInst"));
		user = new MyPictureLabel(e.element("user"));
		time = new MyPictureLabel(e.element("time"));
		message = new MyPictureLabel(e.element("message"));
		title = new MyLabel(e.element("title"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		datePicker = new MyDatePicker(e.element("datePicker"));
		mainTable = new MainTable(e.element("table") , this);
		addCar = new AddCar(e.element("addCar"), this);
		addPeople = new AddPeople(e.element("addPeople") , this);
		addInst = new AddInst(e.element("addInst"), this);

	}

	@Override
	protected void addCompoment() {
		changePanel.add(addInst, addInstStr);
		changePanel.add(addCar, addCarStr);
		changePanel.add(addPeople, addPeopleStr);
		add(cancel);
		add(confirm);
		add(newInst);
		add(user);
		add(name);
		add(datePicker);
		add(message);
		add(add);
		add(time);
		add(title);
		add(mainTable);
		
	}
	/**
	 * 完成一个机构的增加时调用的方法
	 */
	void finishOneInst(){
		bill.instituations.addAll(instVOs);
		bill.persons.addAll(personVOs);
		bill.cars.addAll(carVOs);
		
		InstVO vo = instVOs.get(0);
		String[] data = {vo.ID ,  vo.location.getName() , vo.type.getName() , String.valueOf(personVOs.size()) , String.valueOf(carVOs.size()) };
		mainTable.addOneRow(data);
		instVOs.clear();
		personVOs.clear();
		carVOs.clear();
		
	}
	
	
	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {

			@Override
			protected boolean saveToSQL() {
				bill.date = datePicker.getMyDate();
				bill.finaceman = name.getText();
				if(bl.bulidBill(bill) == ResultMessage.SUCCESS){
					new TipsDialog("成功新建账单", Color.GREEN);
					return true;
				}else{
					new TipsDialog("由于网络或数据库原因，新建失败");
					return false;
				}
			}

			@Override
			protected void reInitial() {
				// TODO Auto-generated method stub

			}

			@Override
			protected boolean checkDataValid() {
				if(name.getText().equals("")){
					new TipsDialog("请输入经手人", Color.GREEN);
					return false;
				}
				return true;
			}

			@Override
			protected void updateMes() {
				// TODO Auto-generated method stub
				
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				// TODO Auto-generated method stub

			}
		});
		add.addMouseListener(new MyPictureButtonListener(add){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				panelManager.show(changePanel, addInstStr);
			}
		});
	}

	@Override
	protected void initWhitePanels(Element e) {
	}

}
