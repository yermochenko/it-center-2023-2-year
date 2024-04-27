public class Main {
	public static void main(String[] args) {
		Player player = new Player();
		player.add(new Music("Бетховен - К Элизе", new Time(4, 34)));
		player.add(new Music("Бетховен - Лунная соната", new Time(5, 34)));
		player.add(new Music("Огинский - Полонез", new Time(3, 59)));
		player.add(new Music("Вивальди - Шторм", new Time(5, 18)));
		player.add(new Music("Queen - We will rock you", new Time(3, 8)));
		player.add(new Music("вивальди - Времена года", new Time(13, 4)));
		player.output();
		player.play(new SimpleOrder());
		player.play(new AlphabeticOrder());
		player.play(new RandomOrder());
		player.play(new RandomOrder());
		player.play(new RandomOrder());
		player.output();
	}
}
