package util;
/** 
 * @author ymc 
 * @version 创建时间：2015年12月9日 下午8:42:20 
 *
 */
public enum TransferWay {
	plane("飞机"), train("火车"),car("汽车");
	
	private final String name;
	private TransferWay(String name) {
		this.name = name;
	}
}
