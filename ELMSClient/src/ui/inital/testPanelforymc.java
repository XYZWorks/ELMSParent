package ui.inital;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.dom4j.Element;

import ui.config.ParseXML;
import ui.generalmanager.constSet.ConstSetPanel;
import ui.tools.MyFrame;

/** 
 * @author ymc 
 * @version 创建时间：2015年11月29日 下午3:09:02 
 *
 */
public class testPanelforymc extends MyFrame{

	public testPanelforymc(Element e) {
		super(e);
		
		initialPanel3 initalPanel = new initialPanel3(e.element("initialpanel3") , this );

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.setContentPane(initalPanel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		ParseXML parseXML = new ParseXML("ymc.xml");
		testPanelforymc test = new testPanelforymc(parseXML.getRoot());
	}

}
