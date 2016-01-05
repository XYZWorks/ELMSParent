package ui.storemanager.alarm;

import java.awt.Color;

import javax.sound.midi.Synthesizer;

import org.dom4j.Element;

import ui.config.SimpleDataFormat;
import ui.storemanager.StoreManagerController;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.tools.MyWhitePanel;
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
	MyWhitePanel whitePanel;

	MyPictureButton confirmButton;
	MyPictureButton returnButton;

	MyPictureLabel centerL;
	MyPictureLabel storeNumL;
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
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();
	}

	@Override
	protected void initWhitePanels(Element e) {
		//whitePanel = new MyWhitePanel(e.element("whitePanel"));
		whitePanel=new MyWhitePanel(65,150,600,230);
	
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
		centerL = new MyPictureLabel(e.element("centerL"));
		storeNumL = new MyPictureLabel(e.element("storeNumL"));
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
		whitePanel.add(modifyL);
		whitePanel.add(modifyT);
		whitePanel.add(nowValue);
		whitePanel.add(nowValueL);

		add(whitePanel);
		add(center);
		add(centerL);
		add(storeNum);
		add(storeNumL);
		add(confirmButton);
		add(returnButton);

	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new ModifyListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "AlarmSetPanel", controller, true));

	}

	class ModifyListener extends ConfirmListener {
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
			nowValue.setText(bl.getAlarmValue(City.toCity(center.getText())) + "%");

		}

		@Override
		protected boolean checkDataValid() {
			value = modifyT.getText();
			int val = 0;
			try {
				val = Integer.parseInt(value);
			} catch (NumberFormatException e) {
				new TipsDialog("警戒值为正整数");
				return false;
			}
			if (val <= 100 && val > 0)
				return true;
			new TipsDialog("警戒值在0到100之间");
			return false;
		}

		@Override
		protected boolean saveToSQL() {
			ResultMessage re = bl.setAlarmValue(value, City.toCity(center.getText()));
			if (re == ResultMessage.SUCCESS)
				new TipsDialog("修改" + center.getText() + "市警戒值成功",Color.GREEN);
			return true;
		}

	}

	public void getInfo(String cen, String sto) {
		center.setText(cen);
		storeNum.setText(sto);
		nowValue.setText(bl.getAlarmValue(City.toCity(cen)) + "%");
	}

}
