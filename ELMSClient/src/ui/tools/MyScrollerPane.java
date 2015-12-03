package ui.tools;

import javax.swing.JScrollPane;

import ui.table.MyTable;
 /** 
 * 
 * @author czq 
 * @version 2015年11月22日 下午11:26:47 
 */
@SuppressWarnings("serial")
public class MyScrollerPane extends JScrollPane {
	
	public MyScrollerPane(MyTable table) {
		super(table);
	}
}
