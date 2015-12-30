package util;


/** 
 * 
 * @author czq 
 * @version 2015年11月24日 上午12:41:39 
 */
public enum City {
	
	
	 NANJING("南京"),BEIJING("北京"),SHANGHAI("上海"),GUANGZHOU("广州");
	
	private final String name;
	
	private City(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
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
