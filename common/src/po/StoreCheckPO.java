package po;

import java.io.Serializable;

import util.MyDate;
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
	private MyDate time;
	/**
	 * 库存信息
	 */
	private StoreMessagePO po;
	public MyDate getTime() {
		return time;
	}
	public void setTime(MyDate time) {
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
	public StoreCheckPO(MyDate time, StoreMessagePO po) {
		super();
		this.time = time;
		this.po = po;
	}
}
