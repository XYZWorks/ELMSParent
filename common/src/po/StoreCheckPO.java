package po;

import java.io.Serializable;

import util.Date;
/**
 * 库存快照信息
 * @author ymc
 *
 */
public class StoreCheckPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
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
