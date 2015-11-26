package ui.inital;

import javax.swing.JFrame;

import org.dom4j.Element;

import ui.tools.MyFrame;
import ui.tools.MyPanel;
import util.AccountType;

/**
 * 构建mainframe主框架
 * 
 * @author czq 10-19
 */

@SuppressWarnings("serial")
public class mainFrame extends MyFrame {
	
	
	/**
	 * 
	 * @param e
	 * @param type 用户类型
	 */
	public mainFrame(Element e , AccountType type) {
		super(e);

		InitalPanel initalPanel = new InitalPanel();

		this.setContentPane(initalPanel);

		this.setVisible(true);

	}
}
