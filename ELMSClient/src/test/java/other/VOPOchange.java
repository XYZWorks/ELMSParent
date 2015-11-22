package test.java.other;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import po.TransferDocPO;
import util.DocType;
import vo.CostVO;
import vo.TransferDocVO;

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
		
		
		for(int i= 0 ; i<field.length;i++){
			System.out.println(field[i]+" "+field[i].getType()+" "+ field[i].getName());
			
		}
		try {		
			poClass = Class.forName(poName);
			
			po = poClass.newInstance();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		if(voClass.getSuperclass().toString().endsWith("DocVO")){
			try {
				Method m1 = po.getClass().getMethod("setID");
				Method m2 = po.getClass().getMethod("setType");
				Method m3 = po.getClass().getMethod("setDate");
				Method m4 = po.getClass().getMethod("setState");
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		String tmp="";
		
		try {
			for(int i= 0 ; i<field.length;i++){

				tmp=(char)(field[i].getName().charAt(0)-'a'+'A')+field[i].getName().substring(1);
				
				met = po.getClass().getMethod("set"+tmp, field[i].getType());
				
				Object ob = field[i].get(o);
				
				if(field[i].getType().toString().endsWith("ArrayList")){
					ParameterizedType type = (ParameterizedType)field[i].getGenericType();
					
					Type[] types = type.getActualTypeArguments();
					
					for(Type t: types){
						//TODO
						System.out.println(t.toString());
					}
				}
				
				met.invoke(po,ob);
			}
		} catch (Exception e) {
 			e.printStackTrace();
		} 
		
		//System.out.println(poName);
		return po;
		
	}
	
	public static void main(String[] args) {
		CostVO  vo = new CostVO(1000, "freigt");
		

		ArrayList<TransferDocVO> vo2 = (ArrayList<TransferDocVO>)DataTool.getDocList(DocType.transferDoc);
		
		

		VOPOchange test = new VOPOchange();
		
		TransferDocPO po = (TransferDocPO)test.VOtoPO(vo2.get(0));
		
		System.out.println(po.getID()+" "+po.getContainerNum()+" "+po.getLoadManName()+ " "+ po.getOrderBarCode()[0]+" "+po.getOrderBarCode()[1]);

	}

}
