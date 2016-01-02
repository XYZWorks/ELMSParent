package ui.generalmanager.people;

import java.awt.Color;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
import ui.tools.MyComboBox;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
import ui.util.RefreshPanel;
import ui.util.TipsDialog;
import util.ResultMessage;
import util.StaffType;
import vo.personnel.PersonVO;
import blservice.personnelblservice.Personnelblservice;
 /** 
 * 
 * @author czq 
 * @version 2016年1月2日 下午4:32:06 
 */
@SuppressWarnings("serial")
public class PeopleAddPanel extends AddDocPanel implements RefreshPanel{
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
	private boolean isModify;
	private PeopleMesPanel peopleMesPanel;
	Personnelblservice bl;
	public PeopleAddPanel(Element config, JPanel changePanel,
			String checkDocPanelStr, MyTablePanel messageTable ) {
		super(config, changePanel, checkDocPanelStr, messageTable);
		peopleMesPanel = (PeopleMesPanel) messageTable;
	}
	
	void setModifyState(boolean isModify , String id) {
		this.isModify = isModify;
		ID.setEditable(!isModify);
		if(isModify){
			ID.setText(id);
		}
	}
	
	
	
	
	
	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub

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
					peopleMesPanel.addOneData(vo, 2);
				}else{
					peopleMesPanel.addOneData(vo, 0);
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
	
}
