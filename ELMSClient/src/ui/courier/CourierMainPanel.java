package ui.courier;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.ButtonState;
import ui.util.CompomentType;

/**
 * 快递员主界面
 * 
 * @author:xingcheng
 * @version 2015年11月26日
 */
public class CourierMainPanel extends MyPanel {

	private MyPictureButton addOrderButton;
	private MyPictureButton findFullInfoButton;
	private MyPictureButton inputReceiveButton;

	public CourierMainPanel(Element config) {
		super(config);
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLables(config.element(CompomentType.LABLES.name()));
		addCompoment();
		addListener();
		setVisible(true);
	}

	@Override
	protected void initButtons(Element e) {
		addOrderButton = new MyPictureButton(e.element("AddOrder"));
		findFullInfoButton = new MyPictureButton(e.element("CheckOrder"));
		inputReceiveButton = new MyPictureButton(e.element("InputReceive"));
	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLables(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addCompoment() {
		this.add(addOrderButton);
		this.add(findFullInfoButton);
		this.add(inputReceiveButton);

	}

	@Override
	protected void addListener() {
		addOrderButton.addMouseListener(new AddOrderListener());
		findFullInfoButton.addMouseListener(new findFullInfoListener());
		inputReceiveButton.addMouseListener(new inputReceiveListener());
	}

	class AddOrderListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			addOrderButton.setMyIcon(ButtonState.MOUSE_CLICKED);
			//切换到主页
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			addOrderButton.setMyIcon(ButtonState.MOUSE_ENTERED);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			addOrderButton.setMyIcon(ButtonState.NORMAL);
		}
	}

	class findFullInfoListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			findFullInfoButton.setMyIcon(ButtonState.MOUSE_CLICKED);
			//切换到主页
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			findFullInfoButton.setMyIcon(ButtonState.MOUSE_ENTERED);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			findFullInfoButton.setMyIcon(ButtonState.NORMAL);
		}
	}

	class inputReceiveListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			inputReceiveButton.setMyIcon(ButtonState.MOUSE_CLICKED);
			//切换到主页
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			inputReceiveButton.setMyIcon(ButtonState.MOUSE_ENTERED);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			inputReceiveButton.setMyIcon(ButtonState.NORMAL);
		}
	}

}
