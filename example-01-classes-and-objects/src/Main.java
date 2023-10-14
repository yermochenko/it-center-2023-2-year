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
		System.out.print("Введите ёмкость аккумулятора (мА × ч): ");
		robot.chassis.battery.powerPerHour = Integer.parseInt(scanner.nextLine());
		System.out.print("Введите массу аккумулятора (кг): ");
		robot.chassis.battery.weight = Double.parseDouble(scanner.nextLine());
		// TODO: закончить ввод данных
		System.out.println("Максимальное время работы робота " + timeOfWorking(robot) + " ч");
		System.out.println("Максимальная грузоподъёмность робота " + liftingCapacity(robot) + " кг");
		scanner.close();
	}
}
