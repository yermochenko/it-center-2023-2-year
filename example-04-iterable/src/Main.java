public class Main {
	public static void main(String[] args) {
		Player player = new Player();
		player.getPlaylist().add(new Music("Бетховен - К Элизе"));
		player.getPlaylist().add(new Music("Бетховен - Лунная соната"));
		player.getPlaylist().add(new Music("Огинский - Полонез"));
		player.getPlaylist().add(new Music("Вивальди - Шторм"));
		player.getPlaylist().add(new Music("Queen - We will rock you"));
		player.output();
		player.play(new SimpleOrder());
		// TODO: добавить собственный Order для проигрывания плейлиста
		// в случайном порядке (наследник класса PlaingOrder)
		player.output();
	}
}
