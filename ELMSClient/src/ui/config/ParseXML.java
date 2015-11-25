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
	
	private String pres = "docs\\";
	
	private String xmlPath=  "UIConfig.xml";
	
	
	
	private SAXReader reader;
	
	private Document doc;

	public ParseXML() {
		init(xmlPath);
	}
	
	public ParseXML(String xmlPath) {
		init(xmlPath);
	}
	
	private void init(String xmlPath){
		
		try {
			 reader = new SAXReader();
			 doc = reader.read(new File(pres + xmlPath));
			 root = doc.getRootElement();
			
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public Element getConfig(String node){
		return root.element(node);
	}
	
	/**
	 * 获得根节点
	 * @return
	 */
	public Element getRoot(){
		return root;
	}
}
