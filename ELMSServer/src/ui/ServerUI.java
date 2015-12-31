package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import config.StaticMessage;
import data.RMIServer;
 /** 
 * 
 * @author czq 
 * @version 2015年12月31日 下午4:34:40 
 */
@SuppressWarnings("serial")
public class ServerUI extends JFrame {

	private JPanel contentPane;
	
	private JTextArea outputArea;
	
	private JLabel labInfo;
	private ServerUI frame;
	private JButton start;
	private JButton stop;
	private JButton config;
	private String address = "127.0.0.1";
	private RMIServer rmiServer;
	private String port = "6666";
	private Image bg ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				try {
					changeLook();
					
					ServerUI frame = new ServerUI();
					frame.addListener();
					frame.frame = frame;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	/**
	 * Create the frame.
	 */
	public ServerUI() {
		try {
			address = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		rmiServer = new RMIServer(address, port);
		try {
			bg = ImageIO.read(new File("image//bg-server.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 590);
		setLocationRelativeTo(null);
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
					g.drawImage(bg, 0, 0, null);
			}
			
			
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		outputArea = new JTextArea();
		outputArea.setBounds(34, 38, 626, 398);
		contentPane.add(outputArea);
		
		start = new JButton("启动服务");
		start.setBounds(34, 5, 93, 23);
		contentPane.add(start);
		
		stop = new JButton("停止服务");
		stop.setBounds(151, 5, 93, 23);
		contentPane.add(stop);
		
		config = new JButton("配置");
		config.setBounds(265, 5, 93, 23);
		contentPane.add(config);
		
		labInfo = new JLabel();
		config.setBounds(265, 5, 93, 23);
		contentPane.add(labInfo);
	}

	/**
	 * 更改外观
	 */
	private static void changeLook() {
	    try {
	    	BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	        // 关闭右上角设置
	        UIManager.put("RootPane.setupButtonVisible", false);
	    } catch(Exception e) {
	    }
	}
	
	
	protected void addListener() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int result = JOptionPane.showConfirmDialog(null, "确认退出？","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					return;
				}
			}
		});
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rmiServer.startRMI();
				updateInfo();
			}
		});
		config.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ChangeDialog(frame, contentPane);
//				rmiServer.stopRMI();
//				rmiServer.startRMI();
//				updateInfo();
				
			}
		});
		stop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rmiServer.stopRMI();
				outputArea.setText("");
			}
		});
	}

	
	
	/**
	 * 更新服务器信息
	 */
	public void updateInfo() {
		labInfo.setText("服务器信息(IP:PORT)：" + this.address + ":" + this.port);
		outputArea.append("==============================\n");
		outputArea.append("本服务器回送地址为：127.0.0.1，端口为：" + this.port + "\n");
		outputArea.append("本服务器内网地址为：" + this.address + "，端口为：" + this.port + "\n");
		outputArea.append("==============================\n");
	}
	
	
	/**
	 * 更新输出区域线程
	 * @param text
	 */
	private void updateTextArea(final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				outputArea.append(text);
				// 强制到最后一行
				outputArea.selectAll();
			}
		});
	}
	
	/**
	 * 输出流重定向
	 */
	private void redirectSystemStreams() {
		OutputStream out = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				updateTextArea(String.valueOf((char) b));
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				updateTextArea(new String(b, off, len));
			}

		    @Override
		    public void write(byte[] b) throws IOException {
		    	write(b, 0, b.length);
		    }
		};
		 
		System.setOut(new PrintStream(out, true));
		System.setErr(new PrintStream(out, true));
	}

	public String getPort() {
		return port;
	}

	public void setPort(int port2) {
		port = String.valueOf(port2);
		
	}
	
	
}
