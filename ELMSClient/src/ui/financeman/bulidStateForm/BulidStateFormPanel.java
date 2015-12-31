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
import ui.tools.MyPanelWithScroller;
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
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class BulidStateFormPanel extends MyPanelWithScroller {

	private Statisticblservice bl;

	// 标题
	private MyPictureLabel title;
	// 起始时间＋结束日期
	private MyLabel startL;
	private MyDatePicker start;
	private MyDatePicker end;
	private MyLabel endL;
	// 确认＋取消
	private MyPictureButton confirm;
	private MyPictureButton cancel;

	// whitepanel
	private MyWhitePanel addDepositPanel;
	private MyWhitePanel addPayPanel;

	// 付款单 显示
	private MyLabel depositeL;
	private MyPictureLabel depositePic;
	private String depositeT="";
	private double depositeD=0.0;

	// 收款单 显示
	private MyLabel payL;
	private MyPictureLabel payPic;
	private String payT="";
	private double payD=0.0;
	
	//whitepanel内的付款单
	private MyLabel depositeWhiteInfo;
	private DepositeSmallTable depositeSmallTable;
	
	//whitepanel内的收款单
	private MyLabel payWhiteInfo;
	private PaySmallTable paySmallTable;

//	private ArrayList<DepositVO> depositVOs = new ArrayList<>();
//	private ArrayList<FormPayVO> payVOs = new ArrayList<>();

	public BulidStateFormPanel(Element config, Statisticblservice bl) {
		super(config);
		this.bl = bl;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		
	
	}


	@Override
	protected void initWhitePanels(Element e) {
		addDepositPanel = new MyWhitePanel(e.element("Deposit"));
		addPayPanel = new MyWhitePanel(e.element("Pay"));
		
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));

	}

	@Override
	protected void initTextFields(Element e) {

	}

	@Override
	protected void initLabels(Element e) {
		startL = new MyPictureLabel(e.element("start"));
		endL = new MyPictureLabel(e.element("end"));
		title = new MyPictureLabel(e.element("title"));
		
		depositePic=new MyPictureLabel(e.element("depositePic"));
		payPic=new MyPictureLabel(e.element("payPic"));
		depositeL=new MyLabel(e.element("depositeL"));
		payL=new MyLabel(e.element("payL"));
		
		depositeWhiteInfo=new MyLabel(e.element("depositeWhiteInfo"));
		payWhiteInfo=new MyLabel(e.element("payWhiteInfo"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		start = new MyDatePicker(e.element("start"));
		end = new MyDatePicker(e.element("end"));
		depositeSmallTable=new DepositeSmallTable(e.element("depositeSmallTable"));
		paySmallTable=new PaySmallTable(e.element("paySmallTable"));
	}

	@Override
	protected void addCompoment() {
		
		add(start);
		add(startL);
		add(end);
		add(endL);
		add(confirm);
		add(cancel);
		
		add(title);
		add(depositePic);
		add(depositeL);
		add(payPic);
		add(payL);
	
		addDepositPanel.add(depositeWhiteInfo);
		addDepositPanel.add(depositeSmallTable);
		add(addDepositPanel);
		
		addPayPanel.add(payWhiteInfo);
		addPayPanel.add(paySmallTable);
		add(addPayPanel);
		
	}

	
	@Override
	protected void addListener() {
	}
//		confirm.addMouseListener(new ConfirmListener(confirm) {
//			MyDate startDate;
//			MyDate endDate;
//			String income;
//			String outCome;
//
//			@Override
//			protected void updateMes() {
//			}
//
//			@Override
//			protected boolean saveToSQL() {
//				if (isStateForm) {
//					// payVOs.trimToSize();
//					// depositVOs.trimToSize();000
//					System.err.println("1");
//					result = bl.bulidStateForm(new StateFormVO(startDate, endDate, payVOs, depositVOs));
//					System.err.println("2");
//				} else {
//					result = bl.bulidCostIncomeForm(
//							new CostIncomeVO(Integer.parseInt(income), Integer.parseInt(outCome), startDate, endDate));
//				}
//				if (result == ResultMessage.SUCCESS) {
//					new TipsDialog("新增成功", Color.GREEN);
//					return true;
//				} else {
//					new TipsDialog("新增失败");
//					return false;
//				}
//			}
//
//			@Override
//			protected void reInitial() {
//				myInit();
//			}
//
//			@Override
//			protected boolean checkDataValid() {
//				startDate = start.getMyDate();
//				endDate = end.getMyDate();
//				
//		
//			}
//		});
//		cancel.addMouseListener(new CancelListener(cancel) {
//			@Override
//			public void resetMes() {
//				myInit();
//
//			}
//		});
//		addOneDeposit.addMouseListener(new MyPictureButtonListener(addOneDeposit) {
//			private MyDate time;
//			private String money;
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				super.mouseClicked(e);
//				time = DepositDate.getMyDate();
//				money = moneyT.getText();
//				if (UserfulMethod.dealWithData(new SimpleDataFormat(money, DataType.PositiveNum, "金额"))) {
//					depositVOs.add(new DepositVO(time, Integer.parseInt(money)));
//					new TipsDialog("成功增加付款单", Color.GREEN);
//					deposits.setText(depositStr + depositVOs.size());
//
//					moneyT.setText("");
//				}
//			}
//		});
//		addOnePay.addMouseListener(new MyPictureButtonListener(addOnePay) {
//			private MyDate time;
//			private String money;
//			private String type;
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				super.mouseClicked(e);
//				time = PayDate.getMyDate();
//				money = payMoneyT.getText();
//				type = payTypeT.getText();
//				if (UserfulMethod.dealWithData(new SimpleDataFormat(money, DataType.PositiveNum, "金额"))) {
//					payVOs.add(new FormPayVO(time, Integer.parseInt(money), type));
//					new TipsDialog("成功增加成本单", Color.GREEN);
//					pays.setText(payStr + payVOs.size());
//
//					payMoneyT.setText("");
//					payTypeT.setText("");
//				}
//			}
//		});
//	}


}
