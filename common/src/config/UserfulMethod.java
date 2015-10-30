package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 /**
  * 保存一些有用的静态方法
  * @author czq
  * @date 2015-10-26
  */
public class UserfulMethod {
	public static List<String> getDocument(String filePath) {
		List<String> document = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(
					filePath)));
			String temp;
			while (true) {
				if ((temp = reader.readLine()) != null) {
					document.add(temp);
				}else{
					break;
				}
			}
			reader.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return document;
	}//#close the method
}
