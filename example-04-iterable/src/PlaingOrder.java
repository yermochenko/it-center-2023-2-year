import java.util.Iterator;
import java.util.List;

public abstract class PlaingOrder implements Iterable<Music>, Iterator<Music> {
	private List<Music> playlist;

	@Override
	final public Iterator<Music> iterator() {
		init();
		return this;
	}

	final public void setPlaylist(List<Music> playlist) {
		this.playlist = playlist;
	}

	final protected List<Music> getPlaylist() {
		return playlist;
	}

	abstract protected void init();
}
