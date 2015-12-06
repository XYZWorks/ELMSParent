package ui.financeman;

import java.awt.Color;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyMainPanelButtonListener;
import ui.util.PanelController;

/**
*财务人员主界面
*@author:xingcheng
*@version 2015年11月26日
*/
@SuppressWarnings("serial")
public class FinanceMain extends MyPanel{
	
	private MyPictureButton financeApprovalButton;
	private MyPictureButton bulidBillButton;
	private MyPictureButton bankAccountManageButton;
	private MyPictureButton costManageButton;
	private MyPictureButton bulidStateFormButton;
	private MyPictureButton bulidPayButton;
	
	private PanelController controller;
	
	public FinanceMain(Element config , PanelController controller) {
		super(config);
		this.controller = controller;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLables(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		setBackground(new Color(241, 241, 241));
		setVisible(true);
	}

	@Override
	protected void initButtons(Element e) {
		financeApprovalButton = new MyPictureButton(e.element("FinanceApproval"));
		bulidBillButton = new MyPictureButton(e.element("BulidBill"));
		bankAccountManageButton = new MyPictureButton(e.element("BankAccountManage"));
		costManageButton = new MyPictureButton(e.element("CostManage"));
		bulidStateFormButton = new MyPictureButton(e.element("BulidStateForm"));
		bulidPayButton = new MyPictureButton(e.element("BulidPay"));
		
	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLables(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addCompoment() {
		this.add(financeApprovalButton);
		this.add(bulidBillButton);
		this.add(bankAccountManageButton);
		this.add(costManageButton);
		this.add(bulidStateFormButton);
		this.add(bulidPayButton);
		
	}

	@Override
	protected void addListener() {
		financeApprovalButton.addMouseListener(new MyMainPanelButtonListener(financeApprovalButton, "FinanceApprovalPanel", controller));
		bulidBillButton.addMouseListener(new MyMainPanelButtonListener(bulidBillButton, "BulidBillPanel", controller));
		bankAccountManageButton.addMouseListener(new MyMainPanelButtonListener(bankAccountManageButton, "BankAccountManagePanel", controller));
		costManageButton.addMouseListener(new MyMainPanelButtonListener(costManageButton, "CostManagePanel", controller));
		bulidStateFormButton.addMouseListener(new MyMainPanelButtonListener(bulidStateFormButton, "BulidStateFromPanel", controller));
		bulidPayButton.addMouseListener(new MyMainPanelButtonListener(bulidPayButton, "BulidPayPanel", controller));
		
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

}
