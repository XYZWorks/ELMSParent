package ui.saleman.PayDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyTextField;
 /** 
 * 
 * @author czq 
 * @version 2015年12月8日 下午8:30:34 
 */
@SuppressWarnings("serial")
public class PayDocAddPanel extends AddDocPanel {
	
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
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLabels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addCompoment() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub

	}

}
