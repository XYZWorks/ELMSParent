package vo.finance;

import util.MyDate;

/**
 * 财务人员新建付款单，内容包括
 * 付款日期、付款金额、付款人、付款账号、条目（租金（按年收）运费（按次计算）人员工资（包括司机之类的）
 * （按月统计）奖励（一次性））
 * 备注（租金年份、运单号、标注工资月份）。（快递员提成、司机计次、业务员月薪））
 * @author ymc
 *
 */
public class PayVO {
	/**
	 * ID
	 */
	public String ID;
	/**
	 * 时间
	 */
	public MyDate time;
	/**
	 * 银行账户
	 */
	public String account;
	/**
	 * 金额
	 */
	public int money;
	/**
	 * 经手人
	 */
	public String person;
	/**
	 * 租金
	 */
	public int rent;
	/**
	 * 运费
	 */
	public int freight;
	/**
	 * 工资
	 */
	public int salary;
	public PayVO() {}
	public PayVO(String iD, MyDate time, String account, int money,
			String person, int rent, int freight, int salary) {
		super();
		ID = iD;
		this.time = time;
		this.account = account;
		this.money = money;
		this.person = person;
		this.rent = rent;
		this.freight = freight;
		this.salary = salary;
	}
	
	
}
