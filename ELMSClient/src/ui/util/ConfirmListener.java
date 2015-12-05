package ui.util;

import ui.tools.MyPictureButton;
 /** 
 * 各种单据保存时确认按钮
 * @author czq 
 * @version 2015年12月5日 下午7:15:22 
 */
public abstract class ConfirmListener extends MyPictureButtonListener{

	public ConfirmListener(MyPictureButton button) {
		super(button);
		if(checkDataValid()){
			saveToSQL();
		}
	}
	/**
	 * 检查数据是否有效
	 */
	protected abstract boolean checkDataValid();
	
	/**
	 * 若数据有效，则保存至数据库
	 */
	protected abstract void saveToSQL();

}
