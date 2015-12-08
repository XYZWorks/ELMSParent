package ui.financeman.bulidPay;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import blservice.financeblservice.PayService;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;

/**
 * 新建付款单
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class BulidPayPanel extends MyPanel {

	private PayService payService;

	private MyPictureButton confirm;
	private MyPictureButton cancel;
	private MyPictureButton addPay;
	private MyPictureButton back;

	private PayTable table;

	private MyLabel time;
	private MyLabel type;
	private MyLabel money;

	private MyDatePicker datePicker;
	private MyComboBox typeT;
	private MyTextField moneyT;

	public BulidPayPanel(Element config, PayService payService) {
		super(config);
		this.payService = payService;
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
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		addPay = new MyPictureButton(e.element("add"));
		back = new MyPictureButton(e.element("back"));
	}

	@Override
	protected void initTextFields(Element e) {

		moneyT = new MyTextField(e.element("money"));

	}

	@Override
	protected void initLabels(Element e) {
		money = new MyPictureLabel(e.element("money"));
		type = new MyPictureLabel(e.element("password"));
		time = new MyPictureLabel(e.element("time"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		typeT = new MyComboBox(e.element("type"));
		datePicker = new MyDatePicker(e.element("datepicker"));
		table = new PayTable(e.element("table") , payService);
	}

	@Override
	protected void addCompoment() {
		add(datePicker);
		add(addPay);
		add(back);
		add(cancel);
		add(confirm);
		add(money);
		add(moneyT);
		add(table);
		add(time);
		add(type);
		add(typeT);

	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {
			
			@Override
			protected void saveToSQL() {
				// TODO Auto-generated method stub
				
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
		addPay.addMouseListener(new MyPictureButtonListener(addPay){
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

}
