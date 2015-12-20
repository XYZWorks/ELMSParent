package ui.financeman.costManage;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.financeblservice.CostService;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.CostType;
import util.MyDate;
import vo.finance.CostVO;
import vo.finance.FreightVO;
import vo.finance.RentVO;
import vo.finance.SalaryVO;
 /** 
 * 运费信息表格
 * @author czq 
 * @version 2015年12月18日 下午8:57:14 
 */
@SuppressWarnings("serial")
public class CostMesTable extends MyTablePanel {
	
	private CostService costService;
	private  CostType type;
	private final static String[] titlesForFrieght = {"ID" , "成本类型" , "创建时间" , "结束时间" , "金额"};
	private final static String[] titlesForSalary = {"ID" , "成本类型" , "创建时间" , "结束时间" , "金额" , "人员类型"};
	private final static String[] titlesForRent = {"ID" , "成本类型" , "创建时间" , "结束时间" , "金额"};
	private ArrayList<? extends CostVO> vos;
	
	
	
	public CostMesTable(Element config, CostType type, CostService costService) {
		super(config);
		this.costService = costService;
		this.type = type;
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		add(rollpane);
		
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		vos = costService.showCosts(type);
		if(type == CostType.FREIGHT){
			columnNames = titlesForFrieght;
			
			
			if(vos != null && vos.size() != 0){
				data = new String[vos.size()][columnNames.length];
				FreightVO vo;
				for (int i = 0; i < vos.size(); i++) {
					vo = (FreightVO) vos.get(i);
					data[i][0] = vo.ID;
					data[i][1] = vo.costType.getName();
					data[i][2] = MyDate.toString(vo.startDate);
					data[i][3] = MyDate.toString(vo.endDate);
					data[i][4] = String.valueOf(vo.money);
					
				}
				
			}
			
			
		}else if(type == CostType.RENT){
			columnNames = titlesForRent;
			
			if(vos != null && vos.size() != 0){
				data = new String[vos.size()][columnNames.length];
				RentVO vo;
				for (int i = 0; i < vos.size(); i++) {
					vo = (RentVO) vos.get(i);
					data[i][0] = vo.ID;
					data[i][1] = vo.costType.getName();
					data[i][2] = MyDate.toString(vo.startDate);
					data[i][3] = MyDate.toString(vo.endDate);
					data[i][4] = String.valueOf(vo.money);
					
				}
				
			}
			
			
		}else if(type == CostType.SALARY){
			columnNames = titlesForSalary;
			
			if(vos != null && vos.size() != 0){
				data = new String[vos.size()][columnNames.length];
				SalaryVO vo;
				for (int i = 0; i < vos.size(); i++) {
					vo = (SalaryVO) vos.get(i);
					data[i][0] = vo.ID;
					data[i][1] = vo.costType.getName();
					data[i][2] = MyDate.toString(vo.startDate);
					data[i][3] = MyDate.toString(vo.endDate);
					data[i][4] = String.valueOf(vo.money);
					data[i][5] = vo.worker;
				}
				
			}
			
			
		}
		
		
		
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		

	}
	
	
}
