package ui.tools;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.dom4j.Element;
 /** 
 * 带有滚动条的面板
 * @author czq 
 * @version 2015年12月6日 下午1:49:57 
 */
@SuppressWarnings("serial")
public abstract class MyPanelWithScroller extends JScrollPane {
	//在有需要的时候 直接将scrollerpane和panel绑定在一起
	private JPanel panel;
	
	public MyPanelWithScroller(Element config) {
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(Integer.parseInt(config.attributeValue("x")) , Integer.parseInt(config.attributeValue("y")) , Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height")));
		panel.setPreferredSize(new Dimension(Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height"))));
		
		this.getViewport().add(panel);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	
	/**
	 * 重写增加方法，统一加到 panel里面
	 */
	@Override
	public Component add(Component component){
		return panel.add(component);
	}
	

	/**
	 * 初始化 若干 白色矩形panel
	 */
	protected abstract void initWhitePanels(Element e);
	
	/**
	 * 初始化按钮
	 */
	protected abstract void initButtons(Element e);
	/**
	 * 初始化文本域
	 */
	protected abstract void initTextFields(Element e);
	/**
	 * 初始化标签
	 */
	protected abstract void initLabels(Element e);
	/**
	 * 初始化其他组件
	 */
	protected abstract void initOtherCompoment(Element e);
	/**
	 * 将组件加到面板上去
	 */
	protected abstract void addCompoment();
	
	/**
	 * 增加监听（内部类机制）
	 */
	protected abstract void addListener();
}
