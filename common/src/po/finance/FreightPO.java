package po.finance;

import java.io.Serializable;

/**
 * 运费信息
 * @author ymc
 * @version 创建时间：2015年10月26日 下午7:10:10
 */
public class FreightPO extends CostPO implements Serializable{
	
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	public FreightPO() {}
	
	public FreightPO(int money, String type) {
		super(money, type);
		// TODO Auto-generated constructor stub
	}

}
