public class Robot {
	private String name;
	private Chassis chassis;
	private ControlBlock controlBlock;
	private VideoSensor videoSensor;
	private SpeedSensor speedSensor;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Chassis getChassis() {
		return chassis;
	}
	public void setChassis(Chassis chassis) {
		this.chassis = chassis;
	}
	public ControlBlock getControlBlock() {
		return controlBlock;
	}
	public void setControlBlock(ControlBlock controlBlock) {
		this.controlBlock = controlBlock;
	}
	public VideoSensor getVideoSensor() {
		return videoSensor;
	}
	public void setVideoSensor(VideoSensor videoSensor) {
		this.videoSensor = videoSensor;
	}
	public SpeedSensor getSpeedSensor() {
		return speedSensor;
	}
	public void setSpeedSensor(SpeedSensor speedSensor) {
		this.speedSensor = speedSensor;
	}
	public double getWeight() {
		double totalWeight = 0;
		totalWeight += chassis.getWeight();
		totalWeight += controlBlock.getWeight();
		totalWeight += videoSensor.getWeight();
		totalWeight += speedSensor.getWeight();
		return totalWeight;
	}
	public int getPower() {
		int totalPower = 0;
		totalPower += chassis.getPower();
		totalPower += controlBlock.getPower();
		totalPower += speedSensor.getPower();
		totalPower += videoSensor.getPower();
		return totalPower;
	}
	public double liftingCapacity() {
		return chassis.getMaxMoveableWeight() - getWeight();
	}
	public int timeOfWorking() {
		return chassis.getBattery().getPowerPerHour() / getPower();
	}
}
