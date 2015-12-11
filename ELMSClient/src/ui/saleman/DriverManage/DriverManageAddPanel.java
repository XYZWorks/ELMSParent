package ui.saleman.DriverManage;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
 /** 
 * 司机增加界面
 * @author czq 
 * @version 2015年12月8日 下午8:17:45 
 */
@SuppressWarnings("serial")
public class DriverManageAddPanel extends AddDocPanel {
	private MyLabel id;
	private MyLabel name;
	private MyLabel bornDay;
	private MyLabel phone;
	
	private MyTextField idT;
	private MyTextField nameT;
	private MyTextField phoneT;
	
	MyDatePicker borns;
	public DriverManageAddPanel(Element config, JPanel changePanel, String checkDocPanelStr, MyTablePanel messageTable) {
		super(config , changePanel , checkDocPanelStr,  messageTable);
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initTextFields(Element e) {
		idT = new MyTextField(e.element("id"));
		nameT = new MyTextField(e.element("name"));
		phoneT = new MyTextField(e.element("phone"));


	}

	@Override
	protected void initLabels(Element e) {
		id = new MyPictureLabel(e.element("id"));
		name = new MyPictureLabel(e.element("name"));
		bornDay = new MyPictureLabel(e.element("bornday"));
		phone = new MyPictureLabel(e.element("phone"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		borns = new MyDatePicker(e.element("borns"));

	}

	@Override
	protected void addCompoment() {
		add(bornDay);add(borns);add(id);add(idT);add(name);add(nameT);add(phone);add(phoneT);

	}

	@Override
	protected void addListener() {
		

	}

}
