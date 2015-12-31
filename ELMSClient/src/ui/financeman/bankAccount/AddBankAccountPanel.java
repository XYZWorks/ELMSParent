package ui.financeman.bankAccount;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.dom4j.Element;

import blservice.financeblservice.BankAccountBusinessService;
import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyCardLayOut;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MyTextField;
import ui.tools.MyWhitePanel;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.TipsDialog;
import util.ResultMessage;
import vo.finance.BankAccountVO;
 /** 
 * 增加银行账户
 * @author czq 
 * @version 2015年12月7日 上午11:11:59 
 */
@SuppressWarnings("serial")
public class AddBankAccountPanel extends MyPanel{
	
	private MyWhitePanel whitePanel;
	private MyPictureLabel addAccount;
	private MyLabel id;
	private MyLabel password;
	private MyLabel money;
	
	private MyTextField idT;
	private MyTextField passwordT;
	private MyTextField moneyT;
	
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	
	private BankAccountBusinessService bl;
	
	private JPanel changePanel;
	private MyCardLayOut layout;
	private final String bankAccountStr = "BankAccountManagePanel";
	private boolean addOrModify = true;
	private BankAccountTable table;
	
	public AddBankAccountPanel(Element config , BankAccountBusinessService bl ,JPanel changePanel, BankAccountTable table) {
		super(config);
		this.bl = bl;
		this.changePanel = changePanel;
		this.layout = (MyCardLayOut) changePanel.getLayout();
		this.table = table;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
	}

	@Override
	protected void initWhitePanels(Element e) {
		whitePanel=new MyWhitePanel(e.element("whitePanel"));
	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		
	}

	@Override
	protected void initTextFields(Element e) {
		idT = new MyTextField(e.element("idT"));
		passwordT = new MyTextField(e.element("passT"));
		moneyT = new MyTextField(e.element("money"));
		
	}

	@Override
	protected void initLabels(Element e) {
		money = new MyLabel(e.element("money"));
		password = new MyLabel(e.element("password"));
		id = new MyLabel(e.element("id"));
		addAccount=new MyPictureLabel(e.element("addAccount"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
	}

	@Override
	protected void addCompoment() {
		whitePanel.add(addAccount);
		whitePanel.add(id);
		whitePanel.add(idT);
		whitePanel.add(password);
		whitePanel.add(passwordT);
		whitePanel.add(money);
		whitePanel.add(moneyT);
		
		add(whitePanel);
		add(cancel);
		add(confirm);
	}

	@Override
	protected void addListener() {
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String id;
			String money;
			String password;
			@Override
			protected boolean checkDataValid() {
				id = idT.getText();
				money = moneyT.getText();
				password = passwordT.getText();
				SimpleDataFormat[] datas = {new SimpleDataFormat(id, DataType.ID, "银行账户ID")
				, new SimpleDataFormat(money, DataType.PositiveNum, "存款") , new SimpleDataFormat(password, DataType.ID, "密码")
				};
				return UserfulMethod.dealWithData(datas);
			}

			@Override
			protected boolean saveToSQL() {
				if(addOrModify){
					result = bl.addAccount(new BankAccountVO(id, password, money));
					if(result == ResultMessage.SUCCESS){
						new TipsDialog("成功增加账户", Color.GREEN);
						return true;
					}else if(result == ResultMessage.hasExist){
						new TipsDialog("账户ID已经存在");
					}else{
						new TipsDialog("网络或数据库异常");
					}
					return false;
				}else{
					result = bl.modifyAccount(new BankAccountVO(id, password, money));
					if(result == ResultMessage.SUCCESS){
						new TipsDialog("成功修改账户", Color.GREEN);
						return true;
					}else if(result == ResultMessage.NOT_EXIST){
						new TipsDialog("账户ID不存在");
					}else{
						new TipsDialog("网络或数据库异常");
					}
					return false;
					
					
				}
				

			}

			@Override
			protected void reInitial() {
				idT.setText("");
				passwordT.setText("");
				moneyT.setText("");
				layout.show(changePanel, bankAccountStr);
			}

			
			@Override
			protected void updateMes() {
				String[] data = {id , money , password};
// 				table.addon
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				idT.setText("");
				passwordT.setText("");
				moneyT.setText("");
				layout.show(changePanel, bankAccountStr);
			}
		});
		
	}
	void setAddOrModify(boolean isAdd , String id){
		if(isAdd){
			idT.setEditable(true);
			this.addOrModify = true;
		}else{
			idT.setEditable(false);
			this.addOrModify = false;
			idT.setText(id);
		}
		
	}
}
