package ui.financeman.bulidBill;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.dom4j.Element;

import blservice.statisticblservice.Statisticblservice;
import ui.tools.MyDatePicker;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
import vo.DTManage.CarVO;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;
import vo.statistic.BillVO;

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
	BillVO newBill;
	ArrayList<InstVO> instVOs = new ArrayList<>();;
	ArrayList<CarVO> carVOs = new ArrayList<>();
	ArrayList<PersonVO> personVOs = new ArrayList<>();

	MainTable mainTable;
	AddCar addCar;
	AddPeople addPeople;
	AddInst addInst;

	private MyPictureButton confirm;
	private MyPictureButton cancel;
	private MyPictureButton newInst;

	private MyPictureLabel title;
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

	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		newInst = new MyPictureButton(e.element("newInst"));

	}

	@Override
	protected void initTextFields(Element e) {
		name = new MyTextField(e.element("name"));
	}

	@Override
	protected void initLabels(Element e) {
		// 要特大号字体
		title = new MyPictureLabel(e.element("title"));
		user = new MyPictureLabel(e.element("user"));
		time = new MyPictureLabel(e.element("time"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		mainTable = new MainTable(e.element("table"));
		addCar = new AddCar(e.element("addCar"));
		addPeople = new AddPeople(e.element("addPeople"));
		addInst = new AddInst(e.element("addInst"));

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
		add(title);
		add(time);

	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {

			@Override
			protected void saveToSQL() {
				// TODO Auto-generated method stub

			}

			@Override
			protected void reInitial() {
				// TODO Auto-generated method stub

			}

			@Override
			protected boolean checkDataValid() {
				// TODO Auto-generated method stub
				return false;
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

}
