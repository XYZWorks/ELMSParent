package ui.table;

//import javax.swing.table.AbstractTableModel;
//import javax.swing.*;
//
//import java.awt.*;
//import java.awt.event.*;
//
//public class TableModel1 {
//	public TableModel1() {
//		JFrame f = new JFrame();
//		MyTable mt = new MyTable();
//		JTable t = new JTable(mt);
//		t.setPreferredScrollableViewportSize(new Dimension(300, 30));
//		JScrollPane s = new JScrollPane(t);
//		f.getContentPane().add(s, BorderLayout.CENTER);
//		f.setTitle("JTable1");
//		f.pack();
//		f.setVisible(true);
//		f.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
//	}
//
//	public static void main(String args[]) {
//		new TableModel1();
//	}
//}
//
//@SuppressWarnings("serial")
//class MyTable extends AbstractTableModel {
//	Object[][] p = {
//			{ "阿呆", new Integer(66), new Integer(32), new Integer(98),
//					new Boolean(false), new Boolean(false) },
//			{ "阿瓜", new Integer(85), new Integer(69), new Integer(154),
//					new Boolean(true), new Boolean(false) }, };
//	String[] n = { "姓名", "语文", "数学", "总分", "及格", "作弊" };
//
//	public int getColumnCount() {
//		return n.length;
//	}
//
//	public int getRowCount() {
//		return p.length;
//	}
//
//	public String getColumnName(int col) {
//		return n[col];
//	}
//
//	public Object getValueAt(int row, int col) {
//		return p[row][col];
//	}
//
//	public Class getColumnClass(int c) {
//		return getValueAt(0, c).getClass();
//	}
//}