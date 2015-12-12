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
import ui.tools.MyPictureLabel;
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
	
	private MyLabel title;
	private MyLabel message;
	private MyLabel addCar;
	private MyPictureLabel IDL;
	private MyPictureLabel nameL;
	private MyPictureLabel phoneL;
	private MyPictureLabel typeL;
	
	private MyTextField ID;
	private MyTextField name;
	private MyTextField phone;
	
	private MyComboBox type;
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	/**
	 * 完成人员增加，进入增加车辆信息界面
	 */
	private MyPictureButton add;
	
	private CardLayout panelManager;
	private JPanel changePanel;
	private BulidBillPanel mainPanel;
	
	private AddPeopleTable table;
	
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
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		add = new MyPictureButton(e.element("add"));
	}

	@Override
	protected void initTextFields(Element e) {
		ID = new MyTextField(e.element("ID"));
		name = new MyTextField(e.element("Name"));
		phone = new MyTextField(e.element("Phone"));
	}

	@Override
	protected void initLabels(Element e) {
		IDL = new MyPictureLabel(e.element("ID"));
		nameL = new MyPictureLabel(e.element("Name"));
		phoneL = new MyPictureLabel(e.element("Phone"));
		typeL = new MyPictureLabel(e.element("Type"));
		title = new MyLabel(e.element("title"));
		message = new MyLabel(e.element("message"));
		addCar = new MyLabel(e.element("addCar"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		type = new MyComboBox(e.element("Type"));
		table = new AddPeopleTable(e.element("table"));
	}

	@Override
	protected void addCompoment() {
		add(ID);
		add(IDL);
		add(cancel);
		add(confirm);
		add(type);
		add(typeL);
		add(phone);
		add(phoneL);
		add(name);
		add(nameL);
		add(add);
		add(title);
		add(message);
		add(addCar);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new MyCancelButtonListener(confirm));
		cancel.addMouseListener(new MyConfirmButtonListner(cancel));
		add.addMouseListener(new MyPictureButtonListener(add){
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
