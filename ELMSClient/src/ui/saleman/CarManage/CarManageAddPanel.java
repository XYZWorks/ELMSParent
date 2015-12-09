package ui.saleman.CarManage;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.table.MyTablePanel;
import ui.tools.AddDocPanel;
import ui.tools.MyLabel;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.ConfirmListener;
 /** 
 * 车辆管理增加界面
 * @author czq 
 * @version 2015年12月8日 下午8:16:56 
 */
@SuppressWarnings("serial")
public class CarManageAddPanel extends AddDocPanel {
	
	MyLabel id;
	MyLabel plateNum;
	MyLabel useYear;

	MyTextField idT;
	MyTextField plateNumT;
	MyTextField useYearT;

	public CarManageAddPanel(Element config, JPanel changePanel, String checkDocPanelStr, MyTablePanel messageTable) {
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
			
			@Override
			protected void saveToSQL() {
				// TODO Auto-generated method stub
				
				//增加一条信息
//				messageTable.addOneRow(data);
			}
			
			@Override
			protected void reInitial() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected boolean checkDataValid() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			protected void updateMes() {
				// TODO Auto-generated method stub
				
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {
			
			@Override
			public void resetMes() {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
