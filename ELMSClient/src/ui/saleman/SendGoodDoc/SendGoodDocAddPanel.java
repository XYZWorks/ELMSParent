package ui.saleman.SendGoodDoc;

import java.awt.Color;

import javax.swing.JPanel;

import org.dom4j.Element;

import blservice.transportblservice.Transportblservice;
import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
import ui.tools.MyComboBox;
import ui.tools.MyDatePicker;
import ui.tools.MyLabel;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
import ui.util.TipsDialog;
import util.City;
import util.MyDate;
import util.ResultMessage;
import vo.transport.SendGoodDocVO;

/**
 * 派送单增加界面
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class SendGoodDocAddPanel extends AddDocPanel{
	
	private MyLabel id;
	private MyDatePicker date;
	private MyLabel sendMan;
	private MyLabel orderBarCode;
	private MyLabel sendCity;
	
	private MyTextField idT;
	private MyTextField sendManT;
	private MyTextField orderBarCodeT;
	private MyComboBox sendCityB;
	
	Transportblservice bl;
	
	public SendGoodDocAddPanel(Element config, JPanel changePanel, String checkDocPanelStr, MyTablePanel messageTable , Transportblservice bl) {
		super(config , changePanel , checkDocPanelStr,  messageTable );
		this.bl = bl;
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
		sendManT = new MyTextField(e.element("sendMan"));
		orderBarCodeT = new MyTextField(e.element("orderBarCode"));
		
	}

	@Override
	protected void initLabels(Element e) {
		id = new MyPictureLabel(e.element("id"));
		sendMan = new MyPictureLabel(e.element("sendMan"));
		orderBarCode = new MyPictureLabel(e.element("orderBarCode"));
		sendCity = new MyPictureLabel(e.element("sendCity"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		date = new MyDatePicker(e.element("datepicker"));
		sendCityB = new MyComboBox(e.element("sendCity"));
	}

	@Override
	protected void addCompoment() {
		add(sendMan);add(sendManT);add(sendCity);add(sendCityB);add(date);add(id);add(idT);
		add(orderBarCode);add(orderBarCodeT);
		
	}

	@Override
	protected void addListener() {
		
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String id;
			MyDate myDate;
			String sendMan;
			String orderBarCode;
			City sendCity;
			@Override
			protected boolean checkDataValid() {
				id = idT.getText();
				myDate = date.getMyDate();
				sendMan = sendManT.getText();
				orderBarCode = orderBarCodeT.getText();
				sendCity = City.toCity((String) sendCityB.getSelectedItem());
				SimpleDataFormat[] datas = {new SimpleDataFormat(id, DataType.ID, "ID")  , new SimpleDataFormat(orderBarCode, DataType.ID, "订单号")};
				return UserfulMethod.dealWithData(datas);
			}
			@Override
			protected void updateMes() {
				String[] data = {id, MyDate.toString(myDate), sendMan, orderBarCode,sendCity.getName()};
				messageTable.addOneRow(data);
			}
			
			@Override
			protected boolean saveToSQL() {
				if(bl.add(new SendGoodDocVO(id, myDate, sendMan, orderBarCode, sendCity))==ResultMessage.SUCCESS){
					new TipsDialog("成功生成接收单~"  , Color.GREEN);
					return true;
				}else{
					new TipsDialog("接收单可能单据ID重复或数据库问题，未能保存成功", Color.RED);
					return false;
				}
			}
			
			@Override
			protected void reInitial() {
				myInit();
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
		idT.setText("");
		sendManT.setText("");
		orderBarCodeT.setText("");
	}
}
