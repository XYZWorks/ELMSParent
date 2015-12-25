package ui.storemanager.storecheck;

import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.dom4j.Element;

import com.eltima.components.ui.a3;

import bl.storebl.StoreController;
import ui.storemanager.instore.InStoreTablePanel;
import ui.storemanager.outstore.OutStoreTablePanel;
import ui.storemanager.storeshow.OrderInfoTable;
import ui.storemanager.storeshow.StoreSingleShowPanel;
import ui.tools.MyDatePicker;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.MyPictureButtonListener;
import ui.util.PanelController;
import ui.util.TipsDialog;
import util.MyDate;
import util.ResultMessage;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
import vo.store.StoreMessageVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月13日 下午3:54:03 
 *
 */
public class StoreCheckInfoPanel extends StoreSingleShowPanel {

	public StoreCheckInfoPanel(Element config, StoreController bl, PanelController controller) {
		super(config, bl, controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initButtons(Element e) {
		confirmButton = new MyPictureButton(e.element("confirm"));
		returnButton = new MyPictureButton(e.element("return"));

	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLabels(Element e) {
		center = new MyLabel(e.element("center"));
		centerL = new MyLabel(e.element("centerL"));
		storeNum = new MyLabel(e.element("storeNum"));
		storeNumL = new MyLabel(e.element("storeNumL"));
		infoin = new MyLabel(e.element("infoin"));
		infoout = new MyLabel(e.element("infoout"));
		nowNum = new MyLabel(e.element("nowNum"));
		nowNumL = new MyLabel(e.element("nowNumL"));
		nowTime = new MyLabel(e.element("nowTime"));
		nowTimeL = new MyLabel(e.element("nowTimeL"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		nowDate = MyDate.getNowTime();
		nowTime.setText(MyDate.toString(nowDate));
		outTable = new OutStoreTablePanel(e.element("outTable"), bl, MyDate.getNowTime());
		inTable = new InStoreTablePanel(e.element("inTable"), bl,  MyDate.getNowTime());
		
	}

	@Override
	protected void addCompoment() {
		add(confirmButton);
		add(returnButton);
		add(center);
		add(centerL);
		add(storeNum);
		add(storeNumL);
		add(infoin);
		add(infoout);
		add(nowNum);
		add(nowNumL);
		add(nowTime);
		add(nowTimeL);
		add(outTable);
		add(inTable);
	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new ExportListener(confirmButton));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "StoreCheckPanel", controller,true));

	}
	
	class ExportListener extends MyPictureButtonListener{

		public ExportListener(MyPictureButton button) {
			super(button);
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			ResultMessage result = bl.exportExcel("库存快照"+MyDate.toString(MyDate.getNowTime())+" "+center.getText()+storeNum.getText(), target);
//			ResultMessage result = bl.exportExcel("库存快照"+MyDate.toString(MyDate.getNowTime()), target);

			if(result==ResultMessage.SUCCESS)
				new TipsDialog("导出excel成功");
			else { 
				new TipsDialog("导出excel失败");
			}
		}
		
	}
	@Override
	public void getInfo(String cen, String sto) {
		center.setText(cen);
		storeNum.setText(sto);
		for (StoreMessageVO vo : bl.show()) {
			if (cen.equals(vo.location.getName()) && sto.equals(vo.storeLoc.getStoreLocation()+"区")){
				target = vo;
				break;
			}
				
		}
		if(target!=null){
			ins = new ArrayList<>();
			outs = new ArrayList<>();
			nowNum.setText("   "+String.valueOf(target.number));
			ArrayList<InStoreDocVO> instmp = target.inStoreDocs;
			ArrayList<OutStoreDocVO> outstmp = target.outStoreDocs;
			for(InStoreDocVO in : instmp){
				if(in.date.equals(nowDate))
					ins.add(in);
			}
			target.inStoreDocs = ins;
			
			for(OutStoreDocVO out : outstmp){
				if(out.date.equals(nowDate))
					outs.add(out);
			}
			
			target.outStoreDocs = outs;
			inTable.resetValue(ins);
			
			outTable.resetValue(outs);
		}
	}

}
