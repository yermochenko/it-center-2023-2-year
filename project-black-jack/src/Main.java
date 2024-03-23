import java.util.List;

public class Main {
	public static void main(String[] args) throws NegativeMoneyException {
		Game game = new Game(new Deck(6), List.of(
			new Player("Коля", 1000),
			new Player("Вася", 1000),
			new Player("Петя", 1000),
			new Player("Ваня", 1000),
			new Player("Саша", 1000)
		));
		game.play(3);
	}
}
