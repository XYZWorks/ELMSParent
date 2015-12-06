package ui.generalmanager.institution;

import java.awt.CardLayout;
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
	
	private MyComboBox type;
	private MyComboBox location;
	
	public InstManagePanel(Element config , JPanel changePanel , Personnelblservice bl) {
		super(config);
		this.bl = bl;
		this.changePanel = changePanel;
		initLables(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
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
	protected void initLables(Element e) {
		newType = new MyLabel(e.element("type"));
		newLoc = new MyLabel(e.element("location"));
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
		changePanel.add(addInstPanel, addInstPanelStr);
	}

	@Override
	protected void addListener() {
		modify.addMouseListener(new MyPictureButtonListener(modify) {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
			}
		});
		addInst.addMouseListener(new MyPictureButtonListener(addInst){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				((CardLayout)changePanel.getLayout()).show(changePanel, addInstPanelStr);
			}
		});
		confirm.addMouseListener(new ConfirmListener(confirm) {
			
			@Override
			protected void saveToSQL() {
				
			}
			
			@Override
			protected boolean checkDataValid() {
				return false;
			}

			@Override
			protected void reInitial() {
				// TODO Auto-generated method stub
				
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			
			@Override
			public void resetMes() {
				
			}
		});
		
	}
	
	
	
	
	
	
	@Override
	protected void initWhitePanels(Element e) {
		
	}

}
