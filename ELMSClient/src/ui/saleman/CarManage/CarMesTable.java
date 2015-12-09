package ui.saleman.CarManage;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.DTManageblservice.DTManageblservice;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import ui.table.MyTablePanel;
import vo.DTManage.CarVO;
 /** 
 * 
 * @author czq 
 * @version 2015年12月8日 下午8:26:14 
 */
@SuppressWarnings("serial")
public class CarMesTable extends MyTablePanel{
	
	DTManageblservice bl;
	
	ArrayList<CarVO> vos;
	
	public CarMesTable(Element config , DTManageblservice bl) {
		super(config);
		this.bl = bl;
	}
	
	
	
	
	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
//		vos = bl.
//		
		
		
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		
	}

}
