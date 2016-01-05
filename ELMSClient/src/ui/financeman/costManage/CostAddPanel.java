package ui.financeman.costManage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import blservice.financeblservice.CostService;
import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyCardLayOut;
import ui.tools.MyComboBox;
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
import util.CostType;
import util.MyDate;
import util.ResultMessage;
import util.StaffType;
import vo.finance.CostVO;
import vo.finance.FreightVO;
import vo.finance.RentVO;
import vo.finance.SalaryVO;

/**
 * 成本信息增加界面
 * 
 * @author czq
 * @version 2015年12月18日 下午8:58:45
 */
@SuppressWarnings("serial")
public class CostAddPanel extends MyPanel {

	private CostService costService;
	private JPanel changePanel;
	private MyCardLayOut panelManager;
	private CostManagePanel costManagePanel;
	private boolean modifyState = false;

	/*
	 * 以下为共有组件
	 */

	private MyWhitePanel whitePanel1;
	private MyWhitePanel whitePanel2;

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

	public CostAddPanel(Element config, CostService costService, JPanel changePanel, CostManagePanel costManagePanel) {
		super(config);
		this.changePanel = changePanel;
		this.panelManager = (MyCardLayOut) changePanel.getLayout();
		this.costService = costService;
		this.costManagePanel = costManagePanel;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		costTypeB.setSelectedIndex(0);
	}

	@Override
	protected void initWhitePanels(Element e) {
		whitePanel1 = new MyWhitePanel(e.element("whitePanel1"));
		whitePanel2 = new MyWhitePanel(e.element("whitePanel2"));
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
		title = new MyPictureLabel(e.element("title"));
		idL = new MyLabel(e.element("id"));
		startDateL = new MyLabel(e.element("startDate"));
		endDateL = new MyLabel(e.element("endDate"));
		moneyL = new MyLabel(e.element("money"));
		costTypeL = new MyLabel(e.element("costType"));
		staffTypeL = new MyLabel(e.element("staffType"));

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
		add(title);
		 
		whitePanel1.add(startDate);
		whitePanel1.add(startDateL);
		whitePanel1.add(endDate);
		whitePanel1.add(endDateL);
		whitePanel1.add(costTypeB);
		whitePanel1.add(costTypeL);
		whitePanel1.add(staffTypeB);
		whitePanel1.add(staffTypeL);
		
		whitePanel2.add(idL);
		whitePanel2.add(idT);
		whitePanel2.add(moneyL);
		whitePanel2.add(moneyT);

		add(whitePanel1);
		add(whitePanel2);
		add(back);
		add(cancel);
		add(confirm);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {
			private String id;
			private CostType type;
			private MyDate start;
			private MyDate end;
			private String money;
			private StaffType staffType;
			CostVO vo;

			@Override
			protected void updateMes() {
				if (modifyState) {
					if (type == CostType.FREIGHT) {
						costManagePanel.freightTable.myInit();
					} else if (type == CostType.RENT) {
						costManagePanel.rentTable.myInit();
					} else {
						costManagePanel.salaryTable.myInit();
					}
				} else {
					if (type == CostType.FREIGHT) {
						costManagePanel.freightTable.addOneData(vo, 1);
					} else if (type == CostType.RENT) {
						costManagePanel.rentTable.addOneData(vo, 1);
					} else {
						costManagePanel.salaryTable.addOneData(vo, 1);
					}
				}
			}

			@Override
			protected boolean saveToSQL() {
				if (modifyState) {
					if (type == CostType.FREIGHT) {
						result = costService.modify(vo = new FreightVO(id, start, end, Integer.parseInt(money), type));
					} else if (type == CostType.RENT) {
						result = costService.modify(vo = new RentVO(id, start, end, Integer.parseInt(money), type));
					} else {
						result = costService
								.modify(vo = new SalaryVO(id, start, end, Integer.parseInt(money), type, staffType));
					}
				} else {
					if (type == CostType.FREIGHT) {
						result = costService.add(vo = new FreightVO(id, start, end, Integer.parseInt(money), type));
					} else if (type == CostType.RENT) {
						result = costService.add(vo = new RentVO(id, start, end, Integer.parseInt(money), type));
					} else {
						result = costService
								.add(vo = new SalaryVO(id, start, end, Integer.parseInt(money), type, staffType));
					}
				}

				if (result == ResultMessage.SUCCESS) {
					new TipsDialog("成功增加/修改一条成本信息", Color.GREEN);
					return true;
				} else {
					new TipsDialog("未成功增加一条信息");
					System.err.println(result);
					return false;
				}
			}

			@Override
			protected void reInitial() {
				myInit();
			}

			@Override
			protected boolean checkDataValid() {
				id = idT.getText();
				money = moneyT.getText();
				start = startDate.getMyDate();
				end = endDate.getMyDate();
				type = CostType.toCostType((String) costTypeB.getSelectedItem());
				staffType = StaffType.getType((String) staffTypeB.getSelectedItem());
				SimpleDataFormat[] datas = { new SimpleDataFormat(id, DataType.ID, "ID"),
						new SimpleDataFormat(money, DataType.PositiveNum, "金额") };
				return UserfulMethod.dealWithData(datas);
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			@Override
			public void resetMes() {
				myInit();
			}
		});
		back.addMouseListener(new MyPictureButtonListener(back) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				panelManager.show(changePanel, "CostManagePanel");
				myInit();
			}
		});
	}

	private void myInit() {
		idT.setText("");
		moneyT.setText("");
		costTypeB.setSelectedIndex(0);
		staffTypeB.setSelectedIndex(0);
	}

	/**
	 * 修改状态时
	 * 
	 * @param modifyState
	 * @param ID
	 * @param string
	 */
	void setModifyState(boolean modifyState, String ID, String type) {
		this.modifyState = modifyState;
		if (modifyState) {
			idT.setText(ID);
			costTypeB.setSelectedItem(type);
		}
		idT.setEditable(!modifyState);
		costTypeB.setEditable(!modifyState);
	}

}
