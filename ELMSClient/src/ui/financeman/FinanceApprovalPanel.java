package ui.financeman;

import org.dom4j.Element;

import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;

/**
 * 财务人员的交易审核界面
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class FinanceApprovalPanel extends MyPanel{
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	
	private MyPictureLabel time;
	private MyPictureLabel person;
	private MyPictureLabel money;
	private MyPictureLabel company;
	
	private MyDatePicker datePicker;
	private MyTextField name;
	private MyTextField moneyT;
	private MyTextField companyT;
	
	public FinanceApprovalPanel(Element config) {
		super(config);
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		
	}

	@Override
	protected void initTextFields(Element e) {
		name = new MyTextField(e.element("name"));
		moneyT = new MyTextField(e.element("money"));
		companyT = new MyTextField(e.element("company"));
		
	}

	@Override
	protected void initLabels(Element e) {
		time = new MyPictureLabel(e.element("time"));
		person = new MyPictureLabel(e.element("person"));
		money = new MyPictureLabel(e.element("money"));
		company = new MyPictureLabel(e.element("company"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		datePicker = new MyDatePicker(e.element("date"));
		
	}

	@Override
	protected void addCompoment() {
		add(time);
		add(datePicker);
		add(companyT);
		add(company);
		add(cancel);
		add(confirm);
		add(person);
		add(name);
		add(money);
		add(moneyT);
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

			@Override
			protected void updateMes() {
				// TODO Auto-generated method stub
				
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			
			@Override
			public void resetMes() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	protected void initWhitePanels(Element e) {}

}
