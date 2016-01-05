package ui.storemanager.alarm;

import java.awt.Color;

import org.dom4j.Element;

import ui.config.UserfulMethod;
import ui.storemanager.StoreManagerController;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.tools.MyWhitePanel;
import ui.util.ConfirmListener;
import ui.util.TipsDialog;
import util.FormatMes;
import util.ResultMessage;
import vo.store.StoreMessageVO;
import bl.storebl.StoreController;

/**
 * @author ymc
 * @version 创建时间：2015年12月16日 下午8:15:21
 *
 */
@SuppressWarnings("serial")
public class AlarmRecoverSinglePanel extends AlarmSetSinglePanel {

	MyWhitePanel whitePanel;
	
	MyLabel nowNum;
	MyLabel totalNum;
	MyLabel nowNumL;
	MyLabel totalNumL;

	MyLabel addNumL;
	MyTextField addNumT;
	StoreMessageVO target;

	public AlarmRecoverSinglePanel(Element config, StoreController bl, StoreManagerController controller) {
		super(config, bl, controller);
	}

	@Override
	protected void initWhitePanels(Element e) {
		//whitePanel = new MyWhitePanel(e.element("whitePanel"));
		whitePanel=new MyWhitePanel(65,150,600,240);
	
	}

	@Override
	protected void initLabels(Element e) {
		super.initLabels(e);
		nowNum = new MyLabel(e.element("nowNum"));
		totalNum = new MyLabel(e.element("totalNum"));
		nowNumL = new MyLabel(e.element("nowNumL"));
		totalNumL = new MyLabel(e.element("totalNumL"));
		addNumL = new MyLabel(e.element("addNumL"));

	}

	@Override
	protected void initTextFields(Element e) {
		addNumT = new MyTextField(e.element("addNumT"));
	}

	@Override
	protected void addCompoment() {
		add(center);
		add(centerL);
		add(storeNum);
		add(storeNumL);
		
		add(confirmButton);
		add(returnButton);
		
		whitePanel.add(nowValue);
		whitePanel.add(nowValueL);
		whitePanel.add(nowNum);
		whitePanel.add(nowNumL);
		whitePanel.add(totalNum);
		whitePanel.add(totalNumL);
		whitePanel.add(addNumL);
		whitePanel.add(addNumT);
		
		add(whitePanel);
	}

	@Override
	public void getInfo(String cen, String sto) {
		super.getInfo(cen, sto);
		for (StoreMessageVO vo : bl.show()) {
//			System.out.println(cen+" "+vo.location.getName());
			if (cen.equals(vo.location.getName()) && sto.equals(vo.storeLoc.getStoreLocation()+"区"))
				target = vo;
		}
		if(target!=null){
			nowNum.setText("   "+String.valueOf(target.number));
			totalNum.setText("   "+String.valueOf(target.totalNum));
		}
	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new UpdateListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "AlarmRecoverPanel", controller, true));
	}

	class UpdateListener extends ConfirmListener {
		int modifyNum;
		public UpdateListener(MyPictureButton button) {
			super(button);
		}

		@Override
		protected void reInitial() {
			addNumT.setText("");

		}

		@Override
		protected void updateMes() {
			totalNum.setText("    "+target.totalNum);

		}

		@Override
		protected boolean checkDataValid() {
			if(UserfulMethod.checkPositiveNum(addNumT.getText())!=FormatMes.CORRECT){
				new TipsDialog("输入格式有误");
				return false;
			}
			else {
				modifyNum = Integer.parseInt(addNumT.getText());
				return true;
			}
		}

		@Override
		protected boolean saveToSQL() {
			target.totalNum =target.totalNum+ modifyNum;
			ResultMessage res = bl.update(target);
			if(res ==ResultMessage.SUCCESS){
				new TipsDialog("成功修改库存容量",Color.GREEN);
				return true;
			}
			return false;

		}

	}
}
