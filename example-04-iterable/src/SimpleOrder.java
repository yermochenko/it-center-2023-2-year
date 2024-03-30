import java.util.Iterator;

public class SimpleOrder extends PlaingOrder {
	private Iterator<Music> iterator;

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public Music next() {
		return iterator.next();
	}

	@Override
	protected void init() {
		iterator = getPlaylist().iterator();
	}
}
