package bbang;

import java.util.Scanner;

public class GameSet extends Thread {
	// 테스트용 단어 배열
	String word[] = { "금치산자", "사면초가", "구곡간장", "전전반측", "오매불망", "낙화유수", "관포지교", "백아절현", "금란지교", "막역지우", "간담상조", "대기만성",
			"마부위침", "입신양명", "이효상효", "혼정신성", "백유지효", "망운지정", "괄목상대", "각곡유목", "다기망양", "형설지공", "곡학아세", "세록치부", "부창부수" };
	Scanner scan = new Scanner(System.in);
	String set[] = new String[4];
	String answer;
	int score = 0;

	public void Games() {

		for (int i = 0; i < 4; i++) {
			set[i] = word[(int) (Math.random() * word.length)];
			System.out.println(set[i]);
		}
	}

	public void GameRule() {
		while (true) {
			for (int i = 0; i < set.length; i++) {
				answer = scan.next();
				if (set[i].equals(answer)) {
					score += 50;
					System.out.println(score);
				} else {
					score -= 20;
					System.out.println(score);
				}

			}

		}
	}

	public void ControlGame() {
		Games();
		GameRule();
	}

	public static void main(String[] args) {
		Games games = new Games();
		GameRule gr = new GameRule();
		games.start();
		gr.start();

	}
}

class Games extends GameSet {

	public void run() {
		try {
			
			for (int i = 0; i < 4; i++) {
				sleep(1000);
				set[i] = word[(int) (Math.random() * word.length)];
				System.out.println(set[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class GameRule extends GameSet {

	public void run() {
		try {
			while (true) {
				answer = scan.next();
				for (int i = 0; i < word.length; i++) {
					if (word[i].equals(answer)) {
						score += 50;
						System.out.println(score);
					} 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}