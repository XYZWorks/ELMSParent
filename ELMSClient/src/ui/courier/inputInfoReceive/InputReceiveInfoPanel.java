package ui.courier.inputInfoReceive;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.dom4j.Element;

import blservice.orderblservice.Orderblservice;
import ui.tools.MyDatePicker;
import ui.tools.MyPanelWithScroller;
import ui.tools.MyPictureButton;
import ui.tools.MyPictureLabel;
import ui.tools.MySearchBox;
import ui.util.CancelListener;
import ui.util.CompomentType;
import ui.util.ConfirmListener;
import ui.util.RefreshPanel;
import ui.util.TipsDialog;
import util.MyDate;
import vo.order.PreReceiveVO;
import vo.order.ReceiveVO;

@SuppressWarnings("serial")
public class InputReceiveInfoPanel extends MyPanelWithScroller implements RefreshPanel{

	/**
	 * 确认修改的按钮 如果点击确认修改 则更新所有改动数据
	 */
	private MyPictureButton confirm;

	/**
	 * 取消修改的按钮 如果点击取消 则撤销本次的所有改动
	 */
	private MyPictureButton cancel;

	private MyDatePicker datePicker;
	private MySearchBox searchBox;
	
	//查看全部
	private MyPictureLabel seeAll;

	private inputReceiveTablePanel table;
	private Orderblservice bl;

	public InputReceiveInfoPanel(Element config, Orderblservice bl) {
		// TODO Auto-generated constructor stub
		super(config);
		this.bl = bl;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		setVisible(true);

	}

	@Override
	protected void initButtons(Element e) {
		confirm = new MyPictureButton(e.element("confirm"));
		cancel = new MyPictureButton(e.element("cancel"));
		
	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLabels(Element e) {
		// TODO Auto-generated method stub
		seeAll=new MyPictureLabel(e.element("seeAll"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		datePicker = new MyDatePicker(e.element("datePicker"));
		searchBox = new MySearchBox(e.element("searchBox"));
		// initTabel
		table = new inputReceiveTablePanel(e.element("inputReceiveTable"), bl, this);

	}

	@Override
	protected void addCompoment() {
		this.add(cancel);
		this.add(confirm);
		this.add(table);
		this.add(datePicker);
		this.add(searchBox);
		this.add(seeAll);

	}

	@Override
	protected void addListener() {
		cancel.addMouseListener(new CancelListener(cancel) {

			@Override
			public void resetMes() {
				// TODO 重新读取数据

			}
		});

		confirm.addMouseListener(new ConfirmListener(confirm) {

			@Override
			protected boolean saveToSQL() {
				// 表格上 data.length=data二维数组的行数
				String[][] data=table.getData();
				
				for (int i = 0; i < data.length; i++) {
					// TODO  check mydate的格式
					// try{
					
					//获取表格里的时间
					String time = (String) table.getValueAt(i, 4);
					String[] x = time.split("");
					MyDate date = new MyDate(Integer.parseInt(x[0]), Integer.parseInt(x[1]), Integer.parseInt(x[2]));
					// }catch{
					//
					// }
					
					ReceiveVO receiveVO = new ReceiveVO(data[i][0], date,
							(String) table.getValueAt(i, 3));
					bl.receiveInfo(receiveVO);

				}

				// 反馈
				TipsDialog success = new TipsDialog("订单添加成功");
				return true;
			}

			@Override
			protected boolean checkDataValid() {
				return true;
			}

			@Override
			protected void reInitial() {
			}

			@Override
			protected void updateMes() {
				// TODO Auto-generated method stub

			}
		});

		searchBox.addKeyListener(new SearchBoxListener());
		seeAll.addMouseListener(new seeAllListener());
	}

	class SearchBoxListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				
				String orderBarCode = searchBox.getMyText();
				System.out.println("orderBarCode"+orderBarCode);
				
				ArrayList<PreReceiveVO> after = table.after;
				for (int i = 0; i < after.size(); i++) {
					if (after.get(i).barCode != orderBarCode) {
						after.remove(i);
					}
				}
				table.updateTableMes(after);
			}
		}
	}

	class seeAllListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			table.myInit();
			table.validate();
			table.repaint();
		}
	}
	
	
	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh() {
		table.updateTableMes();
		
	}

}
