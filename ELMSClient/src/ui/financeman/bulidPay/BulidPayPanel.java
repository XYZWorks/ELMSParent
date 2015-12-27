package ui.financeman.bulidPay;

import java.awt.Color;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.TipsDialog;
import util.DocState;
import util.MyDate;
import util.ResultMessage;
import vo.finance.PayVO;
import blservice.financeblservice.BankAccountBusinessService;
import blservice.financeblservice.PayService;

/**
 * 新建付款单
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class BulidPayPanel extends MyPanel {

	private PayService payService;
	private BankAccountBusinessService bankAccountBusinessService;
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;

	private MyLabel title;

	private MyPictureLabel idL;
	private MyPictureLabel accountL;
	private MyPictureLabel personL;
	private MyPictureLabel dateL;
	private MyPictureLabel moneyL;
	private MyPictureLabel rentL;
	private MyPictureLabel freightL;
	private MyPictureLabel salaryL;

	private MyTextField idT;
	private MyTextField accountT;
	private MyTextField personT;
	private MyTextField moneyT;
	private MyTextField rentT;
	private MyTextField freightT;
	private MyTextField salaryT;

	private MyDatePicker datePicker;

	public BulidPayPanel(Element config, PayService payService , BankAccountBusinessService bankAccountBusinessService) {
		super(config);
		this.payService = payService;
		this.bankAccountBusinessService = bankAccountBusinessService;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
	}

	@Override
	protected void initTextFields(Element e) {
		idT = new MyTextField(e.element("id"));
		accountT = new MyTextField(e.element("account"));
		personT = new MyTextField(e.element("person"));
		moneyT = new MyTextField(e.element("money"));
		rentT = new MyTextField(e.element("rent"));
		freightT = new MyTextField(e.element("freight"));
		salaryT = new MyTextField(e.element("salary"));

	}

	@Override
	protected void initLabels(Element e) {
		title = new MyLabel(e.element("title"));

		idL = new MyPictureLabel(e.element("id"));
		accountL = new MyPictureLabel(e.element("account"));
		personL = new MyPictureLabel(e.element("person"));
		dateL = new MyPictureLabel(e.element("date"));
		moneyL = new MyPictureLabel(e.element("money"));
		rentL = new MyPictureLabel(e.element("rent"));
		freightL = new MyPictureLabel(e.element("freight"));
		salaryL = new MyPictureLabel(e.element("salary"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		datePicker = new MyDatePicker(e.element("datepicker"));
	}

	@Override
	protected void addCompoment() {

		add(title);
		add(cancel);
		add(confirm);

		add(accountL);
		add(freightL);
		add(rentL);
		add(salaryL);
		add(personL);
		add(dateL);
		add(idL);
		add(moneyL);
		add(personL);
		add(accountT);
		add(freightT);
		add(rentT);
		add(salaryT);
		add(personT);
		add(idT);
		add(moneyT);
		add(personT);
		add(datePicker);
		
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String id;
			String account;
			MyDate date;
			String money;
			String person;
			String rent;
			String freight;
			String salary;
			PayVO vo;

			@Override
			protected boolean saveToSQL() {
				result = bankAccountBusinessService.checkAccount(account , Integer.parseInt(money));
				if(result == ResultMessage.NOT_EXIST){
					new TipsDialog("银行账户不存在！请您重新输入银行账户");
					return false;
				}else if(result == ResultMessage.MONEY_NOT_ENOUGH){
					new TipsDialog("余额不足！请您重新输入银行账户");
					return false;
				}else{
					result = payService.create(vo = new PayVO(id, date, account, Integer.parseInt(money), person, Integer.parseInt(rent), Integer.parseInt(freight), Integer.parseInt(salary) , DocState.wait));
					if(result == ResultMessage.SUCCESS){
						new TipsDialog("成功增加新增付款单", Color.GREEN);
						return true;
					}else{
						new TipsDialog("未能成功增加到数据库");
						System.err.println(result);
						return false;
					}
					
				}
			}

			@Override
			protected void reInitial() {
				myInit();

			}

			@Override
			protected boolean checkDataValid() {
				id = idT.getText();
				account = accountT.getText();
				date = datePicker.getMyDate();
				money = moneyT.getText();
				person = personT.getText();
				rent = rentT.getText();
				freight = freightT.getText();
				salary = salaryT.getText();
				SimpleDataFormat[] datas = {
						new SimpleDataFormat(id, DataType.ID, "ID"),
						new SimpleDataFormat(account, DataType.bankAccount,
								"银行账户"),
						new SimpleDataFormat(money, DataType.PositiveNum, "总金额"),
						new SimpleDataFormat(freight, DataType.PositiveNum,
								"运费"),
						new SimpleDataFormat(rent, DataType.PositiveNum, "租金") ,
						new SimpleDataFormat(salary, DataType.PositiveNum, "人员工资")
						};
				return UserfulMethod.dealWithData(datas);
			}

			@Override
			protected void updateMes() {

			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				myInit();

			}
		});
	}
	
	private void myInit() {
		idT.setText("");accountT.setText("");moneyT.setText("");freightT.setText("");
		rentT.setText("");salaryT.setText("");personT.setText("");
	}
	
	
	@Override
	protected void initWhitePanels(Element e) {
	}

}
