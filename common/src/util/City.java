package util;

import java.lang.annotation.Retention;

import javax.print.attribute.standard.RequestingUserName;

/** 
 * 
 * @author czq 
 * @version 2015年11月24日 上午12:41:39 
 */
public enum City {
	NANJING,BEIJING,SHANGHAI,GUANGZHOU;
	public static City toCity(String city) {
		switch (city) {
		case "南京":
			return NANJING;
			
		case "北京":
			return BEIJING;
		
		case "上海":
			return SHANGHAI;
			
		case "广州":
			return GUANGZHOU;
			
		default:
			System.err.println("city not exist");
			return null;
			
		}
		
	}
}
