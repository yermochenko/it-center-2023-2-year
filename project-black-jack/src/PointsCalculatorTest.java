import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointsCalculatorTest {
	@Test
	void test01() {
		List<Card> cards = List.of(
			new Card(Rank._2, Suit.CLUBS),
			new Card(Rank._3, Suit.DIAMONDS),
			new Card(Rank._4, Suit.HEARTS),
			new Card(Rank._5, Suit.SPADES)
		);
		int points = PointsCalculator.calc(cards);
		Assertions.assertEquals(14, points);
	}

	@Test
	void test02() {
		List<Card> cards = List.of(
			new Card(Rank._J, Suit.CLUBS),
			new Card(Rank._A, Suit.DIAMONDS)
		);
		int points = PointsCalculator.calc(cards);
		Assertions.assertEquals(21, points);
	}

	@Test
	void test03() {
		List<Card> cards = List.of(
			new Card(Rank._8, Suit.CLUBS),
			new Card(Rank._A, Suit.DIAMONDS),
			new Card(Rank._4, Suit.DIAMONDS),
			new Card(Rank._A, Suit.CLUBS)
		);
		int points = PointsCalculator.calc(cards);
		Assertions.assertEquals(14, points);
	}
}
