import java.util.Iterator;

public class Main {
	public static void outputSequence(Iterable<Integer> sequence) {
		Iterator<Integer> iterator = sequence.iterator();
		while(iterator.hasNext()) {
			Integer n = iterator.next();
			System.out.println(n);
		}
	}
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci(10);
		System.out.println("Fibonacci");
//		outputSequence(f);
		for(Integer n : f) {
			System.out.println(n);
		}
		Factorial f2 = new Factorial(5);
		System.out.println("Factorial");
//		outputSequence(f2);
		for(Integer n : f2) {
			System.out.println(n);
		}
	}
}
