package ui.financeman.bulidStateForm;

import java.awt.Color;
import java.awt.Font;
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
import vo.finance.PayVO;
import vo.statistic.CostIncomeVO;
import vo.statistic.StateFormVO;
import vo.transport.PayDocVO;
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
	private MyPictureButton check;
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
		check = new MyPictureButton(e.element("check"));
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
		depositeL.setFont(new Font("微软雅黑", Font.BOLD, 25));
		payL=new MyLabel(e.element("payL"));
		payL.setFont(new Font("微软雅黑", Font.BOLD, 25));
		
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
		add(check);
		
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
		check.addMouseListener(new MyPictureButtonListener(check){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				MyDate startDate = start.getMyDate();
				MyDate endDate = end.getMyDate();
				
				ArrayList<PayVO> payVOs = bl.getDatePays(startDate, endDate);
				ArrayList<PayDocVO> payDocVOs = bl.getDatePayDocs(startDate, endDate);
				
				depositeL.setText(String.valueOf(depositeSmallTable.setMessage(payVOs)));;
				payL.setText(String.valueOf(paySmallTable.setMessage(payDocVOs)));
				
				
				
				
			}
		});
		
		
	}



}
