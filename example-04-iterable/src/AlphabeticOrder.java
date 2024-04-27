import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlphabeticOrder extends PlaingOrder {
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
		List<Music> list = new ArrayList<>(getPlaylist());
		list.sort((m1, m2) -> m1.getName().compareToIgnoreCase(m2.getName()));
		iterator = list.iterator();
	}
}
