import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnitRobotTest {
	Robot robot;

	@BeforeEach
	void initRobot() {
		robot = new Robot();
		robot.setName("Вилли");
		robot.setChassis(new Chassis());
		robot.getChassis().setType("Гусеничное");
		robot.getChassis().setWeight(5);
		robot.getChassis().setBattery(new Battery());
		robot.getChassis().getBattery().setName("Литий-ферро-фосфатный");
		robot.getChassis().getBattery().setPowerPerHour(100_000);
		robot.getChassis().getBattery().setWeight(1.5);
		robot.getChassis().setEngine(new Engine());
		robot.getChassis().getEngine().setName("BMV-45a");
		robot.getChassis().getEngine().setTorque(1_000);
		robot.getChassis().getEngine().setMoveableEffort(250);
		robot.getChassis().getEngine().setPower(1_000);
		robot.getChassis().getEngine().setWeight(2.1);
		robot.getChassis().setTransmisson(new Transmisson());
		robot.getChassis().getTransmisson().setName("Шестерёнчатая");
		robot.getChassis().getTransmisson().setLevelCount(3);
		robot.getChassis().getTransmisson().setReverse(true);
		robot.getChassis().getTransmisson().setWeight(0.6);
		robot.setControlBlock(new ControlBlock());
		robot.getControlBlock().setName("IBA 6798");
		robot.getControlBlock().setClockFrequency(1.4);
		robot.getControlBlock().setRamVolume(2);
		robot.getControlBlock().setPower(500);
		robot.getControlBlock().setWeight(0.4);
		robot.setVideoSensor(new VideoSensor());
		robot.getVideoSensor().setName("Sony TQ-12-3");
		robot.getVideoSensor().setColorMode("16 bits");
		robot.getVideoSensor().setWidthResolution(1024);
		robot.getVideoSensor().setHeightResolution(768);
		robot.getVideoSensor().setFps(75);
		robot.getVideoSensor().setPower(400);
		robot.getVideoSensor().setWeight(0.25);
		robot.setSpeedSensor(new SpeedSensor());
		robot.getSpeedSensor().setName("LG-0xAFEC");
		robot.getSpeedSensor().setLatency(0.01);
		robot.getSpeedSensor().setPower(100);
		robot.getSpeedSensor().setWeight(0.15);
	}

	@Test
	void testLiftingCapacity() {
		assertEquals(240.0, robot.liftingCapacity(), 0.0001);
	}

	@Test
	void testTimeOfWorking() {
		assertEquals(50, robot.timeOfWorking());
	}

	@AfterEach
	void destroyRobot() {
		robot = null;
	}
}
