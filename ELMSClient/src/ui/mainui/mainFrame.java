package ui.mainui;

import javax.swing.JFrame;

import org.dom4j.Element;

import ui.tools.InitalPanel;
import ui.tools.MyFrame;
import util.AccountType;

/**
 * 主界面
 * 
 * @author czq 10-19
 */
@SuppressWarnings("serial")
public class mainFrame extends MyFrame {

	public mainFrame(Element e , AccountType type) {
		super(e);
//		JFrame frame = new JFrame();
//		frame.setSize(1080, 720);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(null);// 不使用布局函数
//		frame.setLocationRelativeTo(null);// 使窗口显示在屏幕正中央

		// frame.setResizable(false);
//		System.out.println("mainframe");
		InitalPanel initalPanel = new InitalPanel();
//		System.out.println("initalpanel");
		this.setContentPane(initalPanel);

		this.setVisible(true);

	}

//	public static void main(String[] args) {
//		mainFrame mf = new mainFrame();
//	}

}
