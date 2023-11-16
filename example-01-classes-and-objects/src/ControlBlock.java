public class ControlBlock {
	private String name;
	private double clockFrequency;
	private int ramVolume;
	private int power;
	private double weight;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getClockFrequency() {
		return clockFrequency;
	}
	public void setClockFrequency(double clockFrequency) {
		this.clockFrequency = clockFrequency;
	}
	public int getRamVolume() {
		return ramVolume;
	}
	public void setRamVolume(int ramVolume) {
		this.ramVolume = ramVolume;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		if(weight > 0) {
			this.weight = weight;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
