package ui.financeman.bulidBill;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyCardLayOut;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import vo.DTManage.CarVO;
 /** 
 * 增加车辆主界面
 * @author czq 
 * @version 2015年12月7日 下午9:07:18 
 */
@SuppressWarnings("serial")
public class AddCar extends MyPanel{
	
	private MyPictureLabel IDL;
	private MyPictureLabel plateNumL;
	private MyPictureLabel useYearL;
	private MyLabel title;
	private MyLabel message;
	
	private MyTextField ID;
	private MyTextField plateNumT;
	private MyTextField useYear;
	
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	/**
	 * 完成车辆增加，进入主信息界面
	 */
	private MyPictureButton back;
	
	private MyCardLayOut panelManager;
	private JPanel changePanel;
	private BulidBillPanel mainPanel;
	
	private AddCarTable table;
	
	public AddCar(Element config, BulidBillPanel mainPanel) {
		super(config);
		this.mainPanel = mainPanel;
		this.changePanel = mainPanel.changePanel;
		this.panelManager = mainPanel.panelManager;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();
	}

	@Override
	protected void initWhitePanels(Element e) {
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
	back = new MyPictureButton(e.element("back"));
		
	}

	@Override
	protected void initTextFields(Element e) {
		ID = new MyTextField(e.element("ID"));
		plateNumT = new MyTextField(e.element("plateNum"));
		useYear = new MyTextField(e.element("useYear"));
		
	}

	@Override
	protected void initLabels(Element e) {
		IDL = new MyPictureLabel(e.element("ID"));
		plateNumL = new MyPictureLabel(e.element("plateNum"));
		useYearL = new MyPictureLabel(e.element("useYear"));
		title = new MyLabel(e.element("title"));
		message = new MyLabel(e.element("message"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		table = new AddCarTable(e.element("table"));
		
	}

	@Override
	protected void addCompoment() {
		add(ID);add(IDL);add(cancel);add(confirm);add(useYear);
		add(useYearL);add(plateNumT);add(plateNumL);add(table);add(title);
		add(message);add(back);
		
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String id;
			String plateNum;
			String year;
			String instid;
			@Override
			protected boolean saveToSQL() {
				mainPanel.carVOs.add(new CarVO(id,instid, plateNum, Integer.parseInt(year)));
				new TipsDialog("成功增加汽车信息", Color.GREEN);
				return true;
			}
			
			@Override
			protected void reInitial() {
				myInit();
				
			}
			
			@Override
			protected boolean checkDataValid() {
				id = ID.getText();
				plateNum = plateNumT.getText();
				year = useYear.getText();
				instid  = mainPanel.instVOs.get(0).ID;
				SimpleDataFormat[] datas = {new SimpleDataFormat(id, DataType.ID, "ID") , new SimpleDataFormat(plateNum, DataType.PlateNum, "车牌号")  , new SimpleDataFormat(year, DataType.PositiveNum, "使用年份")};
				return UserfulMethod.dealWithData(datas);
			}

			@Override
			protected void updateMes() {
				String[] data = {id , plateNum , year};
				table.addOneRow(data);
				
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			@Override
			public void resetMes() {
				myInit();
				
			}
		});
		back.addMouseListener(new MyPictureButtonListener(back){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				panelManager.show(changePanel, BulidBillPanel.bulidBillStr);
				new TipsDialog("完成一个机构信息的增加", Color.GREEN);
				myInit();
				table.removeAllRows();
				mainPanel.finishOneInst();
			}
		});
	}
	private void  myInit() {
		ID.setText("");useYear.setText("");plateNumT.setText("");
	}
}
