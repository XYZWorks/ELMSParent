package ui;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;




/**
 * 带有图片的button按钮
 * 
 * @author czq
 * @version 2015年11月26日 下午7:19:05
 */
@SuppressWarnings("serial")
public class MyPictureButton extends JLabel {

	// 一个按钮分：普通、进入、点击 三种不同的图片状态

	private Icon normal;
	private Icon entered;
	private Icon clicked;

//	public MyPictureButton(Element e) {
//		
//		if(e.attributeValue("type")!= null){
//			ButtonOrLabelPicture pics = GraphicsUtils.getButtonLabelPic(e.attributeValue("type"));
//			normal = pics.getNormal();
//			clicked = pics.getClicked();
//			entered = pics.getEnter();
//			
//		}else{
//			normal = GraphicsUtils.getIcon(e.attributeValue("normal"));
//			entered = GraphicsUtils.getIcon(e.attributeValue("enter"));
//			clicked = GraphicsUtils.getIcon(e.attributeValue("clicked"));
//		}
//		
//
//		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		this.setIcon(normal);
//		this.setBounds(Integer.parseInt(e.attributeValue("x")),
//				Integer.parseInt(e.attributeValue("y")),
//				Integer.parseInt(e.attributeValue("width")),
//				Integer.parseInt(e.attributeValue("height")));
//
//		this.setFont(GraphicsUtils.getFont(e));
//		if(e.attributeValue("text") != null){
//			this.setText(e.attributeValue("text"));
//			this.setHorizontalTextPosition(SwingConstants.CENTER);
//			this.setVerticalTextPosition(SwingConstants.CENTER);
//		}
//		
//		this.repaint();
//		this.setVisible(true);
//	}
	/**
	 * 用于返回按钮
	 */
	public MyPictureButton(String filepath){
		ButtonOrLabelPicture pics = GraphicsUtils.getButtonLabelPic(filepath);
		normal = pics.getNormal();
		clicked = pics.getClicked();
		entered = pics.getEnter();
		setFont(new Font("华文细黑", Font.PLAIN, 16));
		this.setIcon(normal);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.repaint();
		this.setVisible(true);
	}
	
	
	public void setMyIcon(ButtonState state) {
		switch (state) {
		case NORMAL:
			this.setIcon(normal);
			break;
		case MOUSE_ENTERED:
			this.setIcon(entered);
			break;
		case MOUSE_CLICKED:
			this.setIcon(clicked);
			break;
		default:
			break;
		}

	}
}
