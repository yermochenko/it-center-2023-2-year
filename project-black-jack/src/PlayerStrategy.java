public interface PlayerStrategy {
	int makeBet(PlayerInfo playerInfo, GameInfo gameInfo);

	boolean isNeedMoreCard(PlayerInfo playerInfo, GameInfo gameInfo);
}
