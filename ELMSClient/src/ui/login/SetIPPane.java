package ui.login;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.StaticMessage;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月27日 下午3:18:45 
 *
 */
public class SetIPPane extends JOptionPane {
	
	final static String pre = "请输入IP地址：";
	
	public SetIPPane(JFrame parent) {
		super(pre);
		handleIP(parent);
	}

	private void handleIP(JFrame parent) {
		String ip = SetIPPane.showInputDialog(parent,pre);
		if(ip!=null&&!ip.equals("")){
			System.out.println(ip);
			StaticMessage.setPort(ip);
			
			System.out.println(StaticMessage.RMIPres);
		}
		
	}

	
	

	

}
