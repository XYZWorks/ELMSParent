package ui.financeman.bulidBill;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.generalmanager.people.PeopleMesPanel;
import ui.saleman.CarManage.CarMesTable;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyBackListener;
import vo.DTManage.CarVO;
import vo.personnel.PersonVO;
 /** 
 * 
 * @author czq 
 * @version 2015年12月29日 下午6:38:16 
 */
@SuppressWarnings("serial")
public class DetailPanel extends MyPanel{
	
	PeopleMesPanel peopleMesPanel;
	CarMesTable carMesTable;
	MyPictureButton back;
	JPanel changePanel;
	String backStr;
	public DetailPanel(Element config , JPanel changePanel ,String backStr) {
		super(config);
		this.backStr = backStr;
		this.changePanel = changePanel;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();
	}
	void showDetail(ArrayList<PersonVO> personVOs , ArrayList<CarVO> carVOs){
		peopleMesPanel.changeMes(personVOs);
		carMesTable.setMes(carVOs);
	}
	
	
	
	@Override
	protected void initWhitePanels(Element e) {
	}

	@Override
	protected void initButtons(Element e) {
		back = new MyPictureButton();
		
	}

	@Override
	protected void initTextFields(Element e) {
	}

	@Override
	protected void initLabels(Element e) {
	}

	@Override
	protected void initOtherCompoment(Element e) {
		peopleMesPanel = new PeopleMesPanel(e.element("peopleMes"));
		carMesTable = new CarMesTable(e.element("carMes"));
	}

	@Override
	protected void addCompoment() {
		add(peopleMesPanel);add(carMesTable);add(back);
		
	}

	@Override
	protected void addListener() {
		back.addMouseListener(new MyBackListener(back, changePanel, backStr));
		
	}

}
