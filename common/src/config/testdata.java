package config;
 /** * @author czq @version 创建时间：2015年10月30日 上午11:50:11 * 简单说明 */
public class testdata {

	public static void main(String[] args) {
		if(DataBaseInit.getConnection() != null){
			System.out.println("succeed to bulid database");
		}

	}

}
