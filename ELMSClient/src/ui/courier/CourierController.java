package ui.courier;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import org.dom4j.Element;

import config.StaticMessage;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MySideBarButton;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MySideBarListener;
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
	
	
	private MySideBarButton addOrderButton;
	private MySideBarButton findFullInfoButton;
	private MySideBarButton inputReceiveInfoButton;
	
	private final String courierMainPanelStr = StaticMessage.MAIN_WINDOW;
	private final String addOrderPanelStr = "addOrderPanel";
	private final String findFullInfoPanelStr="findFullInfoPanel";
	private final String inputReceiveInfoPanelStr="inputReceiveInfoPanel";
	
	public CourierController(MyPanel initialPanel, Element e) {
		super(initialPanel,e);
		initButtons(e.element(CompomentType.BUTTONS.name()));
		initPanel(e);
		addButtons();
		addPanels();
		addListeners();	
		addToMap();
		//panelManager.show(changePanel, "courierMainPanel");
		this.setAllButtonVisable(false);
		changePanel.setVisible(true);
	
	
	}
	
	@Override
	protected void initPanel(Element e) {
		courierMainPanel=new CourierMainPanel(e.element(courierMainPanelStr),this);
		addOrderPanel=new AddOrderPanel(e.element(addOrderPanelStr));
		findFullInfoPanel=new FindFullOrderInfoPanel(e.element(findFullInfoPanelStr));
		//inputReceiveInfoPanel=new InputReceiveInfoPanel(e.element(inputReceiveInfoPanelStr));
//		pane = new JScrollPane();
////		pane.setLayout(null);
//		pane.getViewport().add(addOrderPanel);
//		addOrderPanel.setPreferredSize(new Dimension(848, 1200));
////		pane.add(addOrderPanel);
////		pane.setPreferredSize(new Dimension(848, 637));
//		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}

	@Override
	protected void initButtons(Element e) {
		addOrderButton=new MySideBarButton(e.element("addOrder"));
		findFullInfoButton=new MySideBarButton(e.element("findFullInfo"));
		inputReceiveInfoButton=new MySideBarButton(e.element("inputReceiveInfo"));
		
	}

	@Override
	protected void addButtons() {
		mainPanel.add(addOrderButton);
		mainPanel.add(findFullInfoButton);
		mainPanel.add(inputReceiveInfoButton);
		
	}

	@Override
	protected void addPanels() {
		changePanel.add(courierMainPanel , courierMainPanelStr);
		changePanel.add(addOrderPanel , addOrderPanelStr);
		changePanel.add(findFullInfoPanel , findFullInfoPanelStr);
		//changePanel.add(inputReceiveInfoPanel , inputReceiveInfoPanelStr);
		
	}

	@Override
	protected void addListeners() {
		addOrderButton.addMouseListener(new MySideBarListener(addOrderButton, this, addOrderPanelStr));
		findFullInfoButton.addMouseListener(new MySideBarListener(findFullInfoButton, this, findFullInfoPanelStr));
		inputReceiveInfoButton.addMouseListener(new MySideBarListener(inputReceiveInfoButton, this, inputReceiveInfoPanelStr));
		
		
	}

	@Override
	public void setAllButtonUnClicked() {
		addOrderButton.setMyIcon(ButtonState.NORMAL);
		findFullInfoButton.setMyIcon(ButtonState.NORMAL);
		inputReceiveInfoButton.setMyIcon(ButtonState.NORMAL);
	}

	@Override
	public void setAllButtonVisable(boolean state) {
		addOrderButton.setVisible(state);
		findFullInfoButton.setVisible(state);
		inputReceiveInfoButton.setVisible(state);
	}

	@Override
	protected void addToMap() {
		buttonMap.put(addOrderPanelStr,addOrderButton);
		buttonMap.put(findFullInfoPanelStr, findFullInfoButton);
		buttonMap.put(inputReceiveInfoPanelStr, inputReceiveInfoButton);
		
	}

	@Override
	protected void initialBL() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
