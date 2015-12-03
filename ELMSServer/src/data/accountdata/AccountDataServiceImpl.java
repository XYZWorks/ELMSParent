 package data.accountdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.account.AccountPO;
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
public class AccountDataServiceImpl extends DataSuperClass implements
		AccountDataService {

	private static final long serialVersionUID = 1L;
	
	private final String tableName = "account";
	
	public AccountDataServiceImpl() throws RemoteException {
		super();
	}

	public ResultMessage add(AccountPO po) throws RemoteException {
		return addToSQL( tableName, po.getID(), po.getName(), po.getType()
				.getName(), po.getPassword(), "", "");
	}
	
	public void initial() throws RemoteException {
		initialFromSQL(tableName);
		//管理员账户
		add(new AccountPO("000000" , "Adminstrator" , AccountType.Adminstrator , "000000"));
		
	}

	public AccountPO find(String ID) throws RemoteException {
		AccountPO po = getMes(ID);
		if (po != null) {
			po.setMail(null);
			po.setPhoneNum(null);
		}
		return po;
	}

	public ResultMessage delete(String ID) throws RemoteException {
		return delFromSQL(tableName, ID);
	}

	public ResultMessage modify(AccountPO po) throws RemoteException {
		return modifyFromSQL(tableName, po.getID(), po.getName(), po.getType()
				.getName(), po.getPassword(), po.getPhoneNum(), po.getMail());
	}

	public AccountPO check(String ID, String password)
			throws RemoteException {
		try {
			sql = "SELECT `id`,`password` FROM "  + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				if (result.getString(1).equalsIgnoreCase(ID)
						&& result.getString(2).equalsIgnoreCase(password)) {
					return find(ID);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public AccountPO getMes(String ID) throws RemoteException {
		findMes = findFromSQL(tableName, ID);
		if(findMes==null){
			return null;
		}else{
			return new AccountPO(findMes.get(0), findMes.get(1), AccountType.getType(findMes.get(2)), findMes.get(3), findMes.get(4), findMes.get(5));
		}
	}
	
	public ArrayList<AccountPO> show() throws RemoteException {
		ArrayList<AccountPO> pos = new ArrayList<AccountPO>(30);
		try {
			sql = "SELECT * FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new AccountPO(result.getString(1), result.getString(2), AccountType.valueOf(result.getString(3)), result.getString(4)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pos.size()==0?null:pos;
		
		
		
	}

	
	
	/**
	 * 仅供测试
	 * 
	 * @param args
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws RemoteException {
		AccountDataService test = new AccountDataServiceImpl();
		try {
			test.initial();
			 test.add(new AccountPO("124414", "c阿斯顿", AccountType.financeman,
			 "111111"));
			 test.add(new AccountPO("124415", "斯顿", AccountType.financeman,
			 "111111"));
			 test.modify(new AccountPO("124414", "陈自强你哈", AccountType.manager,
			 "111111"));
			AccountPO po = test.find("124415");
			System.out.println(po.getID());
			System.out.println(po.getName());
			// test.delete("124413");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

	
}
