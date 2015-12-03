package ui.generalmanager;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import bl.BusinessLogicDataFactory;
import blservice.strategyblservice.StrategyblService;
import ui.generalmanager.ConstSetPanel.MyConfirmButtonListner;
import ui.table.MyTable;
import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.TextFieldsManage;

/**
 * 定薪水策略
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class SalaryStrategySetPanel  extends MyPanel implements TextFieldsManage{
	
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
	
	private MyTable mesTable;
	
	private StrategyblService bl;
	
	public SalaryStrategySetPanel(Element config) {
		super(config);
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLables(config.element(CompomentType.LABLES.name()));
		addCompoment();
		addListener();
		
		MyInit();
		
		
		
		
		setVisible(true);
	}
	
	private void MyInit(){
		//数据层初始化工作，获得数据量，填至field里
//		bl = BusinessLogicDataFactory.getFactory().getStrategyBusinessLogic();
		
		
		
		confirm.setVisible(false);
		cancel.setVisible(false);
		allowTextFieldToModify(false);
		
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
		basicMoneyField = new  MyTextField(e.element("BasicMoneyField"));
		moreMoneyField = new  MyTextField(e.element("MoreMoneyField"));
	}

	@Override
	protected void initLables(Element e) {
		staffTypeLabel = new MyPictureLabel(e.element("StaffTypeLabel"));
		wageStrategyLabel = new MyPictureLabel(e.element("WageStrategyLabel"));
		basicMoneyLabel = new MyPictureLabel(e.element("BasicMoneyLabel"));
		moreMoneyLabel = new MyPictureLabel(e.element("MoreMoneyLabel"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		staffTypeBox = new MyComboBox(e.element("StaffTypeBox"));
		wageStrategyBox = new MyComboBox(e.element("WageStrategyBox"));
		
//		mesTable = new MyTable();
		
		
	}

	@Override
	protected void addCompoment() {
		this.add(basicMoneyField);
		this.add(basicMoneyLabel);
		this.add(cancel);
		this.add(confirm);
//		this.add(mesTable);
		this.add(modify);
		this.add(moreMoneyField);
		this.add(moreMoneyLabel);
		this.add(showInTable);
		this.add(staffTypeBox);
		this.add(staffTypeLabel);
		this.add(wageStrategyBox);
		this.add(wageStrategyLabel);
		
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new MyConfirmButtonListner(confirm));
		cancel.addMouseListener(new MyCancelButtonListener(cancel));
		modify.addMouseListener(new MyModifyButtonListener(modify));
		showInTable.addMouseListener(new MyShowInTableButtonListener(showInTable));
	}
	
	
	public void allowTextFieldToModify(boolean flag) {
		basicMoneyField.setEditable(flag);
		moreMoneyField.setEditable(flag);
	}
	
	class MyConfirmButtonListner extends MyPictureButtonListener{

		public MyConfirmButtonListner(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			//TODO 检查数据合法性、保存至数据库
			
			showInTable.setVisible(true);
			modify.setVisible(true);
			confirm.setVisible(false);
			cancel.setVisible(false);
			allowTextFieldToModify(false);
		}

	}
	
	class MyCancelButtonListener extends MyPictureButtonListener{
		public MyCancelButtonListener(MyPictureButton button) {
			super(button);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			//TODO 重新从数据库中读取数据填写到textfield中
			
			showInTable.setVisible(true);
			modify.setVisible(true);
			confirm.setVisible(false);
			cancel.setVisible(false);
			allowTextFieldToModify(false);
		}
	}
	
	class MyShowInTableButtonListener extends MyPictureButtonListener{
		public MyShowInTableButtonListener(MyPictureButton button) {
			super(button);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			//TODO 显示表格
		}
	}
	
	class MyModifyButtonListener extends MyPictureButtonListener{
		public MyModifyButtonListener(MyPictureButton button) {
			super(button);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			allowTextFieldToModify(true);
			showInTable.setVisible(false);
			modify.setVisible(false);
			confirm.setVisible(true);
			cancel.setVisible(true);
		}
		
		
		
	}
	
}
