package test.java.other;


import po.CostPO;
import po.InStoreDocPO;

import java.lang.reflect.*;
import java.util.ArrayList;

import util.DocType;

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
	
	public static void main(String[] args) {
		CostVO  vo = new CostVO(1000, "freigt");
		

		ArrayList<InStoreDocVO> vo2 = (ArrayList<InStoreDocVO>)DataTool.getDocList(DocType.inStoreDoc);
		System.out.println(vo2.size());

		

		VOPOchange test = new VOPOchange();
		
		InStoreDocPO po = (InStoreDocPO)test.VOtoPO(vo2.get(0));
		
		System.out.println(po.getID()+" "+po.getLoc()+" "+po.getLocation());

	}

}
