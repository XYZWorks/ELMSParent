package ui.financeman.bulidBill;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyCardLayOut;
import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
import util.City;
import util.InstType;
import vo.personnel.InstVO;
 /** 
 * 增加机构主界面
 * @author czq 
 * @version 2015年12月7日 下午9:06:06 
 */
@SuppressWarnings("serial")
public class AddInst extends MyPanel{
	
	private MyLabel title;
	
	private MyPictureLabel instid;
	private MyPictureLabel location;
	private MyPictureLabel type;
	private MyTextField instidT;
	private MyComboBox locationB;
	private MyComboBox typeB;
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	
	private MyCardLayOut panelManager;
	private JPanel changePanel;
	private BulidBillPanel mainPanel;
	InstVO vo;
	
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
		title=new MyLabel(e.element("title"));
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
		add(title);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new MyConfirmButtonListner(confirm));
		cancel.addMouseListener(new MyCancelButtonListener(cancel));
		
	}

	@Override
	protected void initWhitePanels(Element e) {}
	
	class MyConfirmButtonListner extends ConfirmListener{
		String instid;
		InstType type;
		City city;
		public MyConfirmButtonListner(MyPictureButton button) {
			super(button);
		}

		@Override
		protected boolean checkDataValid() {
			instid = instidT.getText();
			type = InstType.toInst((String) typeB.getSelectedItem());
			city = City.toCity((String) locationB.getSelectedItem());
			return UserfulMethod.dealWithData(new SimpleDataFormat(instid, DataType.ID, "机构ID"));
		}

		@Override
		protected boolean saveToSQL() {
			vo = new InstVO(instid, city, type);
			mainPanel.instVOs.add(vo);
			return true;
			
		}

		@Override
		protected void reInitial() {
			instidT.setText("");
			typeB.setSelectedIndex(0);
			locationB.setSelectedIndex(0);
		}

		@Override
		protected void updateMes() {
			panelManager.show(changePanel, BulidBillPanel.addPeopleStr);
			
		}

	}
	
	class MyCancelButtonListener extends MyPictureButtonListener{
		public MyCancelButtonListener(MyPictureButton button) {
			super(button);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			instidT.setText("");
			panelManager.show(changePanel, BulidBillPanel.bulidBillStr);
		}
	}
	

}
