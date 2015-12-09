package ui.saleman.ArriveYYDoc;

import javax.swing.JPanel;

import org.dom4j.Element;




/**
 * 接收单界面
 */
import ui.table.MyTable;
import ui.tools.AddDocPanel;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureLabel;
import ui.util.PanelController;
/**
 * 接收单增加界面
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class ArriveYYDocAddPanel extends AddDocPanel{
	
	//接收单号
	private MyPictureLabel arriveYYDocID;
	private MyLabel ID;
	
	//日历
	private MyDatePicker datePicker;
	
	//属性
	private MyLabel instID;
	private MyLabel arriveDate;
	private MyLabel transferDocID;
	private MyLabel sendCIty;
	private MyLabel goodState;

	public  ArriveYYDocAddPanel(Element config , JPanel changePanel, String checkDocPanelStr) {
		super(config , changePanel , checkDocPanelStr);
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
