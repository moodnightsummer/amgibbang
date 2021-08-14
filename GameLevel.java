package bbang;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameLevel extends JFrame{
	int sens=0;
	

	public GameLevel(int sens) {
		switch (sens) {
		case 1: {
			new Bbang(1);
			break;
		}
		case 4:{
			new Bbang(4);
			break;
		}
		case 8:{
			new Bbang(8);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + sens);
		}
	}



	JButton jbt1;
	JButton jbt2;
	JButton jbt3;
	
	ImageIcon btn1 = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/chobo.png");
	ImageIcon btn2 = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/suck.png");
	ImageIcon btn3 = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/hard.png");
	
	ImageIcon backs=new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/backs.png");
	
	
	JPanel panel1= new JPanel() {
		
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.drawImage(backs.getImage(), 0, 0, null);
		}
	};
	
	
	
	
	public GameLevel() {
		setTitle("암기빵");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
		panel1.setBounds(0, 0, 700, 700);
		panel1.setLayout(null);
		setLayout(null);
		setVisible(true);
		add(panel1);
		buttonSet();
		
		
	}
	
	public void buttonSet() {
		jbt1=new JButton(btn1);
		jbt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bbang(1);
				sens=1;
				dispose();
			}
		});
		jbt2=new JButton(btn2);
		jbt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bbang(4);
				sens=4;
				dispose();
			}
		});
		
		jbt3=new JButton(btn3);
		jbt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bbang(8);
				sens=8;
				dispose();
			}
		});
		
		panel1.add(jbt1);
		jbt1.setLayout(null);
		jbt1.setBounds(234, 212, 232, 70);
		jbt1.setBorderPainted(false);
		panel1.add(jbt2);
		jbt2.setLayout(null);
		jbt2.setBounds(234, 312, 232, 70);
		jbt2.setBorderPainted(false);
		panel1.add(jbt3);
		jbt3.setLayout(null);
		jbt3.setBounds(234, 412, 232, 70);
		jbt3.setBorderPainted(false);
		
		
	}
	
	
	
	public static void main(String[] args) {
		new GameLevel();
	}
	
}
