package ui.inital;

import org.dom4j.Element;

import ui.config.ParseXML;
import ui.tools.MyFrame;
import util.AccountType;

/** * @author zr 
* @date 创建时间：2015年12月5日 下午6:37:04 
* @version 1.0 
* @parameter  
* @since  	
* @return  
*/
public class testframeforzr extends MyFrame{
		
	public static void main(String[] args) {
		ParseXML xml = new ParseXML("zr.xml");
		testframeforzr test = new testframeforzr(xml.getRoot(), null);
		
				
	}

	public testframeforzr(Element e , AccountType type) {
		super(e);
		
		InitalPanel4 initialPanel = new InitalPanel4(e.element("initialpanel"), this ,null);
		
		this.setContentPane(initialPanel);
		
		this.setVisible(true);
				
	}

}
