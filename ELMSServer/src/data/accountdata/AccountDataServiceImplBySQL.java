package data.accountdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DataBaseInit;
import po.AccountPO;
import util.AccountType;
import util.ResultMessage;
import ds.accountdataservice.AccountDataService;

/**
 * 使用数据库实现账户数据层
 * 
 * @author czq
 * @version 2015年10月30日 下午12:02:04
 */
public class AccountDataServiceImplBySQL implements AccountDataService {

	private Connection conn;

	private PreparedStatement prestate;

	public AccountDataServiceImplBySQL() {
		this.conn = DataBaseInit.getConnection();
	}

	public ResultMessage add(AccountPO po) throws RemoteException {

		try {
			String sql = "insert into account values(?,?,?,?,?,?)";
			prestate = conn.prepareStatement(sql);
			prestate.setString(1, po.getID());
			prestate.setString(2, po.getName());
			prestate.setString(3, po.getType().getName());
			prestate.setString(4, po.getPassword());
			prestate.setString(5, po.getPhoneNum());
			prestate.setString(6, po.getMail());
			if (prestate.execute()) {
				return ResultMessage.SUCCESS;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;

	}

	public ResultMessage initial() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * version : 10-30
	 */
	public AccountPO find(String ID) throws RemoteException {

		try {
			String sql = "select * from account";
			prestate = conn.prepareStatement(sql);
			ResultSet result = prestate.executeQuery();
			while (result.next()) {
				if (result.getString(1).equalsIgnoreCase(ID)) {
					return new AccountPO(result.getString(1),
							result.getString(2), AccountType.getType(result
									.getString(3)), result.getString(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ResultMessage delete(String ID) throws RemoteException {
		try {
			String sql = "delete from account where ID = " + ID;
			prestate = conn.prepareStatement(sql);
			if (prestate.execute()) {
				return ResultMessage.SUCCESS;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;

	}

	public ResultMessage modify(AccountPO po) throws RemoteException {

		try {
			String sql = "update account set name = ? , type = ? , password = ? , telephone = ? where id = " +po.getID() ;
			prestate = conn.prepareStatement(sql);
			prestate.setString(1, po.getName());
			prestate.setString(2, po.getType().getName());
			prestate.setString(3, po.getPassword());
			prestate.setString(4, po.getPhoneNum());
			if (prestate.execute()) {
				return ResultMessage.SUCCESS;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;

	}

	public ResultMessage check(String ID, String password)
			throws RemoteException {
		try {
			String sql = "select id,password from account";
			prestate = conn.prepareStatement(sql);
			ResultSet results = prestate.executeQuery();
			while(results.next()){
				if(results.getString(1).equalsIgnoreCase(ID) && results.getString(2).equalsIgnoreCase(password)){
					return ResultMessage.SUCCESS;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public AccountPO getMes(String ID) throws RemoteException {
		try {
			String sql = "select * from account";
			prestate = conn.prepareStatement(sql);
			ResultSet results = prestate.executeQuery();
			while(results.next()){
				if(results.getString(1).equalsIgnoreCase(ID)){
					return new AccountPO(results.getString(1), results.getString(2), AccountType.getType(results.getString(3)), results.getString(4),results.getString(5),results.getString(6));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		AccountDataService test = new AccountDataServiceImplBySQL();
		try {
			 test.add(new AccountPO("124414", "c阿斯顿", AccountType.financeman,
			 "111111"));
			 test.modify(new AccountPO("124414", "陈自强", AccountType.manager,
			 "111111"));
			 AccountPO po = test.find("124414");
			 System.out.println(po.getID());
			 System.out.println(po.getName());
//			test.delete("124413");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
