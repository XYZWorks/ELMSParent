package ui.util;

import javax.swing.JPanel;

 /** 
 * 审批单据接口，用于单据界面
 * @author czq 
 * @version 2015年12月23日 下午7:42:15 
 */
public interface DocPanelForApproval {
	//以下两个方法生成时执行
	/**
	 * 使得所有组件不可更改
	 */
	public void setAllCompUneditOrUnVisiable();
	/**
	 * 加上返回按钮，两个参数提供返回路径,若已经有的可以不需要
	 */
	public void addBackButton(JPanel changePanel , String backStr);
	
	//每次跳转时执行
	/**
	 * 设置信息
	 */
	public void setMessage(Object vo);
	
	
}
