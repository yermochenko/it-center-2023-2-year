public class ResultChecker {
	public static ResultType check(int playerPoints, int croupierPoints) {
		if(playerPoints == 21 || (playerPoints < 21 && (playerPoints > croupierPoints || croupierPoints > 21))) {
			return ResultType.WIN;
		} else if(playerPoints < 21 && playerPoints == croupierPoints) {
			return ResultType.DRAW;
		} else {
			return ResultType.LOSS;
		}
	}
}
