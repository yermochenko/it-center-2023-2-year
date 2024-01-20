public interface List<T> {
	int size();
	T get(int index);
	void set(int index, T value);
	void add(T value);
	// void remove(int index);
}
