import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Game implements GameInfo {
	private List<Player> players = new ArrayList<>();
	private Deck deck;
	private Map<Player, Integer> bets = new HashMap<>();
	private List<Card> croupierHand = new ArrayList<>();
	private int currentRound;
	private int roundsCount;

	public Game(Deck deck, List<Player> players) {
		this.deck = deck;
		deck.shuffle();
		this.players.addAll(players);
		for(Player player : players) {
			player.setGame(this);
		}
		Collections.shuffle(this.players);
	}

	public void play(int rounds) {
		try {
			roundsCount = rounds;
			for(currentRound = 1; currentRound <= rounds; currentRound++) {
				System.out.println("РАУНД " + currentRound + " из " + rounds + " НАЧАТ");
				for(Player player : players) {
					System.out.println("    Игрок " + player.getName() + ": " + player.getMoney());
				}
				System.out.println("    Сбор ставок игроков...");
				Iterator<Player> itertor = players.iterator();
				while(itertor.hasNext()) {
					Player player = itertor.next();
					Integer bet = player.makeBet();
					System.out.print("        Игрок " + player.getName() + " сделал ставку " + bet + ". ");
					try {
						player.subMoney(bet);
						bets.put(player, bet);
						System.out.println("Ставка принята");
					} catch(NotPositiveMoneyException | NotEnoughMoneyException e) {
						System.out.println("Ставка не принята.\nОшибочная сумма: " + e.getMessage());
						System.out.println("Игрок " + player.getName() + " дисквалифицирован");
						itertor.remove();
					}
				}
				System.out.println("    Игра...");
				// сдача карт игрокам
				System.out.println("        Сдача карт:");
				for(Player player : players) {
					player.getHand().add(deck.take());
					player.getHand().add(deck.take());
					System.out.println("            Карты игрока " + player.getName() + ": " + player.getHand());
				}
				// сдача карты крупье
				croupierHand.add(deck.take());
				System.out.println("            Карты крупье: " + croupierHand);
				// игра игроков
				System.out.println("    Игра:");
				for(Player player : players) {
					System.out.println("        Игрок " + player.getName());
					System.out.println("            карты: " + player.getHand());
					while(true) {
						int points = PointsCalculator.calc(player.getHand());
						System.out.println("            " + points + " очков");
						if(points >= 21) break;
						if(!player.isNeedMoreCard()) {
							System.out.println("            игрок отказался от карты");
							break;
						}
						player.getHand().add(deck.take());
						System.out.println("            карты: " + player.getHand());
					}
//					while(PointsCalculator.calc(player.getHand()) < 21 && player.isNeedMoreCard()) {
//						player.getHand().add(deck.take());
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
				for(Player player : players) {
					System.out.print("        Игрок " + player.getName() + " ");
					int points = PointsCalculator.calc(player.getHand());
					switch(ResultChecker.check(points, croupierPoints)) {
						case WIN:
							try {
								player.addMoney(bets.get(player) * 2);
								System.out.println("выиграл.");
							} catch(NotPositiveMoneyException e) {}
							break;
						case DRAW:
							try {
								player.addMoney(bets.get(player));
								System.out.println("сыграл вничью.");
							} catch(NotPositiveMoneyException e) {}
							break;
						case LOSS:
							System.out.println("проиграл.");
					}
				}
				for(Player player : players) {
					System.out.println("    Игрок " + player.getName() + ": " + player.getMoney());
					player.getHand().clear();
				}
				croupierHand.clear();
				bets.clear();
				System.out.println("РАУНД " + currentRound + " из " + rounds + " ОКОНЧЕН");
				System.out.println("*****************************");
			}
			roundsCount = 0;
			System.out.println("СПИСОК ПОБЕДИТЕЛЕЙ");
			Collections.sort(players, (player1, player2) -> Double.compare(player2.getMoney(), player1.getMoney()));
			for(int i = 0; i < players.size() && i < 3; i++) {
				System.out.println("    " + (i + 1) + "-е место: игрок " + players.get(i).getName() + ", " + players.get(i).getMoney());
			}
		} catch(NotEnoughCardsException e) {
			System.out.println("ОШИБКА: Для продолжения игры не хватает карт в колоде");
		}
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Map<Player, Integer> getBets() {
		return bets;
	}

	@Override
	public List<Card> getCroupierHand() {
		return Collections.unmodifiableList(croupierHand);
	}

	@Override
	public int getCurrentRound() {
		return currentRound;
	}

	@Override
	public int getRoundsCount() {
		return roundsCount;
	}
}
