package dataSuper;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.ResultMessage;
import config.DataBaseInit;

/**
 * 所有数据实现层的父类
 * 
 * @author czq
 * @version 2015年10月31日 上午9:18:30
 */
public class DataSuperClass extends UnicastRemoteObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 与数据库的连接
	 */
	protected Connection conn;
	/**
	 * 
	 */
	protected PreparedStatement preState;
	/**
	 * 数据库语句
	 */
	protected String sql;
	
	protected ResultSet result;
	/**
	 * 查找返回的消息
	 */
	protected ArrayList<String> findMes;


	private static final Map<String, ArrayList<String>> SQLmap = new HashMap<String, ArrayList<String>>(100);

	static {
		SQLmap.put("account", bulidSQL("account", 6, "id", "name", "type", "password","phone", "email"));
		SQLmap.put("person", bulidSQL("person" , 5 , "id" , "instid" , "name" , "type" ,"phone"));
		SQLmap.put("inst", bulidSQL("inst", 3, "id" , "location" , "type"));
	}

	public DataSuperClass() throws RemoteException {
		this.conn = DataBaseInit.getConnection();
	}

	/**
	 * 向数据库中增加一条数据
	 * @param tableName 表的名字
	 * @param paras 可变参数列表
	 * @return
	 */
	protected ResultMessage addToSQL(String tableName , String... paras) {
		try {
			int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
			preState = conn.prepareStatement(SQLmap.get(tableName).get(1));
			for (int i = 0; i < paralen; i++) {
				preState.setString(i + 1, paras[i]);
			}
			if (preState.execute()) {
				return ResultMessage.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;

	}
	
	/**
	 * 从数据库中删除一个数据
	 * @param tableName 表的名字
	 * @param ID 要删除数据的ID
	 * @return
	 */
	protected ResultMessage delFromSQL(String tableName , String ID) {
		try {
			preState = conn.prepareStatement(SQLmap.get(tableName).get(2));
			if(preState.execute()){
				return ResultMessage.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAIL;
	}
	
	
	/**
	 * 在数据库中查找一条消息
	 * @param tableName 表的名字
	 * @param ID 要查找数据的ID
	 * @return 找不到事返回null，否则返回PO类所有信息
	 */
	protected ArrayList<String> findFromSQL(String tableName, String ID) {
		
		
		try {
			preState = conn.prepareStatement(SQLmap.get(tableName).get(3) + ID);
			result = preState.executeQuery();
			if(result.next()) {
				// 如果查找到对应的ID
				int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
				ArrayList<String> temp = new ArrayList<String>(paralen);
				for (int i = 0; i < paralen; i++) {
					temp.add(result.getString(i + 1));
				}
				return temp;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	/**
	 * 修改一条数据
	 * @param tableName 表的名字
	 * @param newParas  PO参数列表
	 * @return 
	 */
	protected ResultMessage modifyFromSQL(String tableName , String... newParas) {
		
		try {
			int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
			preState = conn.prepareStatement(SQLmap.get(tableName).get(4) + newParas[0]);
			for (int i = 0; i < paralen - 1; i++) {
				preState.setString(i + 1, newParas[i + 1]);
			}
			if(preState.execute()){
				return ResultMessage.SUCCESS;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	
	/**
	 * 清除表内所有信息
	 * @param tableName
	 * @return
	 */
	protected ResultMessage initialFromSQL(String tableName) {
		try {
			preState = conn.prepareStatement(SQLmap.get(tableName).get(5));
			if(preState.execute()){
				return ResultMessage.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	
//	/**
//	 * 执行语句并返回执行结果
//	 * 
//	 * @param tempPreState
//	 * @return
//	 */
//	protected ResultMessage getDoResult(PreparedStatement tempPreState) {
//		try {
//			if (tempPreState.execute()) {
//				return ResultMessage.SUCCESS;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ResultMessage.FAIL;
//	}

	private static ArrayList<String> bulidSQL(String tableName, int num,
			String... paras) {
		ArrayList<String> temp = new ArrayList<String>(6);
		temp.add(String.valueOf(num));
		temp.add(bulidAddSQL(tableName, num));
		temp.add(bulidDelSQL(tableName));
		temp.add(bulidFindSQL(tableName));
		temp.add(bulidUpdateSQL(tableName, num, paras));
		temp.add("TRUNCATE TABLE " + tableName);
		return temp;
	}

	
	private static String bulidAddSQL(String name, int paraNum) {
		StringBuffer buffer = new StringBuffer("INSERT INTO `" + name
				+ "` VALUES (");
		for (int i = 0; i < paraNum - 1; i++) {
			buffer.append(" ? ,");
		}

		buffer.append("? )");

		return buffer.toString();
	}

	private static String bulidDelSQL(String name) {
		return "DELETE FROM `" + name + "` WHERE ID = ";
	}

	private static String bulidFindSQL(String name) {
		return "SELECT * FROM `" + name + "` WHERE id =";
	}

	private static String bulidUpdateSQL(String name, int paraNum,
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

	/**
	 * 仅供测试
	 */
	public void showSQLMap() {
		for (Entry<String, ArrayList<String>> temp : SQLmap.entrySet()) {
			System.out.println(temp.getKey());
			for (int i = 0; i < 6; i++) {
				System.out.println(temp.getValue().get(i));
			}

		}
	}

}
