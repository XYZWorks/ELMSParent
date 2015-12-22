package ui.courier.FindFullInfo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import org.dom4j.Element;

import blservice.orderblservice.Orderblservice;
import ui.config.UserfulMethod;
import ui.courier.CourierController;
import ui.tools.MyDatePicker;
import ui.tools.MyPanelWithScroller;
import ui.tools.MySearchBox;
import ui.util.CompomentType;
import ui.util.TipsDialog;
import util.FormatMes;
import util.ResultMessage;

@SuppressWarnings("serial")
public class showInfoPanel extends MyPanelWithScroller {

	private CourierController controller;
	private Orderblservice orderblservice;
	private showTable showTable;
	private MyDatePicker datePicker;
	private MySearchBox searchBox;
	private Element config;
	private FindFullOrderInfoPanel findFullOrderInfoPanel;

	public showInfoPanel(Element config, Orderblservice orderblservice, CourierController controller,
			FindFullOrderInfoPanel findFullOrderInfoPanel) {
		super(config);

		this.config = config;
		this.orderblservice = orderblservice;
		this.controller = controller;
		this.findFullOrderInfoPanel = findFullOrderInfoPanel;

		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		setVisible(true);
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLabels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initOtherCompoment(Element e) {
		if (orderblservice == null) {
			System.out.println("ShowInfoPanle---null");
		}
		showTable = new showTable(e.element("showTable"), orderblservice);
		datePicker = new MyDatePicker(e.element("datePicker"));
		searchBox = new MySearchBox(e.element("searchBox"));
	}

	@Override
	protected void addCompoment() {
		this.add(showTable);
		this.add(datePicker);
		this.add(searchBox);
	}

	@Override
	protected void addListener() {
		searchBox.addKeyListener(new SearchBoxListener());

	}

	class SearchBoxListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				// TipsDialog wrongLength = new TipsDialog("订单号是10位哦～", 670, 95,
				// 235, 45);
				 System.out.println("showInfoPanel收到监听");
				// 获得输入的条形码
				String orderBarCode = searchBox.getMyText();
				// 判断条形码格式是否正确
				FormatMes result = UserfulMethod.checkBarCode(orderBarCode);
				if (result == FormatMes.WRONG_LENGTH) {
					TipsDialog wrongLength = new TipsDialog("订单号是10位哦～");
				} else if (result == FormatMes.ILEGAL_CHAR) {
					TipsDialog ilegalChar = new TipsDialog("订单号是10位数字,输入了非法字符");
				} else if (result == FormatMes.CORRECT) {
//					if (orderblservice.checkBarCode(orderBarCode) == ResultMessage.NOT_EXIST) {
//						TipsDialog notExist = new TipsDialog("此订单号不存在");
//					} else if (orderblservice.checkBarCode(orderBarCode) == ResultMessage.hasExist) {
						findFullOrderInfoPanel.readInfo(orderBarCode);
						findFullOrderInfoPanel.repaint();
						controller.getCardLayout().show(controller.getChangePanel(), "findFullInfoPanel");
					//}

				}
			}
		}
	}
}
