package ui.generalmanager.people;

import java.util.ArrayList;
import java.util.Vector;

import org.dom4j.Element;

import blservice.personnelblservice.Personnelblservice;
import po.personnel.PersonPO;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.personnel.PersonVO;
 /** 
 * 
 * @author czq 
 * @version 2015年12月5日 上午9:24:16 
 */
@SuppressWarnings("serial")
public class PeopleMesPanel extends MyTablePanel{
	
	private static final int COLUMN_NUMS = 5;
	
	private ArrayList<PersonVO> vos;
	
	private Personnelblservice bl;
	
	public PeopleMesPanel(Element config , Personnelblservice bl) {
		super(config);
		this.bl = bl;
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
		
		int[] columnLen = {100,100,100,100 , 200};
		setRowAndColumnLen(30, columnLen);
//		vos = bl.
	}
	
	
	
	
	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = new String[COLUMN_NUMS];
		columnNames[0] = "机构ID";
		columnNames[1] = "人员ID";
		columnNames[2] = "姓名";
		columnNames[3] = "职位";
		columnNames[4] = "手机号码";
		
		
		
	}
	
	
	
	
	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		int[] columnLen = { 30 , 30,  30 , 30 };
		setRowAndColumnLen(30, columnLen);
	}

	
	/**
	 * 更新信息
	 * @param vo
	 */
	public void  changeMes(ArrayList<PersonVO> vo) {
		if(vo == null){
			return;
		}
		
		Object[] mes= new Object[5];
		for (PersonVO personVO : vo) {
			mes[0] = personVO.ID ;
			mes [1] = personVO.instID;
			mes [2] = personVO.name;
			mes [3] = personVO.type.name();
			mes [4] = personVO.phoneNum;
			table.getModel().addRow(mes);
		}
		
		
		
		
		
		
	}
	public void  changeMes(PersonVO personVO) {
		if(personVO == null){
			return;
		}
		
			Object[] mes= new Object[5];
			mes[0] = personVO.ID ;
			mes [1] = personVO.instID;
			mes [2] = personVO.name;
			mes [3] = personVO.type.name();
			mes [4] = personVO.phoneNum;
			table.getModel().addRow(mes);
		
		
		
		
		
		
	}
	
	
	
	@Override
	public void updateTableMes() {
		
		
		
		
	}

	

	

}
