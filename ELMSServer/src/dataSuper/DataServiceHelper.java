package dataSuper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
 /** 
 * 
 * @author czq 
 * @version 2015年11月18日 下午2:44:51 
 */
public class DataServiceHelper {
	
	public DataServiceHelper() {}
	
	public ArrayList<String> bulidSQL(String tableName, int num,
			String... paras) {
		ArrayList<String> temp = new ArrayList<String>(6);
		temp.add(String.valueOf(num));
		temp.add(bulidAddSQL(tableName, num));
		temp.add(bulidDelSQL(tableName , paras[0]));
		temp.add(bulidFindSQL(tableName , paras[0]));
		temp.add(bulidUpdateSQL(tableName, num, paras));
		//清空表内数据，用于初始化
		temp.add("TRUNCATE TABLE " + tableName);		
		return temp;
	}
	
	/**
	 * 用于没有ID的PO类的数据库语句生产
	 * @return
	 */
	public ArrayList<String> bulidSQLForNoID(String tableName , int num , String... paras){
		ArrayList<String> temp = new ArrayList<String>(6);
		temp.add(String.valueOf(num));
		temp.add(bulidAddSQL(tableName, num));
		temp.add(bulidDelSQL(tableName , paras[0]));
		temp.add(bulidFindSQL(tableName , paras[0]));
		temp.add(bulidUpdateSQL(tableName, num, paras));
		//清空表内数据，用于初始化
		temp.add("TRUNCATE TABLE " + tableName);
		return temp;

	
	}
	
	
	
	private String bulidAddSQL(String name, int paraNum) {
		StringBuffer buffer = new StringBuffer("INSERT INTO `" + name
				+ "` VALUES (");
		for (int i = 0; i < paraNum - 1; i++) {
			buffer.append(" ? ,");
		}

		buffer.append("? )");

		return buffer.toString();
	}
	
	
	

	private String bulidDelSQL(String name ,String primaryKey) {
		return "DELETE FROM `" + name + "` WHERE " + primaryKey + " =";
	}

	private String bulidFindSQL(String name , String primaryKey) {
		
			return "SELECT * FROM `" + name + "` WHERE " + primaryKey + " =" ;
	
		
	}

	private String bulidUpdateSQL(String name, int paraNum,
			String... paras) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE `").append(name).append("` SET ");
		for (int i = 0; i < paraNum - 1; i++) {
			buffer.append(paras[i + 1]).append('=').append(" ? ,");
		}
		buffer.deleteCharAt(buffer.length() - 1);

		buffer.append("WHERE " + paras[0] + " = ");

		return buffer.toString();
	}
	
	
	public boolean changeFromInt(int num){
		return (num!=0)?true:false;
	}
	
	public boolean changeFromInt(String num){
		return (num.equalsIgnoreCase("0"))?false:true;
	}
	
	/**
	 * 辅助方法，实现将数组转化为字符串
	 * @return
	 */
	public  String tranFromArrayToString(String[] datas){
		StringBuffer buffer = new StringBuffer(datas.length*15);
		for (int i = 0; i < datas.length; i++) {
			buffer.append(datas[i]).append(',');
		}
		return buffer.toString();
	}
	
	public String tranFromArrayToString(ArrayList<String> datas){
		StringBuffer buffer = new StringBuffer(datas.size()*15);
		for (int i = 0; i < datas.size(); i++) {
			buffer.append(datas.get(i)).append(',');
		}
		return buffer.toString();
	}
	
	public  String[] tranFromStringToArray(String data){
		String[]  temp =  data.split(",");
		return (temp.length==0)?null:temp;
	}
	
	public  ArrayList<String> tranFromStringToArrayList(String data){
		ArrayList<String> result;
		String[] temp = tranFromStringToArray(data);
		if(temp != null){
			result = new ArrayList<String>(temp.length);
			for (int i = 0; i < temp.length; i++) {
				result.add(temp[i]);
			}
			return result;
		}else{
			return null;
		}
	}
	
	/**
	 * 向序列化文件中写入一个对象
	 * @param object
	 * @param name
	 * @return
	 */
	public boolean writeToSerFile(Object object , String name){
		String pres = "data\\";
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream(pres + name));
			out.writeObject(object);
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
		}
		
		return false;
		
	}
	
	/**
	 * 从序列化文件中读取一个对象
	 * @param name
	 * @return
	 */
	public Object readFromSerFile(String name){
		String pres = "data\\";
		Object result;
		ObjectInputStream input;
		try {
			input = new ObjectInputStream(new FileInputStream(pres + name));
			result = input.readObject();
			input.close();
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
