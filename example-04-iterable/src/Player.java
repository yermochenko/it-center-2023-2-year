import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Music> playlist = new ArrayList<>();

	public List<Music> getPlaylist() {
		return playlist;
	}

	public void output() {
		int index = 1;
		System.out.println("Playlist:");
		for(Music music : playlist) {
			System.out.printf("%2d. %s\n", index++, music.getName());
		}
		System.out.println("Total:");
		// TODO: вывести суммарное время звучания плейлиста
	}

	public void play(PlaingOrder order) {
		order.setPlaylist(playlist);
		for(Music music : order) {
			music.play();
		}
	}
}
