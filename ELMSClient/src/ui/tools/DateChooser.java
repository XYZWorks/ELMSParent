package ui.tools;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 * 出自： 编程中国 http://www.bccn.net
 * 
 * @author 千里冰封,czq
 *
 */
@SuppressWarnings("serial")
public class DateChooser extends JPanel {
	private Date initDate;
	private Calendar now = Calendar.getInstance();
	private Calendar select;
	private JPanel mainPanel;// 月历
	/**
	 * 显示月份的面板
	 */
	private MonthPanel monthPanel;// 四块面板,组成
	/**
	 * 显示周几的面板
	 */
	private DayPanel dayPanel;
	/**
	 * 核心面板，显示日期 30天
	 */
	private CorePanel corePanel;
	
	private Font font = new Font("宋体", Font.PLAIN, 12);
	
	private final LabelManager lm = new LabelManager();
	private JLabel showDate;// ,toSelect;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	private boolean isShow = false;
	private Popup pop;

	public DateChooser() {
		this(new Date());
	}

	private DateChooser(Date date) {
		initDate = date;
		select = Calendar.getInstance();
		select.setTime(initDate);
		initPanel();
	}

	public void setEnabled(boolean b) {
		super.setEnabled(b);
		showDate.setEnabled(b);
	}

	public Date getDate() {
		return select.getTime();
	}

	// 根据初始化的日期,初始化面板
	private void initPanel() {
		mainPanel = new JPanel(new BorderLayout());
		
		//TODO 可以换颜色 
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		
		JPanel up = new JPanel(new BorderLayout());
		up.add(monthPanel = new MonthPanel(), BorderLayout.NORTH);
		up.add(dayPanel = new DayPanel(), BorderLayout.CENTER);
		mainPanel.add(corePanel = new CorePanel(), BorderLayout.CENTER);
		mainPanel.add(up, BorderLayout.NORTH);
		this.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {

			}

			public void ancestorRemoved(AncestorEvent event) {

			}

			// 只要祖先组件一移动,马上就让popup消失
			public void ancestorMoved(AncestorEvent event) {
				hidePanel();
			}

		});
	}

	// 初始化标签

	// 根据新的日期刷新
	private void refresh() {
		monthPanel.updateDate();
		corePanel.updateDate();
		SwingUtilities.updateComponentTreeUI(this);
	}

	// 提交日期
	private void commit() {
		System.out.println("选中的日期是：" + sdf.format(select.getTime()));
		showDate.setText(sdf.format(select.getTime()));
		hidePanel();
	}

	private void hidePanel() {
		if (pop != null) {
			isShow = false;
			pop.hide();
			pop = null;
		}
	}

