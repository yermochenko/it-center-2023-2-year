import java.util.List;

public class Main {
	public static void main(String[] args) throws NotPositiveMoneyException {
		TestPlayerStrategy strategy = new TestPlayerStrategy();
		MyStrategy myStrategy = new MyStrategy();
		Game game = new Game(new Deck(6), List.of(
			new Player("Коля", 1000, myStrategy),
			new Player("Вася", 1000, strategy),
			new Player("Петя", 1000, strategy),
			new Player("Ваня", 1000, strategy),
			new Player("Саша", 1000, strategy)
		));
		game.play(3);
	}
}
