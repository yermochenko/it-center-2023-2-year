import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		Scanner keyboard = new Scanner(System.in);
		while(!deck.isEmpty()) {
			System.out.println("Введите количество карт: ");
			int n = keyboard.nextInt();
			List<Card> cards = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				Card card = deck.take();
				if(card == null) {
					System.out.println("Недостаточно карт в колоде");
					keyboard.close();
					return;
				}
				cards.add(card);
			}
			System.out.println(cards);
			System.out.println("Всего очков: " + PointsCalculator.calc(cards));
		}
		keyboard.close();
	}
}
