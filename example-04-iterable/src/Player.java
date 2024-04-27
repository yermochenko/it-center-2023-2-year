import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Music> playlist = new ArrayList<>();

	public List<Music> getPlaylist() {
		return playlist;
	}

	public void add(Music music) {
		playlist.add(music);
	}

	public void output() {
		int index = 1;
		System.out.println("Playlist:");
		Time total = new Time(0, 0);
		for(Music music : playlist) {
			Time durarion = music.getDuration();
			System.out.printf("%2d. %s (%s)\n", index++, music.getName(), durarion);
			total = Time.sum(total, durarion);
		}
		System.out.println("Total: " + total);
	}

	public void play(PlaingOrder order) {
		order.setPlaylist(playlist);
		System.out.println("Начало проигрывания плейлиста");
		for(Music music : order) {
			music.play();
		}
		System.out.println("Окончание проигрывания плейлиста");
	}
}
