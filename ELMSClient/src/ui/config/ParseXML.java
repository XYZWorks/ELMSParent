package ui.config;

import org.w3c.dom.Element;

/**
 * 对XML文件进行解析（读取修改）
 * @author czq
 * @version 2015年11月25日 下午3:32:05
 */
public class ParseXML {

	
	private Element root;

	private String xmlPath=  "docs\\UIConfig.xml";
	
	private ParseXML XMLReader;

	private ParseXML() {
		init(xmlPath);
	}
	
	public ParseXML getXMLReader(){
		if(XMLReader==null){
			XMLReader = new ParseXML();
		}
		
		return XMLReader;
	}
	
	private void init(String xmlPath){
//		SAXReader re
		
		}
}
