package ui.storemanager.storeshow;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.dom4j.Element;

import ui.storemanager.instore.InStoreTablePanel;
import ui.storemanager.outstore.OutStoreTablePanel;
import ui.tools.MyDatePicker;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanelWithScroller;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyWhitePanel;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.PanelController;
import util.MyDate;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
import vo.store.StoreMessageVO;
import vo.store.StoreShowVO;
import bl.storebl.StoreController;

/**
 * @author ymc
 * @version 创建时间：2015年12月12日 上午10:27:55
 *
 */
@SuppressWarnings("serial")
public class StoreSingleShowPanel extends MyPanelWithScroller {

	protected StoreController bl;

	//初始whitepanel
	private MyWhitePanel showSimpleWhitePanel;
	private MyWhitePanel locateWhitePanel;
	private MyWhitePanel inWhitePanel;
	private MyWhitePanel outWhitePanel;

	protected MyPictureButton confirmButton;
	protected MyPictureButton returnButton;

	protected MyPictureLabel centerL;
	protected MyPictureLabel storeNumL;
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

	public StoreSingleShowPanel(Element config, StoreController bl, PanelController controller) {
		super(config);
		this.bl = bl;
		this.controller = controller;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		
		if(config.element(CompomentType.WHITEPANELS.name())==null){
			System.out.println("报错");
		}
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();
	}

	@Override
	protected void initWhitePanels(Element e) {
		showSimpleWhitePanel = new MyWhitePanel(e.element("showSimpleWhitePanel"));
		locateWhitePanel = new MyWhitePanel(e.element("locateWhitePanel"));
		inWhitePanel = new MyWhitePanel(e.element("inWhitePanel"));
		outWhitePanel = new MyWhitePanel(e.element("outWhitePanel"));
		
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
		centerL = new MyPictureLabel(e.element("centerL"));
		storeNumL = new MyPictureLabel(e.element("storeNumL"));
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
		inTable = new InStoreTablePanel(e.element("inTable"), bl, MyDate.getNowTime());
		orderTable = new OrderInfoTable(e.element("orderTable"));

	}

	@Override
	protected void addCompoment() {
		//开头的 中转中心 和 仓库区
		add(center);
		add(centerL);
		add(storeNum);
		add(storeNumL);
		
		//显示仓库的基本信息
		showSimpleWhitePanel.add(nowNum);
		showSimpleWhitePanel.add(nowNumL);
		showSimpleWhitePanel.add(nowTime);
		showSimpleWhitePanel.add(nowTimeL);
		showSimpleWhitePanel.add(totalNum);
		showSimpleWhitePanel.add(totalNumL);
		add(showSimpleWhitePanel);
		
		//显示位置信息
		locateWhitePanel.add(nowLoc);
		locateWhitePanel.add(orderTable);
		add(locateWhitePanel);
		
		//查询时间
		add(confirmButton);
		add(inputTime);
		
		//查询入库
		inWhitePanel.add(infoin);
		inWhitePanel.add(inTable);
		add(inWhitePanel);
		
		//查询出库
		outWhitePanel.add(outTable);
		outWhitePanel.add(infoout);
		add(outWhitePanel);

		add(picker);
		add(returnButton);
		
		
	
	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new ShowListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "StoreShowPanel", controller, true));

	}

	public class ShowListener extends MyPictureButtonListener {

		public ShowListener(MyPictureButton button) {
			super(button);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			MyDate past = picker.getMyDate();
			ArrayList<InStoreDocVO> inStoreDocVOs = new ArrayList<>();
			ArrayList<OutStoreDocVO> outStoreDocVOs = new ArrayList<>();
			for (InStoreDocVO in : ins) {
				if (in.date.between(past, nowDate)) {
					inStoreDocVOs.add(in);
				}
			}

			for (OutStoreDocVO out : outs) {
				if (out.date.between(past, nowDate)) {
					outStoreDocVOs.add(out);
				}
			}
			inTable.resetValue(inStoreDocVOs);
			outTable.resetValue(outStoreDocVOs);

		}

	}

	public void getInfo(String cen, String sto) {
		center.setText(cen);
		storeNum.setText(sto);
		for (StoreMessageVO vo : bl.show()) {
			if (cen.equals(vo.location.getName()) && sto.equals(vo.storeLoc.getStoreLocation() + "区")) {
				target = vo;
				break;
			}

		}
		if (target != null) {

			nowNum.setText("   " + String.valueOf(target.number));
			totalNum.setText("   " + String.valueOf(target.totalNum));
			ins = target.inStoreDocs;
			outs = target.outStoreDocs;

			inTable.resetValue(ins);
			outTable.resetValue(outs);
			StoreShowVO show = StoreShowVO.getStoreShow(target);
			orderTable.resetValue(show);
		}
	}

}
