package ui.storemanager.alarm;

import org.dom4j.Element;

import bl.storebl.StoreController;
import po.store.StoreMessagePO;
import ui.storemanager.StoreManagerController;
import ui.storemanager.alarm.AlarmSetSinglePanel.ModifyListener;
import ui.tools.MyButton;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.ConfirmListener;
import ui.util.TipsDialog;
import util.ResultMessage;
import vo.store.StoreMessageVO;

/**
 * @author ymc
 * @version 创建时间：2015年12月16日 下午8:15:21
 *
 */
public class AlarmRecoverSinglePanel extends AlarmSetSinglePanel {

	MyLabel nowNum;
	MyLabel totalNum;
	MyLabel nowNumL;
	MyLabel totalNumL;

	MyLabel addNumL;
	MyTextField addNumT;
	StoreMessageVO target;

	public AlarmRecoverSinglePanel(Element config, StoreController bl, StoreManagerController controller) {
		super(config, bl, controller);
		// TODO Auto-generated constructor stub
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
		add(confirmButton);
		add(nowValue);
		add(nowValueL);
		add(returnButton);
		add(storeNum);
		add(storeNumL);
		add(nowNum);
		add(nowNumL);
		add(totalNum);
		add(totalNumL);
		add(addNumL);
		add(addNumT);
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
			modifyNum = Integer.parseInt(addNumT.getText());
			if(modifyNum>0){
				return true;
			}
			else {
				new TipsDialog("库存容量未增加");
				return false;
			}
		}

		@Override
		protected boolean saveToSQL() {
			target.totalNum =target.totalNum+ modifyNum;
			ResultMessage res = bl.update(target);
			if(res ==ResultMessage.SUCCESS){
				new TipsDialog("成功修改库存容量");
				return true;
			}
			return false;

		}

	}
}
