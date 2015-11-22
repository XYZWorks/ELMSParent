package test.java.other;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

import ds.storedataservice.StoreDataService;
import net.RMIManage;
import util.DataServiceType;

/** 
 * @author ymc 
 * @version 创建时间：2015年11月18日 下午7:39:11 
 *
 */
public class VOPOchange {
	
	public Object VOtoPO(Object o){
		
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
		String tmp="";
		
		try {
			for(int i= 0 ; i<field.length;i++){

				tmp=(char)(field[i].getName().charAt(0)-'a'+'A')+field[i].getName().substring(1);
				
				met = po.getClass().getMethod("set"+tmp, field[i].getType());
				Object ob = field[i].get(o);
				
				System.out.println(met.getName()+" "+met.getReturnType());
				met.invoke(po,ob);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//System.out.println(poName);
		return po;
		
	}
	
	private void setSuperField(Object po,Object o, String name) {
		
		Field field1 = getSuperField(o.getClass(), name);
		Field field2 = getSuperField(po.getClass(), name);
		
		try {
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
	
	private Field getSuperField(Class clazz, String name) {
		
		Field[] field = clazz.getDeclaredFields();
		
		for(Field f:field ){
			if(f.getName().equals(name)){
				return f;
				
			}
		}
		
		Class supClass = clazz.getSuperclass();
		System.out.println(supClass);
		if(supClass!=null){
			return getSuperField(supClass, name);
		}
		return null;
	}
	public static void main(String[] args) {
//		CostVO  vo = new CostVO(1000, "freigt");		
//
//		ArrayList<InStoreDocVO> vo2 = (ArrayList<InStoreDocVO>)DataTool.getDocList(DocType.inStoreDoc);
//
//		VOPOchange test = new VOPOchange();
//		
//		InStoreDocPO po = (InStoreDocPO)test.VOtoPO(vo2.get(0));
//		
//		System.out.println(po.getID()+" "+po.getLoc()+" "+po.getLocation());
		
		StoreDataService storeData = (StoreDataService)RMIManage.getDataService(DataServiceType.StoreDataService);
		
		try {
			storeData.getIn();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
