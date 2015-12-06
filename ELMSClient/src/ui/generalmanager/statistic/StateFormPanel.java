package ui.generalmanager.statistic;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.statisticblservice.Statisticblservice;
import ui.table.MyTablePanel;
import util.MyDate;
import vo.statistic.StateFormVO;
 /** 
 * 经营状况表,显示开始日期和结束日期以及序号
 * @author czq 
 * @version 2015年12月6日 上午11:33:45 
 */
@SuppressWarnings("serial")
public class StateFormPanel extends MyTablePanel{
	
	private Statisticblservice bl;
	
	private ArrayList<StateFormVO> vos;
	
	private final static int COLUMN_NUM = 4;
	
	public StateFormPanel(Element config , Statisticblservice bl) {
		super(config);
		this.bl = bl;
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = config.attributeValue("column").split(" ");
		
		vos = bl.getStateForm();
		
		StateFormVO vo;
		if(vos!= null){
			
			for (int i = 0; i < vos.size(); i++) {
				vo = vos.get(i);
				
				data[i][0] = MyDate.toString(vo.startDate);
				data[i][1] = MyDate.toString(vo.endDate);
				data[i][2] = vo.pays;
				
			}
			
			
		}
		
		
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		
	}

}
