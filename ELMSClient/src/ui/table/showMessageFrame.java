package ui.table;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import ui.tools.MyPictureLabel;

@SuppressWarnings("serial")
public class showMessageFrame extends javax.swing.JFrame {
    private JLabel text;
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screensize = tk.getScreenSize();
    int height = screensize.height;
    int width = screensize.width;
    private String str = null;

    public showMessageFrame(String str) {
        this.str = str;
        new Thread(new Runnable() {
            @Override
            public void run() {
                initGUI();
            }
        }).start();
    }

    private void initGUI() {
           setUndecorated(true);
           
           setLocationRelativeTo(null);
           
           MyPictureLabel tips = new MyPictureLabel(str);
           
           
           
           
    }
    
    
    public static void main(String[] args) {
    	new showMessageFrame("hello world");
	}
}