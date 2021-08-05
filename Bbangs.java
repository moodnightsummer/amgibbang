package bbang;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

 class Bbangs extends JFrame {
	String word[] = { "금치산자", "사면초가", "구곡간장", "전전반측", "오매불망", "낙화유수", "관포지교", "백아절현", "금란지교", "막역지우", "간담상조", "대기만성",
			"마부위침", "입신양명", "이효상효", "혼정신성", "백유지효", "망운지정", "괄목상대", "각곡유목", "다기망양", "형설지공", "곡학아세", "세록치부", "부창부수" };
	ImageIcon ic = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/bbang.png");
	ImageIcon ic2 = new ImageIcon("/Users/jelly/git/amgibbang/bbang/src/bbang/sicbbang.png");
	
	JLabel[] label = new JLabel[4];
	Font font = new Font("나눔손글씨 붓", Font.BOLD, 20);

	public Bbangs() { // 생성자
		
		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(ic.getImage(), 0, 0, null);
                setOpaque(true); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
                
            }
        };
        this.add(background);
        for (int i = 0; i < 4; i++) {
        	label[i] = new JLabel(ic2);
        	label[i].setOpaque(false);
        	label[i].setLayout(null);
        	label[i].setText(word[(int) (Math.random() * word.length)]);
        	label[i].setHorizontalTextPosition(JButton.CENTER);
        	label[i].setVerticalTextPosition(JButton.CENTER);
        	label[i].setFont(font);
        	background.add(label[i]);// 프레임에 추가
        }
        label[0].setBounds(200, 200, 100, 80);
    	label[1].setBounds(400, 150, 100, 80);
    	label[2].setBounds(280, 400, 100, 80);
    	label[3].setBounds(450, 350, 100, 80);
        	
	}

	public static void main(String[] args) {
		Bbangs b = new Bbangs();
		b.setTitle("암기빵");
		b.setResizable(false);
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.setLayout(null);
		b.setSize(700,700);
		b.setVisible(true);

	}
	
}



