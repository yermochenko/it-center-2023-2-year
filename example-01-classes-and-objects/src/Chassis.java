public class Chassis {
	private String type;
	private double weight;
	private Engine engine;
	private Transmisson transmisson;
	private Battery battery;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getWeight() {
		return weight + engine.getWeight() + transmisson.getWeight() + battery.getWeight();
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Transmisson getTransmisson() {
		return transmisson;
	}
	public void setTransmisson(Transmisson transmisson) {
		this.transmisson = transmisson;
	}
	public Battery getBattery() {
		return battery;
	}
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	public double getMaxMoveableWeight() {
		return engine.getMoveableEffort();
	}
	public int getPower() {
		return engine.getPower();
	}
}
