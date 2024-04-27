public class Time {
	private final int seconds;

	private Time(int seconds) {
		if(seconds >=0) {
			this.seconds = seconds;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public Time(int minutes, int seconds) {
		this(0, minutes, seconds);
	}

	public Time(int hours, int minutes, int seconds) {
		if(hours >= 0 && 0 <= minutes && minutes < 60 && 0 <= seconds && seconds < 60) {
			this.seconds = (hours * 60 + minutes) * 60 + seconds;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int getHours() {
		return seconds / 3600;
	}

	public int getMinutes() {
		return (seconds / 60) % 60;
	}

	public int getSeconds() {
		return seconds % 60;
	}

	public static Time sum(Time a, Time b) {
		return new Time(a.seconds + b.seconds);
	}

	@Override
	public String toString() {
		return String.format("%d:%02d:%02d", getHours(), getMinutes(), getSeconds());
	}
}
