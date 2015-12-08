package ui.storeman.arrivezz;

import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;

import org.dom4j.Element;

import blservice.accountblservice.Accountblservice;
import blservice.transportblservice.Transportblservice;
import blservice.transportblservice.transportblservice_Driver;
import ui.config.GraphicsUtils;
import ui.config.UserfulMethod;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.DocType;
import util.MyDate;
import vo.account.AccountVO;
import vo.transport.ArriveZZDocVO;

/**
 * @author ymc
 * @version 创建时间：2015年12月5日 上午9:20:32
 *
 */
public class ArriveZZTablePanel extends MyTablePanel {

	private static final int COLUMN_NUM = 7;

	private Transportblservice bl;

	private ArrayList<ArriveZZDocVO> vos;

	public ArriveZZTablePanel(Element config, Transportblservice bl, MyDate date) {
		super(config);
		this.bl = bl;
		initialTitleAndColumn(config, date);
		initTable();
		initScrollerPane();
		this.add(rollpane);
		int[] columnLen = { 50, 140, 60, 40, 40,40,330};
		this.setRowAndColumnLen(30, columnLen);
	}

	@Override
	protected void initialTitleAndColumn(Element config,MyDate date) {
		columnNames = getColumnName(config.attributeValue("columnName"));
		
		vos = bl.getDayArriveZZDocs(date);
		data = new String[vos.size()][COLUMN_NUM];
		ArriveZZDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			data[i][0] = DocType.getName(vo.type);
			data[i][1] = vo.ID;
			data[i][2] = MyDate.toString(vo.date);
			data[i][3] = vo.zZID;
			data[i][4] = vo.sendCity.getName();
			data[i][5] = vo.goodState.getName();
			data[i][6] = UserfulMethod.orderArrayToString(vo.orderBarCodes);
		}

	}

	
	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		table.setBounds(0, 0, 500,700);
//		setRowAndColumnLen(rowLen, columnLen);
		table.setFont(GraphicsUtils.getFont(null));

	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}

}
