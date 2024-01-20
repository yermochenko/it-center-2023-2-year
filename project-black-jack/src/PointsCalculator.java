import java.util.List;

public class PointsCalculator {
	public static int calc(List<Card> cards) {
		int points = 0;
		for(Card card : cards) {
			points += card.getRank().getPoints();
		}
		return points;
	}
}
