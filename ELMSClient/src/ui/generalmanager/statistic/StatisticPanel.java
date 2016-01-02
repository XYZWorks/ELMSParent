package ui.generalmanager.statistic;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.financeman.bulidStateForm.BulidStateFormPanel;
import ui.tools.MyCardLayOut;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import vo.finance.PayVO;
import bl.financebl.Deposit;
import blservice.statisticblservice.Statisticblservice;

/**
 * 统计分析，仅有查看功能
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class StatisticPanel extends MyPanel{
	
	private Statisticblservice bl;
	
	private StateFormPanel stateFormPanel;
//	private CostFormPanel costFormPanel;
//	private StateFormDetailPanel detailPanel;
	
//	private MyComboBox chooseType;
	private BulidStateFormPanel detailPanel;
	private final static String detailPanelStr = "BulidStateFromPanel";
	private MyPictureButton detail;
	private JPanel changePanel;
	private MyCardLayOut panelManager;
	
	public StatisticPanel(Element config , Statisticblservice bl , JPanel changePanel) {
		super(config);
		this.bl = bl;
		this.panelManager = (MyCardLayOut) changePanel.getLayout();
		this.changePanel = changePanel;
		
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
		
	}

	@Override
	protected void initButtons(Element e) {
		detail = new MyPictureButton(e.element("detail"));
	}

	@Override
	protected void initTextFields(Element e) {}

	@Override
	protected void initLabels(Element e) {}

	@Override
	protected void initOtherCompoment(Element e) {
		stateFormPanel = new StateFormPanel(e.element("stateFormPanel") , bl);
		detailPanel = new BulidStateFormPanel(e.element(detailPanelStr), bl);
		detailPanel.setAllCompUneditOrUnVisiable();
		detailPanel.addBackButton(changePanel, "StatisticPanel");
//		costFormPanel = new CostFormPanel(e.element("costFormPanel") , bl);
//		chooseType = new MyComboBox(e.element("type"));
//		detailPanel = new StateFormDetailPanel(e.element("detailPanel") );
		
		
	}

	@Override
	protected void addCompoment() {
		add(stateFormPanel);
		changePanel.add(detailPanel, detailPanelStr);
//		add(chooseType);
//		add(costFormPanel);
//		add(detailPanel);
		add(detail);
	}

	@Override
	protected void addListener() {
//		chooseType.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if( ((String)chooseType.getSelectedItem()).equals("经营状况表")){
//					stateFormPanel.setVisible(true);
//					detailPanel.setVisible(false);
//					costFormPanel.setVisible(false);
//					
//					detail.setVisible(true);
//				}else{
//					stateFormPanel.setVisible(false);
//					detailPanel.setVisible(false);
//					costFormPanel.setVisible(true);
//					
//					detail.setVisible(false);
//					
//					
//				}
//				
//				
//			}
//		});
		detail.addMouseListener(new MyPictureButtonListener(detail){
			@Override
			public void mouseClicked(MouseEvent e){
				jumpToDetail();
				
			}
		});
		stateFormPanel.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					jumpToDetail();
				}
			}
		});
		
		
		
	}
	
	void changeToDetailPanel(ArrayList<PayVO> pays , ArrayList<Deposit> deposits){
		
		
	}
	
	private void jumpToDetail(){
		if(stateFormPanel.getSelectedRow() == -1){
			new TipsDialog("您未选择任何一行");
			return;
		}
		detailPanel.setMessage(stateFormPanel.getAForm());
		panelManager.show(changePanel, detailPanelStr);
	}
	
	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

}
