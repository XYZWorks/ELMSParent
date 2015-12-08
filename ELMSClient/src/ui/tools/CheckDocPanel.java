package ui.tools;

import java.awt.CardLayout;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.table.MyTablePanel;
 /** 
 * 所有单据查看的界面 
 * 因为所有单据的增加、查看有极大的相似性，基本上分为查看和增加两个界面
 * 这个父类将实现封装界面跳转、预声明部分组件
 * @author czq 
 * @version 2015年12月8日 下午7:25:52 
 */
@SuppressWarnings("serial")
public abstract class CheckDocPanel extends JPanel{
	/**
	 * 搜索框
	 */
	protected MySerachBox searchBox;
	/**
	 * 日期选择器
	 */
	protected MyDatePicker datePicker;
	/**
	 * 增加单据、信息按钮
	 */
	protected MyPictureButton addDoc;
	/**
	 * 信息表格
	 */
	protected MyTablePanel messageTable;
	
	private final static String checkDocPanelStr = "CheckDocPanel";
	private final static String addDocPanelStr = "AddDocPanel";
	/**
	 * 增加订单的界面
	 */
	protected AddDocPanel addDocPanel;
	
	protected final JPanel changePanel;
	protected final CardLayout panelManager;
	
	public CheckDocPanel(Element config , JPanel changePanel) {
		super();
		this.setBounds(Integer.parseInt(config.attributeValue("x")) , Integer.parseInt(config.attributeValue("y")) , Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height")));;
		this.changePanel = changePanel;
		panelManager = (CardLayout) changePanel.getLayout();
		initialAddDocPanel(config.element(addDocPanelStr));
		initialOtherComp(config);
		addComp();
		changePanel.add(addDocPanel, addDocPanelStr);
		panelManager.show(changePanel, checkDocPanelStr);
	}
	
	
	protected final void jumpToADD() {
		panelManager.show(changePanel, addDocPanelStr);
	}
	
	/**
	 * 初始化增加订单界面
	 */
	protected abstract void initialAddDocPanel(Element e);
	/**
	 * 初始化其他组件
	 * @param e
	 */
	protected abstract void initialOtherComp(Element e);
	/**
	 * 填充组件
	 */
	protected abstract void addComp();
	/**
	 * 增加监听
	 */
	protected abstract void addListener();
}
