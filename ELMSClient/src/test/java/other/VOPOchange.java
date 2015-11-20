package test.java.other;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import util.MyDate;
import vo.CostVO;
import vo.InStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年11月18日 下午7:39:11 
 *
 */
public class VOPOchange {
	
	public Object VOtoPO(Object o){
		
		Object po = null;
		
		Class voClass = o.getClass();
		
		Class poClass = null;
		
		String voName = voClass.getName();
		
		String poName = "po"+voName.substring(2,voName.length()-2)+"PO";
		
		Field[] field = voClass.getDeclaredFields();
		
		for(int i= 0 ; i<field.length;i++)
			System.out.println(field[i].getType()+" "+ field[i].getName());
		try {		
			poClass = Class.forName(poName);
			
			Method[] met = poClass.getDeclaredMethods();
			for(int i = 0; i<met.length ; i++)
				System.out.println(met[i].getName()+" "+met[i].getReturnType());
			
			Constructor[] cons = poClass.getConstructors();
			System.out.println("cons"+cons[0]);

		//	po = poClass.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(poName);
		return po;
		
	}
	
	public static void main(String[] args) {
		CostVO  vo = new CostVO(1000, "freigt");
		
		InStoreDocVO vo2 = new InStoreDocVO("", new MyDate(1,1,1), null, "", null);
		
		VOPOchange test = new VOPOchange();
		
		test.VOtoPO(vo);

	}

}
