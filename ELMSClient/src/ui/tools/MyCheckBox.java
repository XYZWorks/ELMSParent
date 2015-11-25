package ui.tools;

import javax.swing.JCheckBox;
 /** 
 * 
 * @author czq 
 * @version 2015年11月22日 下午11:25:50 
 */
@SuppressWarnings("serial")
public class MyCheckBox extends JCheckBox{
	public MyCheckBox() {
		this.setOpaque(true);
		this.setVisible(true);
	}

	public MyCheckBox(int x1, int x2, int y1,  int y2) {
		this.setBounds(x1 , y1 , x2 - x1 , y2 - y1);
		this.setVisible(true);
	}
}
