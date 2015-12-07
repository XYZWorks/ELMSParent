package ui.generalmanager.approval;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import blservice.approvalblservice.Approvalblservice;
import ui.table.MyTable;
import ui.tools.MyComboBox;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;
import ui.util.TipsDialog;
import util.DocType;

/**
 * 审批单据
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class ApprovalDocsPanel extends MyPanel{
	
	private MyPictureLabel chooseDocType;
	private MyComboBox DocTypeChooseBox;
	
	private DocSimpleInfoTable table;
	
	private MyPictureButton approvalMany;
	private MyPictureButton approvalOne;
	/**
	 * 查看详细信息
	 */
	private MyPictureButton checkForMoreInfo;
	
	//持有其他单据查看界面的引用，这些界面可用于传入参数进行显示
	
	
	
	private Approvalblservice bl;
	
	public ApprovalDocsPanel(Element config  , Approvalblservice bl) {
		super(config);
		this.bl = bl;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
	}

	@Override
	protected void initButtons(Element e) {
		approvalMany = new MyPictureButton(e.element("approveMany"));
		approvalOne = new MyPictureButton(e.element("approveOne"));
		checkForMoreInfo = new MyPictureButton(e.element("checkForMoreInfo"));
		
	}

	@Override
	protected void initTextFields(Element e) {
	}

	@Override
	protected void initLabels(Element e) {
		chooseDocType = new MyPictureLabel(e.element("choose"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		table = new DocSimpleInfoTable(e.element("table"), bl , DocType.order);
		DocTypeChooseBox = new MyComboBox(e.element("type"));
	}

	@Override
	protected void addCompoment() {
		add(DocTypeChooseBox);
		add(approvalMany);
		add(approvalOne);
		add(table);
		add(checkForMoreInfo);
		add(chooseDocType);
		
	}

	@Override
	protected void addListener() {
		DocTypeChooseBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				DocType type = DocType.getDocType((String) DocTypeChooseBox.getSelectedItem());
				if(type != null){
					table.changeDocType(type);
				}
			}
		});
		approvalMany.addMouseListener(new MyPictureButtonListener(approvalMany){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int Number;
				if( ( Number = table.approveMany() ) > 0){
					new TipsDialog("成功审批" + String.valueOf(Number) + "个单据");
				}else{
					new TipsDialog("您未选择任何单据！");
				}
			}
			
			
		});
		approvalOne.addMouseListener(new MyPictureButtonListener(approvalOne){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(table.approvaeOne()){
					new TipsDialog("成功审批单据");
				}else {
					new TipsDialog("未成功审批单据");
				}
			}
		});
		checkForMoreInfo.addMouseListener(new MyPictureButtonListener(checkForMoreInfo){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//跳转Panel
			}
		});
		
	}

	@Override
	protected void initWhitePanels(Element e) {}

}
