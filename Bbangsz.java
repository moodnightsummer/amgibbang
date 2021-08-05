package bbang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bbangsz extends JFrame {
	MyPanel panel = new MyPanel();
	String word[] = { "금치산자", "사면초가", "구곡간장", "전전반측", "오매불망", "낙화유수", "관포지교", "백아절현", "금란지교", "막역지우", "간담상조", "대기만성",
			"마부위침", "입신양명", "이효상효", "혼정신성", "백유지효", "망운지정", "괄목상대", "각곡유목", "다기망양", "형설지공", "곡학아세", "세록치부", "부창부수" };
	ImageIcon ic = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/bbang.png");
	ImageIcon ic2 = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/sicbbang.png");
	Image icback = ic.getImage();
	JLabel[] label = new JLabel[4];
	Font font = new Font("netmarble", Font.BOLD, 20);
	int[] setting = new int[4];
	int score = 0;
	JLabel scoreLabel;
	Font font2 = new Font("netmarble", Font.BOLD, 0);
	Font font3 = new Font("netmarble", Font.BOLD, 60);
	JPanel panel2 = new JPanel();

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(icback, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	public void textFileld() {
		JTextField jtf = new JTextField(4);
		jtf.setLayout(null);
		jtf.setFont(font3);
		jtf.setBounds(320, 680, 100, 80);
		jtf.setOpaque(true);
		panel.add(jtf);

		jtf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});

		jtf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				jtf.getText();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				jtf.getText();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					for (int i = 0; i < 4; i++) {
						if (jtf.getText().equals(word[setting[i]])) {
							score += 50;
							System.out.println(score);
							for(int k=0; k<label.length;k++) {
								if(jtf.getText().equals(label[i])) {
									label[i].setFont(font);
								}
							}
							
						}
					}
					jtf.setText("");
				}
			}
		});
	}


	public Bbangsz() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.add(panel);
		panel.setLayout(null);
		this.setBounds(0,0,700,700);
		this.setVisible(true);
		this.setTitle("암기빵");
		this.setResizable(false);
		setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		
		new Thread(new Runnable() {
			public void run() {
				runSet();
				for (int i = 0; i < label.length; i++) {
					label[i] = new JLabel();
					label[i].setIcon(ic2);
					label[i].setText(word[setting[i]]);
					label[i].setLayout(null);
					label[i].setHorizontalTextPosition(JButton.CENTER);
					label[i].setVerticalTextPosition(JButton.CENTER);
					label[i].setFont(font);
					label[i].setOpaque(false);
					panel.add(label[i]);
				}
				try {
					Thread.sleep(500);
					label[0].setBounds(200, 200, 100, 80);
					Thread.sleep(500);
					label[1].setBounds(400, 150, 100, 80);
					Thread.sleep(500);
					label[2].setBounds(280, 400, 100, 80);
					Thread.sleep(500);
					label[3].setBounds(450, 350, 100, 80);
					
					for (int i = 0; i < label.length; i++) {
						//Thread.sleep(800);
						label[i].setFont(font2);
					}
					textFileld();
					
				} catch (

				Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void runSet() { // 랜덤 값만 넣어 둠 중복 제거
		for (int i = 0; i < setting.length; i++) {
			setting[i] = (int) (Math.random() * word.length);

			for (int k = 0; k < i; k++) {
				if (setting[i] == setting[k]) {
					i--;
					break;
				}
			}
		}
	}
	



	public static void main(String[] args) {
		new Bbangsz();
	}

}
