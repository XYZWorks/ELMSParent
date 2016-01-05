package ui.financeman.bulidBill;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.financeman.FinanceController;
import ui.tools.MyCardLayOut;
import ui.tools.MyComboBox;
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
import ui.util.RefreshPanel;
import ui.util.TipsDialog;
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
public class BulidBillPanel extends MyPanel implements RefreshPanel {
	// 均为默认权限，包内可访问
	Statisticblservice bl;
	JPanel changePanel;
	MyCardLayOut panelManager;
	DetailPanel detailPanel;
	final static String detailPanelStr = "detail";
	/**
	 * 往期账单
	 */
	ArrayList<BillVO> vos;

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
	private MyComboBox lastBill;

	final static String bulidBillStr = "BulidBillPanel";
	final static String addInstStr = "AddInstStrPanel";
	final static String addPeopleStr = "AddPeoplePanel";
	final static String addCarStr = "AddCarPanel";

	public BulidBillPanel(Element config, Statisticblservice bl,
			JPanel changePanel) {
		super(config);
		this.changePanel = changePanel;
		this.panelManager = (MyCardLayOut) changePanel.getLayout();
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
		vos = bl.getBills();
		lastBill.addItem("当前账单");
		if (vos != null && !vos.isEmpty()) {
			for (int i = 0; i < vos.size(); i++) {
				lastBill.addItem((i + 1) + "."
						+ MyDate.getPartDay(vos.get(i).date));
			}

			lastBill.setSelectedIndex(0);
			// initABill(vos.get(0));

		} else {
			vos = new ArrayList<>();
		}

	}

	private void initABill(BillVO billvo) {
		String[][] data = new String[billvo.instituations.size()][5];
		String instid;
		InstVO vo;
		mainTable.removeAllRows();
		for (int i = 0; i < data.length; i++) {
			vo = billvo.instituations.get(i);
			instid = data[i][0] = vo.ID;
			data[i][1] = vo.location.getName();
			data[i][2] = vo.type.getName();
			data[i][3] = getPersons(instid, billvo.persons);
			data[i][4] = getCars(instid, billvo.cars);
			mainTable.addOneRow(data[i]);
		}

	}

	private String getCars(String instid, ArrayList<CarVO> carVOs) {

		int carNum = 0;
		CarVO vo;
		for (int i = 0; i < carVOs.size(); i++) {
			vo = carVOs.get(i);
			if (vo.instID.equals(instid)) {
				carNum++;
			}

		}

		return String.valueOf(carNum);
	}

	private ArrayList<CarVO> getCars(String instid, ArrayList<CarVO> carVOs,
			int num) {

		ArrayList<CarVO> vos = new ArrayList<>();
		CarVO vo;
		for (int i = 0; i < carVOs.size(); i++) {
			vo = carVOs.get(i);
			if (vo.instID.equals(instid)) {
				vos.add(vo);
			}

		}

		return vos;
	}

	private String getPersons(String instid, ArrayList<PersonVO> personVOs) {
		int personNum = 0;
		PersonVO vo;
		for (int i = 0; i < personVOs.size(); i++) {
			vo = personVOs.get(i);
			if (vo.instID.equals(instid)) {
				personNum++;
			}

		}

		return String.valueOf(personNum);
	}

	private ArrayList<PersonVO> getPersons(String instid,
			ArrayList<PersonVO> personVOs, int num) {
		ArrayList<PersonVO> vos = new ArrayList<>(personVOs.size());
		PersonVO vo;
		for (int i = 0; i < personVOs.size(); i++) {
			vo = personVOs.get(i);
			if (vo.instID.equals(instid)) {
				vos.add(vo);
			}

		}

		return vos;
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
		mainTable = new MainTable(e.element("table"), this);
		addCar = new AddCar(e.element("addCar"), this);
		addPeople = new AddPeople(e.element("addPeople"), this);
		addInst = new AddInst(e.element("addInst"), this);
		lastBill = new MyComboBox(new Rectangle(190, 167, 200, 50));

		detailPanel = new DetailPanel(e.element(detailPanelStr), changePanel,
				FinanceController.bulidBillStr);

	}

	@Override
	protected void addCompoment() {
		changePanel.add(addInst, addInstStr);
		changePanel.add(addCar, addCarStr);
		changePanel.add(addPeople, addPeopleStr);
		changePanel.add(detailPanel, detailPanelStr);
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
		add(lastBill);
	}

	/**
	 * 完成一个机构的增加时调用的方法
	 */
	void finishOneInst() {
		bill.instituations.addAll(instVOs);
		bill.persons.addAll(personVOs);
		bill.cars.addAll(carVOs);

		InstVO vo = instVOs.get(0);
		String[] data = { vo.ID, vo.location.getName(), vo.type.getName(),
				String.valueOf(personVOs.size()), String.valueOf(carVOs.size()) };
		mainTable.addOneRow(data);
		instVOs.clear();
		personVOs.clear();
		carVOs.clear();

	}

	@Override
	protected void addListener() {
		lastBill.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				readBill(lastBill.getSelectedIndex());
			}

		});
		mainTable.getTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = mainTable.getSelectedRow();
					System.out.println("监听到了双击");
					System.err.println(row);
					if (row == -1) {
						return;
					} else {
						int billNum = lastBill.getSelectedIndex();
						if (billNum == 0) {
							detailPanel.showDetail(
									getPersons((String) mainTable.getValueAt(
											row, 0), personVOs, 0),
									getCars((String) mainTable.getValueAt(row,
											0), carVOs, 0));
						

						} else {
							detailPanel.showDetail(
									getPersons((String) mainTable.getValueAt(
											row, 0),
											vos.get(billNum - 1).persons, 0),
									getCars((String) mainTable.getValueAt(row,
											0), vos.get(billNum - 1).cars, 0));
						}
						panelManager.show(changePanel, detailPanelStr);
					}
				}
			}

		});

		confirm.addMouseListener(new ConfirmListener(confirm) {

			@Override
			protected boolean saveToSQL() {
				bill.date = datePicker.getMyDate();
				bill.finaceman = name.getText();
				if (bl.bulidBill(bill) == ResultMessage.SUCCESS) {
					new TipsDialog("成功新建账单", Color.GREEN);
					vos.add(bill);
					lastBill.addItem(vos.size() + "."
							+ MyDate.getPartDay(vos.get(vos.size() - 1).date));
					bill = new BillVO("", MyDate.getNowTime());
					return true;
				} else {
					new TipsDialog("由于网络或数据库原因，新建失败");
					return false;
				}
			}

			@Override
			protected void reInitial() {
				refresh();

			}

			@Override
			protected boolean checkDataValid() {
				if (name.getText().equals("")) {
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
		add.addMouseListener(new MyPictureButtonListener(add) {
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

	private void readBill(int selectedIndex) {
		if (selectedIndex == 0) {
			initABill(bill);
		} else if (selectedIndex > 0) {
			initABill(vos.get(selectedIndex - 1));
		}

	}

	@Override
	public void refresh() {
		lastBill.setSelectedIndex(0);
		readBill(0);
	}
}
