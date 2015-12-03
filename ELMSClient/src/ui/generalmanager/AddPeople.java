package ui.generalmanager;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

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
 * @version 2015年12月3日 上午9:07:46 
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
	
	private CardLayout panelManager;
	
	public AddPeople(Element config ,CardLayout panelManager) {
		super(config);
		this.panelManager = panelManager;
		initLables(config.element(CompomentType.LABLES.name()));
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
	}

	@Override
	protected void initTextFields(Element e) {
		instID = new MyTextField(e.element("InstID"));
		ID = new MyTextField(e.element("ID"));
		name = new MyTextField(e.element("Name"));
		phone = new MyTextField(e.element("Phone"));
	}

	@Override
	protected void initLables(Element e) {
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
		add(nameL);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new MyCancelButtonListener(confirm));
		cancel.addMouseListener(new MyCancelButtonListener(cancel));
		
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
	
}
