package ui.tools;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
 










import org.dom4j.Element;

import ui.table.MyTablePanel;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
/** 
 * 增加单据的父类
 * 封装其界面跳转
 * @author czq 
 * @version 2015年12月8日 下午7:30:40 
 */
@SuppressWarnings("serial")
public abstract class AddDocPanel extends MyPanel{
	
	protected MyPictureButton confirm;
	protected MyPictureButton cancel;											
	private MyPictureButton back;
	
	private String checkDocPanelStr = "CheckDocPanel";
	private final static String confirmButtonStr = "confirm";
	private final static String cancelButtonStr = "cancel";
	private final static String backButtonStr = "back";
	
	protected MyTablePanel messageTable;
	
	private final JPanel changePanel;
	private final CardLayout panelManager;
	
	public AddDocPanel(Element config , JPanel changePanel , String checkDocPanelStr , MyTablePanel messageTable) {
		super(config);
		this.changePanel = changePanel;
		this.checkDocPanelStr = checkDocPanelStr;
		this.messageTable = messageTable;
		panelManager = (CardLayout) changePanel.getLayout();
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initCommonComp(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
		initalBackListener();
	}
	
	private void jumpToCheck() {
		panelManager.show(changePanel, checkDocPanelStr);
	}
	
	private void initCommonComp(Element e){
		confirm = new MyPictureButton(e.element(CompomentType.BUTTONS.name()).element(confirmButtonStr));
		cancel = new MyPictureButton(e.element(CompomentType.BUTTONS.name()).element(cancelButtonStr));
		back = new MyPictureButton(e.element(CompomentType.BUTTONS.name()).element(backButtonStr));
		add(confirm); add(cancel);add(back);
	}
	
	private void initalBackListener() {
		back.addMouseListener(new MyPictureButtonListener(back){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				jumpToCheck();
			}
		});
	}
	
}
