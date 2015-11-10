package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接器
 * @author czq
 *
 */
public class DataBaseInit {
	/**
	 * 所有数据读取使用的数据流
	 */
	private static Connection conn;
	/**
	 * 获得连接
	 * @return
	 */
	public static Connection getConnection()
	{	
		if(conn == null){
			connection();
		}
		return conn;
	}
	
	
	/**
	 * 每次程序第一次运行时获取连接
	 * 配置多的发疯，注意编码，太坑了！！！！
	 */
	private static void connection() {
		  try {			  
			  //使用JDBC
			  Class.forName("com.mysql.jdbc.Driver");        

		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
		  
		  try {
			  //连接URL为'jdbc:mysql//服务器地址/数据库名 ' ，后面的2个参数分别是登陆用户名和密码
			  conn = DriverManager.getConnection(
					  "jdbc:mysql://localhost:3306/ELMSsql?useUnicode=true&characterEncoding=UTF-8","root","");
		  } catch (SQLException e) {
			e.printStackTrace();
		  }
	}
	
	
	/**
	 * 程序结束时调用
	 */
	public static void disconnect(){
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
