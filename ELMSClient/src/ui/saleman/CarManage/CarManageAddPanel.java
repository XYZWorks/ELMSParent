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
import ui.tools.MyWhitePanel;
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
	
	private MyWhitePanel whitePanel;
	
	private MyPictureLabel addCar;
	
	private MyLabel id;
	private MyLabel plateNum;
	private MyLabel useYear;
	private MyLabel instid;
	private MyTextField instidT;
	private MyTextField idT;
	private MyTextField plateNumT;
	private MyTextField useYearT;
	
	DTManageblservice bl;
	public CarManageAddPanel(Element config, JPanel changePanel, String checkDocPanelStr, MyTablePanel messageTable, DTManageblservice bl ) {
		super(config , changePanel , checkDocPanelStr,  messageTable);
		this.bl = bl;
		
	}

	@Override
	protected void initWhitePanels(Element e) {
		whitePanel=new MyWhitePanel(e.element("whitePanel"));

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
		instidT = new MyTextField(e.element("instid"));
	}

	@Override
	protected void initLabels(Element e) {
		addCar=new MyPictureLabel(e.element("addCar"));
		id = new MyLabel(e.element("id"));
		plateNum = new MyLabel(e.element("plateNum"));
		useYear = new MyLabel(e.element("useYear"));
		instid = new MyLabel(e.element("instid"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addCompoment() {
		whitePanel.add(addCar);
		whitePanel.add(id);
		whitePanel.add(plateNum);
		whitePanel.add(useYear);
		whitePanel.add(idT);
		whitePanel.add(plateNumT);
		whitePanel.add(useYearT);
		whitePanel.add(instid);
		whitePanel.add(instidT);
		
		//修改从父类里继承的confirm cancel的位置
		confirm.setLocation(320,470);
		cancel.setLocation(450,470);
		
		
		this.add(whitePanel);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String id;
			String plateNum;
			String useYear;
			String instid;
			CarVO vo;
			@Override
			protected boolean saveToSQL() {
				if(isAddOrModify){
					result = bl.addCar(vo = new CarVO(id , instid , plateNum, Integer.parseInt(useYear)));
					if(result == ResultMessage.SUCCESS){
						new TipsDialog("成功增加司机信息" , Color.GREEN);
						return true;
					}else{
						new TipsDialog("未能增加司机信息", Color.RED);
						System.err.println(result);
						return false;
					}
				}else{
					result = bl.modifyCar(vo = new CarVO(id, instid ,plateNum, Integer.parseInt(useYear)));
					if(result == ResultMessage.SUCCESS){
						new TipsDialog("成功修改司机信息" , Color.GREEN);
						return true;
					}else{
						new TipsDialog("未能修改司机信息", Color.RED);
						System.err.println(result);
						return false;
					}
				}
				
			}
			
			@Override
			protected void reInitial() {
				myInit();
			}
			
			@Override
			protected boolean checkDataValid() {
				id = idT.getText();
				plateNum = plateNumT.getText();
				useYear = useYearT.getText();
				instid = instidT.getText();
				SimpleDataFormat[] datas = {new SimpleDataFormat(id, DataType.ID, "ID") , new SimpleDataFormat(instid, DataType.ID, "机构ID"), new SimpleDataFormat(plateNum, DataType.PlateNum, "车牌号")};
				return UserfulMethod.dealWithData(datas);
			}

			@Override
			protected void updateMes() {
				if(isAddOrModify){
					messageTable.addOneData(vo, 1);
				}else {
					messageTable.addOneData(vo, 2);
				}
				
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
		idT.setText("");plateNumT.setText("");useYearT.setText("");instidT.setText("");
	}
	
	@Override
	public void setAddOrModify(boolean isAdd, String id) {
		isAddOrModify = isAdd;
		idT.setEditable(isAdd);
		
		if(isAdd){
			
		}else{
			idT.setText(id);
		}
		
		
	}
	
}
