package ui.saleman.ArriveYYDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.CheckDocPanel;
import ui.tools.MySerachBox;
/**
 * 接收单查看界面
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class ArriveYYDocCheckPanel extends CheckDocPanel{

	

	public ArriveYYDocCheckPanel(Element config, JPanel changePanel) {
		super(config, changePanel);
		// TODO Auto-generated constructor stub
	}

	

	

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialAddDocPanel(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialOtherComp(Element e) {
		messageTable = new ArriveYYDocMesTable(e.element("table"));
		searchBox = new MySerachBox(e.element("search"));
		
		
	}

	@Override
	protected void addComp() {
		// TODO Auto-generated method stub
		
	}

}
