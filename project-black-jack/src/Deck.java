import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		this(1);
	}

	public Deck(int n) {
		cards = new ArrayList<>(n * Suit.values().length * Rank.values().length);
		for(int k = 0; k < n; k++) {
			for(Suit suit : Suit.values()) {
				for(Rank rank : Rank.values()) {
					cards.add(new Card(rank, suit));
				}
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card take() {
		if(cards.isEmpty()) {
			return null;
		} else {
			Card card = cards.get(cards.size() - 1);
			cards.remove(cards.size() - 1);
			return card;
		}
	}

	public boolean isEmpty() {
		return cards.isEmpty();
	}
}
