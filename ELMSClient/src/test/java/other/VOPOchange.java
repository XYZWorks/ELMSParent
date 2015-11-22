package test.java.other;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ds.storedataservice.StoreDataService;
import net.RMIManage;
import po.account.AccountPO;
import po.finance.CostPO;
import po.store.InStoreDocPO;
import util.DataServiceType;
import util.DocType;
import vo.account.AccountVO;
import vo.finance.CostVO;
import vo.store.InStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年11月18日 下午7:39:11 
 *
 */
public class VOPOchange {
	
	public static Object POtoVO(Object o){
		
		Object vo = null;
		
		Class<? extends Object> poClass = o.getClass();
		
		Class< ? extends Object> voClass = null;
		String poName = poClass.getName();
		
		String voName = "vo"+poName.substring(2,poName.length()-2)+"VO";
		
		try {
			voClass = Class.forName(voName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			vo = voClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field[] fields = poClass.getDeclaredFields();
		
		if(poClass.getSuperclass().toString().endsWith("DocVO")){
			setSuperField(vo, o, "ID");
			setSuperField(vo, o, "type");
			setSuperField(vo, o, "date");
			setSuperField(vo, o, "state");
			
			
		}
	
		
		for(Field f : fields){
			Field tmp = null;
			if(f.getName().equals("serialVersionUID"))
				continue;
			try {
				tmp = voClass.getDeclaredField(f.getName());
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			f.setAccessible(true);
			tmp.setAccessible(true);
			try {
				tmp.set(vo, f.get(o));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
		
	}
	public static Object VOtoPO(Object o){
		
		Object po = null;
		
		Class<? extends Object> voClass = o.getClass();
		
		Class<? extends Object> poClass = null;
		
		String voName = voClass.getName();
		
		String poName = "po"+voName.substring(2,voName.length()-2)+"PO";
		
		Field[] field = voClass.getDeclaredFields();
	
		Method met = null;
		
		
		
		
		try {		
			poClass = Class.forName(poName);
			
			po = poClass.newInstance();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(voClass.getSuperclass().toString().endsWith("DocVO")){
			setSuperField(po, o, "ID");
			setSuperField(po, o, "type");
			setSuperField(po, o, "date");
			setSuperField(po, o, "state");
			
			
		}
		
		
		for(int i= 0 ; i<field.length;i++){

			setSuperField(po, o, field[i].getName());
		}
		
		//System.out.println(poName);
		return po;
		
	}
	
	private static void setSuperField(Object po,Object o, String name) {
		
		Field field1 = getSuperField(o.getClass(), name);
		Field field2 = getSuperField(po.getClass(), name);
		
		try {
			field1.setAccessible(true);
			Object val = field1.get(o);
			//System.out.println(val.toString());
			field2.setAccessible(true);
			field2.set(po, val);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static Field getSuperField(Class clazz, String name) {
		
		Field[] field = clazz.getDeclaredFields();
		
		for(Field f:field ){
			if(f.getName().equals(name)){
				return f;
				
			}
		}
		
		Class supClass = clazz.getSuperclass();
		//System.out.println(supClass);
		if(supClass!=null){
			return getSuperField(supClass, name);
		}
		return null;
	}
	public static void main(String[] args) {
		CostVO  vo = new CostVO(1000, "freigt");		
		CostPO po = (CostPO) VOtoPO(vo);
		System.out.println(po.getMoney()+ " "+ po.getType());
		
		ArrayList<InStoreDocVO> vo2 = (ArrayList<InStoreDocVO>)DataTool.getDocList(DocType.inStoreDoc);
		InStoreDocPO po2 = (InStoreDocPO)VOtoPO(vo2.get(0));
		System.out.println(po2.getID()+" "+po2.getLoc()+" "+po2.getLocation()+" "+ po2.getDate());

		
		AccountVO voa= DataTool.getAccountVO();
		AccountPO poa = (AccountPO) VOtoPO(voa);
		
		System.out.println(poa.getID()+" "+ poa.getPassword());
		
		AccountVO voav = (AccountVO)POtoVO(poa);
		System.out.println(voav.ID+" "+voav.password);
		

	}

}
