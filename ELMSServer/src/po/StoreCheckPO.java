package po;

import util.Date;

public class StoreCheckPO {
	/**
	 * 时间
	 */
	private Date time;
	/**
	 * 库存信息
	 */
	private StoreMessagePO po;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public StoreMessagePO getPo() {
		return po;
	}
	public void setPo(StoreMessagePO po) {
		this.po = po;
	}
	/**
	 * 
	 * @param time
	 * @param vo
	 */
	public StoreCheckPO(Date time, StoreMessagePO po) {
		super();
		this.time = time;
		this.po = po;
	}
}
