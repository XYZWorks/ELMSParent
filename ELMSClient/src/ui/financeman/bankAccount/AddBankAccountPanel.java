package ui.financeman.bankAccount;

import java.awt.CardLayout;

import javax.swing.JPanel;

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
 /** 
 * 增加银行账户
 * @author czq 
 * @version 2015年12月7日 上午11:11:59 
 */
@SuppressWarnings("serial")
public class AddBankAccountPanel extends MyPanel{
	
	private MyLabel id;
	private MyLabel password;
	private MyLabel money;
	
	private MyTextField idT;
	private MyTextField passwordT;
	private MyTextField moneyT;
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	
	private BankAccountBusinessService bl;
	
	private JPanel changePanel;
	private CardLayout layout;
	private final String bankAccountStr = "BankAccountManagePanel";
	
	public AddBankAccountPanel(Element config , BankAccountBusinessService bl ,JPanel changePanel) {
		super(config);
		this.bl = bl;
		this.changePanel = changePanel;
		this.layout = (CardLayout) changePanel.getLayout();
		
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		
	}

	@Override
	protected void initTextFields(Element e) {
		idT = new MyTextField(e.element("idT"));
		passwordT = new MyTextField(e.element("passT"));
		moneyT = new MyTextField(e.element("money"));
		
	}

	@Override
	protected void initLabels(Element e) {
		money = new MyPictureLabel(e.element("money"));
		password = new MyPictureLabel(e.element("password"));
		id = new MyPictureLabel(e.element("id"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addCompoment() {
		add(id);
		add(cancel);
		add(confirm);
		add(idT);
		add(password);
		add(passwordT);
		add(money);
		add(moneyT);
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
				return false;
			}

			@Override
			protected void updateMes() {
				// TODO Auto-generated method stub
				
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				idT.setText("");
				passwordT.setText("");
				moneyT.setText("");
				layout.show(changePanel, bankAccountStr);
			}
		});
		
	}

}
