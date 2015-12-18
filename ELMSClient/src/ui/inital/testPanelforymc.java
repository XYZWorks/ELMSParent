package ui.inital;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.dom4j.Element;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

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
		

		try {
			System.setProperty("sun.java2d.noddraw", "true");
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	

			UIManager.put("RootPane.setupButtonVisible" ,false);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialPanel3 initalPanel = new initialPanel3(e.element("initialpanel3") , this );


		this.setContentPane(initalPanel);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		ParseXML parseXML = new ParseXML("ymc.xml");
		testPanelforymc test = new testPanelforymc(parseXML.getRoot());
	}

}
