package ui.tools;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
 /** 
 * 
 * @author czq 
 * @version 2015年11月25日 下午2:22:03 
 */
@SuppressWarnings("serial")
public class MyOptionPane extends JOptionPane {
	public MyOptionPane(JFrame parent , String message) {
		super(message);
		MyOptionPane.showMessageDialog(parent, message);
	}
	public MyOptionPane(JFrame parent , String message , int chooseType){
//		super(message, messageType);
		super(message, JOptionPane.INFORMATION_MESSAGE, chooseType);
		MyOptionPane.showMessageDialog(parent, message, "" , messageType);
		
	}
	
//	public MyOptionPane(JFrame parent , String message , int messageType , int chooseType){
//		super(message, messageType, chooseType);
//		MyOptionPane.showMessageDialog(parent, message , "提示"  , chooseType,messageType);
//	}
}
