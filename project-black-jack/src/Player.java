import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
	private final String name;
	private final List<Card> hand = new ArrayList<>();
	private Integer money;

	public Player(String name, Integer money) {
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public List<Card> getHand() {
		return hand;
	}

	public Integer getMoney() {
		return money;
	}

	public void addMoney(Integer money) throws NegativeMoneyException {
		if(money >= 0) {
			this.money += money;
		} else {
			throw new NegativeMoneyException();
		}
	}

	public void subMoney(Integer money) throws NegativeMoneyException, NotEnoughMoneyException {
		if(money >= 0) {
			if(money <= this.money) {
				this.money -= money;
			} else {
				throw new NotEnoughMoneyException("попытка взять у игрока " + money + " монет, но у него есть только " + this.money + " монент");
			}
		} else {
			throw new NegativeMoneyException();
		}
	}

	public Integer makeBet() {
		Random random = new Random();
		return random.nextInt(money) + 1;
	}

	public boolean isNeedMoreCard() {
		Random random = new Random();
		return random.nextBoolean();
	}
}
