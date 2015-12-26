package ui.generalmanager.people;

import java.awt.Color;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyComboBox;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.RefreshPanel;
import ui.util.TipsDialog;
import util.ResultMessage;
import util.StaffType;
import vo.personnel.PersonVO;
import blservice.personnelblservice.Personnelblservice;
 /** 
 * 增加人员界面
 * @author czq 
 * @version 2015年12月3日 上午9:07:46 
 */
@SuppressWarnings("serial")
public class AddPeoplePanel extends MyPanel implements RefreshPanel{
	
	private MyPictureLabel instIDL;
	private MyPictureLabel IDL;
	private MyPictureLabel nameL;
	private MyPictureLabel phoneL;
	private MyPictureLabel typeL;
	
	private MyTextField instID;
	private MyTextField ID;
	private MyTextField name;
	private MyTextField phone;
	
	private MyComboBox type;
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	
	private PeopleManagePanel managePanel;
	private Personnelblservice bl;
	
	private boolean isModify = false;
	
	
	public AddPeoplePanel(Element config ,PeopleManagePanel managePanel , Personnelblservice bl) {
		super(config);
		this.managePanel = managePanel;
		this.bl = bl;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();
	}
	
	void setModifyState(boolean isModify , String id) {
		this.isModify = isModify;
		ID.setEditable(!isModify);
		if(isModify){
			ID.setText(id);
		}
	}
	
	
	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
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
		instIDL = new MyPictureLabel(e.element("InstIDL"));
		IDL = new MyPictureLabel(e.element("IDL"));
		nameL = new MyPictureLabel(e.element("NameL"));
		phoneL = new MyPictureLabel(e.element("PhoneL"));
		typeL = new MyPictureLabel(e.element("TypeL"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		type = new MyComboBox(e.element("type"));
		
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
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String instidc;
			String namec;
			String idc;
			StaffType typec;
			String phonec;
			PersonVO vo;
			@Override
			protected void updateMes() {
				if(isModify){
					managePanel.peopleMesTable.addOneData(vo, 2);
				}else{
					managePanel.peopleMesTable.addOneData(vo, 1);
				}
				
			}
			
			@Override
			protected boolean saveToSQL() {
				if(isModify){
					result = bl.modifyPerson(vo  = new PersonVO(instidc, idc, namec, typec, phonec));
					if(result == ResultMessage.SUCCESS){
						new TipsDialog("成功修改一条人员信息", Color.GREEN);
						return true;
					}else{
						new TipsDialog("修改人员信息出错");
						System.err.println(result);
						return false;
					}
				}
				
				
				result = bl.addPeople(vo = new PersonVO(instidc, idc, namec, typec, phonec));
				if(result == ResultMessage.SUCCESS){
					new TipsDialog("成功增加一条人员信息", Color.GREEN);
					return true;
				}else{
					new TipsDialog("增加人员信息出错");
					System.err.println(result);
					return false;
				}
			}
			
			@Override
			protected void reInitial() {
				myInit();
				managePanel.changeADDPanel(false);
				
			}
			
			
			@Override
			protected boolean checkDataValid() {
				instidc = instID.getText();
				namec = name.getText();
				idc = ID.getText();
				typec = StaffType.getType((String) type.getSelectedItem());
				phonec = phone.getText();
				SimpleDataFormat[] datas = {new SimpleDataFormat(instidc, DataType.ID, "jigouID")  , new SimpleDataFormat(idc, DataType.ID, "ID") , new SimpleDataFormat(phonec, DataType.phone, "手机号")};
				
				return UserfulMethod.dealWithData(datas);
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			
			@Override
			public void resetMes() {
				myInit();
				managePanel.changeADDPanel(false);
			}

			
		});
		
	}
	
	private void myInit() {
		name.setText("");phone.setText("");instID.setText("");type.setSelectedIndex(0);
	}
	
	@Override
	public void refresh() {
		myInit();
	}
	

	@Override
	protected void initWhitePanels(Element e) {
		
	}
	
}
