package ui.financeman.bulidStateForm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPanelWithScroller;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyWhitePanel;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.DocPanelForApproval;
import ui.util.MyBackListener;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.MyDate;
import util.ResultMessage;
import vo.finance.PayVO;
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
public class BulidStateFormPanel extends MyPanelWithScroller implements DocPanelForApproval{

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
	private MyLabel depositeText;


	// 收款单 显示
	private MyLabel payL;
	private MyPictureLabel payPic;
	private MyLabel payText;

	
	//whitepanel内的付款单
	private MyLabel depositeWhiteInfo;
	private DepositeSmallTable depositeSmallTable;
	
	//whitepanel内的收款单
	private MyLabel payWhiteInfo;
	private PaySmallTable paySmallTable;

	private MyDate startDate;
	private MyDate endDate;
	private ArrayList<PayDocVO> payDocVOs = new ArrayList<>();
	private ArrayList<PayVO> payVOs = new ArrayList<>();

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
		depositeText=new MyLabel(e.element("depositeText"));
		payText=new MyLabel(e.element("payText"));
		
		
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
		
		add(depositeText);
		add(depositePic);
		add(depositeL);
		
		add(payL);
		add(payText);
		add(payPic);
	
		
		
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
				startDate = start.getMyDate();
				endDate = end.getMyDate();
				
				payVOs = bl.getDatePays(startDate, endDate);
				payDocVOs = bl.getDatePayDocs(startDate, endDate);
				
				//统一绘制cost的格式
				depositeText.setForeground(new Color(255, 138, 0));
				payText.setForeground(new Color(255, 138, 0));
				
				depositeText.setText(String.valueOf(depositeSmallTable.setMessage(payVOs)));;
				payText.setText(String.valueOf(paySmallTable.setMessage(payDocVOs)));
				
				
				
				new TipsDialog("已生成该阶段的收款单和付款单，请确认", Color.GREEN);
			}
		});
		confirm.addMouseListener(new ConfirmListener(confirm) {
			@Override
			protected void updateMes() {
				
			}
			
			@Override
			protected boolean saveToSQL() {
				result = bl.bulidStateForm(new StateFormVO(startDate, endDate, payVOs, payDocVOs));
				if(result == ResultMessage.SUCCESS){
					new TipsDialog("成功增加经营状况表" , Color.GREEN);
					return true;
				}else {
					new TipsDialog("未成功增加经营状况表");
					return false;
				}
			}
			
			@Override
			protected void reInitial() {
				myinit();
			}
			
			@Override
			protected boolean checkDataValid() {
				return true;
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			
			@Override
			public void resetMes() {
				myinit();
				
			}
		});
		
	}
	private void myinit(){
//		depositeL.setText(String.valueOf(depositeD));
//		payL.setText(String.valueOf(payD));
		depositeSmallTable.removeAllRows();
		paySmallTable.removeAllRows();
	}

	@Override
	public void setAllCompUneditOrUnVisiable() {
		check.setVisible(false);
		confirm.setVisible(false);
		cancel.setVisible(false);
	}


	@Override
	public void addBackButton(JPanel changePanel, String backStr) {
		MyPictureButton back = new MyPictureButton();
		back.addMouseListener(new MyBackListener(back, changePanel, backStr));
		add(back);
	}


	@Override
	public void setMessage(Object vo) {
		if(vo == null){
			return;
		}
		StateFormVO myVo = (StateFormVO) vo;
		
		ArrayList<PayVO> payVOs = myVo.pays;
		ArrayList<PayDocVO> payDocVOs = myVo.deposits;
		
		depositeL.setText(String.valueOf(depositeSmallTable.setMessage(payVOs)));;
		payL.setText(String.valueOf(paySmallTable.setMessage(payDocVOs)));
	}



}
