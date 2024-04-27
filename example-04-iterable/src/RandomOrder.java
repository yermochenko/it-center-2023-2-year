import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RandomOrder extends PlaingOrder {
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
		Collections.shuffle(list);
		iterator = list.iterator();
	}
}
