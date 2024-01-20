public class LinkedList<T> implements List<T> {
	private Node begin;
	private Node end;

	@Override
	public int size() {
		Node current = begin;
		int count = 0;
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	@Override
	public T get(int index) {
		Node current = begin;
		int i = 0;
		while(current != null) {
			if(i == index) {
				return current.value;
			}
			i++;
			current = current.next;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

	@Override
	public void set(int index, T value) {
		Node current = begin;
		int i = 0;
		while(current != null) {
			if(i == index) {
				current.value = value;
				return;
			}
			i++;
			current = current.next;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

	@Override
	public void add(T value) {
		Node element = new Node();
		element.value = value;
		if(begin != null && end != null) {
			end.next = element;
			element.prev = end;
		} else {
			begin = element;
		}
		end = element;
	}

	private class Node {
		private T value;
		private Node next;
		private Node prev;
	}
}
