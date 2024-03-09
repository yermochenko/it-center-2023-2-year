import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NegativeMoneyException {
		Deck deck = new Deck(5);
		deck.shuffle();
		Game game = new Game(deck, List.of(
			new Player("Коля", 1000),
			new Player("Вася", 1000),
			new Player("Петя", 1000)
		));
		game.play(3);
//		Scanner keyboard = new Scanner(System.in);
//		while(!deck.isEmpty()) {
//			System.out.println("Введите количество карт: ");
//			int n = keyboard.nextInt();
//			List<Card> cards = new ArrayList<>();
//			for(int i = 0; i < n; i++) {
//				Card card = deck.take();
//				if(card == null) {
//					System.out.println("Недостаточно карт в колоде");
//					keyboard.close();
//					return;
//				}
//				cards.add(card);
//			}
//			System.out.println(cards);
//			System.out.println("Всего очков: " + PointsCalculator.calc(cards));
//		}
//		keyboard.close();
//		Player player = new Player("John", 1000);
//		player.addMoney(100);
	}
}
