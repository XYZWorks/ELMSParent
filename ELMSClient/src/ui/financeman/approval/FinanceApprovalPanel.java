package ui.financeman.approval;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
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
import util.DocState;
import util.DocType;
import util.ResultMessage;
import bl.BusinessLogicDataFactory;
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
	Transportblservice transportblservice = BusinessLogicDataFactory.getFactory().getTransportblservice();
	private PayDocMesTable myTable;
	
	public FinanceApprovalPanel(Element config , JPanel changePanel , String MainPanel , String detailName , Transportblservice bl) {
		super(config, changePanel, MainPanel, detailName);
		this.bl = bl;
		myTable = (PayDocMesTable) messageTable;
		myTable.bl = this.bl;
		myTable.isApproval = true;
		myAddPanel = (PayDocAddPanel) addDocPanel;
		myAddPanel.bl = this.bl;
		initTableContent();
		myInit();
		myAddPanel.setAllCompUneditOrUnVisiable();
	}






	@Override
	protected void addListener() {
//		addDoc.addMouseListener(new MyPictureButtonListener(addDoc){
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				super.mouseClicked(e);
//				if(myTable.getSelectedRow() == -1){
//					new TipsDialog("请选择一行数据", Color.GREEN);
//					return;
//				}else{
//					myAddPanel.setMessage(myTable.getARowMes(myTable.getSelectedRow()));
//					jumpToADD();
//				}
//				
//			}
//		});
		addDoc.setVisible(false);
		
//		search.setvi
		
		
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
			String id;
			int row;
			@Override
			protected void updateMes() {
				myTable.getTable().getModel().removeRow(row);
				
			}
			
			@Override
			protected boolean saveToSQL() {
				
				row = myTable.getSelectedRow();
				if(row == -1){
					new TipsDialog("请选择一条信息", Color.GREEN);
					return false;
				}
				
				id = (String) myTable.getValueAt(row, 0);
				
				result =transportblservice.changeOneDocState(id, DocType.payDoc, DocState.pass);
				
				if(result == ResultMessage.SUCCESS){
					new TipsDialog("成功审批单据");
					return true;
				}else{
					new TipsDialog("未成功审批单据");
					return false;
				}
				
				
			}
			
			@Override
			protected void reInitial() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected boolean checkDataValid() {
				// TODO Auto-generated method stub
				return true;
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
	
	private void myInit() {
		myTable.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					if(myTable.getSelectedRow() == -1){
						return ;
					}else{
						myAddPanel.setMessage(myTable.getARowMes(myTable.getSelectedRow()));
						jumpToADD();
					}
					
				}
				
				
			}
		});
	}
}
