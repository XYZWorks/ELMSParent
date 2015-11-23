package util;
/**
 * 日期类
 * @author czq
 *
 */
public class MyDate {
	

	public int year;
	
	public int month;
	
	public int day;
	
	public int hour;
	
	public int minute;
	
	public int second;
	
	
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		minute = -1;
		hour = -1;
		second = -1;
	}


	public MyDate(int year, int month, int day, int hour, int minute, int second) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public static String toString(MyDate date){
		if(date.hour == -1){
			return String.valueOf(date.year)+ "-" + String.valueOf(date.month) + "-" + String.valueOf(date.day);
		}else{
			return String.valueOf(date.year)+ "-" + String.valueOf(date.month) + "-" + String.valueOf(date.day) + "-" +String.valueOf(date.hour) + "-" + String.valueOf(date.minute) + "-" + String.valueOf(date.second);
		}
	}
	
	public static MyDate getDate(String date){
		String[] temp = date.split("-");
		if(temp.length == 3){
			return new MyDate(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
		}else{
			return new MyDate(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]) ,Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]));
		}
	}
	
	public boolean equals(MyDate date){
		if(this.year!=date.year)
			return false;
		if(this.month!=date.year)
			return false;
		if(this.day!=date.year)
			return false;
		return true;
		
	}
	
}
