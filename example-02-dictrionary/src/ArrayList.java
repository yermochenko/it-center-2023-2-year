public class ArrayList<T> implements List<T> {
	public static final int DEFAULT_SIZE = 10;

	private Object[] buffer = new Object[DEFAULT_SIZE];
	private int size;

	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		checkBounds(index);
		return (T)buffer[index];
	}

	public void set(int index, T value) {
		checkBounds(index);
		buffer[index] = value;
	}

	public void add(T value) {
		if(size == buffer.length) {
			Object[] newDictionary = new Object[buffer.length + DEFAULT_SIZE];
			for(int i = 0; i < size; i++) {
				newDictionary[i] = buffer[i];
			}
			buffer = newDictionary;
		}
		buffer[size++] = value;
	}

	private void checkBounds(int index) {
		if(index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}
}
