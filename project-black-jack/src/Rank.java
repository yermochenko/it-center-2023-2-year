public enum Rank {
	_A("A", 1),
	_2("2", 2),
	_3("3", 3),
	_4("4", 4),
	_5("5", 5),
	_6("6", 6),
	_7("7", 7),
	_8("8", 8),
	_9("9", 9),
	_10("10", 10),
	_J("J", 10),
	_Q("Q", 10),
	_K("K", 10);

	private final String symbol;
	private final int points;

	Rank(String symbol, int points) {
		this.symbol = symbol;
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

	public String toString() {
		return symbol;
	}
}
