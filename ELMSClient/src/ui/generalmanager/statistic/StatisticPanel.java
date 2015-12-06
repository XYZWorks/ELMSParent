package ui.generalmanager.statistic;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.dom4j.Element;

import bl.financebl.Deposit;
import blservice.statisticblservice.Statisticblservice;
import ui.tools.MyComboBox;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import vo.finance.PayVO;

/**
 * 统计分析，仅有查看功能
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class StatisticPanel extends MyPanel{
	
	private Statisticblservice bl;
	
	private StateFormPanel stateFormPanel;
	private CostFormPanel costFormPanel;
	private StateFormDetailPanel detailPanel;
	
	private MyComboBox chooseType;
	
	private MyPictureButton detail;
	private MyPictureButton back;
	
	
	public StatisticPanel(Element config , Statisticblservice bl) {
		super(config);
		this.bl = bl;
		initLables(config.element(CompomentType.LABELS.name()));
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
		back = new MyPictureButton(e.element("back"));
	}

	@Override
	protected void initTextFields(Element e) {}

	@Override
	protected void initLables(Element e) {}

	@Override
	protected void initOtherCompoment(Element e) {
		stateFormPanel = new StateFormPanel(e.element("stateFormPanel") , bl);
		costFormPanel = new CostFormPanel(e.element("costFormPanel") , bl);
		chooseType = new MyComboBox(e.element("type"));
		detailPanel = new StateFormDetailPanel(e.element("detailPanel") );
		
		
	}

	@Override
	protected void addCompoment() {
		add(stateFormPanel);
		add(chooseType);
		add(costFormPanel);
		add(detailPanel);
		add(back);
		add(detail);
	}

	@Override
	protected void addListener() {
		chooseType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		detail.addMouseListener(new MyPictureButtonListener(detail){
			@Override
			public void mouseClicked(MouseEvent e){
				
			}
		});
		back.addMouseListener(new MyPictureButtonListener(back){
			@Override
			public void mouseClicked(MouseEvent e){
				
			}
		});
	}
	
	void changeToDetailPanel(ArrayList<PayVO> pays , ArrayList<Deposit> deposits){
		
		
	}
	

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

}