//	private void showPanel(Component owner) {
//		if (pop != null) {
//			pop.hide();
//		}
//		Point show = new Point(0, showDate.getHeight());
//		SwingUtilities.convertPointToScreen(show, showDate);
//		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
//		int x = show.x;
//		int y = show.y;
//		if (x < 0) {
//			x = 0;
//		}
//		if (x > size.width - 295) {
//			x = size.width - 295;
//		}
//		if (y > size.width - 188) {
//
//		} else {
//			y -= 188;
//		}
//		pop = PopupFactory.getSharedInstance()
//				.getPopup(owner, mainPanel, x, y);
//		pop.show();
//		isShow = true;
//	}

	private class MonthPanel extends JPanel {
		JLabel left, right, center;

		public MonthPanel() {
			super(new BorderLayout());
			this.setBackground(new Color(160, 185, 215));
			initmonthPanel();
		}

		private void initmonthPanel() {
			left = new JLabel(" << ", JLabel.CENTER);
			left.setToolTipText("上一月");
			right = new JLabel(" >> ", JLabel.CENTER);
			right.setToolTipText("下一月");
			left.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
			right.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
			center = new JLabel("", JLabel.CENTER);
			updateDate();
			this.add(left, BorderLayout.WEST);
			this.add(center, BorderLayout.CENTER);
			this.add(right, BorderLayout.EAST);
			this.setPreferredSize(new Dimension(295, 25));
			left.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					left.setCursor(new Cursor(Cursor.HAND_CURSOR));
					left.setForeground(Color.RED);
				}

				public void mouseExited(MouseEvent me) {
					left.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					left.setForeground(Color.BLACK);
				}

				public void mousePressed(MouseEvent me) {
					select.add(Calendar.MONTH, -1);
					left.setForeground(Color.WHITE);
					refresh();
				}

				public void mouseReleased(MouseEvent me) {
					left.setForeground(Color.BLACK);
				}
			});
			right.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					right.setCursor(new Cursor(Cursor.HAND_CURSOR));
					right.setForeground(Color.RED);
				}

				public void mouseExited(MouseEvent me) {
					right.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					right.setForeground(Color.BLACK);
				}

				public void mousePressed(MouseEvent me) {
					select.add(Calendar.MONTH, 1);
					right.setForeground(Color.WHITE);
					refresh();
				}

				public void mouseReleased(MouseEvent me) {
					right.setForeground(Color.BLACK);
				}
			});
		}

		private void updateDate() {
			center.setText(select.get(Calendar.YEAR) + "年"
					+ (select.get(Calendar.MONTH) + 1) + "月");
		}
	}

	private class DayPanel extends JPanel {
		public DayPanel() {
			this.setPreferredSize(new Dimension(295, 20));
		}

		protected void paintComponent(Graphics g) {
			g.setFont(font);
			g.drawString("星期日 星期一 星期二 星期三 星期四 星期五 星期六", 5, 10);
			g.drawLine(0, 15, getWidth(), 15);
		}
	}

	private class CorePanel extends JPanel {
		public CorePanel() {
			super(new GridLayout(6, 7));
			this.setPreferredSize(new Dimension(295, 100));
			initcorePanel();
		}

		private void initcorePanel() {
			updateDate();
		}

		public void updateDate() {
			this.removeAll();
			lm.clear();
			Date temp = select.getTime();
			Calendar select = Calendar.getInstance();
			select.setTime(temp);
			select.set(Calendar.DAY_OF_MONTH, 1);
			int index = select.get(Calendar.DAY_OF_WEEK);
			int sum = (index == 1 ? 8 : index);
			select.add(Calendar.DAY_OF_MONTH, 0 - sum);
			for (int i = 0; i < 42; i++) {
				select.add(Calendar.DAY_OF_MONTH, 1);
				lm.addLabel(new MyLabel(select.get(Calendar.YEAR), select
						.get(Calendar.MONTH), select.get(Calendar.DAY_OF_MONTH)));
			}
			for (MyLabel my : lm.getLabels()) {
				this.add(my);
			}
			select.setTime(temp);
		}
	}

	private class MyLabel extends JLabel implements Comparator<MyLabel>,
			MouseListener, MouseMotionListener {
		private int year, month, day;
		private boolean isSelected;

		public MyLabel(int year, int month, int day) {
			super("" + day, JLabel.CENTER);
			this.year = year;
			this.day = day;
			this.month = month;
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
			this.setFont(font);
			if (month == select.get(Calendar.MONTH)) {
				this.setForeground(Color.BLACK);
			} else {
				this.setForeground(Color.LIGHT_GRAY);
			}
			if (day == select.get(Calendar.DAY_OF_MONTH)) {
				this.setBackground(new Color(160, 185, 215));
			} else {
				this.setBackground(Color.WHITE);
			}
		}

		public boolean getIsSelected() {
			return isSelected;
		}

		public void setSelected(boolean b, boolean isDrag) {
			isSelected = b;
			if (b && !isDrag) {
				int temp = select.get(Calendar.MONTH);
				select.set(year, month, day);
				if (temp == month) {
					SwingUtilities.updateComponentTreeUI(corePanel);
				} else {
					refresh();
				}
			}
			this.repaint();
		}

		protected void paintComponent(Graphics g) {
			if (day == select.get(Calendar.DAY_OF_MONTH)
					&& month == select.get(Calendar.MONTH)) {
				// 如果当前日期是选择日期,则高亮显示
				g.setColor(new Color(160, 185, 215));
				g.fillRect(0, 0, getWidth(), getHeight());
			}
			if (year == now.get(Calendar.YEAR)
					&& month == now.get(Calendar.MONTH)
					&& day == now.get(Calendar.DAY_OF_MONTH)) {
				// 如果日期和当前日期一样,则用红框
				Graphics2D gd = (Graphics2D) g;
				gd.setColor(Color.RED);
				Polygon p = new Polygon();
				p.addPoint(0, 0);
				p.addPoint(getWidth() - 1, 0);
				p.addPoint(getWidth() - 1, getHeight() - 1);
				p.addPoint(0, getHeight() - 1);
				gd.drawPolygon(p);
			}
			if (isSelected) {// 如果被选中了就画出一个虚线框出来
				Stroke s = new BasicStroke(1.0f, BasicStroke.CAP_SQUARE,
						BasicStroke.JOIN_BEVEL, 1.0f,
						new float[] { 2.0f, 2.0f }, 1.0f);
				Graphics2D gd = (Graphics2D) g;
				gd.setStroke(s);
				gd.setColor(Color.BLACK);
				Polygon p = new Polygon();
				p.addPoint(0, 0);
				p.addPoint(getWidth() - 1, 0);
				p.addPoint(getWidth() - 1, getHeight() - 1);
				p.addPoint(0, getHeight() - 1);
				gd.drawPolygon(p);
			}
			super.paintComponent(g);
		}

		public boolean contains(Point p) {
			return this.getBounds().contains(p);
		}

		private void update() {
			repaint();
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			isSelected = true;
			update();
		}

		public void mouseReleased(MouseEvent e) {
			Point p = SwingUtilities.convertPoint(this, e.getPoint(), corePanel);
			lm.setSelect(p, false);
			commit();
		}

		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {
		}
		public void mouseDragged(MouseEvent e) {
			Point p = SwingUtilities.convertPoint(this, e.getPoint(), corePanel);
			lm.setSelect(p, true);
		}
		public void mouseMoved(MouseEvent e) {
		}

		public int compare(MyLabel o1, MyLabel o2) {
			Calendar c1 = Calendar.getInstance();
			c1.set(o1.year, o2.month, o1.day);
			Calendar c2 = Calendar.getInstance();
			c2.set(o2.year, o2.month, o2.day);
			return c1.compareTo(c2);
		}
	}

	private class LabelManager {
		private List<MyLabel> list;

		public LabelManager() {
			list = new ArrayList<MyLabel>();
		}

		public List<MyLabel> getLabels() {
			return list;
		}

		public void addLabel(MyLabel my) {
			list.add(my);
		}

		public void clear() {
			list.clear();
		}

//		public void setSelect(MyLabel my, boolean b) {
//			for (MyLabel m : list) {
//				if (m.equals(my)) {
//					m.setSelected(true, b);
//				} else {
//					m.setSelected(false, b);
//				}
//			}
//		}

		public void setSelect(Point p, boolean b) {
			// 如果是拖动,则要优化一下,以提高效率
			if (b) {
				// 表示是否能返回,不用比较完所有的标签,能返回的标志就是把上一个标签和
				// 将要显示的标签找到了就可以了
				boolean findPrevious = false, findNext = false;
				for (MyLabel m : list) {
					if (m.contains(p)) {
						findNext = true;
						if (m.getIsSelected()) {
							findPrevious = true;
						} else {
							m.setSelected(true, b);
						}
					} else if (m.getIsSelected()) {
						findPrevious = true;
						m.setSelected(false, b);
					}
					if (findPrevious && findNext) {
						return;
					}
				}
			} else {
				MyLabel temp = null;
				for (MyLabel m : list) {
					if (m.contains(p)) {
						temp = m;
					} else if (m.getIsSelected()) {
						m.setSelected(false, b);
					}
				}
				if (temp != null) {
					temp.setSelected(true, b);
				}
			}
		}

	}

