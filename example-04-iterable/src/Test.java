import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(3000, Calendar.DECEMBER, 31);
		Date date = new Date(Long.MAX_VALUE);//c.getTime();
		System.out.println(date);
		long millis = date.getTime();
		System.out.println(millis);
	}
}
