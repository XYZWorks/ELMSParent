package ui.config;

import java.util.ArrayList;

import util.FormatMes;
import util.ResultMessage;
/**
  * 保存一些有用的UI层静态方法
  * @author czq
  * @date 2015-10-26
  */
public class UserfulMethod {
	
	/**
	 * 检查ID是否有误，返回有关信息
	 * @param ID
	 * @return
	 */
	public static final FormatMes checkID(String ID){
		if(ID.length() < 6){
			return FormatMes.WRONG_LENGTH;
		}
		
		for (int i = 0; i < ID.length(); i++) {
			if(!isAlaOrNum(ID.charAt(i))){
				return FormatMes.ILEGAL_CHAR;
			}
		}
		return FormatMes.CORRECT;
	}
	
	public static final FormatMes checkPhone(String phone) {
		if (phone.length() != 11) {
			return FormatMes.WRONG_LENGTH;
		}
		for (int i = 0; i < 11; i++) {
			if(!isNum(phone.charAt(i))){
				return FormatMes.ILEGAL_CHAR;
			}
			
		}

		return FormatMes.CORRECT;

	}
	
	public static ArrayList<String>  stringToArray(String total) {
		ArrayList<String> orders = new ArrayList<>();
		String[] spl = total.split(",");
		for (int i = 0; i < spl.length; i++) {
			orders.add(spl[i]);
		}
		return orders;
	}
	
	public static String orderArrayToString(ArrayList<String> array) {
		String result = "";
		
		try{
			for(int i = 0;i<array.size();i++){
				result = result+"订单号"+(i+1)+":"+array.get(i)+" ";
			}
		}
		catch(NullPointerException e){
		}
		return result;
	}
//	public static final FormatMes checkTexts(String texts){
//		for (int i = 0; i < texts.length(); i++) {
////			if(texts.charAt(i))
//		}
//		
//		
//	}
	
	
//	private static final boolean is_HANZI_OrAlaOrNum(){
//		
//	}
	
	
	
	/**
	 * 是否为字母或数字
	 * @param c
	 * @return
	 */
	private static final boolean isAlaOrNum(char c){
		return isNum(c)||isAla(c);
		
	}

	private static final boolean isNum(char c){
		if( c > '9' || c < '0'){
			return false;
		}else{
			return true;
		}
	}
	
	private static final boolean isAla(char c){
		if( c > 'z' || c < 'a'){
			return false;
			
		}else{
			return true;
		}
	}
	
	
}
