package ui.financeman.bankAccount;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import blservice.financeblservice.BankAccountBusinessService;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;

/**
 * 银行账户管理
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class BankAccountManagePanel extends MyPanel {

	private BankAccountBusinessService bl;

	private BankAccountTable table;

	private MyPictureButton confirm;
	private MyPictureButton delete;
	private MyPictureButton cancel;
	private MyPictureButton modify;

	private MyLabel newPassword;
	private MyLabel newMoney;

	private MyTextField moneyT;
	private MyTextField passT;

	public BankAccountManagePanel(Element config, BankAccountBusinessService bl) {
		super(config);
		this.bl = bl;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLables(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		delete = new MyPictureButton(e.element("delete"));
		modify = new MyPictureButton(e.element("modify"));
	}

	@Override
	protected void initTextFields(Element e) {
		passT = new MyTextField(e.element("passT"));
		moneyT = new MyTextField(e.element("money"));
	}

	@Override
	protected void initLables(Element e) {
		newMoney = new MyPictureLabel(e.element("money"));
		newPassword = new MyPictureLabel(e.element("password"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		table = new BankAccountTable(e.element("table"));

	}

	@Override
	protected void addCompoment() {
		add(cancel);
		add(confirm);
		add(delete);
		add(modify);
		add(moneyT);
		add(newMoney);
		add(newPassword);
		add(passT);
		add(table);
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
		modify.addMouseListener(new MyPictureButtonListener(modify) {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

		});
		delete.addMouseListener(new MyPictureButtonListener(delete) {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

		});
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

}
