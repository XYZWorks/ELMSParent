package ui.financeman.bulidStateForm;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
import ui.tools.MyWhitePanel;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.MyDate;
import util.ResultMessage;
import vo.finance.DepositVO;
import vo.finance.FormPayVO;
import vo.statistic.CostIncomeVO;
import vo.statistic.StateFormVO;
import blservice.statisticblservice.Statisticblservice;

/**
 * 增加成本收益表、经营状况表界面
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class BulidStateFormPanel extends MyPanel{
	
	private Statisticblservice bl;
	private boolean isStateForm = true;
	/*
	 * 共有组件
	 */
	private MyDatePicker start;
	private MyDatePicker end;
	private MyLabel title;//标题
	private MyLabel startL;
	private MyLabel endL;
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	/**
	 * 跳转两个表格
	 */
	private MyPictureButton addCostInComeOrState;
	/*
	 * 以下为经营状况表组件
	 */
	
	
	
	private MyWhitePanel addDepositPanel;
	private MyPictureButton addOneDeposit;
	private MyDatePicker DepositDate;
	private MyLabel depositMoney;
	private MyTextField moneyT;
	
	private MyWhitePanel addPayPanel;
	private MyPictureButton addOnePay;
	private MyDatePicker PayDate;
	private MyLabel payMoney;
	private MyTextField payMoneyT;
	private MyLabel payType;
	private MyTextField payTypeT;
	/*
	 * 显示当前经营状况表中付款单和成本单的数量, 如“付款单数量：3”
	 */
	private MyLabel deposits;
	private MyLabel pays;
	private static final String depositStr = "付款单数量： ";
	private static final String payStr = "成本单数量： ";
	
	
	/*
	 * 以下为成本收益表组件
	 */
	private MyLabel income;
	private MyLabel outCome;
	
	private MyTextField incomeT;
	private MyTextField outComeT;
	
	private ArrayList<DepositVO> depositVOs = new ArrayList<>();
	private ArrayList<FormPayVO> payVOs = new ArrayList<>();
	
	
	
	public BulidStateFormPanel(Element config , Statisticblservice bl) {
		super(config);
		this.bl = bl;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		//----------------------------------------
		myInit();
		changePanel(true);
	}

	@Override
	protected void initButtons(Element e) {
		addCostInComeOrState = new MyPictureButton(e.element("jump"));
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		addOneDeposit = new MyPictureButton(e.element("addOneDeposit"));
		addOnePay = new MyPictureButton(e.element("addOnePay"));
	}

	@Override
	protected void initTextFields(Element e) {
		moneyT = new MyTextField(e.element("moneyT"));
		payMoneyT = new MyTextField(e.element("payMoneyT"));
		payTypeT = new MyTextField(e.element("payTypeT"));
		incomeT = new MyTextField(e.element("incomeT"));
		outComeT = new MyTextField(e.element("outComeT"));
		
	}

	@Override
	protected void initLabels(Element e) {
		startL = new MyPictureLabel(e.element("start"));
		endL = new MyPictureLabel(e.element("end"));
		title = new MyLabel(e.element("title"));
		
		depositMoney = new MyPictureLabel(e.element("depositMoney"));
		payMoney = new MyPictureLabel(e.element("payMoney"));
		payType = new MyPictureLabel(e.element("payType"));
		
		deposits = new MyPictureLabel(e.element("deposits"));
		pays = new MyPictureLabel(e.element("pays"));
		
		income= new MyPictureLabel(e.element("income"));
		outCome= new MyPictureLabel(e.element("outCome"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		start = new MyDatePicker(e.element("start"));
		end = new MyDatePicker(e.element("end"));
		PayDate = new MyDatePicker(e.element("PayDate"));
		DepositDate = new MyDatePicker(e.element("DepositDate"));
		
	}

	@Override
	protected void addCompoment() {
		add(addDepositPanel);
		add(addOneDeposit);
		add(deposits);add(pays);
		add(start);add(startL);add(end);add(endL);add(confirm);add(cancel);add(addCostInComeOrState);
		add(title);
		//以下为经营状况表组件
		add(DepositDate);add(moneyT);add(depositMoney);
		add(addPayPanel);
		add(addOnePay);add(PayDate);add(payMoney);
		add(payMoneyT);add(payType);add(payTypeT);
		//以下为成本收益表组件
		add(income);add(incomeT);
		add(outCome);add(outComeT);
	}
	/**
	 * 转换两个panel，true表示经营状况表
	 * @param flag
	 */
	private void changePanel(boolean flag) {
		isStateForm = flag;
		//------------------------------
		deposits.setVisible(flag);
		pays.setVisible(flag);
		addDepositPanel.setVisible(flag);
		addOneDeposit.setVisible(flag);
		DepositDate.setVisible(flag);
		moneyT.setVisible(flag);
		depositMoney.setVisible(flag);
		addPayPanel.setVisible(flag);
		addOnePay.setVisible(flag);
		PayDate.setVisible(flag);
		payMoney.setVisible(flag);
		payMoneyT.setVisible(flag);
		payType.setVisible(flag);
		payTypeT.setVisible(flag);
		//----------------------------------
		income.setVisible(!flag);
		incomeT.setVisible(!flag);
		outCome.setVisible(!flag);
		outComeT.setVisible(!flag);
		//-----------------------------------
		if(flag){
			title.setText("增加经营状况表");
			addCostInComeOrState.setText("增加成本收益表");
		}else{
			title.setText("增加成本收益表");
			addCostInComeOrState.setText("增加经营状况表");
		}
	}
	
	@Override
	protected void addListener() {
		addCostInComeOrState.addMouseListener(new MyPictureButtonListener(addCostInComeOrState){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				myInit();
				changePanel(!isStateForm);
			}
		});
		confirm.addMouseListener(new ConfirmListener(confirm) {
			MyDate startDate;
			MyDate endDate;
			String income;
			String outCome;
			@Override
			protected void updateMes() {
			}
			@Override
			protected boolean saveToSQL() {
				if(isStateForm){
					payVOs.trimToSize();
					depositVOs.trimToSize();
					result = bl.bulidStateForm(new StateFormVO(startDate, endDate, payVOs, depositVOs));
				}else{
					result = bl.bulidCostIncomeForm(new CostIncomeVO(Integer.parseInt(income), Integer.parseInt(outCome), startDate, endDate));
				}
				if(result == ResultMessage.SUCCESS){
					new TipsDialog("新增成功", Color.GREEN);
					return true;
				}else{
					new TipsDialog("新增失败");
					return false;
				}
			}
			@Override
			protected void reInitial() {
				myInit();
			}
			@Override
			protected boolean checkDataValid() {
				startDate = start.getMyDate();
				endDate = end.getMyDate();
				if(isStateForm){
					return true;
				}else{
					income = incomeT.getText();
					outCome = outComeT.getText();
					SimpleDataFormat[] datas = {new SimpleDataFormat(income, DataType.PositiveNum, "收入") , new SimpleDataFormat(outCome, DataType.PositiveNum, "支出")};
					return UserfulMethod.dealWithData(datas);
				}
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			@Override
			public void resetMes() {
				myInit();
				
			}
		});
		addOneDeposit.addMouseListener(new MyPictureButtonListener(addOneDeposit){
			private MyDate time;
			private String money;
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				time = DepositDate.getMyDate();
				money = moneyT.getText();
				if(UserfulMethod.dealWithData(new SimpleDataFormat(money, DataType.PositiveNum, "金额"))){
					depositVOs.add(new DepositVO(time, Integer.parseInt(money)));
					new TipsDialog("成功增加付款单", Color.GREEN);
					deposits.setText(depositStr + depositVOs.size());
					
					moneyT.setText("");
				}
			}
		});
		addOnePay.addMouseListener(new MyPictureButtonListener(addOnePay){
			private MyDate time;
			private String money;
			private String type;
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				time = PayDate.getMyDate();
				money = payMoneyT.getText();
				type = payTypeT.getText();
				if(UserfulMethod.dealWithData(new SimpleDataFormat(money, DataType.PositiveNum, "金额"))){
					payVOs.add(new FormPayVO(time, Integer.parseInt(money), type));
					new TipsDialog("成功增加成本单", Color.GREEN);
					pays.setText(payStr + payVOs.size());
					
					payMoneyT.setText("");payTypeT.setText("");
				}
			}
		});
	}
	
	private void myInit(){
		moneyT.setText("");payMoneyT.setText("");payTypeT.setText("");incomeT.setText("");outComeT.setText("");
		deposits.setText("付款单数量：0");pays.setText("收款单数量：0");
		
		depositVOs.clear();payVOs.clear();
	}
	
	@Override
	protected void initWhitePanels(Element e) {
		addDepositPanel = new MyWhitePanel(e.element("Deposit"));
		addPayPanel = new MyWhitePanel(e.element("Pay"));
		
	}

}
