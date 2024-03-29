import java.util.Iterator;

public class Factorial implements Iterator<Integer>, Iterable<Integer> {
	private int n;
	private int k = 0;
	private int a = 1;

	public Factorial(int n) {
		this.n = n;
	}

	@Override
	public boolean hasNext() {
		return k < n;
	}

	@Override
	public Integer next() {
		k++;
		a *= k;
		return a;
	}

	@Override
	public Iterator<Integer> iterator() {
		return this;
	}
}
