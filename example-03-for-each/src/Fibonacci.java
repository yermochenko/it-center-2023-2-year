import java.util.Iterator;

public class Fibonacci implements Iterator<Integer>, Iterable<Integer> {
	private int a = 0;
	private int b = 1;
	private int n;
	private int k = 0;

	public Fibonacci(int n) {
		this.n = n;
	}

	@Override
	public boolean hasNext() {
		System.out.println("DEBUG: hasNext()");
		return k < n;
	}

	@Override
	public Integer next() {
		System.out.println("DEBUG: next()");
		k++;
		int c = a + b;
		b = a;
		a = c;
		return c;
	}

	@Override
	public Iterator<Integer> iterator() {
		System.out.println("DEBUG: iterator()");
		return this;
	}
}
