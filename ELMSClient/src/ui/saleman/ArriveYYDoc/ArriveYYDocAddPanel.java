package ui.saleman.ArriveYYDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.saleman.LoadDoc.LoadDocOrders;
import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
/**
 * 接收单界面
 */
/**
 * 接收单增加界面
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class ArriveYYDocAddPanel extends AddDocPanel{
	
	private MyLabel id;
	private MyDatePicker date;
	private MyLabel ZZID;
	private MyLabel sendCity;
	private MyLabel goodState;
	private MyLabel newOrder;
	
	private MyTextField idT;
	private MyTextField ZZIDT;
	private MyComboBox sendCityB;;
	private MyComboBox goodStateB;
	

	private MyPictureButton addOneOrder;
	/**
	 * 装车单上放置的订单号表
	 */
	private LoadDocOrders ordersTable;
	
	public  ArriveYYDocAddPanel(Element config , JPanel changePanel, String checkDocPanelStr, MyTablePanel messageTable) {
		super(config , changePanel , checkDocPanelStr,  messageTable);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initButtons(Element e) {
		addOneOrder = new MyPictureButton(e.element("addOrder"));
		
	}

	@Override
	protected void initTextFields(Element e) {
		idT = new MyTextField(e.element("id"));
		ZZIDT = new MyTextField(e.element("ZZID"));
		
	}

	@Override
	protected void initLabels(Element e) {
		id = new MyPictureLabel(e.element("id"));
		ZZID = new MyPictureLabel(e.element("ZZID"));
		sendCity = new MyPictureLabel(e.element("sendCity"));
		goodState = new MyPictureLabel(e.element("goodState"));
		newOrder = new MyPictureLabel(e.element("order"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		date = new MyDatePicker(e.element("datepicker"));
		sendCityB = new MyComboBox(e.element("sendCity"));
		ordersTable = new LoadDocOrders(e.element("table"));
		goodStateB = new MyComboBox(e.element("goodState"));
	}

	@Override
	protected void addCompoment() {
		add(ZZID);add(ZZIDT);add(sendCity);add(sendCityB);add(goodState);add(date);add(id);add(idT);
		add(newOrder);add(addOneOrder);add(ordersTable);add(goodStateB);
	
		
	}

	@Override
	protected void addListener() {
			confirm.addMouseListener(new ConfirmListener(confirm) {
			
			@Override
			protected void saveToSQL() {
				// TODO Auto-generated method stub
				
				//增加一条信息
//				messageTable.addOneRow(data);
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
		
	}


