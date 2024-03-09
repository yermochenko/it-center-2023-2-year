public class NegativeMoneyException extends Exception {
	public NegativeMoneyException() {
		super("количество денег отрицательное");
	}
}
