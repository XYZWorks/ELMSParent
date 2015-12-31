package ui.initial;

import org.dom4j.Element;

import ui.tools.MyFrame;
import vo.account.AccountVO;

/**
 * 主界面
 * 
 * @author czq 10-19
 */

@SuppressWarnings("serial")
public class mainFrame extends MyFrame {
	
//	private MyPanel panel;
	
	/**
	 * 
	 * @param e
	 * @param vo 用户类型
	 */
	public mainFrame(Element e , AccountVO vo) {
		super(e);
		
		
		/**
		 * 整个过程中不动的界面，底色
		 */
		InitialPanel initalPanel = new InitialPanel(e.element("initialpanel") , this , vo);

		this.setContentPane(initalPanel);

		this.setVisible(true);

	}


}
