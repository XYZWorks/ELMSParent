package test.java.other;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

import po.statistic.StateFormPO;
import po.store.InStoreDocPO;
import util.DocType;
import vo.statistic.StateFormVO;
import vo.store.InStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年11月18日 下午7:39:11 
 *
 */
public class VOPOchange {
	
	public static Object POtoVO(Object o){
		
		if(o == null){
			return null;
		}
		
		
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
		
		if(poClass.getSuperclass().toString().endsWith("DocPO")){
			setSuperField(vo, o, "ID");
			setSuperField(vo, o, "type");
			setSuperField(vo, o, "date");
			setSuperField(vo, o, "state");
			
			
		}
	
		
		for(Field f : fields){
			Field tmp = null;
			if(f.getName().equals("serialVersionUID"))
				continue;
//			if(f.getType().toString().endsWith("PO"))
				
			if(f.getType().toString().endsWith("ArrayList")&&!f.getGenericType().toString().endsWith("String>")){
				
				Type listType = f.getGenericType();
				Object list = null;
				f.setAccessible(true);
				try {
					 list = f.get(o);
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<Object> polist = (ArrayList<Object>)list;
				
				String[] spl = listType.toString().split("<");		
				String votName = "vo"+spl[1].substring(2, spl[1].length()-3)+"VO";

				Class<? extends Object> votmp = null;

				try {
					votmp = Class.forName(votName);

				} catch (ClassNotFoundException e) {
			
					e.printStackTrace();
				}
				ArrayList<Object> volist = new ArrayList<Object>(polist.size());
				for(int j =0 ; j< polist.size(); j++){
					volist.add(votmp.cast(POtoVO(polist.get(j))));
				}
				
				Field ft = null;
				try {
					ft = vo.getClass().getDeclaredField(f.getName());
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ft.setAccessible(true);
				try {
					ft.set(vo, volist);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			else{
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
			if(field[i].getType().toString().endsWith("ArrayList")&&!field[i].getGenericType().toString().endsWith("String>")){
				
				Type listType = field[i].getGenericType();
				Object list = null;
				
				try {
					 list = field[i].get(o);
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<Object> volist = (ArrayList<Object>)list;
				
				String[] spl = listType.toString().split("<");		
				String potName = "po"+spl[1].substring(2, spl[1].length()-3)+"PO";

				Class<? extends Object> potmp = null;

				try {
					potmp = Class.forName(potName);

				} catch (ClassNotFoundException e) {
			
					e.printStackTrace();
				}
				ArrayList<Object> polist = new ArrayList<Object>(volist.size());
				for(int j =0 ; j< volist.size(); j++){
					polist.add(potmp.cast(VOtoPO(volist.get(j))));
				}
				
				Field ft = null;
				try {
					ft = po.getClass().getDeclaredField(field[i].getName());
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ft.setAccessible(true);
				try {
					ft.set(po, polist);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			else
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
//			System.out.println(val.toString());
//			System.out.println("ready to change "+field2.getName());
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
//		CostVO  vo = new CostVO(1000, "freigt");		
//		CostPO po = (CostPO) VOtoPO(vo);
//		System.out.println(po.getMoney()+ " "+ po.getType());
//		
		ArrayList<InStoreDocVO> vo2 = (ArrayList<InStoreDocVO>)DataTool.getDocList(DocType.inStoreDoc);
		InStoreDocPO po2 = (InStoreDocPO)VOtoPO(vo2.get(0));
		System.out.println(po2.getID()+" "+po2.getLoc()+" "+ po2.getOrders()+" "+po2.getLocation()+" "+ po2.getDate());
		InStoreDocVO vo22 = (InStoreDocVO) POtoVO(po2);
		System.out.println(vo22.ID+ " "+vo22.loc+" "+vo22.orders+" "+ vo22.location+ " "+ vo22.date);
//		
//		AccountVO voa= DataTool.getAccountVO();
//		AccountPO poa = (AccountPO) VOtoPO(voa);
//		
//		System.out.println(poa.getID()+" "+ poa.getPassword());
//		
//		AccountVO voav = (AccountVO)POtoVO(poa);
//		System.out.println(voav.ID+" "+voav.password);
		
//		ArrayList<DriverVO> vod = DataTool.getDriverList();
//		DriverVO vo1 = vod.get(0);
//		System.out.println(vo1.ID+" "+vo1.IDcard+" "+vo1.licenseYear+" "+vo1.name);
//		DriverPO po1 = (DriverPO) VOtoPO(vo1);
//		System.out.println(po1.getID()+" "+po1.getIDcard()+" "+po1.getLicenseYear()+" "+po1.getName());
		
		StateFormVO vo = DataTool.getStateForm();
		StateFormPO po = (StateFormPO) VOtoPO(vo);
		System.out.println(po.getEndDate()+ " "+po.getPays());
		StateFormVO vot = (StateFormVO) POtoVO(po);
		System.out.println(vot.endDate+" "+vot.pays);
		

	}

}
