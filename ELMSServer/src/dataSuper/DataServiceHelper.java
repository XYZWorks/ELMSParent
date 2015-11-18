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
	
	public DataServiceHelper() {
	}
	
	public ArrayList<String> bulidSQL(String tableName, int num,
			String... paras) {
		ArrayList<String> temp = new ArrayList<String>(6);
		temp.add(String.valueOf(num));
		temp.add(bulidAddSQL(tableName, num));
		temp.add(bulidDelSQL(tableName));
		temp.add(bulidFindSQL(tableName , 1));
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
		temp.add(bulidDelSQL(tableName));
		temp.add(bulidFindSQL(tableName , 0));
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
	
	
	

	private String bulidDelSQL(String name) {
		return "DELETE FROM `" + name + "` WHERE ID = ";
	}

	private String bulidFindSQL(String name , int type) {
		if(type == 1){
			return "SELECT * FROM `" + name + "` WHERE id =";
		}else{
			return "SELECT * FROM `" + name + "`";
		}
		
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
