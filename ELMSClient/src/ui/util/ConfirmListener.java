package ui.util;

import java.awt.event.MouseEvent;

import ui.tools.MyPictureButton;
 /** 
 * 各种单据保存时确认按钮
 * @author czq 
 * @version 2015年12月5日 下午7:15:22 
 */
public abstract class ConfirmListener extends MyPictureButtonListener{

	public ConfirmListener(MyPictureButton button) {
		super(button);
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {	
		super.mouseClicked(e);
		if(checkDataValid()){
			if(saveToSQL()){
				
				updateMes();
				reInitial();
				
			}
			
		}
	}
	/**
	 * 重置组件以再来一单
	 */
	protected abstract void reInitial();
	/**
	 * 同步信息
	 */
	protected abstract void updateMes();

	/**
	 * 检查数据是否有效
	 */
	protected abstract boolean checkDataValid();
	
	/**
	 * 保存数据，若保存成功，则进行下一步动作：更新相关信息，清空表格
	 * @return
	 */
	protected abstract boolean saveToSQL();
	
	

}
