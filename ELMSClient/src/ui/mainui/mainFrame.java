package ui.mainui;

import javax.swing.JFrame;
import ui.tools.initalPanel;


/**
 * 主界面
 * @author czq
 * 10-19
 */
public class mainFrame extends JFrame{

	public mainFrame() {
		
		JFrame frame = new JFrame();
		frame.setSize(1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);//不使用布局函数
		frame.setLocationRelativeTo(null);//使窗口显示在屏幕正中央
		frame.setVisible(true);
		
		//frame.setResizable(false);	
		System.out.println("mainframe");
		initalPanel initalPanel=new initalPanel();
		System.out.println("initalpanel");
		frame.setContentPane(initalPanel);

		}
		
	 public static void main(String[] args){
		 mainFrame mf=new mainFrame();
	}
	
}
