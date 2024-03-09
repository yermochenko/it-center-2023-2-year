import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: написать на модульные тесты для метода ResultChecker.check
//       p - количество очков игрока (playerPoints)
//       c - количество очков крупье (croupierPoints)
//       рассмотреть случаи p < 21, p = 21, p > 21
//                          c < 21, c = 21, c > 21
//                          для случая p < 21 и c < 21 рассмотреть p < c, p = c, p > c
public class ResultCheckerTest {
	// p = 21
	// c = 21
	@Test
	void test01() {
		Assertions.assertEquals(ResultType.WIN, ResultChecker.check(21, 21));
	}
}
