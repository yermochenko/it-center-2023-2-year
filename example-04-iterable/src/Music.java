public class Music {
	private String name;
	// TODO: добавить время звучания трека (либо как целое число - количество
	// секунд, либо создать отдельный класс Time, либо использовать стандартный
	// класс Duration

	public Music(String name) {
		this.name = name;
	}

	public void play() {
		System.out.println("Проигрывается \"" + name + "\"");
	}

	public String getName() {
		return name;
	}
}
