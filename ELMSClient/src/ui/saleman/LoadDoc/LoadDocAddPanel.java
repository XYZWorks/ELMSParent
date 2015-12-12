package ui.saleman.LoadDoc;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

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
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
 /** 
 * 装车单增加界面
 * @author czq 
 * @version 2015年12月8日 下午8:27:23 
 */
@SuppressWarnings("serial")
public class LoadDocAddPanel extends AddDocPanel{
	
	
	
	private MyLabel id;
	private MyDatePicker date;
	private MyLabel YYID;
	private MyLabel loadDocID;
	private MyLabel arriveCity;
	private MyLabel carID;
	private MyLabel supervisor;
	private MyLabel escort;
	private MyLabel newOrder;
	
	private MyTextField idT;
	private MyTextField YYIDT;
	private MyTextField loadDocT;
	private MyComboBox arriveCityB;;
	private MyTextField supervisorT;
	private MyTextField carT;
	private MyTextField escortT;
	private MyTextField orderCode;
	
	private MyPictureButton addOneOrder;
	/**
	 * 装车单上放置的订单号表
	 */
	private LoadDocOrders ordersTable;
	
	public LoadDocAddPanel(Element config, JPanel changePanel, String checkDocPanelStr, MyTablePanel messageTable) {
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
		YYIDT = new MyTextField(e.element("YYID"));
		loadDocT = new MyTextField(e.element("loadDoc"));
		carT = new MyTextField(e.element("car"));
		supervisorT = new MyTextField(e.element("supervisor"));
		escortT= new MyTextField(e.element("escort"));
		orderCode = new MyTextField(e.element("order"));
	}

	@Override
	protected void initLabels(Element e) {
		id = new MyPictureLabel(e.element("id"));
		YYID = new MyPictureLabel(e.element("YYID"));
		loadDocID = new MyPictureLabel(e.element("loadDoc"));
		arriveCity = new MyPictureLabel(e.element("arriveCity"));
		carID = new MyPictureLabel(e.element("carID"));
		supervisor = new MyPictureLabel(e.element("supervisor"));
		escort = new MyPictureLabel(e.element("escort"));
		newOrder = new MyPictureLabel(e.element("order"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		date = new MyDatePicker(e.element("datepicker"));
		arriveCityB = new MyComboBox(e.element("arrive"));
		ordersTable = new LoadDocOrders(e.element("table"));
	}

	@Override
	protected void addCompoment() {
		add(YYID);add(YYIDT);add(arriveCity);add(arriveCityB);add(carID);add(carT);add(date);add(escort);add(escortT);add(id);add(idT);
		add(loadDocID);add(loadDocT);add(supervisor);add(supervisorT);add(orderCode);add(newOrder);add(addOneOrder);add(ordersTable);
	}

	@Override
	protected void addListener() {
		addOneOrder.addMouseListener(new MyPictureButtonListener(addOneOrder){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String temp = orderCode.getText();
				//格式检查 TODO
				ordersTable.addAOrder(temp);
				new TipsDialog("成功新增订单" , Color.BLUE);
			}
		});
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
