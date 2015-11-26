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
		
	}

	@Override
	protected void addButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addPanels() {
		approvalPanel = new ApprovalDocsPanel(e);
		changePanel.add(approvalPanel, e.attributeValue("approval"));
		
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		
	}

}
