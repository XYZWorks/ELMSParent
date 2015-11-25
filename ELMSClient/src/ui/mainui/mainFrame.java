package ui.mainui;

import javax.swing.JFrame;

import org.dom4j.Element;

import ui.tools.InitalPanel;
import ui.tools.MyFrame;
import ui.tools.MyPanel;
import util.AccountType;

/**
 * 主界面
 * 
 * @author czq 10-19
 */
<<<<<<< Updated upstream
@SuppressWarnings("serial")
public class mainFrame extends MyFrame {
	
//	private MyPanel panel;
	
	
	
	/**
	 * 
	 * @param e
	 * @param type 用户类型
	 */
	public mainFrame(Element e , AccountType type) {
		super(e);

		InitalPanel initalPanel = new InitalPanel();
=======
public class mainFrame extends JFrame {

	public mainFrame() {

		JFrame frame = new JFrame();
		frame.setSize(1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);// 不使用布局函数
		frame.setLocationRelativeTo(null);// 使窗口显示在屏幕正中央
		
		//frame.setUndecorated(true);//窗口无边缘
		
		// frame.setResizable(false);//鼠标拖动无法改变窗口大小
		System.out.println("mainframe");
		InitalPanel initalPanel = new InitalPanel();
		System.out.println("initalpanel");
		frame.setContentPane(initalPanel);//容易遗漏的一点！ 
>>>>>>> Stashed changes

		this.setContentPane(initalPanel);

		this.setVisible(true);

	}



}
