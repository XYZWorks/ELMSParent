package ui.courier.inputInfoReceive;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.dom4j.Element;

import com.eltima.components.ui.DatePicker;

import bl.orderbl.Order;
import blservice.orderblservice.Orderblservice;
import ui.tools.MyDatePicker;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MySearchBox;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;

@SuppressWarnings("serial")
public class InputReceiveInfoPanel extends MyPanel{
	
	/**
	 * 确认修改的按钮 如果点击确认修改 则更新所有改动数据
	 */
	private MyPictureButton confirm;
	
	/**
	 * 取消修改的按钮 如果点击取消 则撤销本次的所有改动
	 */
	private MyPictureButton cancel;
	
	private MyDatePicker datePicker;
	private MySearchBox searchBox;
	
	private inputReceiveTablePanel table;
	private Orderblservice bl;
	
	public InputReceiveInfoPanel(Element config,Orderblservice bl) {
		// TODO Auto-generated constructor stub
		super(config);
		this.bl=bl;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		setVisible(true);

	}

	@Override
	protected void initButtons(Element e) {
		confirm=new MyPictureButton(e.element("confirm"));
		cancel=new MyPictureButton(e.element("cancel"));
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
		datePicker=new MyDatePicker(e.element("datePicker"));
		searchBox=new MySearchBox(e.element("searchBox"));
		//initTabel
		table=new inputReceiveTablePanel(e.element("inputReceiveTable"), bl);
		
	}

	@Override
	protected void addCompoment() {
		this.add(cancel);
		this.add(confirm);
		this.add(table);
		this.add(datePicker);
		this.add(searchBox);
		
	}

	@Override
	protected void addListener() {
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				//TODO 重新读取数据
				
			}
		});
		
		confirm.addMouseListener(new ConfirmListener(confirm) {

			@Override
			protected boolean saveToSQL() {
				return false;
				// TODO Auto-generated method stub

			}

			@Override
			protected boolean checkDataValid() {
				// TODO 检查必填项目是否正确

				return true;
			}

			@Override
			protected void reInitial() {
			}

			@Override
			protected void updateMes() {
				// TODO Auto-generated method stub
				
			}
		});

	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}
}
