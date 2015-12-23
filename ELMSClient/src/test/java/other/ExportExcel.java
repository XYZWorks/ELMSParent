package test.java.other;

import java.io.File;
import java.io.IOException;

import bl.storebl.StoreController;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import util.ResultMessage;
import vo.store.StoreMessageVO;
import vo.store.StoreShowVO;

/**
 * @author ymc
 * @version 创建时间：2015年12月23日 下午5:30:20
 *
 */
public class ExportExcel {
	
	final static String PRE = "excel//";
	final static String post = ".xls";
	final static int COLUMN = 5;
	public static ResultMessage exportExcel(String path,StoreShowVO storevo) {
		try {
			
			WritableWorkbook book = Workbook.createWorkbook(new File(PRE+path+post));
			WritableSheet sheet = book.createSheet("库存盘点", 0);
			
			for(int i = 0 ;i<COLUMN;i++)
				sheet.setColumnView(i, 20);
			sheet.mergeCells(0, 0, COLUMN, 0);
			sheet.setRowView(0, 500);
			
			Label title = new Label(0, 0, "库存盘点");
			Label center = new Label(0,1,"中转中心："+storevo.location.getName());
			Label store = new Label(2,1,"仓库区："+storevo.storeLoc.getStoreLocation());
			Label num = new Label(4,1,"库存数量："+storevo.number);
			
			Label l1 = new Label(0, 2, "当前库存订单");
			Label l2 = new Label(1, 2, "对应位置信息");
			Label l3 = new Label(2, 2, "当天生成入库单");
			Label l4 = new Label(3,2,"当天生成出库单");
			
			sheet.addCell(title);
			sheet.addCell(center);
			sheet.addCell(store);
			sheet.addCell(num);
			sheet.addCell(l1);
			sheet.addCell(l2);
			sheet.addCell(l3);
			sheet.addCell(l4);
			
			for (int i = 0; i < storevo.orders.size(); i++) {
				Label tmp = new Label(0,i+3,storevo.orders.get(i));
				sheet.addCell(tmp);
			}
			for (int i = 0; i < storevo.locs.size(); i++) {
				Label tmp = new Label(1,i+3,storevo.locs.get(i));
				sheet.addCell(tmp);
			}
			for (int i = 0; i < storevo.inStoreDocs.size(); i++) {
				Label tmp = new Label(2,i+3,storevo.inStoreDocs.get(i));
				sheet.addCell(tmp);
			}
			for (int i = 0; i < storevo.outStoreDocs.size(); i++) {
				Label tmp = new Label(3,i+3,storevo.outStoreDocs.get(i));
				sheet.addCell(tmp);
			}
			book.write();
			book.close();
			return ResultMessage.SUCCESS;
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public static void main(String[] args) {
		StoreController tmp = new StoreController();
		StoreMessageVO vo = tmp.show().get(0);
		tmp.exportExcel("1",vo );
	}

}
