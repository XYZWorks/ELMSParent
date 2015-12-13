package util;
/** 
 * @author ymc 
 * @version 创建时间：2015年12月9日 下午8:42:20 
 *
 */
public enum TransferWay  {
	plane("飞机" , "航运"), train("火车" , "铁运"),car("汽车" ,"汽运");
	
	private final String transferWay;
	private final String storeLocation;
	private TransferWay(String transferWay , String storeLocation) {
		this.transferWay = transferWay;
		this.storeLocation = storeLocation;
	}
	
	public String getTransferWay() {
		return this.transferWay;
	}
	public String getStoreLocation(){
		return this.storeLocation;
	}
	
	public static TransferWay getStoreLocation(String storeLocation){
		switch (storeLocation) {
		case "航运":
			return plane;
		case "铁运":
			return train;
		case "汽运":
			return car;
		default:
			return null;
		}
	}
	
	
	public static TransferWay getTransferWay(String transferWay) {
		switch (transferWay) {
		case "飞机":
			return plane;
		case "火车":
			return train;
		case "汽车":
			return car;
		default:
			return null;
		}
	}
}
