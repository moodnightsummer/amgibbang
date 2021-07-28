package bbang;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sun.tools.javac.Main;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Bbang extends JFrame {
	// private Image background = new ImageIcon(
	// getResource("/Users/jelly/eclipse-workspace/bbang/src/bbang/bbang.png")).getImage();
	ImageIcon ic;
	JScrollPane scrollPane;
	
	
	public Bbang() {
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		ic = new ImageIcon("/Users/jelly/eclipse-workspace/bbang/src/bbang/bbang.png");
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel() {
		public void paint(Graphics g) {
			g.drawImage(ic.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
		};
		
		
		setLayout(null);
		panel.setLayout(null);
		panel.setBounds(0, 0, 700, 700);
		add(panel);
		

		this.setTitle("암기빵");
		this.setSize(700, 700);
		this.setResizable(false);
		this.setBounds(100, 100, 700, 700);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Bbang();

	}

}
