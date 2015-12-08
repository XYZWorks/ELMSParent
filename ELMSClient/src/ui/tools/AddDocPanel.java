package ui.tools;

import java.awt.CardLayout;

import javax.swing.JPanel;
 







import org.dom4j.Element;

import ui.util.CompomentType;
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
	
	private final static String checkDocPanelStr = "CheckDocPanel";
	
	private final JPanel changePanel;
	private final CardLayout panelManager;
	
	public AddDocPanel(Element config , JPanel changePanel) {
		super(config);
		this.changePanel = changePanel;
		panelManager = (CardLayout) changePanel.getLayout();
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
	}
	
	protected final void jumpToCheck() {
		panelManager.show(changePanel, checkDocPanelStr);
	}
	
	
	
	
}
