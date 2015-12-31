package dataSuper;

import java.io.EOFException;
import java.io.File;
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
		temp.add(bulidDelSQL(tableName, paras[0]));
		temp.add(bulidFindSQL(tableName, paras[0]));
		temp.add(bulidUpdateSQL(tableName, num, paras));
		// 清空表内数据，用于初始化
		temp.add("TRUNCATE TABLE " + tableName);
		return temp;
	}

	/**
	 * 用于没有ID的PO类的数据库语句生产
	 * 
	 * @return
	 */
	public ArrayList<String> bulidSQLForNoID(String tableName, int num,
			String... paras) {
		ArrayList<String> temp = new ArrayList<String>(6);
		temp.add(String.valueOf(num));
		temp.add(bulidAddSQL(tableName, num));
		temp.add(bulidDelSQL(tableName, paras[0]));
		temp.add(bulidFindSQL(tableName, paras[0]));
		temp.add(bulidUpdateSQL(tableName, num, paras));
		// 清空表内数据，用于初始化
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

	private String bulidDelSQL(String name, String primaryKey) {
		return "DELETE FROM `" + name + "` WHERE " + primaryKey + " =";
	}

	private String bulidFindSQL(String name, String primaryKey) {

		return "SELECT * FROM `" + name + "` WHERE " + primaryKey + " = ";

	}

	private String bulidUpdateSQL(String name, int paraNum, String... paras) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE `").append(name).append("` SET ");
		for (int i = 0; i < paraNum - 1; i++) {
			buffer.append(paras[i + 1]).append('=').append(" ? ,");
		}
		buffer.deleteCharAt(buffer.length() - 1);

		buffer.append("WHERE " + paras[0] + " = ");

		return buffer.toString();
	}

	public boolean changeFromInt(int num) {
		return (num != 0) ? true : false;
	}

	public boolean changeFromInt(String num) {
		return (num.equalsIgnoreCase("0")) ? false : true;
	}

	/**
	 * 辅助方法，实现将数组转化为字符串
	 * 
	 * @return
	 */
	public String tranFromArrayToString(String[] datas) {
		if(datas == null){
			return null;
		}
		StringBuffer buffer = new StringBuffer(datas.length * 15);
		for (int i = 0; i < datas.length; i++) {
			buffer.append(datas[i]).append(',');
		}
		return buffer.toString();
	}

	public String tranFromArrayToString(ArrayList<String> datas) {
		if(datas == null){
			return null;
		}
		
		StringBuffer buffer = new StringBuffer(datas.size() * 15);
		for (int i = 0; i < datas.size(); i++) {
			buffer.append(datas.get(i)).append(',');
		}
		return buffer.toString();
	}

	public String[] tranFromStringToArray(String data) {
		String[] temp = data.split(",");
		return (temp.length == 0) ? null : temp;
	}

	public ArrayList<String> tranFromStringToArrayList(String data) {
		if(data == null){
			return null;
		}
		ArrayList<String> result;
		String[] temp = tranFromStringToArray(data);
		if (temp != null) {
			result = new ArrayList<String>(temp.length);
			for (int i = 0; i < temp.length; i++) {
				result.add(temp[i]);
			}
			return result;
		} else {
			return null;
		}
	}

	/**
	 * 向序列化文件中写入一个对象
	 * 
	 * @param object
	 * @param name
	 * @return
	 */
	public boolean writeToSerFile(Object object, String name, boolean append) {
		String pres = "data//";
		ObjectOutputStream out;
		ArrayList<Object> objects = null;
		File file = null;
		try {
			file = new File(pres + name);
			//當需要寫入多個對象至同一個文件時需要將開頭的節點AD刪去，否則會報錯（怎麼突然變繁體字了 = =）
			if(append){
				if(file.length() > 1){
					objects = readManyFromSerFile(name);
					
				}
				out = new ObjectOutputStream(new FileOutputStream(file));
//				out.write
				if(objects != null){
					System.out.println("已有的文件数量" +objects.size());
					for (Object object2 : objects) {
						out.writeObject(object2);
					}
				}
			}else{
				out = new ObjectOutputStream(new FileOutputStream(file));
			}
			
			
			out.writeObject(object);
			
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			System.err.println("序列化文件丢失或未创建，将创建一个空文件");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

		return false;

	}

	/**
	 * 从序列化文件中读取一个对象
	 * 
	 * @param name
	 * @return
	 */
	public final Object readFromSerFile(String name) {
		String pres = "data//";
		Object result;
		ObjectInputStream input;

		File file = new File(pres + name);
		try {

			input = new ObjectInputStream(new FileInputStream(file));
			
			result = input.readObject();
			input.close();
			return result;
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
		return null;
	}
	/**
	 * 從序列化文件中讀取多個對象
	 * @param name
	 * @return
	 */
	public final ArrayList<Object> readManyFromSerFile(String name) {
		String pres = "data\\";
		ArrayList<Object> result = new ArrayList<>();
		ObjectInputStream input = null;
		File file = new File(pres + name);

		try {
			input = new ObjectInputStream(new FileInputStream(file));
			while (input.available() != -1) {
				try {
					result.add(input.readObject());
				} catch (ClassNotFoundException e ) {
					e.printStackTrace();
				} catch (EOFException e) {
					break;
				}
			}
		} catch (FileNotFoundException e1) {
			System.err.println("序列化文件丢失");
			//重新嘗試創建新文件
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		}catch (EOFException e) {
			System.err.println("WARNING: 账单文件丢失");
			return null;
		}
		catch (IOException e1) {
			e1.printStackTrace();
			return null;
		} 
		
		
		
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.isEmpty() ? null : result;

	}

}
