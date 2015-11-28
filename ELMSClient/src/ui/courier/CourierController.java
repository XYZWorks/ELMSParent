package ui.courier;

import java.awt.Component;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.PanelController;
 /** 
 * 
 * @author czq 
 * @version 2015年11月26日 下午3:43:30 
 */
public class CourierController extends PanelController{
	private CourierMainPanel courierMainPanel;
	private AddOrderPanel addOrderPanel;
	private FindFullOrderInfoPanel findFullInfoPanel;
	private InputReceiveInfoPanel inputReceiveInfoPanel;
	
	public CourierController(MyPanel initialPanel, Element e) {
		super(initialPanel , e);
		initButtons(e.element(CompomentType.BUTTONS.name()));
		initPanel(e);
		addButtons();
		addPanels();
		addListeners();
	}

	@Override
	protected void initPanel(Element e) {
		courierMainPanel=new CourierMainPanel(e.element("CourierMain"));
	}

	@Override
	protected void initButtons(Element e) {
		
		
	}

	@Override
	protected void addButtons() {
		
	}

	@Override
	protected void addPanels() {
		changePanel.add(courierMainPanel);
		
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
