package ui.financeman.costManage;

import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.MyPictureButtonListener;
import util.CostType;
import blservice.financeblservice.CostService;

/**
 * 成本管理
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class CostManagePanel extends MyPanel {
	JPanel changePanel;
	CardLayout panelManager;
	CostService costService;
	final static String addCostPanelStr = "addCostPanel";
	final static String costManageStr = "CostManagePanel";

	private CostAddPanel addCostPanel;
	private CostMesTable freightTable;
	private CostMesTable rentTable;
	private CostMesTable salaryTable;
	// 成本信息管理标题
	private MyLabel title;

	private CostType nowType = CostType.SALARY;

	private MyComboBox costType;
	private MyPictureButton add;
	private MyPictureButton delete;
	private MyPictureButton modify;
	private MyPictureButton confirm;
	private MyPictureButton cancel;

	public CostManagePanel(Element config, CostService costService,
			JPanel changePanel, String costManageStr) {
		super(config);
		this.costService = costService;
		this.changePanel = changePanel;
		this.panelManager = (CardLayout) changePanel.getLayout();
		// TODO Auto-generated constructor stub
		
		
		myInit();
	}

	private void myInit() {
		showTable(CostType.SALARY);
		panelManager.show(changePanel, costManageStr);
	}

	@Override
	protected void initButtons(Element e) {

		add = new MyPictureButton(e.element("add"));
		delete = new MyPictureButton(e.element("delete"));
		modify = new MyPictureButton(e.element("modify"));
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
	}

	@Override
	protected void initTextFields(Element e) {
	}

	@Override
	protected void initLabels(Element e) {
		title = new MyLabel(e.element("title"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		costType = new MyComboBox(e.element("costType"));
		addCostPanel = new CostAddPanel(e.element(addCostPanelStr), costService,
				changePanel);
		freightTable = new CostMesTable(e.element("table"),
				CostType.FREIGHT, costService);
		rentTable = new CostMesTable(e.element("table"), CostType.RENT,
				costService);
		salaryTable = new CostMesTable(e.element("table"),
				CostType.SALARY, costService);
	}

	@Override
	protected void addCompoment() {
		add(add);
		add(costType);
		add(confirm);
		add(cancel);
		add(modify);
		add(delete);
		add(title);

		add(freightTable);
		add(rentTable);
		add(salaryTable);
		changePanel.add(addCostPanel, addCostPanelStr);

	}

	@Override
	protected void addListener() {
		add.addMouseListener(new MyPictureButtonListener(add) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
		});
		modify.addMouseListener(new MyPictureButtonListener(modify) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
		});
		delete.addMouseListener(new MyPictureButtonListener(delete) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
		});
		confirm.addMouseListener(new MyPictureButtonListener(confirm) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
		});
		cancel.addMouseListener(new MyPictureButtonListener(confirm) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
		});
		costType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				nowType = CostType.toCostType((String) costType
						.getSelectedItem());
				showTable(nowType);
			}
		});
	}

	private void showTable(CostType type) {
		switch (type) {
		case FREIGHT:
			freightTable.setVisible(true);
			rentTable.setVisible(false);
			salaryTable.setVisible(false);
			break;
		case RENT:
			freightTable.setVisible(false);
			rentTable.setVisible(true);
			salaryTable.setVisible(false);
			break;
		case SALARY:
			freightTable.setVisible(false);
			rentTable.setVisible(false);
			salaryTable.setVisible(true);
			break;

		default:
			break;
		}
	}

	@Override
	protected void initWhitePanels(Element e) {
	}

}
