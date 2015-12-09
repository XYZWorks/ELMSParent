package ui.tools;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.table.MyTablePanel;
import ui.util.MyPictureButtonListener;
 /** 
 * 所有单据查看的界面 
 * 因为所有单据的增加、查看有极大的相似性，基本上分为查看和增加两个界面
 * 这个父类将实现封装界面跳转、预声明部分组件,并完成一些共有组件：搜索框、日历、按钮的初始化、增加工作
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
	
	protected String checkDocPanelStr;
	protected String addDocPanelStr;
	protected final static String searchBoxStr = "search";
	protected final static String tableStr = "table";
	protected final static String datePickerStr = "datepicker";
	protected final static String addDocButtonStr = "addDoc";
	
	
	/**
	 * 增加订单的界面
	 */
	protected AddDocPanel addDocPanel;
	
	protected final JPanel changePanel;
	protected final CardLayout panelManager;
	
	public CheckDocPanel(Element config , JPanel changePanel , String checkDocName , String addDocName) {
		super();
		this.setBounds(Integer.parseInt(config.attributeValue("x")) , Integer.parseInt(config.attributeValue("y")) , Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height")));;
		this.changePanel = changePanel;
		panelManager = (CardLayout) changePanel.getLayout();
		checkDocPanelStr = checkDocName;
		addDocPanelStr = addDocName;
		
		
		initialAddDocPanelAndTable(config);
		initialCommonComp(config);
		initialDifferComp(config);
		addCommonComp();
		addDifferComp();
		addListener();
		changePanel.add(addDocPanel, addDocPanelStr);
		panelManager.show(changePanel, checkDocPanelStr);
	}
	
	
	protected final void jumpToADD() {
		panelManager.show(changePanel, addDocPanelStr);
	}
	
	/**
	 * 初始化增加订单界面、表格
	 */
	protected abstract void initialAddDocPanelAndTable(Element e);
	
	/**
	 * 初始化其他非共有的组件
	 * @param e
	 */
	protected abstract void initialDifferComp(Element e) ;
	
	/**
	 * 初始化共有的组件
	 * @param e
	 */
	private void initialCommonComp(Element e){
		searchBox = new MySerachBox(e.element(searchBoxStr));
		datePicker = new MyDatePicker(e.element(datePickerStr));
		addDoc = new MyPictureButton(e.element(addDocButtonStr));
		
		
	}
	
	private void addCommonComp(){
		add(searchBox);add(datePicker);add(addDoc);
		add(addDocPanel);add(messageTable);
	}
	
	/**
	 * 填充组件
	 */
	protected abstract void addDifferComp();
	/**
	 * 增加监听
	 */
	protected void addListener(){
		addDoc.addMouseListener(new MyPictureButtonListener(addDoc){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				jumpToADD();
			}
		});
	}
}
