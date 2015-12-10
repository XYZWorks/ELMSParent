package ui.common;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.config.UserfulMethod;
import ui.tools.MyFrame;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MySearchBox;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.TipsDialog;
import util.FormatMes;

/**
*
*@author:xingcheng
*@version 2015年12月9日
*/
@SuppressWarnings("serial")
public class CommonInitalPanel extends MyPanel{
	
	private MyFrame parent;
	private MyPanel inital;
	
	//搜索栏
	private MySearchBox searchBox;
	//字：显示查询订单
	private MyPictureLabel show;
	private MyPictureButton exit;
	private MyPictureButton min;
	private Element config;

	
	private final static Image bg = GraphicsUtils.getImage("bg//bg");
	
	public CommonInitalPanel(Element config, MyFrame parent) {
		super(config);
		this.parent=parent;
		this.config=config;
		inital=this;
		
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initLabels(config.element(CompomentType.LABELS.name()));
		initOtherCompoment(config);
		
		
		addCompoment();
		addListener();
		setVisible(true);
		repaint();
		
	}

	@Override
	 public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);
		
		
	};     
	
	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initButtons(Element e) {
		min = new MyPictureButton(e.element("min"));
		exit = new MyPictureButton(e.element("exit"));
		
	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLabels(Element e) {
		show=new MyPictureLabel(e.element("show"));
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		searchBox=new MySearchBox(e.element("searchBox"));
		
		
	}

	@Override
	protected void addCompoment() {
		this.add(exit);
		this.add(min);
		this.add(searchBox);
		this.add(show);
		
	}

	@Override
	protected void addListener() {
		exit.addMouseListener(new ExitListener());
		min.addMouseListener(new MinListener());
		searchBox.addKeyListener(new SearchBoxListener());
	}
	
	/**
	 * 输入条形码查询订单时，把初始界面的图标和搜索栏隐藏
	 */
	public void setTwoUnvisible(){
		searchBox.setVisible(false);
		show.setVisible(false);
	}
	
	
	
	
	class SearchBoxListener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				TipsDialog wrongLength=new TipsDialog("订单号是10位哦～",560,470,300,55);
				
//				//获得输入的条形码
//				String barcode=searchBox.getMyText();
//				//判断条形码格式是否正确
//				FormatMes result=UserfulMethod.checkBarCode(barcode);
//				if(result==FormatMes.WRONG_LENGTH){
//					TipsDialog wrongLength=new TipsDialog("订单号是10位哦～");
//				}
//				else if(result==FormatMes.ILEGAL_CHAR){
//					TipsDialog ilegalChar=new TipsDialog("订单号是10位数字,输入了非法字符");
//				}
//				else if(result==FormatMes.CORRECT){
//					setTwoUnvisible();
//					FindSimpleOrderInfoPanel findSimpleOrderInfoPanel=new FindSimpleOrderInfoPanel(config.element("CommonMainPanel"),inital);
//				}
			}
		}
	}

	class ExitListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			exit.setMyIcon(ButtonState.MOUSE_CLICKED);
			//弹出optionpane 确认退出 TODO
			
			System.exit(0);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			exit.setMyIcon(ButtonState.MOUSE_ENTERED);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			exit.setMyIcon(ButtonState.NORMAL);
		}
	}
	
	class MinListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			min.setMyIcon(ButtonState.MOUSE_CLICKED);
			//最小化到任务栏
			parent.setExtendedState(JFrame.ICONIFIED);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			min.setMyIcon(ButtonState.MOUSE_ENTERED);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			min.setMyIcon(ButtonState.NORMAL);
		}
	}

}
