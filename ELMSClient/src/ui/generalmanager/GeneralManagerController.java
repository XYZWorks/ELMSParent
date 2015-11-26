package ui.generalmanager;

import org.dom4j.Element;

import ui.tools.MyButton;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.PanelController;
 /** 
 * 总经理界面跳转控制器
 * @author czq 
 * @version 2015年11月26日 下午3:41:24 
 */
public class GeneralManagerController extends PanelController{
	
	private GeneralManagerMain GMmainpanel;
	private ConstSetPanel constSetPanel;
	private ApprovalDocsPanel approvalPanel;
	private InstManagePanel instManagePanel;
	private PeopleManagePanel peopleManagePanel;
	private StatisticPanel statisticPanel;
	
	private MyPictureButton constsetButton;
	private MyPictureButton approvalButton;
	private MyPictureButton instManageButton;
	private MyPictureButton peopleManageButton;
	private MyPictureButton statisticButton;
	
	
	public GeneralManagerController(MyPanel initialPanel , Element e) {
		super(initialPanel , e);
		addButtons(e.element("buttons"));
	}

	@Override
	protected void addButtons(Element e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void initPanel(Element e) {
//		approvalPanel = new ApprovalDocsPanel(e.attributeValue("approval"));
		
	}
	
	
	@Override
	protected void addPanels() {
		
//		changePanel.add(approvalPanel, e.attributeValue("approval"));
		
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		
	}

	

}
