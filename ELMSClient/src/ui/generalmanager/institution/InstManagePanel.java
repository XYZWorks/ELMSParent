package ui.generalmanager.institution;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CancelListener;
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
 * 机构管理
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class InstManagePanel extends MyPanel{
	
	private InstTablePanel table;
	private JPanel changePanel;
	private AddInstPanel addInstPanel;
	private final static String addInstPanelStr = "addInstPanel";
	
	private Personnelblservice bl;
	
	
	private MyPictureButton addInst;
	private MyPictureButton modify;
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	private MyPictureButton delete;
	
	private MyLabel newType;
	private MyLabel newLoc;
	private MyLabel title;
	
	private MyComboBox type;
	private MyComboBox location;
	
	private boolean isModify = false;
	
	public InstManagePanel(Element config , JPanel changePanel , Personnelblservice bl) {
		super(config);
		this.bl = bl;
		this.changePanel = changePanel;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
		
		ismodify(false);
	}

	@Override
	protected void initButtons(Element e) {
		addInst = new MyPictureButton(e.element("addInst"));
		modify = new MyPictureButton(e.element("modify"));
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		delete = new MyPictureButton(e.element("delete"));
	}

	@Override
	protected void initTextFields(Element e) {}

	@Override
	protected void initLabels(Element e) {
		newType = new MyLabel(e.element("type"));
		newLoc = new MyLabel(e.element("location"));
		title = new MyLabel(e.element("title"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		type = new MyComboBox(e.element("type"));
		location = new MyComboBox(e.element("location"));
		addInstPanel = new AddInstPanel(e.element(addInstPanelStr), changePanel);
		table = new InstTablePanel(e.element("table") , bl);
	}

	@Override
	protected void addCompoment() {
		add(addInst);
		add(table);
		add(type);
		add(location);
		add(modify);
		add(newLoc);
		add(newType);
		add(delete);
		add(confirm);
		add(cancel);
		add(title);
		changePanel.add(addInstPanel, addInstPanelStr);
	}
	
	private void ismodify(boolean flag){
		newLoc.setVisible(flag);
		newType.setVisible(flag);
		type.setVisible(flag);
		location.setVisible(flag);
		title.setVisible(!flag);
		modify.setVisible(!flag);
		isModify = flag;
	}
	
	@Override
	protected void addListener() {
		modify.addMouseListener(new MyPictureButtonListener(modify){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				ismodify(true);
			}
		});
		addInst.addMouseListener(new MyPictureButtonListener(addInst){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				((CardLayout)changePanel.getLayout()).show(changePanel, addInstPanelStr);
				ismodify(false);
			}
		});
		confirm.addMouseListener(new ConfirmListener(confirm) {
			
			@Override
			protected boolean saveToSQL() {
				int temp = table.getSelectedRow();
				if(temp != -1){
					String instid = (String) table.getValueAt(temp, 0);
							
					result = bl.modifyInst(new InstVO(instid, City.toCity((String) location.getSelectedItem()), InstType.toInst((String) type.getSelectedItem())));
					
					if(result == ResultMessage.SUCCESS){
						new TipsDialog("成功修改机构！");
						table.getTable().setValueAt((String) location.getSelectedItem(), temp, 1);
						table.getTable().setValueAt((String) type.getSelectedItem(), temp, 2);
					}
				}
				
				
				return false;
				
			}
			@Override
			protected boolean checkDataValid() {
				return true;
			}

			@Override
			protected void reInitial() {
			}

			@Override
			protected void updateMes() {
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			
			@Override
			public void resetMes() {
				
			}
		});
		delete.addMouseListener(new MyPictureButtonListener(delete){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(table.getSelectedRow() == -1){
					new TipsDialog("请选择一行数据", Color.GREEN);
					return ;
				}else{
					result = bl.delInst((String) table.getValueAt(table.getSelectedRow(), 0));
					if(result == ResultMessage.SUCCESS){
						new TipsDialog("成功删除一条数据" , Color.GREEN);
					}else{
						new TipsDialog("未成功删除数据");
					}
				}
			}
		
		});
	}
	
	
	
	
	
	
	@Override
	protected void initWhitePanels(Element e) {
		
	}

}
