package ui.tools;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Observer;

import javax.swing.SwingUtilities;

import com.qt.datapicker.DatePicker;

public class ExtendsDatePicker extends DatePicker {

	public ExtendsDatePicker(Observer observer, Locale locale) {
		super(observer, new Date(), locale);
	}

	@Override
	public String formatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		if (date == null)
			return "";
		return dateFormat.format(date);
	}
	
	@Override
    public Date parseDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            return dateFormat.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

	public void start(Component c) {
        if (c != null) {
            Component p = c.getParent();
            int x = c.getX(), y = c.getY() + c.getHeight();
            while (p != null) {
                //System.out.println(p.getClass().getName()+" "+p.getX()+" "+p.getY());
                x += p.getX();
                y += p.getY();
                p = p.getParent();
            }
            //System.out.println("x="+x+ " y="+y);
            this.getScreen().setLocation(x, y);
            
        } else {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.getScreen().setLocation((int) (dim.getWidth() -  this.getScreen().getWidth()) / 2,
                    (int) (dim.getHeight() -  this.getScreen().getHeight()) / 2);
        }
        SwingUtilities.invokeLater(this);
    }
	
}
