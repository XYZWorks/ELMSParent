package ui.tools;

import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import org.dom4j.Element;

import com.qt.datapicker.DatePicker;

/**
 * 日历显示条
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class DateObservingTextField extends JTextField  implements Observer {
	
	public DateObservingTextField(Element config) {
		this.setBounds(Integer.parseInt(config.attributeValue("x")),
				Integer.parseInt(config.attributeValue("y")),
				Integer.parseInt(config.attributeValue("width")),
				Integer.parseInt(config.attributeValue("height")));
		setEditable(false);
	}
	
	
    public void update(Observable o, Object arg) {
        Calendar calendar = (Calendar) arg;
        DatePicker dp = (DatePicker) o;
        setText(dp.formatDate(calendar));
    }
    
}
