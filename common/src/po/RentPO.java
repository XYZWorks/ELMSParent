package po;

import java.io.Serializable;

/**
 *租金成本信息
 *@author ymc
 *
 */
public class RentPO extends CostPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	public RentPO(int money, String type) {
		super(money, type);
		// TODO Auto-generated constructor stub
	}

}
