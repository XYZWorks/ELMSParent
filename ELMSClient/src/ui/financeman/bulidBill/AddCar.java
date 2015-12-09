package ui.financeman.bulidBill;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
 /** 
 * 增加车辆主界面
 * @author czq 
 * @version 2015年12月7日 下午9:07:18 
 */
@SuppressWarnings("serial")
public class AddCar extends MyPanel{
	
	private MyLabel IDL;
	private MyLabel plateNumL;
	private MyLabel useYearL;
	
	private MyTextField ID;
	private MyTextField plateNum;
	private MyTextField useYear;
	
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	/**
	 * 完成车辆增加，进入主信息界面
	 */
	private MyPictureButton back;
	
	private CardLayout panelManager;
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
		// TODO Auto-generated method stub
		
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
		plateNum = new MyTextField(e.element("plateNum"));
		useYear = new MyTextField(e.element("useYear"));
		
	}

	@Override
	protected void initLabels(Element e) {
		IDL = new MyPictureLabel(e.element("ID"));
		plateNumL = new MyPictureLabel(e.element("plateNum"));
		useYearL = new MyPictureLabel(e.element("useYear"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		table = new AddCarTable(e.element("table"));
		
	}

	@Override
	protected void addCompoment() {
		add(ID);add(IDL);add(back);add(cancel);add(confirm);add(useYear);
		add(useYearL);add(plateNum);add(plateNumL);add(table);
		
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {
			
			@Override
			protected void saveToSQL() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected void reInitial() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected boolean checkDataValid() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			protected void updateMes() {
				// TODO Auto-generated method stub
				
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			
			@Override
			public void resetMes() {
				// TODO Auto-generated method stub
				
			}
		});
		back.addMouseListener(new MyPictureButtonListener(back){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//TODO 检查数据合法性、保存至数据库
				//无错误时跳转至查看界面
				
				panelManager.show(changePanel, BulidBillPanel.bulidBillStr);
				
			}
		});
	}

}
