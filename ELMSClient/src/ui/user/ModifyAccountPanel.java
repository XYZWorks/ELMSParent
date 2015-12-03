package ui.user;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import bl.BusinessLogicDataFactory;
import blservice.accountblservice.Accountblservice;
import ui.config.UserfulMethod;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
 /** 
 * 查找、修改、删除界面
 * @author czq 
 * @version 2015年12月2日 下午7:12:08 
 */
@SuppressWarnings("serial")
public class ModifyAccountPanel extends MyPanel{
	
	Accountblservice bl;
	/**
	 * 账户信息表格
	 */
	private AccountMesTablePanel table;
	
	private MyPictureButton modifyButton;
	private MyPictureButton deleteButton;
	
	
	
	public ModifyAccountPanel(Element config , Accountblservice bl) {
		super(config);
		this.bl = bl;
		initLables(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();
		
		
	}

	@Override
	protected void initButtons(Element e) {
		modifyButton = new MyPictureButton(e.element("modify"));
		deleteButton = new MyPictureButton(e.element("delete"));
	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLables(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		table = new AccountMesTablePanel(e.element("table"), bl);
		
	}

	@Override
	protected void addCompoment() {
		add(deleteButton);
		add(modifyButton);
		add(table);
	}

	@Override
	protected void addListener() {
		modifyButton.addMouseListener(new MyModifyAccountListener(modifyButton));
		deleteButton.addMouseListener(new MyDeleteAccountListener(deleteButton));
	}
	
	
	class MyModifyAccountListener extends MyPictureButtonListener{

		public MyModifyAccountListener(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
		}
	}
	
	class MyDeleteAccountListener extends MyPictureButtonListener{

		public MyDeleteAccountListener(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
		}
	}
	
}
