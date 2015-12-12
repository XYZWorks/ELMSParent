package ui.financeman.bankAccount;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

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
	private MyPictureButton add;
	
	private MyLabel title;
	private MyLabel deleteL;
	private MyLabel modifyL;
	private MyLabel addL;
	

	
	private AddBankAccountPanel addPanel;
	private final static String addPanelStr = "addPanel";
	
	private JPanel changePanel;
	private CardLayout layout;

	public BankAccountManagePanel(Element config, BankAccountBusinessService bl , JPanel changePanel) {
		super(config);
		this.bl = bl;
		this.changePanel =changePanel;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		
		changePanel.add(addPanel, addPanelStr);
		layout = (CardLayout) changePanel.getLayout();
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		delete = new MyPictureButton(e.element("delete"));
		modify = new MyPictureButton(e.element("modify"));
		add = new MyPictureButton(e.element("add"));
	}

	@Override
	protected void initTextFields(Element e) {
	
	}

	@Override
	protected void initLabels(Element e) {
		deleteL = new MyLabel(e.element("deleteL"));
		modifyL = new MyLabel(e.element("modifyL"));
		addL = new MyLabel(e.element("addL"));
		title = new MyLabel(e.element("title"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		table = new BankAccountTable(e.element("table") , bl);
		addPanel = new AddBankAccountPanel(e.element("addPanel"), bl, changePanel);
	}

	@Override
	protected void addCompoment() {
		add(cancel);
		add(confirm);
		add(delete);
		add(modify);
		add(table);
		add(add);
		add(addPanel);
		add(deleteL);
		add(modifyL);
		add(addL);
		add(title);
	}

	@Override
	protected void addListener() {
		add.addMouseListener(new MyPictureButtonListener(add){
			@Override
			public void mouseClicked(MouseEvent e) {
				layout.show(changePanel, addPanelStr);
			}
		});
		
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
