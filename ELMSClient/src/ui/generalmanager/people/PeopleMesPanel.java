package ui.generalmanager.people;

import java.awt.Color;
import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.util.TipsDialog;
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
	
	Personnelblservice bl;
	
	public PeopleMesPanel(Element config , int flag) {
		super(config);
		
		
	}
	/**
	 * 用于期初建账界面
	 * @param config
	 */
	public PeopleMesPanel(Element config ) {
		super(config);
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
		
		if(bl != null){
			vos = bl.getPersons();
		}
		
		
		if (vos == null) {
			vos = new ArrayList<>();
			return ;
		}
		
		data = new Object[vos.size()][5];
		int i = 0;
		for (PersonVO vo : vos) {
			data[i][0] = vo.instID;
			data[i][1] = vo.ID;
			data[i][2] = vo.name;
			data[i][3] = vo.type.getName();
			data[i][4] = vo.phoneNum;
			i++;
		}
		
		
		
		
	}
	/**
	 * 这里如果type为2，表示修改一条数据
	 */
	@Override
	public void addOneData(Object o, int type) {
		PersonVO vo = (PersonVO) o;
		if(type == 0){
			vos.add(vo);
			showAllMessages();
		}else if(type == 1){
			String[] temp = new String[5];
			temp[0] = vo.instID;
			temp[1] = vo.ID;
			temp[2] = vo.name;
			temp[3] = vo.type.getName();
			temp[4] = vo.phoneNum;
			addOneRow(temp);
		}else{
			for (int i = 0 ; i < vos.size() ; i++)  {
				if(vos.get(i).ID.equals(vo.ID)){
					vos.set(i, vo);
				}
			}
			showAllMessages();
		}
		
	}
	@Override
	public void searchID(String id) {
		removeAllRows();
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).ID.equals(id)){
				addOneData(vos.get(i) , 1);
				new TipsDialog("成功找到一条信息", Color.GREEN);
				return;
			}
		}
		new TipsDialog("未找到任何一条信息");
	}
	public void searchInstID(String instid){
		removeAllRows();
		int count = 0;
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).instID.equals(instid)){
				addOneData(vos.get(i) , 1);
				count++;
			}
		}
		if(count > 0){
			new TipsDialog("成功找到" + count + "条信息", Color.GREEN);
		}else{
			new TipsDialog("未找到任何一条信息");
		}
	}
	public void searchName(String  name) {
		removeAllRows();
		ArrayList<PersonVO> vos = bl.getPeopleByName(name);
		int count = 0;
		for (PersonVO personVO : vos) {
			addOneData(personVO , 1);
			count++;
			
		}
		if(count > 0){
			new TipsDialog("成功找到" + count + "条信息", Color.GREEN);
		}else{
			new TipsDialog("未找到任何一条信息");
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
			mes [3] = personVO.type.getName();
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
			mes[0] = personVO.instID ;
			mes [1] = personVO.ID;
			mes [2] = personVO.name;
			mes [3] = personVO.type.getName();
			mes [4] = personVO.phoneNum;
			table.getModel().addRow(mes);
		
		
		
		
		
		
	}
	@Override
	public void showAllMessages() {
		removeAllRows();
		for (int i = 0; i < vos.size(); i++) {
			addOneData(vos.get(i), 1);
		}
	}
	
	
	@Override
	public void updateTableMes() {
		
		
		
		
	}



	
	
}
