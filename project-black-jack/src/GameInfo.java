import java.util.List;

public interface GameInfo {
	List<Card> getCroupierHand();

	int getCurrentRound();

	int getRoundsCount();
}
