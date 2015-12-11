package ui.saleman.LoadDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
 /** 
 * 装车单增加界面
 * @author czq 
 * @version 2015年12月8日 下午8:27:23 
 */
@SuppressWarnings("serial")
public class LoadDocAddPanel extends AddDocPanel{
	
	LoadDocOrders orderTable;
	
	
	private MyLabel id;
	private MyDatePicker date;
	private MyLabel YYID;
	private MyLabel loadDocID;
	private MyLabel arriveCity;
	private MyLabel carID;
	private MyLabel supervisor;
	private MyLabel escort;
	
	private MyTextField idT;
	private MyTextField YYIDT;
	private MyTextField loadDocT;
	private MyComboBox arriveCityB;;
	private MyTextField supervisorT;
	private MyTextField carT;
	private MyTextField escortT;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTextFields(Element e) {
		idT = new MyTextField(e.element("id"));
		YYIDT = new MyTextField(e.element("YYID"));
		loadDocT = new MyTextField(e.element("loadDoc"));
		carT = new MyTextField(e.element("car"));
		supervisorT = new MyTextField(e.element("supervisor"));
		escortT= new MyTextField(e.element("escort"));
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
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		date = new MyDatePicker(e.element("datepicker"));
		arriveCityB = new MyComboBox(e.element("arrive"));
	}

	@Override
	protected void addCompoment() {
		add(YYID);add(YYIDT);add(arriveCity);add(arriveCityB);add(carID);add(carT);add(date);add(escort);add(escortT);add(id);add(idT);
		add(loadDocID);add(loadDocT);add(supervisor);add(supervisorT);
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
