package ui.user;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.util.CompomentType;
import ui.util.PanelController;
 /** 
 * 管理员界面控制器
 * @author czq 
 * @version 2015年11月26日 下午3:07:45 
 */
public class AdminstratorController extends PanelController{

	public AdminstratorController(MyPanel initialPanel, Element e) {
		super(initialPanel , e);
		initButtons(e.element(CompomentType.BUTTONS.name()));
		initPanel(e);
		addButtons();
		addPanels();
		addListeners();
	}

	@Override
	protected void initPanel(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addPanels() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllButtonUnClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllButtonVisable(boolean state) {
		// TODO Auto-generated method stub
		
	}

	

}
