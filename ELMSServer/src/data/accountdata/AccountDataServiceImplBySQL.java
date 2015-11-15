package data.accountdata;

import java.rmi.RemoteException;
import java.sql.SQLException;

import po.AccountPO;
import util.AccountType;
import util.ResultMessage;
import dataSuper.DataSuperClass;
import ds.accountdataservice.AccountDataService;

/**
 * 使用数据库实现账户数据层
 * 
 * @author czq
 * @version 2015年10月30日 下午12:02:04
 */
public class AccountDataServiceImplBySQL extends DataSuperClass implements AccountDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public AccountDataServiceImplBySQL() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage add(AccountPO po) throws RemoteException {

			
			try {
				 sql = "insert into account values(?,?,?,?,?,?)";
				preState = conn.prepareStatement(sql);
				preState.setString(1, po.getID());
				preState.setString(2, po.getName());
				preState.setString(3, po.getType().getName());
				preState.setString(4, po.getPassword());
				preState.setString(5, po.getPhoneNum());
				preState.setString(6, po.getMail());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return getDoResult(preState);
			

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
			sql = "select * from account";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
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
			sql = "delete from account where ID = " + ID;
			preState = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getDoResult(preState);

	}

	public ResultMessage modify(AccountPO po) throws RemoteException {

		try {
			sql = "update account set name = ? , type = ? , password = ? , telephone = ? where id = " +po.getID() ;
			preState = conn.prepareStatement(sql);
			preState.setString(1, po.getName());
			preState.setString(2, po.getType().getName());
			preState.setString(3, po.getPassword());
			preState.setString(4, po.getPhoneNum());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getDoResult(preState);

	}

	public ResultMessage check(String ID, String password)
			throws RemoteException {
		try {
			sql = "select id,password from account";
			preState = conn.prepareStatement(sql);
			 result = preState.executeQuery();
			while(result.next()){
				if(result.getString(1).equalsIgnoreCase(ID) && result.getString(2).equalsIgnoreCase(password)){
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
			sql = "select * from account";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				if(result.getString(1).equalsIgnoreCase(ID)){
					return new AccountPO(result.getString(1), result.getString(2), AccountType.getType(result.getString(3)), result.getString(4),result.getString(5),result.getString(6));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 仅供测试
	 * @param args
	 */
	public static void main(String[] args) {
		AccountDataService test = new AccountDataServiceImplBySQL();
		try {
//			 test.add(new AccountPO("124414", "c阿斯顿", AccountType.financeman,
//			 "111111"));
//			 test.add(new AccountPO("124415", "斯顿", AccountType.financeman,
//					 "111111"));
//			 test.modify(new AccountPO("124414", "陈自强你哈", AccountType.manager,
//			 "111111"));
			 AccountPO po = test.find("124415");
			 System.out.println(po.getID());
			 System.out.println(po.getName());
//			test.delete("124413");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
