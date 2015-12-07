package ui.financeman.bulidBill;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.generalmanager.people.PeopleManagePanel;
import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
 /** 
 * 增加人员界面
 * @author czq 
 * @version 2015年12月7日 下午9:06:53 
 */
@SuppressWarnings("serial")
public class AddPeople extends MyPanel{

	private MyLabel instIDL;
	private MyLabel IDL;
	private MyLabel nameL;
	private MyLabel phoneL;
	private MyLabel typeL;
	
	private MyTextField instID;
	private MyTextField ID;
	private MyTextField name;
	private MyTextField phone;
	
	private MyComboBox type;
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	/**
	 * 完成人员增加，进入增加车辆信息界面
	 */
	private MyPictureButton addCar;
	
	private CardLayout panelManager;
	private JPanel changePanel;
	private BulidBillPanel mainPanel;
	
	public AddPeople(Element config ,BulidBillPanel mainPanel) {
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
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("Confirm"));
		cancel = new MyPictureButton(e.element("Cancel"));
		addCar = new MyPictureButton(e.element("addCar"));
	}

	@Override
	protected void initTextFields(Element e) {
		instID = new MyTextField(e.element("InstID"));
		ID = new MyTextField(e.element("ID"));
		name = new MyTextField(e.element("Name"));
		phone = new MyTextField(e.element("Phone"));
	}

	@Override
	protected void initLabels(Element e) {
		instIDL = new MyLabel(e.element("InstID"));
		IDL = new MyLabel(e.element("ID"));
		nameL = new MyLabel(e.element("Name"));
		phoneL = new MyLabel(e.element("Phone"));
		typeL = new MyLabel(e.element("Type"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		type = new MyComboBox(e.element("Type"));
		
	}

	@Override
	protected void addCompoment() {
		add(ID);
		add(IDL);
		add(cancel);
		add(confirm);
		add(instID);
		add(instIDL);
		add(type);
		add(typeL);
		add(phone);
		add(phoneL);
		add(name);
		add(nameL);add(addCar);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new MyCancelButtonListener(confirm));
		cancel.addMouseListener(new MyConfirmButtonListner(cancel));
		addCar.addMouseListener(new MyPictureButtonListener(addCar){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				panelManager.show(changePanel, BulidBillPanel.addCarStr);
			}
		});
	}
	
	class MyConfirmButtonListner extends MyPictureButtonListener{

		public MyConfirmButtonListner(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			//TODO 检查数据合法性、保存至数据库
			//无错误时跳转至查看界面
			
			panelManager.show(changePanel, BulidBillPanel.addCarStr);
			
		}

	}
	
	class MyCancelButtonListener extends MyPictureButtonListener{
		public MyCancelButtonListener(MyPictureButton button) {
			super(button);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			//TODO 清空数据
			
		}
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

}
