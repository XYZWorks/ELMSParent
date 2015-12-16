package ui.financeman.bankAccount;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.ResultMessage;
import blservice.financeblservice.BankAccountBusinessService;

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
		
		//删除时才出现
		confirm.setVisible(false);cancel.setVisible(false);
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
		addPanel = new AddBankAccountPanel(e.element("addPanel"), bl, changePanel , table);
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
				super.mouseClicked(e);
				addPanel.setAddOrModify(true, null);
				layout.show(changePanel, addPanelStr);
			}
		});
		
		confirm.addMouseListener(new MyPictureButtonListener(confirm) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				confirm.setVisible(false);cancel.setVisible(false);
				result = 
				bl.deleteAccount((String) table.getValueAt(table.getSelectedRow(), 0));
				
				if (result == ResultMessage.SUCCESS) {
					new TipsDialog("删除成功" , Color.green);
					table.removeRow(table.getSelectedRow());
				}else{
					new TipsDialog("数据库或网络故障");
				}
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				confirm.setVisible(false);
				cancel.setVisible(false);

			}
		});
		modify.addMouseListener(new MyPictureButtonListener(modify) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(table.getSelectedRow() == -1){
					new TipsDialog("请选择一条数据", Color.GREEN);
					return;
				}
				
				addPanel.setAddOrModify(false, (String) table.getValueAt(table.getSelectedRow(), 0));
				layout.show(changePanel, addPanelStr);
			}

		});
		delete.addMouseListener(new MyPictureButtonListener(delete) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(table.getSelectedRow() == -1){
					new TipsDialog("请选择一条数据", Color.GREEN);
					return;
				}
				new TipsDialog("请确认！");
				confirm.setVisible(true);
				cancel.setVisible(true);
			}

		});
	}

	@Override
	protected void initWhitePanels(Element e) {
	}

}