//	private void initLabel() {
//	showDate = new JLabel(sdf.format(initDate));
//	showDate.setRequestFocusEnabled(true);
//	showDate.addMouseListener(new MouseAdapter() {
//		public void mousePressed(MouseEvent me) {
//			showDate.requestFocusInWindow();
//		}
//	});
//	this.setBackground(Color.WHITE);
//	this.add(showDate, BorderLayout.CENTER);
//	this.setPreferredSize(new Dimension(90, 25));
//	this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
//	showDate.addMouseListener(new MouseAdapter() {
//		public void mouseEntered(MouseEvent me) {
//			if (showDate.isEnabled()) {
//				showDate.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				showDate.setForeground(Color.RED);
//			}
//		}
//
//		public void mouseExited(MouseEvent me) {
//			if (showDate.isEnabled()) {
//				showDate.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				showDate.setForeground(Color.BLACK);
//			}
//		}
//
//		public void mousePressed(MouseEvent me) {
//			if (showDate.isEnabled()) {
//				showDate.setForeground(Color.CYAN);
//				if (isShow) {
//					hidePanel();
//				} else {
//					showPanel(showDate);
//				}
//			}
//		}
//
//		public void mouseReleased(MouseEvent me) {
//			if (showDate.isEnabled()) {
//				showDate.setForeground(Color.BLACK);
//			}
//		}
//	});
//	showDate.addFocusListener(new FocusListener() {
//		public void focusLost(FocusEvent e) {
//			hidePanel();
//		}
//
//		public void focusGained(FocusEvent e) {
//
//		}
//	});
//}

	

	public static void main(String[] args) {
		final DateChooser mp = new DateChooser();
		JFrame jf = new JFrame("test");
		jf.add(mp, BorderLayout.CENTER);
		jf.add(new JButton("测试用的"), BorderLayout.NORTH);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}