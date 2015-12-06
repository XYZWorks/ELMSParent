package ui.tools;

import java.awt.Dimension;

import javax.swing.JScrollPane;

import ui.courier.AddOrderPanel;
import ui.table.MyTable;
 /** 
 * 
 * @author czq 
 * @version 2015年11月22日 下午11:26:47 
 */
@SuppressWarnings("serial")
public class MyScrollerPane extends JScrollPane {
	
	public MyScrollerPane(MyPanel itPanel) {
		super(itPanel);
		//设置的初始化
		itPanel.setPreferredSize(new Dimension(848,752));
	}
}
