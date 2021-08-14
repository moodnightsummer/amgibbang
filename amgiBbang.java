package bbang;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class amgiBbang extends JFrame{
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
	int x=0;
	JPanel jpn;
	
	public amgiBbang() {
		setTitle("암기빵");
		setSize(700, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new amgiBbang();
	}
}
