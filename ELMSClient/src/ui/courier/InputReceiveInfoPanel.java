package ui.courier;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.util.CompomentType;

@SuppressWarnings("serial")
public class InputReceiveInfoPanel extends MyPanel{

	public InputReceiveInfoPanel(Element config) {
		// TODO Auto-generated constructor stub
		super(config);
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		setVisible(true);
		//System.out.println("couriermainpanel has existed!!");
	}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLabels(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addCompoment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

}
