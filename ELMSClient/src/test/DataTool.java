package test;

import java.util.ArrayList;

import util.Date;
import util.DocType;
import util.GoodsState;
import vo.ArriveYYDocVO;
import vo.ArriveZZDocVO;
import vo.CarVO;
import vo.DocVO;
import vo.DriverVO;
import vo.InStoreDocVO;
import vo.LoadDocVO;
import vo.OrderVO;
import vo.OutStoreDocVO;
import vo.SendGoodDocVO;
import vo.TransferDocVO;

/**
 * @author ymc
 * @version 创建时间：2015年11月15日 上午10:37:13
 *
 */
public class DataTool {
	static Date d1 = new Date(2015, 11, 11);
	static Date d2 = new Date(2015, 11, 12);
	static Date d3 = new Date(2015, 11, 13);
	static Date d4 = new Date(2015, 11, 14);
	static Date d5 = new Date(2015, 11, 15);

	
	static ArrayList<DocVO> test = null;
	static ArrayList<OrderVO> orders = new ArrayList<OrderVO>();
	static ArrayList<String> locs = new ArrayList<String>();
	static ArrayList<DriverVO> drivers = new ArrayList<DriverVO>();
	static ArrayList<CarVO>  cars = new ArrayList<CarVO>();
	
	static{
		orders.add(new OrderVO("2311278906", d1, "02500", "czq", "13188907872", "nju", "常府街44号", "ymc", "13497269020",
				"hs", "仙林大道163号", 1, "book", 2, 30, 20, 10, "wood box", "fast model", 2, 20, test));
		locs.add("航空区2排3架2位");
		orders.add(new OrderVO("2311222479", d2, "02500", "zr", "13137947872", "nju", "常府街21号", "xc", "13132097020",
				"sh", "仙林大道73号", 8, "food", 5, 20, 20, 20, "wood box", "economic model", 1, 30, test));
		locs.add("汽运区8排5架6位");
		
		drivers.add(new DriverVO("000001", "章撒","123456", new Date(1992, 4, 12) , "445202199204121134", "18324522334", true, 5));
		drivers.add(new DriverVO("000002", "张田田","123456", new Date(1990, 4, 11) , "445202199004111134", "18324522333", false, 6));
		
		
		cars.add(new CarVO("025000001", "粤VDC798" , 1));
		cars.add(new CarVO("025000002", "粤Vxx877", 2));
		
	}
	
	public static ArrayList<DocVO> getDocList(DocType tpye) {

		ArrayList<DocVO> al = null;
		
		switch (tpye) {
		case arriveYYDoc:
			al.add(new ArriveYYDocVO("JSD1511110000001", d1, "0250", "南京", GoodsState.Complete));
			al.add(new ArriveYYDocVO("JSD1511110000002", d1, "0250", "南京", GoodsState.Damage));
			al.add(new ArriveYYDocVO("JSD1511120000001", d2, "0251", "上海", GoodsState.Complete));
			al.add(new ArriveYYDocVO("JSD1511130000001", d3, "0250", "南京", GoodsState.Complete));
			break;
		case arriveZZDoc:
			al.add(new ArriveZZDocVO("DDD1511140000001", d4, "0250", "南京", GoodsState.Complete));
			al.add(new ArriveZZDocVO("DDD1511140000002", d4, "0251", "上海", GoodsState.Complete));
			al.add(new ArriveZZDocVO("DDD1511150000001", d5, "0251", "上海", GoodsState.Damage));
			break;
		case loadDoc:
			al.add(new LoadDocVO("ZCD1511120000001", d2, "02500", "02501511120000001", "南京", "001", "ttt", null));
			al.add(new LoadDocVO("ZCD1511120000002", d2, "02500", "02501511120000001", "南京", "002", "hhh", "yyy"));
			al.add(new LoadDocVO("ZCD1511140000001", d4, "02504", "02501511120000006", "南京", "009", null, null));
			break;
		case inStoreDoc:
			al.add(new InStoreDocVO("RKD1511120000001", d2, orders, "南京", locs));
			al.add(new InStoreDocVO("RKD1511150000001", d5, orders, "上海", locs));
			break;
		case order:
			for (int i = 0; i < orders.size(); i++) {
				al.add(orders.get(i));
			}
			break;
		case outStoreDoc:
			al.add(new OutStoreDocVO("CKD1511120000001", d2, orders, "南京","ZZD1511120000001","flight"));
			al.add(new OutStoreDocVO("CKD1511120000002", d2, orders, "上海","ZZD1511120000002","flight"));
			al.add(new OutStoreDocVO("CKD1511140000001", d4, orders, "南京","ZZD1511140000001","train"));
			break;
		case sendGoodDoc:
			al.add(new SendGoodDocVO("PSD1511120000001", d2, "moxigan","3213640812"));
			al.add(new SendGoodDocVO("PSD1511130000001", d3, "dahuang","2343299830"));
			al.add(new SendGoodDocVO("PSD1511150000001", d5, "dahuang","3225890830"));
			break;
		case transferDoc:
			String[] orderID={"3228709728","2297304730","9983018392","2182966170"};
			al.add(new TransferDocVO("ZZD1511130000001", d3, "K155","南京",3,"cee",orderID));
			al.add(new TransferDocVO("ZZD1511150000001", d5, "苏A18729","南京",8,"yio",orderID));
			break;
		default:
			break;
		}
		return al;
	}
	
	
	public static ArrayList<DriverVO> getDriverList(){
		
		return drivers;
		
	}
	
	public static ArrayList<CarVO> getcarlist(){
		return cars;
	}
	
}
