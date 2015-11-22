package po;



import java.io.Serializable;

import util.MyDate;
import util.DocState;
import util.DocType;

/**
 * 所有单据PO类父类
 * @author czq
 *
 */
public abstract class DocPO implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 单据ID
	 */
	protected String ID;
	/**
	 * 单据类型
	 */
	protected DocType type;
	/**
	 * 日期
	 */
	protected MyDate date;
	/**
	 * 单据状态
	 */
	protected DocState state;
	
	
	public DocPO() {}
	
	public DocPO(String iD, DocType type, MyDate date, DocState state) {
		super();
		ID = iD;
		this.type = type;
		this.date = date;
		this.state = state;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public DocType getType() {
		return type;
	}


	public void setType(DocType type) {
		this.type = type;
	}


	public MyDate getDate() {
		return date;
	}


	public void setDate(MyDate date) {
		this.date = date;
	}


	public DocState getState() {
		return state;
	}


	public void setState(DocState state) {
		this.state = state;
	}
	
	
	
	
}
