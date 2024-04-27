import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Player implements PlayerInfo {
	private final String name;
	private final List<Card> hand = new ArrayList<>();
	private int money;
	private Game game;
	private PlayerStrategy strategy;

	public Player(String name, int money, PlayerStrategy strategy) {
		this.name = name;
		this.money = money;
		this.strategy = strategy;
	}

	public String getName() {
		return name;
	}

	public List<Card> getHand() {
		return hand;
	}

	@Override
	public int getMoney() {
		return money;
	}

	public final void addMoney(Integer money) throws NotPositiveMoneyException {
		if(money >= 0) {
			this.money += money;
		} else {
			throw new NotPositiveMoneyException();
		}
	}

	public final void subMoney(Integer money) throws NotPositiveMoneyException, NotEnoughMoneyException {
		if(money > 0) {
			if(money <= this.money) {
				this.money -= money;
			} else {
				throw new NotEnoughMoneyException("попытка взять у игрока " + money + " монет, но у него есть только " + this.money + " монент");
			}
		} else {
			throw new NotPositiveMoneyException();
		}
	}

	public int makeBet() {
		return strategy.makeBet(this, game);
	}

	public boolean isNeedMoreCard() {
		return strategy.isNeedMoreCard(this, game);
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public List<PlayerInfo> getOtherPlayers() {
		ArrayList<Player> players = new ArrayList<>(game.getPlayers());
		players.remove(this);
		return Collections.unmodifiableList(players);
		//return game.getPlayers().stream().filter(player -> player != this).toList();
	}

	@Override
	public int getBet() {
		return game.getBets().get(this);
	}

	@Override
	public List<Card> getPlayerHand() {
		return Collections.unmodifiableList(hand);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		return Objects.equals(name, ((Player) obj).name);
	}
}
