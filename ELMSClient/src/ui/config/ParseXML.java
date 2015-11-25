package ui.config;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 对XML文件进行解析（读取修改）
 * @author czq
 * @version 2015年11月25日 下午3:32:05
 */
public class ParseXML {

	
	private Element root;

	private String xmlPath=  "docs\\UIConfig.xml";
	
	private static ParseXML XMLReader;
	
	private SAXReader reader;
	
	private Document doc;

	private ParseXML() {
		init(xmlPath);
	}
	
	public static ParseXML getXMLReader(){
		if(XMLReader==null){
			XMLReader = new ParseXML();
		}
		
		return XMLReader;
	}
	
	private void init(String xmlPath){
		
		try {
			 reader = new SAXReader();
			 doc = reader.read(new File(xmlPath));
			 root = doc.getRootElement();
			
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public Element getConfig(String node){
		return root.element(node);
	}
}
