package ui.common;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import main.AXIS;

import org.dom4j.Element;

import ui.tools.MyFrame;
import ui.util.TipsDialog;

/**
*
*@author:xingcheng
*@version 2015年12月9日
*/
@SuppressWarnings("serial")
public class CommonFrame extends MyFrame{
	private MyFrame frame;
	private static String[] choices = {"退出系统" , "注销" , "取消"};
	public CommonFrame(Element config) {
		super(config);
		frame = this;
		TipsDialog.setFrame(this);
		CommonInitalPanel inital =new CommonInitalPanel(config.element("commonInitalPanel"),this);
		
		this.setContentPane(inital);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showOptionDialog(frame, "确认退出？","系统提示",
						JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE , null , choices , null);
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.NO_OPTION){
					frame.dispose();
					new AXIS();
				}else{
					return;
				}
			}
		});
	}
//	public static void main(String[] args) {
//		//
//		ParseXML xmlReader = new ParseXML("xc.xml");
//		new CommonFrame(xmlReader.getConfig("commonFrame"));
//	}	
//	
}
