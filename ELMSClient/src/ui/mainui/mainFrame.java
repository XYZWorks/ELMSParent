package ui.mainui;

import javax.swing.JFrame;
import ui.tools.InitalPanel;

/**
 * 主界面
 * 
 * @author czq 10-19
 */
public class mainFrame extends JFrame {

	public mainFrame() {

		JFrame frame = new JFrame();
		frame.setSize(1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);// 不使用布局函数
		frame.setLocationRelativeTo(null);// 使窗口显示在屏幕正中央

		// frame.setResizable(false);
		System.out.println("mainframe");
		InitalPanel initalPanel = new InitalPanel();
		System.out.println("initalpanel");
		frame.setContentPane(initalPanel);

		frame.setVisible(true);

	}

	public static void main(String[] args) {
		mainFrame mf = new mainFrame();
	}

}
