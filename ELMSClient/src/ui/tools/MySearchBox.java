package ui.tools;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
 /** 
 * 搜索框
 * @author czq 
 * @version 2015年12月8日 下午7:27:57 
 */
@SuppressWarnings("serial")
public class MySearchBox extends JLabel{
	
	private static final Image inSerach = GraphicsUtils.getImage("element//search-enter");
	
	private static final Image outSerach = GraphicsUtils.getImage("element//search");
	
	private static final Image editing = GraphicsUtils.getImage("element//search-clicked");
	
	private JTextField field;
	
	private final static Dimension size = new Dimension(330, 45);
	private final static Dimension pictureSize = new Dimension(50, 45);
	private final static Dimension textFieldSize = new Dimension(280,45);
	private final static Font font = new Font("华文新魏", Font.PLAIN, 20);
	
	private Image tempImage = outSerach;
	
	private boolean isEditing = false;
	
	public MySearchBox(Element e) {
		this.setLocation(Integer.parseInt(e.attributeValue("x")), Integer.parseInt(e.attributeValue("y")));
		this.setSize(size);
		field = new JTextField();
		field.setLocation((int)pictureSize.getWidth(), 0);
		field.setSize(textFieldSize);
		field.setOpaque(false);
		//去除边框
		field.setBorder(new EmptyBorder(0,0,0,0));
		field.setFont(font);
		addListener();
		add(field);
		setVisible(true);
		
	}
	
	public String getMyText(){
		return field.getText();
	}
	
	public void setMyText(String s){
		field.setText(s);
	}
	
	private void addListener(){
		MyListener listener = new MyListener();
		this.addMouseListener(listener);
		field.addMouseListener(listener);
		field.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				isEditing = false;
				tempImage = outSerach;
				repaint();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				isEditing = true;
				tempImage = editing;
				repaint();
				
			}
		});
		
	}
	
	class MyListener extends MouseAdapter{
		@Override
		public void mouseEntered(MouseEvent e) {
			if(!isEditing){
				tempImage = inSerach;
				repaint();
			}
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);
			if(!isEditing){
				tempImage = outSerach;
				repaint();
			}
		}
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tempImage, 0, 0, null);
	}
}
