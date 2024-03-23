import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
	private List<Player> players = new ArrayList<>();
	private Deck deck;
	private List<Integer> bets = new ArrayList<>();
	private List<Card> croupierHand = new ArrayList<>();

	public Game(Deck deck, List<Player> players) {
		this.deck = deck;
		deck.shuffle();
		this.players.addAll(players);
		Collections.shuffle(this.players);
	}

	public void play(int rounds) {
		try {
			for(int round = 1; round <= rounds; round++) {
				System.out.println("РАУНД #" + round + " НАЧАТ");
				for(int i = 0; i < players.size(); i++) {
					System.out.println("    Игрок " + players.get(i).getName() + ": " + players.get(i).getMoney());
				}
				System.out.println("    Сбор ставок игроков...");
				for(int i = 0; i < players.size();) {
					Player player = players.get(i);
					Integer bet = player.makeBet();
					System.out.print("        Игрок " + player.getName() + " сделал ставку " + bet + ". ");
					try {
						player.subMoney(bet);
						bets.add(bet);
						System.out.println("Ставка принята");
						i++;
					} catch(NegativeMoneyException | NotEnoughMoneyException e) {
						System.out.println("Ставка не принята.\nОшибочная сумма: " + e.getMessage());
						System.out.println("Игрок " + player.getName() + " дисквалифицирован");
						players.remove(i);
					}
				}
				System.out.println("    Игра...");
				// сдача карт игрокам
				System.out.println("        Сдача карт:");
				for(int i = 0; i < players.size(); i++) {
					players.get(i).getHand().add(deck.take());
					players.get(i).getHand().add(deck.take());
					System.out.println("            Карты игрока " + players.get(i).getName() + ": " + players.get(i).getHand());
				}
				// сдача карты крупье
				croupierHand.add(deck.take());
				System.out.println("            Карты крупье: " + croupierHand);
				// игра игроков
				System.out.println("    Игра:");
				for(int i = 0; i < players.size(); i++) {
					System.out.println("        Игрок " + players.get(i).getName());
					System.out.println("            карты: " + players.get(i).getHand());
					while(true) {
						int points = PointsCalculator.calc(players.get(i).getHand());
						System.out.println("            " + points + " очков");
						if(points >= 21) break;
						if(!players.get(i).isNeedMoreCard()) {
							System.out.println("            игрок отказался от карты");
							break;
						}
						players.get(i).getHand().add(deck.take());
						System.out.println("            карты: " + players.get(i).getHand());
					}
//					while(PointsCalculator.calc(players.get(i).getHand()) < 21 && players.get(i).isNeedMoreCard()) {
//						players.get(i).getHand().add(deck.take());
//					}
				}
				// игра крупье
				int croupierPoints;
				System.out.println("        Крупье");
				System.out.println("            карты: " + croupierHand);
				while((croupierPoints = PointsCalculator.calc(croupierHand)) < 17) {
					System.out.println("            " + croupierPoints + " очков");
					croupierHand.add(deck.take());
					System.out.println("            карты: " + croupierHand);
				}
				System.out.println("            " + croupierPoints + " очков");
				// подсчёт выигрыша
				for(int i = 0; i < players.size(); i++) {
					System.out.print("        Игрок " + players.get(i).getName() + " ");
					int points = PointsCalculator.calc(players.get(i).getHand());
					switch(ResultChecker.check(points, croupierPoints)) {
						case WIN:
							try {
								players.get(i).addMoney(bets.get(i) * 2);
								System.out.println("выиграл.");
							} catch(NegativeMoneyException e) {}
							break;
						case DRAW:
							try {
								players.get(i).addMoney(bets.get(i));
								System.out.println("сыграл вничью.");
							} catch(NegativeMoneyException e) {}
							break;
						case LOSS:
							System.out.println("проиграл.");
					}
				}
				for(int i = 0; i < players.size(); i++) {
					System.out.println("    Игрок " + players.get(i).getName() + ": " + players.get(i).getMoney());
					players.get(i).getHand().clear();
				}
				croupierHand.clear();
				bets.clear();
				System.out.println("РАУНДА #" + round + " ОКОНЧЕН");
				System.out.println("*****************************");
			}
			System.out.println("СПИСОК ПОБЕДИТЕЛЕЙ");
			Collections.sort(players, (player1, player2) -> Double.compare(player2.getMoney(), player1.getMoney()));
			for(int i = 0; i < players.size() && i < 3; i++) {
				System.out.println("    " + (i + 1) + "-е место: игрок " + players.get(i).getName() + ", " + players.get(i).getMoney());
			}
		} catch(NotEnoughCardsException e) {
			System.out.println("ОШИБКА: Для продолжения игры не хватает карт в колоде");
		}
	}
}
