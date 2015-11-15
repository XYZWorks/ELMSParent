package dataSuper;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ResultMessage;
import config.DataBaseInit;
/** 
 * 所有数据实现层的父类
 * @author czq 
 * @version 2015年10月31日 上午9:18:30 
 */
public class DataSuperClass extends UnicastRemoteObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Connection conn;
	
	protected PreparedStatement preState;
	
	protected String sql;
	
	protected ResultSet result;
	
	public DataSuperClass() throws RemoteException{
		this.conn = DataBaseInit.getConnection();
	}
	/**
	 * 执行语句并返回执行结果
	 * @param tempPreState
	 * @return
	 */
	protected ResultMessage getDoResult(PreparedStatement tempPreState){
		try {
			if(tempPreState.execute()){
				return ResultMessage.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	
	
}
