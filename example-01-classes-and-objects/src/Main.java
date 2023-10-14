import java.util.Scanner;

public class Main {
	static int timeOfWorking(Robot robot) {
		int totalPower = 0;
		totalPower += robot.chassis.engine.power;
		totalPower += robot.controlBlock.power;
		totalPower += robot.speedSensor.power;
		totalPower += robot.videoSensor.power;
		return robot.chassis.battery.powerPerHour / totalPower;
	}
	static double liftingCapacity(Robot robot) {
		double totalWeight = 0;
		totalWeight += robot.chassis.weight;
		totalWeight += robot.chassis.battery.weight;
		totalWeight += robot.chassis.engine.weight;
		totalWeight += robot.chassis.transmisson.weight;
		totalWeight += robot.controlBlock.weight;
		totalWeight += robot.speedSensor.weight;
		totalWeight += robot.videoSensor.weight;
		return robot.chassis.engine.maxMoveableWeight - totalWeight;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Robot robot = new Robot();
		System.out.print("Введите название робота: ");
		robot.name = scanner.nextLine();
		robot.chassis = new Chassis();
		System.out.print("Введите тип ходовой части: ");
		robot.chassis.type = scanner.nextLine();
		System.out.print("Введите собственную массу ходовой части (кг): ");
		robot.chassis.weight = Double.parseDouble(scanner.nextLine());
		robot.chassis.battery = new Battery();
		System.out.print("Введите название (тип) аккумулятора: ");
		robot.chassis.battery.name = scanner.nextLine();
		System.out.print("Введите ёмкость аккумулятора (мА×ч): ");
		robot.chassis.battery.powerPerHour = Integer.parseInt(scanner.nextLine());
		System.out.print("Введите массу аккумулятора (кг): ");
		robot.chassis.battery.weight = Double.parseDouble(scanner.nextLine());
		robot.chassis.engine = new Engine();
		System.out.print("Введите название двигателя: ");
		robot.chassis.engine.name = scanner.nextLine();
		System.out.print("Введите величину крутящего момента двигателя (Н×м): ");
		robot.chassis.engine.torque = Double.parseDouble(scanner.nextLine());
		System.out.print("Введите максимальную развиваемую двигателем нагрузку (кг): ");
		robot.chassis.engine.maxMoveableWeight = Double.parseDouble(scanner.nextLine());
		System.out.print("Введите потребляемую мощность двигателя (мА): ");
		robot.chassis.engine.power = Integer.parseInt(scanner.nextLine());
		System.out.print("Введите массу двигателя (кг): ");
		robot.chassis.engine.weight = Double.parseDouble(scanner.nextLine());
		robot.chassis.transmisson = new Transmisson();
		System.out.print("Введите название коробки передач: ");
		robot.chassis.transmisson.name = scanner.nextLine();
		System.out.print("Введите количество передач у коробки передач: ");
		robot.chassis.transmisson.levelCount = Integer.parseInt(scanner.nextLine());
		System.out.print("Поддерживает ли коробка передач реверс (true/false): ");
		robot.chassis.transmisson.reverse = Boolean.parseBoolean(scanner.nextLine());
		System.out.print("Введите массу коробки передач (кг): ");
		robot.chassis.transmisson.weight = Double.parseDouble(scanner.nextLine());
		robot.controlBlock = new ControlBlock();
		System.out.print("Введите название блока управления: ");
		robot.controlBlock.name = scanner.nextLine();
		System.out.print("Введите частоту процессора блока управления (ГГц): ");
		robot.controlBlock.clockFrequency = Double.parseDouble(scanner.nextLine());
		System.out.print("Введите объём оперативной памяти блока управления (ГБ): ");
		robot.controlBlock.ramVolume = Integer.parseInt(scanner.nextLine());
		System.out.print("Введите потребляемую мощность блока управления (мА): ");
		robot.controlBlock.power = Integer.parseInt(scanner.nextLine());
		System.out.print("Введите массу блока управления (кг): ");
		robot.controlBlock.weight = Double.parseDouble(scanner.nextLine());
		robot.videoSensor = new VideoSensor();
		System.out.print("Введите название видеосенсора (камеры): ");
		robot.videoSensor.name = scanner.nextLine();
		System.out.print("Введите цветовой режим видеосенсора: ");
		robot.videoSensor.colorMode = scanner.nextLine();
		System.out.print("Введите разрешение видеосенсора по ширине (пикселей): ");
		robot.videoSensor.widthResolution = Integer.parseInt(scanner.nextLine());
		System.out.print("Введите разрешение видеосенсора по высоте (пикселей): ");
		robot.videoSensor.heightResolution = Integer.parseInt(scanner.nextLine());
		System.out.print("Введите частоту развёртки видеосенсора (кадр/с): ");
		robot.videoSensor.fps = Integer.parseInt(scanner.nextLine());
		System.out.print("Введите потребляемую мощность видеосенсора (мА): ");
		robot.videoSensor.power = Integer.parseInt(scanner.nextLine());
		System.out.print("Введите массу видеосенсора (кг): ");
		robot.videoSensor.weight = Double.parseDouble(scanner.nextLine());
		robot.speedSensor = new SpeedSensor();
		System.out.print("Введите название детектора скорости: ");
		robot.speedSensor.name = scanner.nextLine();
		System.out.print("Введите частоту срабатывания детектора скорости (с): ");
		robot.speedSensor.latency = Double.parseDouble(scanner.nextLine());
		System.out.print("Введите потребляемую мощность детектора скорости (мА): ");
		robot.speedSensor.power = Integer.parseInt(scanner.nextLine());
		System.out.print("Введите массу детектора скорости (кг): ");
		robot.speedSensor.weight = Double.parseDouble(scanner.nextLine());
		System.out.println("Максимальное время работы робота " + timeOfWorking(robot) + " ч");
		System.out.println("Максимальная грузоподъёмность робота " + liftingCapacity(robot) + " кг");
		scanner.close();
	}
}
