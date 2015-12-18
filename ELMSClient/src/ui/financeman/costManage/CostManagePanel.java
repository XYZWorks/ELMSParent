package ui.financeman.costManage;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

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
public class CostManagePanel extends MyPanel{
	
	private CostService costService;
	private CostAddPanel addFreightPanel;
	private CostAddPanel addSalaryPanel;
	private CostAddPanel addRentPanel;
	private CostMesTable freightTable;
	private CostMesTable rentTable;
	private CostMesTable salaryTable;
	//成本信息管理标题
	private MyLabel title;
	
	private MyComboBox costType;
	private MyPictureButton add;
	private MyPictureButton delete;
	private MyPictureButton modify;
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	
	public CostManagePanel(Element config , CostService costService) {
		super(config);
		this.costService = costService;
		// TODO Auto-generated constructor stub
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
		addFreightPanel = new CostAddPanel(e.element("addFreightPanel"), CostType.FREIGHT);
		addRentPanel = new CostAddPanel(e.element(""), CostType.RENT);
		addSalaryPanel = new CostAddPanel(e.element(""), CostType.SALARY);
		freightTable = new CostMesTable(e.element("") , CostType.FREIGHT);
		rentTable = new CostMesTable(e.element(""), CostType.RENT);
		salaryTable = new CostMesTable(e.element(""), CostType.SALARY);
	}

	@Override
	protected void addCompoment() {
		add(add);add(costType);add(confirm);add(cancel);
		add(modify);add(delete);add(title);
		
		add(addFreightPanel);add(addRentPanel);add(addSalaryPanel);
		add(freightTable);add(rentTable);add(salaryTable);
		
	}

	@Override
	protected void addListener() {
		add.addMouseListener(new MyPictureButtonListener(add){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
		});
		modify.addMouseListener(new MyPictureButtonListener(modify){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
		});
		delete.addMouseListener(new MyPictureButtonListener(delete){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
		});
		confirm.addMouseListener(new MyPictureButtonListener(confirm){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
		});
		cancel.addMouseListener(new MyPictureButtonListener(confirm){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
		});
		costType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
			}
		});
	}

	@Override
	protected void initWhitePanels(Element e) {
	}

}
