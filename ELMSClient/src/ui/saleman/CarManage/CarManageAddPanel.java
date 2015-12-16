package ui.saleman.CarManage;

import java.awt.Color;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
import ui.tools.MyLabel;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
import ui.util.TipsDialog;
import util.ResultMessage;
import vo.DTManage.CarVO;
import blservice.DTManageblservice.DTManageblservice;
 /** 
 * 车辆管理增加界面
 * @author czq 
 * @version 2015年12月8日 下午8:16:56 
 */
@SuppressWarnings("serial")
public class CarManageAddPanel extends AddDocPanel {
	
	private MyLabel id;
	private MyLabel plateNum;
	private MyLabel useYear;

	private MyTextField idT;
	private MyTextField plateNumT;
	private MyTextField useYearT;
	
	DTManageblservice bl;
	public CarManageAddPanel(Element config, JPanel changePanel, String checkDocPanelStr, MyTablePanel messageTable ) {
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
		plateNumT = new MyTextField(e.element("plateNum"));
		useYearT = new MyTextField(e.element("useYear"));

	}

	@Override
	protected void initLabels(Element e) {
		id = new MyPictureLabel(e.element("id"));
		plateNum = new MyPictureLabel(e.element("plateNum"));
		useYear = new MyPictureLabel(e.element("useYear"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addCompoment() {
		add(id);add(plateNum);add(useYear);add(idT);add(plateNumT);add(useYearT);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String id;
			String plateNum;
			String useYear;
			@Override
			protected boolean saveToSQL() {
				
				if(bl.addCar(new CarVO(id, plateNum, Integer.parseInt(useYear))) == ResultMessage.SUCCESS){
					new TipsDialog("成功增加司机信息" , Color.GREEN);
					return true;
				}else{
					new TipsDialog("未能增加司机信息", Color.RED);
					return false;
				}
			}
			
			@Override
			protected void reInitial() {
				myInit();
			}
			
			@Override
			protected boolean checkDataValid() {
				System.err.println("2222222222");
				id = idT.getText();
				plateNum = plateNumT.getText();
				useYear = useYearT.getText();
				SimpleDataFormat[] datas = {new SimpleDataFormat(id, DataType.ID, "ID") , new SimpleDataFormat(plateNum, DataType.PlateNum, "车牌号")};
				return UserfulMethod.dealWithData(datas);
			}

			@Override
			protected void updateMes() {
				String[] data = { id, plateNum , useYear };
				messageTable.addOneRow(data);
				
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			
			@Override
			public void resetMes() {
				myInit();
			}
		});
	}
	
	private void  myInit() {
		idT.setText("");plateNumT.setText("");useYearT.setText("");
	}
}
