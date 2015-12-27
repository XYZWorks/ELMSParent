package ui.util;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import org.dom4j.Element;

import config.StaticMessage;
import ui.tools.MyCardLayOut;
import ui.tools.MyPanel;
import ui.tools.MySideBarButton;
 /** 
 * 界面跳转控制器父类
 * @author czq 
 * @version 2015年11月26日 下午3:08:33 
 */
public abstract class PanelController {
	/**
	 * 全局panel
	 */
	protected MyPanel mainPanel;
	/**
	 * 中间将要更改的panel
	 */
	protected JPanel changePanel;
	/**
	 * 布局管理器
	 */
	protected MyCardLayOut panelManager;
	
	/**
	 * 存储字符串与左边钮的对应关系
	 */
	protected Map<String, MySideBarButton> buttonMap ;
	
	/**
	 * 存储字符串与界面的对应关系
	 */
	protected Map<String, Component> panelMap = new HashMap<>(9);
	
	
	/**
	 * 
	 * @param initialPanel
	 * @param root
	 */
	
	public PanelController(MyPanel initialPanel , Element root) {
		super();
		this.mainPanel = initialPanel;
		initial(root);
		
		
	}
	
	/**
	 * 初始化业务逻辑,别忘了在controller的初始化里面加上这一句话
	 */
	protected abstract void initialBL();
	
	/**
	 * 初始化panel
	 */
	protected abstract void initPanel(Element e);
	/**
	 * 初始化按钮
	 */
	protected abstract void initButtons(Element e) ;
	/**
	 * 向panel上左侧栏的Buttons
	 */
	protected abstract void addButtons();
	/**
	 * 增加panel
	 */
	protected abstract void addPanels();
	/**
	 * 增加监听，将按钮与panel联系起来
	 */
	protected abstract void addListeners();
	/**
	 * 使所有按钮回归未被点击状态
	 */
	public abstract void  setAllButtonUnClicked();
	/**
	 * 批量处理按钮状态
	 * @param state
	 */
	public abstract void setAllButtonVisable(boolean state);
	
	public Map<String, Component> getPanelMap() {
		return panelMap;
	}
	
	/**
	 * 将按钮与panel的标示符String关联起来
	 */
	protected abstract void addToMap();
	
	/**
	 * 返回布局管理器
	 * @return
	 */
	public MyCardLayOut getCardLayout() {
		return this.panelManager;
	}
	
	/**
	 * 
	 * @return
	 */
	public JPanel getChangePanel() {
		return this.changePanel;
	}
	/**
	 * 
	 * @param panelName
	 */
	public void jumpToWindow(String panelName) {
		panelManager.show(changePanel, panelName);
		
		setAllButtonVisable(true);
		setTheRelatedButton(panelName);
	}
	

	
	/**
	 * 使得与该界面对应的按钮亮起
	 */
	public void setTheRelatedButton(String panelName){
		if(panelName.length() <= 6){
			return;
		}
		try {
			 buttonMap.get(panelName).setMyIcon(null);;
		} catch (Exception e) {
			//出现异常也无所谓，无伤大雅
			System.err.println("-------------ERROR: ");
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 跳回主界面
	 */
	public  void  jumpBackToMainWindow() {
		panelManager.show(changePanel, StaticMessage.MAIN_WINDOW);
		setAllButtonVisable(false);
		setAllButtonUnClicked();
	}
	
	
	
	
	
	/**
	 * 父类自初始化
	 * @param e
	 */
	private void initial(Element e){
		panelManager = new MyCardLayOut();
		this.changePanel = new JPanel(panelManager);
		buttonMap = new HashMap<String, MySideBarButton>(10);
		
		if(e==null){
			System.err.println("-----------配置文件出错");
		}
		changePanel.setVisible(false);
		changePanel.setBounds(Integer.parseInt(e.attributeValue("x")),
				Integer.parseInt(e.attributeValue("y")),
				Integer.parseInt(e.attributeValue("width")),
				Integer.parseInt(e.attributeValue("height")));
		this.mainPanel.add(changePanel);
	}

}
