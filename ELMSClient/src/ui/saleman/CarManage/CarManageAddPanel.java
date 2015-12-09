package ui.saleman.CarManage;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.AddDocPanel;
import ui.util.ConfirmListener;
 /** 
 * 车辆管理增加界面
 * @author czq 
 * @version 2015年12月8日 下午8:16:56 
 */
@SuppressWarnings("serial")
public class CarManageAddPanel extends AddDocPanel {
	
	
	
	
	public CarManageAddPanel(Element config, JPanel changePanel, String checkDocPanelStr) {
		super(config , changePanel , checkDocPanelStr);
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
		confirm.addMouseListener(new ConfirmListener(confirm) {
			
			@Override
			protected void saveToSQL() {
				// TODO Auto-generated method stub
				
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
		});

	}

}
