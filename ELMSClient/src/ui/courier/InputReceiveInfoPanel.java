package ui.courier;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.dom4j.Element;

import bl.orderbl.Order;
import blservice.orderblservice.Orderblservice;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;

@SuppressWarnings("serial")
public class InputReceiveInfoPanel extends MyPanel{
	private MyPictureButton modify;
	private MyPictureButton cancel;
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
		modify=new MyPictureButton(e.element("modify"));
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
		//initTabel
		table=new inputReceiveTablePanel(e.element("inputReceiveTable"), bl);
		
	}

	@Override
	protected void addCompoment() {
		this.add(cancel);
		this.add(modify);
		this.add(table);
		this.add(table);
		
	}

	@Override
	protected void addListener() {
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				//重新加载表格
			}
		});
		
		modify.addMouseListener(new ConfirmListener(modify) {

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
