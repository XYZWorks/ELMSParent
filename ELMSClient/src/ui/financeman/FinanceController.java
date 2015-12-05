package ui.financeman;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.tools.MySideBarButton;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MySideBarListener;
import ui.util.PanelController;
import config.StaticMessage;
 /** 
 * 财务管理人员控制器类
 * @author czq 
 * @version 2015年11月26日 下午3:43:05 
 */
public class FinanceController extends PanelController {
	
	private MySideBarButton financeApprovalButton;
	private MySideBarButton bulidBillButton;
	private MySideBarButton bankAccountManageButton;
	private MySideBarButton costManageButton;
	private MySideBarButton bulidStateFormButton;
	private MySideBarButton bulidPayButton;
	
	private MyPanel financeMain;
	
	private MyPanel financeApprovalPanel;
	private MyPanel bulidBillPanel;
	private MyPanel bankAccountManagePanel;
	private MyPanel costManagePanel;
	private MyPanel bulidStateFromPanel;
	private MyPanel bulidPayPanel;
	
	private final String financeMainStr = StaticMessage.MAIN_WINDOW;
	private final String finaceApprovalStr = "FinanceApprovalPanel";
	private final String bulidBillStr = "BulidBillPanel";
	private final String bankAccountStr = "BankAccountManagePanel";
	private final String costManageStr = "CostManagePanel";
	private final String bulidStateFormStr = "BulidStateFromPanel";
	private final String bulidPayStr = "BulidPayPanel";
	
	
	
	
	public FinanceController(MyPanel initialPanel, Element e) {
		super(initialPanel , e);
		initButtons(e.element(CompomentType.BUTTONS.name()));
		initPanel(e);
		addButtons();
		addPanels();
		addToMap();
		addListeners();
		setAllButtonVisable(false);
		changePanel.setVisible(true);
	}

	@Override
	protected void initPanel(Element e) {
		financeMain = new FinanceMain(e.element(financeMainStr) , this);
		financeApprovalPanel = new FinanceApprovalPanel(e.element(finaceApprovalStr));
		bulidBillPanel = new BulidBillPanel(e.element(bulidBillStr));
		bankAccountManagePanel = new BankAccountManagePanel(e.element(bankAccountStr));
		costManagePanel = new CostManagePanel(e.element(costManageStr));
		bulidStateFromPanel = new BulidStateFormPanel(e.element(bulidStateFormStr));
		bulidPayPanel = new BulidPayPanel(e.element(bulidPayStr));
	}

	@Override
	protected void initButtons(Element e) {
		financeApprovalButton = new MySideBarButton(e.element("FinanceApproval"));
		bulidBillButton = new MySideBarButton(e.element("BulidBill"));
		bankAccountManageButton = new MySideBarButton(e.element("BankAccountManage"));
		costManageButton = new MySideBarButton(e.element("CostManage"));
		bulidStateFormButton = new MySideBarButton(e.element("BulidStateForm"));
		bulidPayButton = new MySideBarButton(e.element("BulidPay"));
		
	}

	@Override
	protected void addButtons() {
		mainPanel.add(financeApprovalButton);
		mainPanel.add(bulidBillButton);
		mainPanel.add(bankAccountManageButton);
		mainPanel.add(costManageButton);
		mainPanel.add(bulidStateFormButton);
		mainPanel.add(bulidPayButton);
		
	}

	@Override
	protected void addPanels() {
		changePanel.add(financeMain, financeMainStr);
		changePanel.add(financeApprovalPanel , finaceApprovalStr);
		changePanel.add(bulidBillPanel , bulidBillStr);
		changePanel.add(bankAccountManagePanel , bankAccountStr);
		changePanel.add(costManagePanel , costManageStr);
		changePanel.add(bulidStateFromPanel , bulidStateFormStr);
		changePanel.add(bulidPayPanel , bulidPayStr);
	}

	@Override
	protected void addListeners() {
		financeApprovalButton.addMouseListener(new MySideBarListener(financeApprovalButton, this, finaceApprovalStr));
		bulidBillButton.addMouseListener(new MySideBarListener(bulidBillButton, this, bulidBillStr));
		bankAccountManageButton.addMouseListener(new MySideBarListener(bankAccountManageButton, this, bankAccountStr));
		costManageButton.addMouseListener(new MySideBarListener(costManageButton, this, costManageStr));
		bulidStateFormButton.addMouseListener(new MySideBarListener(bulidStateFormButton, this, bulidStateFormStr));
		bulidPayButton.addMouseListener(new MySideBarListener(bulidPayButton, this, bulidPayStr));
		
		
	}

	@Override
	public void setAllButtonUnClicked() {
		financeApprovalButton.setMyIcon(ButtonState.NORMAL);
		bulidBillButton.setMyIcon(ButtonState.NORMAL);
		bankAccountManageButton.setMyIcon(ButtonState.NORMAL);
		costManageButton.setMyIcon(ButtonState.NORMAL);
		bulidStateFormButton.setMyIcon(ButtonState.NORMAL);
		bulidPayButton.setMyIcon(ButtonState.NORMAL);
		
	}

	@Override
	public void setAllButtonVisable(boolean state) {
		financeApprovalButton.setVisible(state);
		bulidBillButton.setVisible(state);
		bankAccountManageButton.setVisible(state);
		costManageButton.setVisible(state);
		bulidStateFormButton.setVisible(state);
		bulidPayButton.setVisible(state);
	}

	@Override
	protected void addToMap() {
		buttonMap.put(finaceApprovalStr, financeApprovalButton);
		buttonMap.put(bulidBillStr, bulidBillButton);
		buttonMap.put(bankAccountStr, bankAccountManageButton);
		buttonMap.put(costManageStr, costManageButton);
		buttonMap.put(bulidStateFormStr, bulidStateFormButton);
		buttonMap.put(bulidPayStr, bulidPayButton);
		
	}

	@Override
	protected void initialBL() {
		// TODO Auto-generated method stub
		
	}

	

	
}
