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
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
 /** 
 * 增加机构主界面
 * @author czq 
 * @version 2015年12月7日 下午9:06:06 
 */
@SuppressWarnings("serial")
public class AddInst extends MyPanel{
	
	
	
	private MyPictureLabel instid;
	private MyPictureLabel location;
	private MyPictureLabel type;
	private MyTextField instidT;
	private MyComboBox locationB;
	private MyComboBox typeB;
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	
	private CardLayout panelManager;
	private JPanel changePanel;
	private BulidBillPanel mainPanel;
	
	public AddInst(Element config , BulidBillPanel mainPanel) {
		super(config);
		this.mainPanel = mainPanel;
		this.changePanel = mainPanel.changePanel;
		this.panelManager = mainPanel.panelManager;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
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
	protected void initLabels(Element e) {
		instid = new MyPictureLabel(e.element("instid"));
		location = new MyPictureLabel(e.element("location"));
		type = new MyPictureLabel(e.element("type"));
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
		confirm.addMouseListener(new MyConfirmButtonListner(confirm));
		cancel.addMouseListener(new MyCancelButtonListener(cancel));
		
	}

	@Override
	protected void initWhitePanels(Element e) {}
	
	class MyConfirmButtonListner extends ConfirmListener{

		public MyConfirmButtonListner(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			panelManager.show(changePanel, BulidBillPanel.addPeopleStr);
		}

		@Override
		protected boolean checkDataValid() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		protected void saveToSQL() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void reInitial() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void updateMes() {
			// TODO Auto-generated method stub
			
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
			
			
			panelManager.show(changePanel, BulidBillPanel.bulidBillStr);
		}
	}
	

}
