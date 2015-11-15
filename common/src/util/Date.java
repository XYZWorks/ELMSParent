package util;
/**
 * 日期类
 * @author czq
 *
 */
public class Date {
	

	public int year;
	
	public int month;
	
	public int day;
	
	public int hour;
	
	public int minute;
	
	public int second;
	
	
	public Date(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}


	public Date(int year, int month, int day, int hour, int minute, int second) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	
	
	
}
