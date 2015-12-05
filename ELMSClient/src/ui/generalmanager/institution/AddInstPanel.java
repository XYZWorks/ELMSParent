package ui.generalmanager.institution;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.MyPictureButtonListener;
 /** 
 * 增加机构界面
 * @author czq 
 * @version 2015年12月3日 上午9:06:13 
 */
@SuppressWarnings("serial")
public class AddInstPanel extends MyPanel {
	
	private CardLayout panelManager;
	
	
	private MyLabel instid;
	private MyLabel location;
	private MyLabel type;
	private MyTextField instidT;
	private MyComboBox locationB;
	private MyComboBox typeB;
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	
	public AddInstPanel(Element config , CardLayout panelManager) {
		super(config);
		this.panelManager = panelManager;
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		
	}

	@Override
	protected void initTextFields(Element e) {
		instidT = new MyTextField(e.element("instid"));
	}

	@Override
	protected void initLables(Element e) {
		instid = new MyLabel(e.element("instid"));
		location = new MyLabel(e.element("location"));
		type = new MyLabel(e.element("type"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		locationB = new MyComboBox(e.element("location"));
		typeB = new MyComboBox(e.element("type"));
		
	}

	@Override
	protected void addCompoment() {
		add(cancel);
		add(confirm);
		add(instid);
		add(instidT);
		add(location);
		add(locationB);
		add(type);
		add(typeB);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new MyCancelButtonListener(confirm));
		cancel.addMouseListener(new MyConfirmButtonListner(cancel));
		
	}

	@Override
	protected void initWhitePanels(Element e) {}
	
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
