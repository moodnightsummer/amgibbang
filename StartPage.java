package bbang;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartPage extends JFrame {
	ImageIcon ic;
	JButton jbtn1;
	JButton jbtn2;

	public StartPage() {
		
		Dimension dim = new Dimension(100, 100);
		
		ic = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/imsi.png");
		setLayout(new BorderLayout());
		jbtn1 = new JButton("게임 시작");
		jbtn2 = new JButton("게임 종료");
		
		this.add(jbtn1);
		this.add(jbtn2);
		
		jbtn1.setBounds(250, 600, 80, 30);
		jbtn2.setBounds(380, 600, 80, 30);
		
		jbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bbang();
				dispose();
			}
		});
		
		jbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel panel = new JPanel() {

			public void paint(Graphics g) {
				g.drawImage(ic.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
			
		};
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
			
		});
		
		setLayout(null);
		panel.setLayout(null);
		panel.setBounds(0, 0, 700, 700);
		add(panel);
		
		this.setBounds(100, 100, 700, 700);
		this.setVisible(true);
	}

	

	public static void main(String[] args) {
		new StartPage();

	}

}
