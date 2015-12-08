package ui.storemanager.instore;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import bl.storebl.StoreController;
import blservice.storeblservice.StoreblService;
import blservice.transportblservice.Transportblservice;
import config.StaticMessage;
import ui.storeman.arrivezz.ArriveZZTablePanel;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.PanelController;
import util.MyDate;
import vo.store.InStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月3日 下午11:36:57 
 *
 */
public class InStorePanel extends MyPanel {
	
	StoreController bl;
	
	private MyPictureButton addButton;
	private MyPictureButton returnButton;
	private MyPictureButton fullButton;
	
	private MyLabel nowDoc;
	

	

	private InStoreTablePanel table;

	private PanelController controller;
	public InStorePanel(Element config, StoreController bl, PanelController controller) {
		super(config);
		this.bl = bl;
		this.controller = controller;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));

		initOtherCompoment(config);
		addCompoment();
		addListener();
		
	}

	@Override
	protected void initButtons(Element e) {
		fullButton = new MyPictureButton(e.element("full"));
		addButton = new MyPictureButton(e.element("add"));
		returnButton = new MyPictureButton(e.element("return"));

	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLabels(Element e) {
		nowDoc = new MyLabel(e.element("nowDoc"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		MyDate date = MyDate.getNowTime();
		table = new InStoreTablePanel(e.element("table"), bl, date);
		

	}

	

	@Override
	protected void addCompoment() {
		this.add(fullButton);
		this.add(addButton);
		this.add(returnButton);
		this.add(nowDoc);
		this.add(table);
		
	}

	@Override
	protected void addListener() {
		addButton.addMouseListener(new MyJumpListener(addButton, "AddInStorePanel", controller));
		returnButton.addMouseListener(new MyJumpListener(returnButton, StaticMessage.MAIN_WINDOW, controller));
		fullButton.addMouseListener(new MyJumpListener(fullButton, "FullInPanel", controller));
//		fullButton.addMouseListener(new MyFullListener (fullButton,  controller));
	}
	class MyFullListener extends MyJumpListener{
		
		
		public MyFullListener(MyPictureButton button, String toPanel, PanelController controller) {
			super(button, toPanel, controller);
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
			FullInPanel  refer = (FullInPanel) controller.getPanelMap().get(toPanel);
			InStoreDocVO vo = getVO();
			refer.setInStoreVO(vo);
			
			
		}
		private InStoreDocVO getVO() {
			int index = table.getSelectedRow();
			if(index>=0)
				return table.getInStoreVO(index);
			return null;
		}
		
	}
	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}
}