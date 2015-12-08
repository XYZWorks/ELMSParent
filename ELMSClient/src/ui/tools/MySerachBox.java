package ui.tools;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
 /** 
 * 搜索框
 * @author czq 
 * @version 2015年12月8日 下午7:27:57 
 */
@SuppressWarnings("serial")
public class MySerachBox extends JLabel{
	
	private static final Image inSerach = GraphicsUtils.getImage("");
	
	private static final Image outSerach = GraphicsUtils.getImage("");
	
	private static final Image editing = GraphicsUtils.getImage("");
	
	private JTextField field;
	
	private final static Dimension size = new Dimension(200, 50);
	private final static Dimension pictureSize = new Dimension(50, 50);
	private final static Dimension textFieldSize = new Dimension(150,50);
	
	private Image tempImage = outSerach;
	
	private boolean isEditing = false;
	
	public MySerachBox(Element e) {
		this.setLocation(Integer.parseInt(e.attributeValue("x")), Integer.parseInt(e.attributeValue("y")));
		this.setSize(size);
		field = new JTextField();
		field.setLocation((int)pictureSize.getWidth(), 0);
		field.setSize(textFieldSize);
		addListener();
		
		setVisible(true);
		
	}
	
	private void addListener(){
		this.addMouseListener(new MouseAdapter() {
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
		});
		
		field.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				isEditing = false;
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				isEditing = true;
				tempImage = editing;
				repaint();
				
			}
		});
		
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tempImage, 0, 0, null);
	}
}
