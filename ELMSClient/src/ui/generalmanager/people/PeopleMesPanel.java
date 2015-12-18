package ui.generalmanager.people;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.StaffType;
import vo.personnel.PersonVO;
import blservice.personnelblservice.Personnelblservice;
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
		
	}
	
	
	
	
	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = new String[COLUMN_NUMS];
		columnNames[0] = "机构ID";
		columnNames[1] = "人员ID";
		columnNames[2] = "姓名";
		columnNames[3] = "职位";
		columnNames[4] = "手机号码";
		
		vos = bl.getPersons();
		
		if (vos == null) {
			return ;
		}
		
		data = new Object[vos.size()][5];
		int i = 0;
		for (PersonVO vo : vos) {
			data[i][0] = vo.instID;
			data[i][1] = vo.ID;
			data[i][2] = vo.name;
			data[i][3] = StaffType.getName(vo.type);
			data[i][4] = vo.phoneNum;
		}
		
		
		
		
	}
	
	
	
	
	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		int[] columnLen = { 30 , 30,  30 , 30 };
		setRowAndColumnLen(30, columnLen);
	}

	
	/**
	 * 搜索结果
	 * @param vo
	 */
	public void  changeMes(ArrayList<PersonVO> vo) {
		if(vo == null){
			return;
		}
		removeAllRows();
		Object[] mes= new Object[5];
		for (PersonVO personVO : vo) {
			mes[0] = personVO.ID ;
			mes [1] = personVO.instID;
			mes [2] = personVO.name;
			mes [3] = StaffType.getName(personVO.type);
			mes [4] = personVO.phoneNum;
			table.getModel().addRow(mes);
		}
		
		
		
		
		
		
	}
	/**
	 * 搜索结果
	 * @param personVO
	 */
	public void  changeMes(PersonVO personVO) {
		if(personVO == null){
			return;
		}
		removeAllRows();
		
			Object[] mes= new Object[5];
			mes[0] = personVO.ID ;
			mes [1] = personVO.instID;
			mes [2] = personVO.name;
			mes [3] = StaffType.getName(personVO.type);
			mes [4] = personVO.phoneNum;
			table.getModel().addRow(mes);
		
		
		
		
		
		
	}
	
	
	
	@Override
	public void updateTableMes() {
		
		
		
		
	}

	

	

}
