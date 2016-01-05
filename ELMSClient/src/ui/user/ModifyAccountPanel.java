package ui.user;

import java.awt.Color;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.config.DataType;
import ui.config.SimpleDataFormat;
import ui.config.UserfulMethod;
import ui.tools.MyComboBox;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyTextField;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.MyPictureButtonListener;
import ui.util.RefreshPanel;
import ui.util.TipsDialog;
import util.AccountType;
import util.ResultMessage;
import vo.account.AccountVO;
import blservice.accountblservice.Accountblservice;

/**
 * 查找、修改、删除界面
 * 
 * @author czq
 * @version 2015年12月2日 下午7:12:08
 */
@SuppressWarnings("serial")
public class ModifyAccountPanel extends MyPanel implements RefreshPanel {

	Accountblservice bl;
	/**
	 * 账户信息表格
	 */
	private AccountMesTablePanel table;

	private MyPictureButton modifyButton;
	private MyPictureButton deleteButton;
	private MyPictureButton confirm;
	private MyPictureButton cancel;
	private MyLabel newName;
	private MyLabel newPassword;
	private MyLabel newType;

	private MyTextField newNameT;
	private MyTextField newPassT;
	private MyComboBox newTypeC;

	private boolean isModify = false;

	public ModifyAccountPanel(Element config, Accountblservice bl) {
		super(config);
		this.bl = bl;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		addCompoment();
		addListener();

		setModifyCompVisiable(false);
	}

	private void setModifyCompVisiable(boolean flag) {
		isModify = flag;
		newName.setVisible(flag);
		newNameT.setVisible(flag);
		newPassT.setVisible(flag);
		newPassword.setVisible(flag);
		newType.setVisible(flag);
		newTypeC.setVisible(flag);
		confirm.setVisible(flag);
		cancel.setVisible(flag);
		table.setVisible(!flag);
	}

	@Override
	protected void initButtons(Element e) {
		modifyButton = new MyPictureButton(e.element("modify"));
		deleteButton = new MyPictureButton(e.element("delete"));
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
	}

	@Override
	protected void initTextFields(Element e) {
		newNameT = new MyTextField(e.element("name"));
		newPassT = new MyTextField(e.element("password"));

	}

	@Override
	protected void initLabels(Element e) {
		newName = new MyLabel(e.element("name"));
		newPassword = new MyLabel(e.element("password"));
		newType = new MyLabel(e.element("type"));

	}

	@Override
	protected void initOtherCompoment(Element e) {
		table = new AccountMesTablePanel(e.element("table"), bl);
		newTypeC = new MyComboBox(e.element("type"));
	}

	@Override
	protected void addCompoment() {
		add(deleteButton);
		add(modifyButton);
		add(table);
		add(newName);
		add(newNameT);
		add(newPassT);
		add(newPassword);
		add(newType);
		add(newTypeC);
		add(confirm);
		add(cancel);
	}

	@Override
	protected void addListener() {
		modifyButton
				.addMouseListener(new MyModifyAccountListener(modifyButton));
		deleteButton
				.addMouseListener(new MyDeleteAccountListener(deleteButton));
		confirm.addMouseListener(new ConfirmListener(confirm) {
			String id;
			String name;
			AccountType type;
			String pass;
			AccountVO vo;

			@Override
			protected void updateMes() {
				table.updateTableMes();
			}

			@Override
			protected boolean saveToSQL() {
				result = bl.modify(vo = new AccountVO(id, name, type, pass));

				if (result == ResultMessage.SUCCESS) {
					new TipsDialog("成功修改数据", Color.GREEN);
					return true;

				} else {
					new TipsDialog("未成功修改数据");
					return false;
				}
			}

			@Override
			protected void reInitial() {
				newNameT.setText("");
				newPassT.setText("");
				newTypeC.setSelectedIndex(0);
				setModifyCompVisiable(false);
			}

			@Override
			protected boolean checkDataValid() {
				id = (String) table.getValueAt(table.getSelectedRow(), 0);
				name = newNameT.getText();
				type = AccountType.getType((String) newTypeC.getSelectedItem());
				pass = newPassT.getText();
				return UserfulMethod.dealWithData(new SimpleDataFormat(pass,
						DataType.ID, "密码"));
			}
		});
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				newNameT.setText("");
				newPassT.setText("");
				newTypeC.setSelectedIndex(0);
				setModifyCompVisiable(false);
			}
		});
	}

	class MyModifyAccountListener extends MyPictureButtonListener {

		public MyModifyAccountListener(MyPictureButton button) {
			super(button);

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);

			int row = table.getSelectedRow();
			if (row == -1) {
				new TipsDialog("请选择一行信息", Color.GREEN);
				return;
			}
			setModifyCompVisiable(true);

		}
	}

	class MyDeleteAccountListener extends MyPictureButtonListener {

		public MyDeleteAccountListener(MyPictureButton button) {
			super(button);

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			int row = table.getTable().getSelectedRow();

			if (row != -1) {
				result = bl
						.delete((String) table.getTable().getValueAt(row, 0));
				if (result == ResultMessage.SUCCESS) {
					table.removeRow(row);
					new TipsDialog("成功删除数据", Color.GREEN);
				} else {
					new TipsDialog("未成功删除，请检查网络");
				}

			} else {
				new TipsDialog("您未选择任何一行信息", Color.GREEN);
			}
		}
	}

	public void updateTableData() {
		table.updateTableMes();
		;
	}

	@Override
	protected void initWhitePanels(Element e) {

	}

	@Override
	public void refresh() {
		table.updateTableMes();

	}

}
