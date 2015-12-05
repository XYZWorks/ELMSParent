package ui.table;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import ui.user.MyTableModel;
 /** 
 * 
 * @author czq 
 * @version 2015年12月3日 下午2:39:41 
 */
public class TableTest extends JFrame{
	
	private MyTable table;
	
	public TableTest() {
		this.setSize(400, 500);
		
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initTable();
//		this.getContentPane().setLayout(null);
		table.setPreferredScrollableViewportSize(new Dimension(300, 30));
		JScrollPane pane = new JScrollPane(table);
		this.getContentPane().add(pane);
		this.setVisible(true);
		
	}
	
	private void initTable(){
		
		Object[] headers = {"姓名" , "学号"  , "年级"  , "是否团员"  } ;
		Object[][] data = {
				{"czq" ,"233"  , "2" ,new Boolean(true)},
				{"caq" ,"233"  , "2" ,new Boolean(false)},
				{"c2q" ,"233"  , "2" ,new Boolean(true)},
				{"cza" ,"233"  , "2" ,new Boolean(false)},
				{"c1q" ,"233"  , "2" ,new Boolean(true)},
				{"czq" ,"233"  , "2" ,new Boolean(true)},
				{"caq" ,"233"  , "2" ,new Boolean(false)},
				{"c2q" ,"233"  , "2" ,new Boolean(true)},
				{"cza" ,"233"  , "2" ,new Boolean(false)},
				{"czq" ,"233"  , "2" ,new Boolean(true)},
				{"caq" ,"233"  , "2" ,new Boolean(false)},
				{"c2q" ,"233"  , "2" ,new Boolean(true)},
				{"cza" ,"233"  , "2" ,new Boolean(false)},
				{"czq" ,"233"  , "2" ,new Boolean(true)},
				{"caq" ,"233"  , "2" ,new Boolean(false)},
				{"c2q" ,"233"  , "2" ,new Boolean(true)},
				{"cza" ,"233"  , "2" ,new Boolean(false)},
				{"czq" ,"233"  , "2" ,new Boolean(true)},
				{"caq" ,"233"  , "2" ,new Boolean(false)},
				{"c2q" ,"233"  , "2" ,new Boolean(true)},
				{"cza" ,"233"  , "2" ,new Boolean(false)},
				{"c2q" ,"233"  , "2" ,new Boolean(true)},
				{"cza" ,"233"  , "2" ,new Boolean(false)},
				{"czq" ,"233"  , "2" ,new Boolean(true)},
				
				
		};
		
		MyTableModel model = new MyTableModel(headers, data);
		
		table = new MyTable(model);
		table.setBounds(0, 100, 200, 200);
		
		table.setColEditable(true, 3);;
	}
	
	public static void main(String[] args) {
		new TableTest();
	}
	
}
