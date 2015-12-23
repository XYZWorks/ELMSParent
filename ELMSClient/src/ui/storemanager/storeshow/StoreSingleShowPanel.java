package ui.storemanager.storeshow;

import java.util.ArrayList;

import org.dom4j.Element;

import bl.storebl.StoreController;
import ui.storemanager.instore.InStoreTablePanel;
import ui.storemanager.outstore.OutStoreTablePanel;
import ui.tools.MyDatePicker;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanelWithScroller;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.PanelController;
import util.MyDate;
import vo.order.OrderVO;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
import vo.store.StoreMessageVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月12日 上午10:27:55 
 *
 */
@SuppressWarnings("serial")
public class StoreSingleShowPanel extends MyPanelWithScroller {
	
	protected StoreController bl;
	
	protected MyPictureButton confirmButton;
	protected MyPictureButton returnButton;
	
	
	protected MyLabel centerL;
	protected MyLabel storeNumL;
	protected MyLabel center;
	protected MyLabel storeNum;
	
	protected MyLabel nowNumL;
	protected MyLabel totalNumL;
	protected MyLabel nowNum;
	protected MyLabel totalNum;
	
	protected MyLabel nowTimeL;
	protected MyLabel nowTime;
	
	protected MyLabel inputTime;
	protected MyLabel nowLoc;
	protected MyLabel infoin;
	protected MyLabel infoout;
	
	protected MyDate nowDate;
	protected MyDatePicker picker;
	protected PanelController controller;
	
	protected OrderInfoTable orderTable;
	protected InStoreTablePanel inTable;
	protected OutStoreTablePanel outTable; 
	
	protected StoreMessageVO target;
	protected ArrayList<InStoreDocVO> ins;
	protected ArrayList<OutStoreDocVO> outs;
	protected ArrayList<String> orderBars;
	protected ArrayList<String> locs;
	
	public StoreSingleShowPanel(Element config, StoreController bl, PanelController controller) {
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
		storeNumL = new MyLabel(e.element("storeNumL"));
		center = new MyLabel(e.element("center"));
		storeNum = new MyLabel(e.element("storeNum"));
		nowNum = new MyLabel(e.element("nowNum"));
		totalNum = new MyLabel(e.element("totalNum"));
		nowNumL = new MyLabel(e.element("nowNumL"));
		totalNumL = new MyLabel(e.element("totalNumL"));
		nowTime = new MyLabel(e.element("nowTime"));
		nowTimeL = new MyLabel(e.element("nowTimeL"));
		inputTime = new MyLabel(e.element("inputTime"));
		nowLoc = new MyLabel(e.element("nowLoc"));
		infoin = new MyLabel(e.element("infoin"));
		infoout = new MyLabel(e.element("infoout"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		nowDate = MyDate.getNowTime();
		nowTime.setText(MyDate.toString(nowDate));
		picker = new MyDatePicker(e.element("DatePicker"));
		outTable = new OutStoreTablePanel(e.element("outTable"), bl, MyDate.getNowTime());
		inTable = new InStoreTablePanel(e.element("inTable"), bl,  MyDate.getNowTime());
		orderTable = new OrderInfoTable(e.element("orderTable"));
		
	}

	@Override
	protected void addCompoment() {
		add(center);
		add(centerL);
		add(confirmButton);
		add(inTable);
		add(infoin);
		add(infoout);
		add(inputTime);
		add(nowLoc);
		add(nowNum);
		add(nowNumL);
		add(nowTime);
		add(nowTimeL);
		add(orderTable);
		add(outTable);
		add(picker);
		add(returnButton);
		add(storeNum);
		add(storeNumL);
		add(totalNum);
		add(totalNumL);
		
	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new ShowListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "StoreShowPanel", controller,true));

	}

	public class ShowListener extends MyPictureButtonListener{

		public ShowListener(MyPictureButton button) {
			super(button);
			// TODO Auto-generated constructor stub
		}
		
	}
	public void getInfo(String cen, String sto) {
		center.setText(cen);
		storeNum.setText(sto);
		for (StoreMessageVO vo : bl.show()) {
			if (cen.equals(vo.location.getName()) && sto.equals(vo.storeLoc.getStoreLocation()+"区")){
				target = vo;
				break;
			}
				
		}
		if(target!=null){
			
			nowNum.setText("   "+String.valueOf(target.number));
			totalNum.setText("   "+String.valueOf(target.totalNum));
			ins = target.inStoreDocs;
			outs = target.outStoreDocs;
			orderBars = new ArrayList<>();
			locs = new ArrayList<>();
			
			
			
			inTable.resetValue(ins);			
			outTable.resetValue(outs);
			orderTable.resetValue(ins,outs);
		}
	}

}
