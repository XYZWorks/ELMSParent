package ui.tools;

import javax.swing.JFrame;

import org.dom4j.Element;
 /** 
 * 所有Frame父类
 * @author czq 
 * @version 2015年11月22日 下午11:50:38 
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame{

	
	public MyFrame(Element config) {
		super();
		//除去边框
		this.setUndecorated(true);
		this.setSize(Integer.parseInt(config.attributeValue("width")), Integer.parseInt(config.attributeValue("height")));
		this.setLayout(null);
		this.setResizable(false);
		//居中放置
		this.setLocationRelativeTo(null);
		
		
	}
	
	//TODO 实现拖动界面
	
}
