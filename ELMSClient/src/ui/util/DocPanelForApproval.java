package ui.util;

 /** 
 * 审批单据接口，用于单据界面
 * @author czq 
 * @version 2015年12月23日 下午7:42:15 
 */
public interface DocPanelForApproval {
	/**
	 * 使得所有组件不可更改
	 */
	public void setAllCompUneditOrUnVisiable();
	/**
	 * 加上返回按钮，两个参数提供返回路径
	 */
	public void addBackButton();
	
	/**
	 * 设置信息
	 */
	public void setMessage(Object vo);
	
}
