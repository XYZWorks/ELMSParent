package vo;


import util.Date;
import util.DocState;
import util.DocType;
/**
 * 所有单据VO类父类
 * @author czq
 *
 */
public abstract class DocVO {
	/**
	 * 单据ID
	 */
	public String ID;
	/**
	 * 单据类型
	 */
	public DocType type;
	/**
	 * 日期
	 */
	public Date date;
	/**
	 * 单据状态
	 */
	public DocState state;
	
	
	public DocVO(String iD, DocType type, Date date, DocState state) {
		super();
		ID = iD;
		this.type = type;
		this.date = date;
		this.state = state;
	}


	
	
	
}
