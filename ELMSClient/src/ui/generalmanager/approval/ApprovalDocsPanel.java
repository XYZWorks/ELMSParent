package ui.generalmanager.approval;

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
	
	//持有其他单据查看界面的引用，这些界面可用于传入参数进行显示
	
	
	
	private Approvalblservice bl;
	
	public ApprovalDocsPanel(Element config  , Approvalblservice bl) {
		super(config);
		this.bl = bl;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initButtons(Element e) {
		approvalMany = new MyPictureButton(e.element("approveMany"));
		approvalOne = new MyPictureButton(e.element("approveOne"));
		checkForMoreInfo = new MyPictureButton(e.element("checkForMoreInfo"));
		
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

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

}
