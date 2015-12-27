package ui.config;
 /** 
 * 
 * @author czq 
 * @version 2015年12月16日 下午1:09:32 
 */
public enum DataType {
	ID("ID"),phone("手机号"), idCard("身份证号") , PositiveNum("数字") , PlateNum("车牌号") , bankAccount("银行账户"),BarCode("订单的条形码号"),StoreNum("仓库区号");
	
	private String name;
	
	private DataType(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
