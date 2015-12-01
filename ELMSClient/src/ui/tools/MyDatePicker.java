package ui.tools;

import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.dom4j.Element;

import ui.util.MyPictureButtonListener;
import util.MyDate;

/**
 * 日历选择器实现类
 *  包含三个部件：显示日历信息的textfield、按钮button
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class MyDatePicker extends MyLabel {

	private DateObservingTextField dateField;

	private MyPictureButton button;

	private ExtendsDatePicker datePicker;

	public MyDatePicker(Element config) {
		super(config);
		
		dateField = new DateObservingTextField(config.element("field"));
		datePicker = new ExtendsDatePicker(dateField, Locale.CHINA);
		button = new MyPictureButton(config.element("button"));
		button.addMouseListener(new MyDateButtonListener(button));

		

		this.add(dateField);
		this.add(button);
	}

	public String getFormatedDate() {
		return this.dateField.getText();
	}
	
	/**
	 * 获得日期
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public MyDate getDate() {
		Date date =  datePicker.parseDate(dateField.getText());
		return new MyDate(date.getYear(), date.getMonth(), date.getDay());
	}
	
	/**
	 * 设置日期
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public void setDate(MyDate date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date dates = new Date(date.year	, date.month, date.day);
		this.datePicker.setSelectedDate(dates);
		this.dateField.setText(dateFormat.format(date));
	}

	public void setDate(String date) {
		this.dateField.setText(date);
		this.datePicker.setSelectedDate(datePicker.parseDate(date));
	}

	class MyDateButtonListener extends MyPictureButtonListener {
		public MyDateButtonListener(MyPictureButton button) {
			super(button);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			Date selectedDate = datePicker.parseDate(dateField.getText());
			datePicker.setSelectedDate(selectedDate);
			datePicker.start(dateField);
			
		}

	}


}
