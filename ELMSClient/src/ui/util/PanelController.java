package ui.util;

import java.awt.CardLayout;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.MyPanel;
 /** 
 * 界面跳转控制器父类
 * @author czq 
 * @version 2015年11月26日 下午3:08:33 
 */
public abstract class PanelController {
	/**
	 * 全局panel
	 */
	protected MyPanel mainPanel;
//	/**
//	 * 左边条
//	 */
//	protected MyPanel leftBar;
	/**
	 * 中间将要更改的panel
	 */
	protected JPanel changePanel;
	/**
	 * 布局管理器
	 */
	protected CardLayout panelManager;
	
	public PanelController(MyPanel initialPanel , Element root) {
		super();
		this.mainPanel = initialPanel;
		initial(root);
		
		
	}
	
	private void initial(Element e){
		panelManager = new CardLayout();
		this.changePanel = new JPanel(panelManager);
		changePanel.setBounds(Integer.parseInt(e.attributeValue("x")),
				Integer.parseInt(e.attributeValue("y")),
				Integer.parseInt(e.attributeValue("width")),
				Integer.parseInt(e.attributeValue("height")));
		this.mainPanel.add(changePanel);
	}
	
	/**
	 * 向panel上左侧栏的Buttons
	 */
	protected abstract void addButtons();
	/**
	 * 增加panel
	 */
	protected abstract void addPanels();
	/**
	 * 增加监听，将按钮与panel联系起来
	 */
	protected abstract void addListeners();
	
	
}
