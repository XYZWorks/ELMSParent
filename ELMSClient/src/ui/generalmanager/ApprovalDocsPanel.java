package ui.generalmanager;

import org.dom4j.Element;

import blservice.approvalblservice.Approvalblservice;
import ui.table.MyTable;
import ui.tools.MyComboBox;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;

/**
 * 审批单据
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class ApprovalDocsPanel extends MyPanel{
	
	private MyPictureLabel chooseDocType;
	private MyComboBox DocTypeChooseBox;
	
	private MyTable docTable;
	
	private MyPictureButton approvalMany;
	private MyPictureButton approvalOne;
	/**
	 * 查看详细信息
	 */
	private MyPictureButton checkForMoreInfo;
	
	private Approvalblservice bl;
	
	public ApprovalDocsPanel(Element config ) {
		super(config);
		// TODO Auto-generated constructor stub
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
	protected void initLables(Element e) {
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
