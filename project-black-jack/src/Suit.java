public enum Suit {
	SPADES("♠"), CLUBS("♣"), DIAMONDS("♦"), HEARTS("♥");

	private final String symbol;

	Suit(String symbol) {
		this.symbol = symbol;
	}

	public String toString() {
		return symbol;
	}
}
