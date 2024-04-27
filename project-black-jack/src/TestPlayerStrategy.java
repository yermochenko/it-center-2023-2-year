import java.util.Random;

public class TestPlayerStrategy implements PlayerStrategy {
	@Override
	public int makeBet(PlayerInfo playerInfo, GameInfo gameInfo) {
		Random random = new Random();
		return random.nextInt(playerInfo.getMoney()) + 1;
	}

	@Override
	public boolean isNeedMoreCard(PlayerInfo playerInfo, GameInfo gameInfo) {
		int points = PointsCalculator.calc(playerInfo.getPlayerHand());
		if(points <= 11) return true;
		if(points >= 20) return false;
		Random random = new Random();
		return random.nextBoolean();
	}
}
