import java.util.List;

public interface PlayerInfo {
	List<PlayerInfo> getOtherPlayers();

	int getMoney();

	int getBet();

	List<Card> getPlayerHand();
}
