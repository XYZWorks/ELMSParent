package ui.storemanager.storeshow;

import org.dom4j.Element;

import bl.storebl.StoreController;
import ui.storemanager.StoreManagerController;
import ui.storemanager.instore.InStoreTablePanel;
import ui.storemanager.outstore.OutStoreTablePanel;
import ui.tools.MyDatePicker;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanelWithScroller;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import util.MyDate;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月12日 上午10:27:55 
 *
 */
public class StoreSingleShowPanel extends MyPanelWithScroller {
	
	StoreController bl;
	
	private MyPictureButton confirmButton;
	private MyPictureButton returnButton;
	
	
	private MyLabel centerL;
	private MyLabel storeNumL;
	private MyLabel center;
	private MyLabel storeNum;
	
	private MyLabel nowNumL;
	private MyLabel totalNumL;
	private MyLabel nowNum;
	private MyLabel totalNum;
	
	private MyLabel nowTimeL;
	private MyLabel nowTime;
	
	private MyLabel inputTime;
	private MyLabel nowLoc;
	private MyLabel info;
	
	MyDate nowDate;
	MyDatePicker picker;
	StoreManagerController controller;
	
	OrderInfoTable orderTable;
	InStoreTablePanel inTable;
	OutStoreTablePanel outTable; 
	public StoreSingleShowPanel(Element config, StoreController bl, StoreManagerController controller) {
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
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initButtons(Element e) {
	
		confirmButton = new MyPictureButton(e.element("confirm"));
		returnButton = new MyPictureButton(e.element("return"));
	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLabels(Element e) {
		centerL = new MyLabel(e.element("centerL"));
		storeNumL = new MyLabel(e.element("storeL"));
		center = new MyLabel(e.element("center"));
		storeNum = new MyLabel(e.element("store"));
		nowNum = new MyLabel(e.element("nowNum"));
		totalNum = new MyLabel(e.element("totalNum"));
		nowNumL = new MyLabel(e.element("nowNumL"));
		totalNumL = new MyLabel(e.element("totalNumL"));
		nowTime = new MyLabel(e.element("nowTime"));
		nowTimeL = new MyLabel(e.element("nowTimeL"));
		inputTime = new MyLabel(e.element("inputTime"));
		nowLoc = new MyLabel(e.element("nowLoc"));
		info = new MyLabel(e.element("info"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		nowDate = MyDate.getNowTime();
		nowTime.setText(MyDate.toString(nowDate));
		picker = new MyDatePicker(e.element("DatePicker"));
		
	}

	@Override
	protected void addCompoment() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new ShowListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "StoreShowPanel", controller,false));

	}

	class ShowListener extends MyPictureButtonListener{

		public ShowListener(MyPictureButton button) {
			super(button);
			// TODO Auto-generated constructor stub
		}
		
	}
	public void getInfo(String cen, String sto) {
		center.setText(cen);
		storeNum.setText(sto);
		
	}

}
