package ui.saleman.PayDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
 /** 
 * 付款单增加界面
 * @author czq 
 * @version 2015年12月8日 下午8:30:34 
 */
@SuppressWarnings("serial")
public class PayDocAddPanel extends AddDocPanel {
	
	private MyLabel id;
	private MyDatePicker date;
	private MyLabel YYID;
	private MyLabel money;
	private MyLabel courierName;
	
	private MyTextField idT;
	private MyTextField YYIDT;
	private MyTextField moneyT;
	private MyTextField courierNameT;
	private PayDocMesTable ordersTable;
	
	public PayDocAddPanel(Element config, JPanel changePanel, String checkDocPanelStr, MyTablePanel messageTable) {
		super(config , changePanel , checkDocPanelStr,  messageTable);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initTextFields(Element e) {
		idT = new MyTextField(e.element("id"));
		YYIDT = new MyTextField(e.element("YYID"));
		moneyT = new MyTextField(e.element("money"));
		courierNameT = new MyTextField(e.element("courierName"));

	}

	@Override
	protected void initLabels(Element e) {
		id = new MyPictureLabel(e.element("id"));
		YYID = new MyPictureLabel(e.element("YYID"));
		money = new MyPictureLabel(e.element("money"));
		courierName = new MyPictureLabel(e.element("courierName"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		date = new MyDatePicker(e.element("datepicker"));
		ordersTable = new PayDocMesTable(e.element("table"));
	}

	@Override
	protected void addCompoment() {
		add(YYID);add(YYIDT);add(courierName);add(courierNameT);add(date);add(id);add(idT);
		add(money);add(moneyT); add(ordersTable);

	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {
			
			@Override
			protected void updateMes() {
				// TODO Auto-generated method stub
				
			}
			
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

	}

}
