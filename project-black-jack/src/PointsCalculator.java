import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PointsCalculator {
	public static int calc(List<Card> cards) {
		int points = 0;
		int aces = 0;
		for(Card card : cards) {
			if(card.getRank() == Rank._A) {
				aces++;
			} else {
				points += card.getRank().getPoints();
			}
		}
		List<Integer> acePoints = new ArrayList<>();
		for(int i = 0; i <= aces; i++) {
			acePoints.add(aces + i * 10 + points);
		}
		List<Integer> limitPoints = new ArrayList<>();
		for(Integer acePoint : acePoints) {
			if(acePoint <= 21) {
				limitPoints.add(acePoint);
			}
		}
		if(limitPoints.isEmpty()) {
			return Collections.min(acePoints);
		} else {
			return Collections.max(limitPoints);
		}
	}
}
