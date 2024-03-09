import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Player> players = new ArrayList<>();
	private Deck deck;
	private List<Integer> bets = new ArrayList<>();
	private List<Card> croupierHand = new ArrayList<>();

	public Game(Deck deck, List<Player> players) {
		this.deck = deck;
		this.players.addAll(players);
	}

	public void play(int rounds) {
		try {
			for(int round = 1; round <= rounds; round++) {
				System.out.println("РАУНД #" + round + " НАЧАТ");
				System.out.println("Сбор ставок игроков...");
				for(int i = 0; i < players.size();) {
					Player player = players.get(i);
					Integer bet = player.makeBet();
					System.out.println("Игрок " + player.getName() + " сделал ставку " + bet);
					try {
						player.subMoney(bet);
						bets.add(bet);
						System.out.println("Ставка принята");
						i++;
					} catch(NegativeMoneyException | NotEnoughMoneyException e) {
						System.out.println("Ставка не принята. Ошибочная сумма: " + e.getMessage());
						System.out.println("Игрок " + player.getName() + " дисквалифицирован");
						players.remove(i);
					}
				}
				System.out.println("Игра:");
				// сдача карт игрокам
				for(int i = 0; i < players.size(); i++) {
					players.get(i).getHand().add(deck.take());
					players.get(i).getHand().add(deck.take());
				}
				// сдача карты крупье
				croupierHand.add(deck.take());
				// игра игроков
				for(int i = 0; i < players.size(); i++) {
					while(true) {
						int points = PointsCalculator.calc(players.get(i).getHand());
						if(points >= 21) break;
						if(!players.get(i).isNeedMoreCard()) break;
						players.get(i).getHand().add(deck.take());
					}
//					while(PointsCalculator.calc(players.get(i).getHand()) < 21 && players.get(i).isNeedMoreCard()) {
//						players.get(i).getHand().add(deck.take());
//					}
				}
				// игра крупье
				int croupierPoints;
				while((croupierPoints = PointsCalculator.calc(croupierHand)) < 17) {
					croupierHand.add(deck.take());
				}
				// подсчёт выигрыша
				for(int i = 0; i < players.size(); i++) {
					int points = PointsCalculator.calc(players.get(i).getHand());
					switch(ResultChecker.check(points, croupierPoints)) {
						case WIN:
							try {
								players.get(i).addMoney(bets.get(i) * 2);
							} catch(NegativeMoneyException e) {}
							break;
						case DRAW:
							try {
								players.get(i).addMoney(bets.get(i));
							} catch(NegativeMoneyException e) {}
							break;
						case LOSS:
					}
				}
				System.out.println("РАУНДА #" + round + " ОКОНЧЕН");
				System.out.println("*****************************");
			}
		} catch(NotEnoughCardsException e) {
			System.out.println("ОШИБКА: Для продолжения игры не хватает карт в колоде");
		}
	}
}
