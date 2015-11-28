package ui.tools;

import java.awt.Graphics;

import javax.swing.JPanel;

import org.dom4j.Element;
 /** 
 * panel 父类
 * @author czq 
 * @version 2015年11月22日 下午8:25:12 
 */
@SuppressWarnings("serial")
public abstract class MyPanel extends JPanel{
	
	public MyPanel(Element config) {
		this.setLayout(null);
		this.setBounds(Integer.parseInt(config.attributeValue("x")) , Integer.parseInt(config.attributeValue("y")) , Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height")));
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
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
	protected abstract void initLables(Element e);
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
