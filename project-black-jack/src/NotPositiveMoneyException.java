public class NotPositiveMoneyException extends Exception {
	public NotPositiveMoneyException() {
		super("количество денег не положительное");
	}
}
