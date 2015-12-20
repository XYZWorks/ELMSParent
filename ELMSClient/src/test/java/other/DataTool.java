package test.java.other;

import java.util.ArrayList;

import blservice.transportblservice.transportblservice_Driver;
import po.statistic.StateFormPO;
import po.store.StoreMessagePO;
import util.MyDate;
import util.AccountType;
import util.City;
import util.CostType;
import util.DocType;
import util.GoodsState;
import util.InstType;
import util.StaffType;
import util.TransferWay;
import util.WageStrategy;
import vo.DocVO;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;
import vo.account.AccountVO;
import vo.finance.CostVO;
import vo.finance.DepositVO;
import vo.finance.PayVO;
import vo.order.OrderVO;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;
import vo.statistic.BillVO;
import vo.statistic.CostIncomeVO;
import vo.statistic.StateFormVO;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
import vo.store.StoreMessageVO;
import vo.strategy.ConstVO;
import vo.strategy.SalaryWayVO;
import vo.transport.ArriveYYDocVO;
import vo.transport.ArriveZZDocVO;
import vo.transport.LoadDocVO;
import vo.transport.SendGoodDocVO;
import vo.transport.TransferDocVO;

/**
 * 用于产生测试用数据
 * @author ymc
 * @version 创建时间：2015年11月15日 上午10:37:13
 *
 */
public class DataTool {
	static MyDate d1 = new MyDate(2015, 11, 11);
	static MyDate d2 = new MyDate(2015, 11, 12);
	static MyDate d3 = new MyDate(2015, 11, 13);
	static MyDate d4 = new MyDate(2015, 12, 05);
	static MyDate d5 = new MyDate(2015, 11, 15);
	
	static String instid1 = "000000";
	static String instid2 = "000001";
	static String instid3 = "000002";
	
	static ArrayList<City> cities = new ArrayList<>();
	static ArrayList<TransferWay> ways = new ArrayList<>();
	
	static String phone1 = "13142321234";
	static String phone2 = "13923689344";
	
	static ArrayList<String> orderID = new ArrayList<String>();
	
	static ArrayList<DocVO> test = new ArrayList<DocVO>();
	static ArrayList<OrderVO> orders = new ArrayList<OrderVO>();
	static ArrayList<String> locs = new ArrayList<String>();
	static ArrayList<DriverVO> drivers = new ArrayList<DriverVO>();
	static ArrayList<CarVO>  cars = new ArrayList<CarVO>();
	
	static ArrayList<PayVO> pays = new ArrayList<PayVO>();
	static ArrayList<DepositVO> deposits = new ArrayList<DepositVO>();
	
	static{
		cities.add(City.BEIJING);
		cities.add(City.NANJING);
		cities.add(City.GUANGZHOU);
		cities.add(City.SHANGHAI);
		
		ways.add(TransferWay.car);
		ways.add(TransferWay.plane);
		ways.add(TransferWay.train);

		
		orders.add(new OrderVO());
		locs.add("航空区2排3架2位");
		orders.add(new OrderVO());
		locs.add("汽运区8排5架6位");
		locs.add("汽运区5排2架1位");
		
		orderID.add("1234536433");
		orderID.add("2069601212");
		orderID.add("4902720820");
		
		drivers.add(new DriverVO("000001", "章撒",instid1, new MyDate(1992, 4, 12) , "445202199204121134", "18324522334", true, 5));
		drivers.add(new DriverVO("000002", "张田田",instid2, new MyDate(1990, 4, 11) , "445202199004111134", "18324522333", false, 6));
		
		
		cars.add(new CarVO("025000001", "123412" ,"粤VDC798" , 1));
		cars.add(new CarVO("025000002", "123412", "粤Vxx877", 2));
		
		pays.add(new PayVO(d1, 2000, "transport"));
		pays.add(new PayVO(d1, 4000, "salary"));
		
		deposits.add(new DepositVO(d1, 7000));
		deposits.add(new DepositVO(d2, 6000));

		
	}
	
