package po.order;

import java.io.Serializable;
 /** 
 * 寄件人、收件人信息封装类
 * @author czq 
 * @version 2015年11月22日 下午12:02:03 
 */
public class PeopleMes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String phone;
	String company;
	String address;
	public PeopleMes(String name, String phone, String company, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.company = company;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
