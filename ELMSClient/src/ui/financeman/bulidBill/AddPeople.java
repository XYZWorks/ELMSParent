package ui.financeman.bulidBill;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
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
import ui.util.TipsDialog;
import util.StaffType;
import vo.personnel.PersonVO;
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
	
	private MyTextField IDT;
	private MyTextField nameT;
	private MyTextField phoneT;
	
	private MyComboBox typeT;
	
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
		IDT = new MyTextField(e.element("ID"));
		nameT = new MyTextField(e.element("Name"));
		phoneT = new MyTextField(e.element("Phone"));
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
		typeT = new MyComboBox(e.element("Type"));
		table = new AddPeopleTable(e.element("table"));
	}

	@Override
	protected void addCompoment() {
		add(IDT);
		add(IDL);
		add(cancel);
		add(confirm);
		add(typeT);
		add(typeL);
		add(phoneT);
		add(phoneL);
		add(nameT);
		add(nameL);
		add(add);
		add(title);
		add(message);
		add(addCar);
		add(table);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String name;
			String id;
			StaffType type;
			String phone;
			@Override
			protected void updateMes() {
				String[] data = {mainPanel.instVOs.get(0).ID,StaffType.getName(type), id, name , phone};
				table.addOneRow(data);
				
			}
			
			@Override
			protected boolean saveToSQL() {
				mainPanel.personVOs.add(new PersonVO(mainPanel.instVOs.get(0).ID, id, name, type, phone));
				new TipsDialog("成功增加一条人员信息", Color.GREEN);
				return true;
			}
			
			@Override
			protected void reInitial() {
				myInit();
				
				
			}
			
			@Override
			protected boolean checkDataValid() {
				name = nameT.getText();
				id = IDT.getText();
				type = StaffType.getType((String) typeT.getSelectedItem());
				phone = phoneT.getText();
				SimpleDataFormat[] datas = {new SimpleDataFormat(id, DataType.ID, "ID") , new SimpleDataFormat(phone, DataType.phone, "手机号")};
				
				return UserfulMethod.dealWithData(datas);
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			
			@Override
			public void resetMes() {
				myInit();
				
			}
		});
		add.addMouseListener(new MyPictureButtonListener(add){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				panelManager.show(changePanel, BulidBillPanel.addCarStr);
			}
		});
	}
	
	private void myInit(){
		nameT.setText("");IDT.setText("");phoneT.setText("");typeT.setSelectedIndex(0);
	}

	@Override
	protected void initWhitePanels(Element e) {
	}

}