	public static ArrayList<? extends DocVO> getDocList(DocType tpye) {

		ArrayList<DocVO> al = new ArrayList<DocVO>();
		 
		switch (tpye) {
		case arriveYYDoc:
			al.add(new ArriveYYDocVO("JSD1511110000001", d1, "0250", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000002", d1, "0250", City.NANJING, GoodsState.Damage,orderID));
			al.add(new ArriveYYDocVO("JSD1511120000001", d2, "0251", City.GUANGZHOU, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511130000001", d3, "0250", City.SHANGHAI, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000001", d1, "0250", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000002", d1, "0250", City.NANJING, GoodsState.Damage,orderID));
			al.add(new ArriveYYDocVO("JSD1511120000001", d2, "0251", City.GUANGZHOU, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511130000001", d3, "0250", City.SHANGHAI, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000001", d1, "0250", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000002", d1, "0250", City.NANJING, GoodsState.Damage,orderID));
			al.add(new ArriveYYDocVO("JSD1511120000001", d2, "0251", City.GUANGZHOU, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511130000001", d3, "0250", City.SHANGHAI, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000001", d1, "0250", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000002", d1, "0250", City.NANJING, GoodsState.Damage,orderID));
			al.add(new ArriveYYDocVO("JSD1511120000001", d2, "0251", City.GUANGZHOU, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511130000001", d3, "0250", City.SHANGHAI, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000001", d1, "0250", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000002", d1, "0250", City.NANJING, GoodsState.Damage,orderID));
			al.add(new ArriveYYDocVO("JSD1511120000001", d2, "0251", City.GUANGZHOU, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511130000001", d3, "0250", City.SHANGHAI, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000001", d1, "0250", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000002", d1, "0250", City.NANJING, GoodsState.Damage,orderID));
			al.add(new ArriveYYDocVO("JSD1511120000001", d2, "0251", City.GUANGZHOU, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511130000001", d3, "0250", City.SHANGHAI, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000001", d1, "0250", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000002", d1, "0250", City.NANJING, GoodsState.Damage,orderID));
			al.add(new ArriveYYDocVO("JSD1511120000001", d2, "0251", City.GUANGZHOU, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511130000001", d3, "0250", City.SHANGHAI, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000001", d1, "0250", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000002", d1, "0250", City.NANJING, GoodsState.Damage,orderID));
			al.add(new ArriveYYDocVO("JSD1511120000001", d2, "0251", City.GUANGZHOU, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511130000001", d3, "0250", City.SHANGHAI, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000001", d1, "0250", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000002", d1, "0250", City.NANJING, GoodsState.Damage,orderID));
			al.add(new ArriveYYDocVO("JSD1511120000001", d2, "0251", City.GUANGZHOU, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511130000001", d3, "0250", City.SHANGHAI, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000001", d1, "0250", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511110000002", d1, "0250", City.NANJING, GoodsState.Damage,orderID));
			al.add(new ArriveYYDocVO("JSD1511120000001", d2, "0251", City.GUANGZHOU, GoodsState.Complete,orderID));
			al.add(new ArriveYYDocVO("JSD1511130000001", d3, "0250", City.SHANGHAI, GoodsState.Complete,orderID));
			break;
		case arriveZZDoc:
			al.add(new ArriveZZDocVO("DDD1511140000001", d4, "0250", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveZZDocVO("DDD1511140000002", d4, "0251", City.BEIJING, GoodsState.Complete,orderID));
			al.add(new ArriveZZDocVO("DDD1511150000001", d5, "0251", City.SHANGHAI, GoodsState.Damage,orderID));
			break;
		case loadDoc:
			al.add(new LoadDocVO("ZCD1511120000001", d2, "02500", "02501511120000001", City.GUANGZHOU, "001", "ttt", null,orderID));
			al.add(new LoadDocVO("ZCD1511120000002", d2, "02500", "02501511120000001", City.NANJING, "002", "hhh", "yyy",orderID));
			al.add(new LoadDocVO("ZCD1511140000001", d4, "02504", "02501511120000006", City.SHANGHAI, "009", null, null,orderID));
			break;
		case inStoreDoc:
			al.add(new InStoreDocVO("RKD1511120000001", d2, orderID, City.NANJING, locs));
			al.add(new InStoreDocVO("RKD1511150000001", d5, orderID, City.GUANGZHOU, locs));
			al.add(new InStoreDocVO("RKD1511140000321", d4, orderID, City.BEIJING, locs));
			break;
		case order:
			for (int i = 0; i < orders.size(); i++) {
				al.add(orders.get(i));
			}
			break;
		case outStoreDoc:
			al.add(new OutStoreDocVO("CKD1511120000001", d2, orderID, City.BEIJING,"ZZD1511120000001",TransferWay.plane));
			al.add(new OutStoreDocVO("CKD1511120000002", d2, orderID, City.GUANGZHOU,"ZZD1511120000002",TransferWay.train));
			al.add(new OutStoreDocVO("CKD1511140000001", d4, orderID, City.SHANGHAI,"ZZD1511140000001",TransferWay.car));
			break;
		case sendGoodDoc:
			al.add(new SendGoodDocVO("PSD1511120000001", d2, "moxigan","3213640812",City.BEIJING));
			al.add(new SendGoodDocVO("PSD1511130000001", d3, "dahuang","2343299830",City.NANJING));
			al.add(new SendGoodDocVO("PSD1511150000001", d5, "dahuang","3225890830",City.GUANGZHOU));
			break;
		case transferDoc:
			
			al.add(new TransferDocVO("ZZD1511130000001", d3, "K155",City.SHANGHAI,3,"cee",orderID));
			al.add(new TransferDocVO("ZZD1511150000001", d5, "苏A18729",City.NANJING,8,"yio",orderID));
			break;
		default:
			break;
		}
		return al;
		
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<StoreMessageVO> getStoreMessage() {
		ArrayList<StoreMessageVO> vos = new ArrayList<>(12);
		StoreMessageVO vo ;
		for(int i = 0;i<cities.size();i++){
			for(int j = 0;j<ways.size();j++){
				vo = new StoreMessageVO(cities.get(i),ways.get(j),0,300,(ArrayList<InStoreDocVO>)getDocList(DocType.inStoreDoc),(ArrayList<OutStoreDocVO>)getDocList(DocType.outStoreDoc));
				vos.add(vo);
			}
		}
		return vos;
	}
	
	public static ArrayList<DriverVO> getDriverList(){
		return drivers;}
	
	public static ArrayList<CarVO> getcarlist(){
		return cars;
	}
	
	public static ArrayList<PayVO> getpays(){
		ArrayList<PayVO> pays = new ArrayList<PayVO>();
		pays.add(new PayVO(d1, 1500,""));
		pays.add(new PayVO(d2, 3000, ""));
		return pays;
	}
	
	public static ArrayList<CostVO> getcosts(){
		ArrayList<CostVO> costs = new ArrayList<CostVO>();
		costs.add(new CostVO("10002",d1, d3, 12000, CostType.FREIGHT));
		costs.add(new CostVO("19202",d1, d4, 10000, CostType.RENT));
		
		return costs;
		
	}
	
	
	public static ArrayList<DepositVO> getDeposits(){
		ArrayList<DepositVO> temp = new  ArrayList<DepositVO>();
		temp.add(new DepositVO(d1, 5000));
		temp.add(new DepositVO(d3, 2000));
		
		return temp;
	}
	
	public static ConstVO getConst(){
		return new ConstVO(2000, 1000, 2000, 233, 231, 13, 1234, 200, 200, 1, 5, 10, new int[]{4 , 5 , 7});
	}
	
	public static ArrayList<SalaryWayVO> getSalarys(){
		ArrayList<SalaryWayVO> temp = new ArrayList<SalaryWayVO>();
		temp.add(new SalaryWayVO(StaffType.courier, 2000, 0, WageStrategy.byMonth));
		temp.add(new SalaryWayVO(StaffType.driver, 3000, 1000, WageStrategy.baseAndMore));
		temp.add(new SalaryWayVO(StaffType.financeman, 3000, 1000, WageStrategy.baseAndMore));
		temp.add(new SalaryWayVO(StaffType.saleman, 3000, 1000, WageStrategy.baseAndMore));
		temp.add(new SalaryWayVO(StaffType.storeman, 3000, 1000, WageStrategy.baseAndMore));
		temp.add(new SalaryWayVO(StaffType.storemanager, 3000, 1000, WageStrategy.baseAndMore));
		return temp;
		
	}
	
	public static ArrayList<PersonVO> getpersons(){
		ArrayList<PersonVO> persons = new ArrayList<PersonVO>();
		persons.add(new PersonVO(instid1, "000001", "陈展鹏", StaffType.courier, phone1));
		persons.add(new PersonVO(instid2, "123456", "程青松", StaffType.financeman, phone2));
		return persons;
		}

	public static ArrayList<InstVO> getInsts(){
		ArrayList<InstVO> insts = new ArrayList<InstVO>();
		insts.add(new InstVO(instid1, City.NANJING, InstType.businessHall));
		insts.add(new InstVO(instid3, City.GUANGZHOU, InstType.headOffice));
		return insts;
		
	}


	public static StateFormVO getStateForm() {
	
		StateFormVO vo = new StateFormVO(d2, d4, pays, deposits);
		return vo;
	}


	public static CostIncomeVO getCostIncomeForm() {

		CostIncomeVO vo = new CostIncomeVO(7000, 6000, d1, d2);
		return vo;
	}


	public static BillVO getBill() {

		BillVO vo = new BillVO();
		return vo;
	}


	public static AccountVO getAccountVO() {
		AccountVO vo = new AccountVO("12323","wsada",AccountType.courier);
		return vo;
	}
	
	public static StoreMessagePO getStoreMessagePO(){
		return new StoreMessagePO(City.NANJING, TransferWay.car, 45, 0, null, null);
	}
	public static StateFormPO getStateFormPO(){
		return new StateFormPO(d2, d4, null, null);
	}
}
