package ui.storemanager.alarm;

import org.dom4j.Element;

import ui.storemanager.StoreManagerController;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.PanelController;
import ui.util.TipsDialog;
import util.City;
import util.ResultMessage;
import bl.storebl.StoreController;

/**
 * @author ymc
 * @version 创建时间：2015年12月16日 下午4:42:52
 *
 */
@SuppressWarnings("serial")
public class AlarmSetSinglePanel extends MyPanel {

	MyPictureButton confirmButton;
	MyPictureButton returnButton;

	MyLabel centerL;
	MyLabel storeNumL;
	MyLabel center;
	MyLabel storeNum;

	
	MyLabel nowValueL;
	MyLabel nowValue;
	MyLabel modifyL;

	MyTextField modifyT;
	

	StoreController bl;
	PanelController controller;

	public AlarmSetSinglePanel(Element config, StoreController bl, StoreManagerController controller) {

		super(config);
		this.bl = bl;
		this.controller = controller;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));

		initOtherCompoment(config);
		addCompoment();
		addListener();
	}

	@Override
	protected void initButtons(Element e) {
		confirmButton = new MyPictureButton(e.element("confirm"));
		returnButton = new MyPictureButton(e.element("return"));

	}

	@Override
	protected void initTextFields(Element e) {
		modifyT = new MyTextField(e.element("modifyT"));

	}

	@Override
	protected void initLabels(Element e) {
		centerL = new MyLabel(e.element("centerL"));
		storeNumL = new MyLabel(e.element("storeNumL"));
		center = new MyLabel(e.element("center"));
		storeNum = new MyLabel(e.element("storeNum"));
		nowValue = new MyLabel(e.element("nowValue")); 
		nowValueL = new MyLabel(e.element("nowValueL")); 
		modifyL = new MyLabel(e.element("modifyL"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addCompoment() {
		add(center);
		add(centerL);
		add(confirmButton);
		add(modifyL);
		add(modifyT);
		add(nowValue);
		add(nowValueL);
		add(returnButton);
		add(storeNum);
		add(storeNumL);
		

	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new ModifyListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "AlarmSetPanel", controller,true));

	}
	class ModifyListener extends ConfirmListener{
		String value;
		public ModifyListener(MyPictureButton button) {
			super(button);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void reInitial() {
			modifyT.setText("");
			
		}

		@Override
		protected void updateMes() {
			nowValue.setText(bl.getAlarmValue(City.toCity(center.getText()))+"%");
			
		}

		@Override
		protected boolean checkDataValid() {
			value = modifyT.getText();
			if(Integer.parseInt(value)<=100&&Integer.parseInt(value)>=0)
				return true;
			return false;
		}

		@Override
		protected boolean saveToSQL() {
			ResultMessage re = bl.setAlarmValue(value, City.toCity(center.getText()));
			if(re==ResultMessage.SUCCESS)
				new TipsDialog("修改"+center.getText()+"市警戒值成功");
			return true;
		}
		
	}
	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}
	
	public void getInfo(String cen, String sto) {
		center.setText(cen);
		storeNum.setText(sto);
		nowValue.setText(bl.getAlarmValue(City.toCity(cen))+"%");
	}

}
