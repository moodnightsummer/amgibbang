package bbang;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.desktop.ScreenSleepEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Bbang extends JFrame {
	// private Image background = new ImageIcon(
	// getResource("/Users/jelly/eclipse-workspace/bbang/src/bbang/bbang.png")).getImage();
	String word[] = { "금치산자", "사면초가", "구곡간장", "전전반측", "오매불망", "낙화유수", "관포지교", "백아절현", "금란지교", "막역지우", "간담상조", "대기만성",
			"마부위침", "입신양명", "이효상효", "혼정신성", "백유지효", "망운지정", "괄목상대", "각곡유목", "다기망양", "형설지공", "곡학아세", "세록치부", "부창부수" };
	ImageIcon ic = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/bbang.png");
	ImageIcon ic2 = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/sicbbang.png");
	JLabel[] label = new JLabel[4];
	Font font = new Font("netmarble", Font.BOLD, 20);
	JPanel newp = new JPanel();
	int[] setting = new int[4];
	int score = 0;
	JLabel scoreLabel;

	String dab = "";

	public void scoreSet() {
		newp.setBounds(600, 10, 100, 30);
		newp.setBackground(new Color(255, 0, 0, 0));
		newp.setOpaque(false);
		scoreLabel = new JLabel();
		scoreLabel.setFont(font);
		scoreLabel.setText("점수:");
		scoreLabel.setOpaque(true);
		scoreLabel.setBackground(new Color(255, 0, 0, 0));
		newp.add(scoreLabel);
		scoreLabel.setBounds(580, 10, 100, 30);
	}

	public void textFileld() {
		JTextField jtf = new JTextField();
		jtf.setLayout(null);
		this.add(jtf);
		jtf.setBounds(300, 600, 100, 50);
		jtf.setOpaque(true);

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
						}
					}
					jtf.setText("");
				}
			}
		});
	}

	public Bbang() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setTitle("암기빵");
		this.setSize(700, 700);
		this.setResizable(false);
		
		setLocationRelativeTo(null);
		setLayout(null);
		this.setVisible(true);
		scoreSet();
		new Thread(new Runnable() {

			@Override
			public void run() {
				runSet();
				for (int i = 0; i < label.length; i++) {
					label[i] = new JLabel(ic2);
					label[i].setText(word[setting[i]]);
					label[i].setHorizontalTextPosition(JButton.CENTER);
					label[i].setVerticalTextPosition(JButton.CENTER);
					label[i].setFont(font);
					label[i].setOpaque(false);
					add(label[i]);

				}

				try {
					label[0].setBounds(200, 200, 100, 80);
					Thread.sleep(800);
					label[1].setBounds(400, 150, 100, 80);
					Thread.sleep(800);
					label[2].setBounds(280, 400, 100, 80);
					Thread.sleep(800);
					label[3].setBounds(450, 350, 100, 80);

					for (int i = 0; i < label.length; i++) {
						Thread.sleep(2000);
						label[i].setText("");
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

	public void paint(Graphics g) {
		g.drawImage(ic.getImage(), 0, 0, null);
	}

	public static void main(String[] args) {
		Bbang b = new Bbang();
	}
}
