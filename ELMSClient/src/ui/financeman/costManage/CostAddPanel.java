package ui.financeman.costManage;

import java.awt.CardLayout;

import javax.swing.JPanel;

import org.dom4j.Element;

import blservice.financeblservice.CostService;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
import util.CostType;
import util.MyDate;
 /** 
 * 成本信息增加界面
 * @author czq 
 * @version 2015年12月18日 下午8:58:45 
 */
@SuppressWarnings("serial")
public class CostAddPanel extends MyPanel {
	
	private CostType type;
	private CostService costService;
	private JPanel changePanel;
	private CardLayout panelManager;
	
	/*
	 * 以下为共有组件
	 */
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	private MyPictureButton back;
	private MyLabel title;
	
	private MyLabel idL;
	private MyLabel startDateL;
	private MyLabel endDateL;
	private MyLabel costTypeL;
	private MyLabel moneyL;
	
	private MyTextField idT;
	private MyDatePicker startDate;
	private MyDatePicker endDate;
	private MyComboBox costTypeB;
	private MyTextField moneyT;
	/*
	 * 人员工资特有组件
	 */
	private MyLabel staffTypeL;
	private MyComboBox staffTypeB;
	
	
	
	public CostAddPanel(Element config , CostService costService, JPanel changePanel) {
		super(config);
		this.changePanel = changePanel;
		this.panelManager = (CardLayout) changePanel.getLayout();
		this.costService = costService;
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initWhitePanels(Element e) {
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		back = new MyPictureButton(e.element("back"));

	}

	@Override
	protected void initTextFields(Element e) {
		idT = new MyTextField(e.element("id"));
		moneyT = new MyTextField(e.element("money"));

	}

	@Override
	protected void initLabels(Element e) {
		title = new MyLabel(e.element("title"));
		idL = new MyPictureLabel(e.element("id"));
		startDateL = new MyPictureLabel(e.element("startDate"));
		endDateL = new MyPictureLabel(e.element("endDate"));
		moneyL = new MyPictureLabel(e.element("money"));
		costTypeL = new MyPictureLabel(e.element("costType"));
		staffTypeL= new MyPictureLabel(e.element("staffType"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		startDate = new MyDatePicker(e.element("startDate"));
		endDate = new MyDatePicker(e.element("endDate"));
		costTypeB = new MyComboBox(e.element("costType"));
		staffTypeB = new MyComboBox(e.element("staffType"));
	}

	@Override
	protected void addCompoment() {
		add(back);add(cancel);add(confirm);add(title);
		add(idL);add(idT);add(startDate);add(startDateL);add(endDate);add(endDateL);
		add(costTypeB);add(costTypeL);add(moneyL);add(moneyT);
		
		add(staffTypeB);add(staffTypeL);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {
			
			@Override
			protected void updateMes() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected boolean saveToSQL() {
				// TODO Auto-generated method stub
				return false;
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
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			
			@Override
			public void resetMes() {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
