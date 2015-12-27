package ui.config;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import config.StaticMessage;
 /** 
 * 负责从XML文件中读取配置
 * @author czq 
 * @version 2015年11月23日 上午10:05:52 
 */
public class XMLParser {
	
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	
	private String xmlFilepath;
	private String pres;
	Document document;
	public XMLParser(String filePath) {
		this.xmlFilepath = filePath;
		this.pres = StaticMessage.xmlPath;
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private void parse(String filepath){
		try {
			document = db.parse(new File(filepath));
			
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）
	// step 2:获得具体的dom解析器
	//      System.out.println("class name: " + db.getClass().getName());

	// step3: 解析一个xml文档，获得Document对象（根结点）

	

	NodeList list = document.getElementsByTagName("PERSON");

	


	
}
