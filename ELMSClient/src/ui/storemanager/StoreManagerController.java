package ui.storemanager;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.util.CompomentType;
import ui.util.PanelController;
 /** 
 * 仓库管理人员控制器
 * @author czq 
 * @version 2015年11月26日 下午3:39:40 
 */
public class StoreManagerController extends PanelController {

	public StoreManagerController(MyPanel initialPanel, Element e) {
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


	

}
