package ui.financeman.approval;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.saleman.PayDoc.PayDocAddPanel;
import ui.saleman.PayDoc.PayDocMesTable;
import ui.tools.CheckDocPanel;
import ui.tools.MyLabel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import blservice.transportblservice.Transportblservice;

/**
 * 财务人员的交易审核界面
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class FinanceApprovalPanel extends CheckDocPanel{
	
	private MyPictureButton approval;
	
	private MyLabel title;
	
	private Transportblservice bl;
	
	private PayDocAddPanel myAddPanel;
	
	private PayDocMesTable myTable;
	
	public FinanceApprovalPanel(Element config , JPanel changePanel , String MainPanel , String detailName , Transportblservice bl) {
		super(config, changePanel, MainPanel, detailName);
		this.bl = bl;
		myTable = (PayDocMesTable) messageTable;
		myTable.bl = this.bl;
		myAddPanel = (PayDocAddPanel) addDocPanel;
		myAddPanel.bl = this.bl;
		initTableContent();
		addListener();
		myAddPanel.setAllCompUneditOrUnVisiable();
	}






	@Override
	protected void addListener() {
		super.addListener();
		addDoc.addMouseListener(new MyPictureButtonListener(addDoc){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(myTable.getSelectedRow() == -1){
					new TipsDialog("请选择一行数据", Color.GREEN);
					return;
				}
				myAddPanel.setMessage(myTable.getARowMes(myTable.getSelectedRow()));
				jumpToADD();
			}
		});
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if(UserfulMethod.dealWithData(new SimpleDataFormat(searchBox.getMyText() , DataType.ID , "ID"))){
						messageTable.searchID(searchBox.getMyText());
					}
				}
				
			}
		});
		
		search.addMouseListener(new MyPictureButtonListener(search){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(UserfulMethod.dealWithData(new SimpleDataFormat(searchBox.getMyText() , DataType.ID , "ID"))){
					messageTable.searchID(searchBox.getMyText());
				}
			}
		});
		approval.addMouseListener(new ConfirmListener(approval) {
			
			@Override
			protected boolean saveToSQL() {
				return false;
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected void reInitial() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected boolean checkDataValid() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			protected void updateMes() {
				// TODO Auto-generated method stub
				
			}
		});
	}


	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		messageTable = new PayDocMesTable(e.element("table"));
		addDocPanel = new PayDocAddPanel(e.element("payDocShowPanelAddPanel"), changePanel, checkDocPanelStr, messageTable);
		
	}

	@Override
	protected void initialDifferComp(Element e) {
		approval = new MyPictureButton(e.element("approval"));
		title = new MyPictureLabel(e.element("title"));
	}

	@Override
	protected void addDifferComp() {
		add(approval);
		add(title);
	}

}
