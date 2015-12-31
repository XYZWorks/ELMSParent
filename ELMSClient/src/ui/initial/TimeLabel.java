package ui.initial;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import ui.config.GraphicsUtils;

 /** 
 * 时间条
 * @author czq 
 * @version 2015年12月31日 下午7:42:36 
 */
@SuppressWarnings("serial")
public class TimeLabel extends JLabel implements Runnable{
	
	private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss  dd/MM/yy");
	public TimeLabel() {
		setBounds(840, 690, 200, 30);
		setFont(GraphicsUtils.getFont(null));
	}
	
	@Override
	public void run() {
		while(true){
			setText(format.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
}
