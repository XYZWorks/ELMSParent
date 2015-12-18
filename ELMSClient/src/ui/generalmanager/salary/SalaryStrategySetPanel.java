package ui.generalmanager.salary;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.dom4j.Element;

import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.TextFieldsManage;
import util.ResultMessage;
import util.StaffType;
import util.WageStrategy;
import vo.strategy.SalaryWayVO;
import blservice.strategyblservice.StrategyblService;

/**
 * 定薪水策略
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class SalaryStrategySetPanel extends MyPanel implements TextFieldsManage {

	private MyLabel staffTypeLabel;
	private MyLabel wageStrategyLabel;
	private MyLabel basicMoneyLabel;
	private MyLabel moreMoneyLabel;

	private MyTextField basicMoneyField;
	private MyTextField moreMoneyField;

	private MyComboBox staffTypeBox;
	private MyComboBox wageStrategyBox;

	private MyPictureButton showInTable;
	private MyPictureButton modify;
	private MyPictureButton confirm;
	private MyPictureButton cancel;

	private SalaryStrategyMesTablePanel table;

	private StrategyblService bl;

	private ArrayList<SalaryWayVO> vos;

	public SalaryStrategySetPanel(Element config, StrategyblService bl) {
		super(config);
		this.bl = bl;

		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();

		MyInit();

		setVisible(true);
	}

	private void MyInit() {
		// 数据层初始化工作，获得数据量，填至field里

		table.setVisible(false);
		confirm.setVisible(false);
		cancel.setVisible(false);
		allowTextFieldToModify(false);
		wageStrategyBox.setEnabled(false);
		showOneSalary();
	}

	/**
	 * 展示一个信息
	 */
	private void showOneSalary() {
		vos = bl.getsalary();
		String temp = (String) staffTypeBox.getSelectedItem();
		for (SalaryWayVO salaryWayVO : vos) {
			if ((temp.equals(StaffType.getName(salaryWayVO.type)))) {
				wageStrategyBox.setSelectedItem(StaffType
						.getName(salaryWayVO.type));
				basicMoneyField
						.setText(String.valueOf(salaryWayVO.basicSalary));
				moreMoneyField.setText(String.valueOf(salaryWayVO.moreMoney));
				break;
			}
		}
	}

	@Override
	protected void initButtons(Element e) {
		showInTable = new MyPictureButton(e.element("ShowInTable"));
		modify = new MyPictureButton(e.element("Modify"));
		confirm = new MyPictureButton(e.element("Confirm"));
		cancel = new MyPictureButton(e.element("Cancel"));

	}

	@Override
	protected void initTextFields(Element e) {
		basicMoneyField = new MyTextField(e.element("BasicMoneyField"));
		moreMoneyField = new MyTextField(e.element("MoreMoneyField"));
	}

	@Override
	protected void initLabels(Element e) {
		staffTypeLabel = new MyPictureLabel(e.element("StaffTypeLabel"));
		wageStrategyLabel = new MyPictureLabel(e.element("WageStrategyLabel"));
		basicMoneyLabel = new MyPictureLabel(e.element("BasicMoneyLabel"));
		moreMoneyLabel = new MyPictureLabel(e.element("MoreMoneyLabel"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		staffTypeBox = new MyComboBox(e.element("StaffTypeBox"));
		wageStrategyBox = new MyComboBox(e.element("WageStrategyBox"));
		table = new SalaryStrategyMesTablePanel(e.element("table"),
				bl.getsalary());

	}

	@Override
	protected void addCompoment() {
		this.add(basicMoneyField);
		this.add(basicMoneyLabel);
		this.add(cancel);
		this.add(confirm);
		// this.add(mesTable);
		this.add(modify);
		this.add(moreMoneyField);
		this.add(moreMoneyLabel);
		this.add(showInTable);
		this.add(staffTypeBox);
		this.add(staffTypeLabel);
		this.add(wageStrategyBox);
		this.add(wageStrategyLabel);

		this.add(table);
	}

	private void setModifyCompVisiable(boolean flag) {
		basicMoneyField.setVisible(flag);
		basicMoneyLabel.setVisible(flag);
		cancel.setVisible(flag);
		confirm.setVisible(flag);
		
		moreMoneyField.setVisible(flag);
		moreMoneyLabel.setVisible(flag);
		
		staffTypeBox.setVisible(flag);
		staffTypeLabel.setVisible(flag);
		wageStrategyBox.setVisible(flag);
		wageStrategyLabel.setVisible(flag);
		
		showInTable.setVisible(!flag);
		table.setVisible(!flag);
		modify.setVisible(!flag);
		showInTable.setEnabled(!flag);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new MyConfirmButtonListner(confirm));
		cancel.addMouseListener(new MyCancelButtonListener(cancel));
		modify.addMouseListener(new MyModifyButtonListener(modify));
		showInTable.addMouseListener(new MyShowInTableButtonListener(
				showInTable));
		staffTypeBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				showOneSalary();

			}
		});

		wageStrategyBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (modify.isVisible()) {

				}

			}
		});

	}

	public void allowTextFieldToModify(boolean flag) {
		basicMoneyField.setEditable(flag);
		moreMoneyField.setEditable(flag);
	}

	class MyConfirmButtonListner extends MyPictureButtonListener {

		public MyConfirmButtonListner(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			// TODO 检查数据合法性、保存至数据库

			StaffType type = StaffType.getType((String) staffTypeBox
					.getSelectedItem());
			WageStrategy wageStrategy = WageStrategy
					.getType((String) wageStrategyBox.getSelectedItem());
			int basic = Integer.parseInt(basicMoneyField.getText());
			int more = Integer.parseInt((moreMoneyField.getText()));

			result = bl.setSalary(new SalaryWayVO(type, basic, more,
					wageStrategy));

			if (result == ResultMessage.SUCCESS) {

			} else {

			}

			showInTable.setVisible(true);
			modify.setVisible(true);
			confirm.setVisible(false);
			cancel.setVisible(false);
			allowTextFieldToModify(false);
			wageStrategyBox.setEnabled(false);
		}

	}

	class MyCancelButtonListener extends MyPictureButtonListener {
		public MyCancelButtonListener(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);

			showOneSalary();
			showInTable.setVisible(true);
			modify.setVisible(true);
			confirm.setVisible(false);
			cancel.setVisible(false);
			allowTextFieldToModify(false);
			wageStrategyBox.setEnabled(false);
		}
	}

	class MyShowInTableButtonListener extends MyPictureButtonListener {
		public MyShowInTableButtonListener(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			// TODO 显示表格
			table.setVisible(true);
			setModifyCompVisiable(false);
			showInTable.setEnabled(false);
			
		}
	}

	class MyModifyButtonListener extends MyPictureButtonListener {
		public MyModifyButtonListener(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			allowTextFieldToModify(true);
			
			setModifyCompVisiable(true);
			
			showInTable.setVisible(false);
			modify.setVisible(false);
			confirm.setVisible(true);
			cancel.setVisible(true);
			wageStrategyBox.setEnabled(true);
			
			
		}

	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

}
