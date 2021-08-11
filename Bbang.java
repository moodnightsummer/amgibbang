package bbang;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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

public class Bbang extends JFrame {
	// private Image background = new ImageIcon(
	// getResource("/Users/jelly/eclipse-workspace/bbang/src/bbang/bbang.png")).getImage();
	String word[] = { "금치산자", "사면초가", "구곡간장", "전전반측", "오매불망", "낙화유수", "관포지교", "백아절현", "금란지교", "막역지우", "간담상조", "대기만성",
			"마부위침", "입신양명", "이효상효", "혼정신성", "백유지효", "망운지정", "괄목상대", "각곡유목", "다기망양", "형설지공", "곡학아세", "세록치부", "부창부수" };
	ImageIcon ic = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/bbang.png");
	ImageIcon ic2 = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/sicbbang1.png");
	ImageIcon ic3 = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/score.jpg");
	JLabel[] label = new JLabel[4];
	Font font = new Font("netmarble", Font.BOLD, 20);
	JPanel newp = new JPanel();
	int[] setting = new int[4];
	int score = 0;
	JLabel scoreLabel;
	JLabel imageLabel = new JLabel();
	MyPanel panel= new MyPanel();
	int x=0;
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(ic.getImage(), 0, 0, getWidth(), getHeight(), this);
		}
	}

	public void runDora() {
		try {
//			JPanel contentPane=new JPanel();
			JLabel imageLabel = new JLabel();
			panel.add(imageLabel);
			
//			add(contentPane);
			
//			contentPane = (JPanel) getContentPane();
//			contentPane.setLayout(null);

			ImageIcon ii = new ImageIcon(this.getClass().getResource("rundora1.gif"));
			imageLabel.setIcon(ii);
			imageLabel.setLayout(null);
//			contentPane.setBounds(0, 500, 200, 200);
//			contentPane.add(imageLabel);
			// show it
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			//contentPane.setOpaque(false);
			imageLabel.setOpaque(false);
			
			
			for(int i=x; i<700; i++) {
				Thread.sleep(10);
				imageLabel.setBounds(x, 500, 200, 200);
				x++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void scoreSet() {
		scoreLabel = new JLabel(ic3);
		scoreLabel.setText("점수 : " + score);
		scoreLabel.setFont(font);
		scoreLabel.setHorizontalTextPosition(JButton.CENTER);
		scoreLabel.setVerticalTextPosition(JButton.CENTER);
		scoreLabel.setOpaque(false);
		panel.add(scoreLabel);
		scoreLabel.setBounds(530, 10, 140, 79);
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void textFileld() {
		JTextField jtf = new JTextField(4);
		jtf.setLayout(null);
		panel.add(jtf);
		jtf.setBounds(300, 600, 100, 50);
		jtf.setFont(font);
		jtf.setOpaque(false);

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
							scoreLabel.setText("점수 : " + score);
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
		this.setBounds(0, 0, 700, 700);
		this.add(panel);
		panel.setLayout(null);
		this.setResizable(false);

		setLocationRelativeTo(null);
		this.setVisible(true);
		scoreSet();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				runSet();
				for (int i = 0; i < label.length; i++) {
					label[i] = new JLabel(ic2);
					label[i].setLayout(null);
					label[i].setText(word[setting[i]]);
					label[i].setHorizontalTextPosition(JButton.CENTER);
					label[i].setVerticalTextPosition(JButton.CENTER);
					label[i].setFont(font);
					label[i].setOpaque(false);
					panel.add(label[i]);

				}
				

				try {
					label[0].setBounds(200, 200, 100, 104);
					Thread.sleep(800);
					label[1].setBounds(400, 150, 100, 104);
					Thread.sleep(800);
					label[2].setBounds(280, 400, 100, 104);
					Thread.sleep(800);
					label[3].setBounds(450, 350, 100, 104);

					for (int i = 0; i < label.length; i++) {
						Thread.sleep(2000);
						label[i].setText("");
					}
					textFileld();
					runDora();
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
		Bbang b = new Bbang();
	}
}
