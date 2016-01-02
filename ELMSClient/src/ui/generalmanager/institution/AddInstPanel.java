package ui.generalmanager.institution;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyCardLayOut;
import ui.tools.MyComboBox;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.City;
import util.InstType;
import util.ResultMessage;
import vo.personnel.InstVO;
import blservice.personnelblservice.Personnelblservice;
 /** 
 * 增加机构界面
 * @author czq 
 * @version 2015年12月3日 上午9:06:13 
 */
@SuppressWarnings("serial")
public class AddInstPanel extends MyPanel {
	
	private JPanel changePanel;
	Personnelblservice bl;
	private InstManagePanel instManagePanel;
	private MyPictureLabel instid;
	private MyPictureLabel location;
	private MyPictureLabel type;
	private MyTextField instidT;
	private MyComboBox locationB;
	private MyComboBox typeB;
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	
	public AddInstPanel(Element config , JPanel changePanel , Personnelblservice bl , InstManagePanel instManagePanel) {
		super(config);
		this.changePanel = changePanel;
		this.bl = bl;
		this.instManagePanel = instManagePanel;
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
		instid =  new MyPictureLabel(e.element("instid"));
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
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String instid;
			City location;
			InstType type;
			InstVO vo;
			@Override
			protected boolean checkDataValid() {
				instid = instidT.getText();
				location = City.toCity((String) locationB.getSelectedItem());
				type = InstType.toInst((String) typeB.getSelectedItem());
				
				return UserfulMethod.dealWithData(new SimpleDataFormat(instid , DataType.ID , "ID"));
			}

			@Override
			protected boolean saveToSQL() {
				result = bl.addInst(vo = new InstVO(instid, location, type));
				if(result== ResultMessage.SUCCESS){
					new TipsDialog("成功增加一个机构" , Color.GREEN);
					return true;
				}else{
					System.err.println(result);
					new  TipsDialog("未成功增加机构");
				}
				
				
				return false;
				
			}

			@Override
			protected void reInitial() {
				myInit();
				((MyCardLayOut)changePanel.getLayout() ).show(changePanel, "InstManagePanel");
			}

			@Override
			protected void updateMes() {
				instManagePanel.table.addOneData(vo, 1);
			}

		});
		cancel.addMouseListener(new MyCancelButtonListener(cancel));
		
	}

	@Override
	protected void initWhitePanels(Element e) {}
	
	
	class MyCancelButtonListener extends MyPictureButtonListener{
		public MyCancelButtonListener(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			myInit();
			((MyCardLayOut)changePanel.getLayout() ).show(changePanel, "InstManagePanel");
		}
	}
	private void myInit() {
		instidT.setText("");typeB.setSelectedIndex(0);locationB.setSelectedIndex(0);
	}
	

}
