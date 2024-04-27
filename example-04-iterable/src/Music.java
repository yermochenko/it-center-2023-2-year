public class Music {
	private String name;
	private Time duration;

	public Music(String name, Time duration) {
		this.name = name;
		this.duration = duration;
	}

	public void play() {
		System.out.println("Проигрывается \"" + name + "\" (" + duration + ")");
	}

	public String getName() {
		return name;
	}

	public Time getDuration() {
		return duration;
	}
}
