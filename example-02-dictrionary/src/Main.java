import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите слова (для окончания ввода введите пустую строку):");
		String word;
		List<String> dictionary = new LinkedList<>();
		List<Integer> lengths = new LinkedList<>();
		while(!(word = scanner.nextLine()).isBlank()) {
			word = word.trim().toLowerCase();
			dictionary.add(word);
			lengths.add(word.length());
		}
		System.out.println("--=< КОНЕЦ ВВОДА >=--");
		int count = 0;
		for(int i = 0; i < dictionary.size(); i++) {
			String s = dictionary.get(i);
			System.out.println(i + "-й элемент массива равен '" + s + "'");
			count += lengths.get(i);
		}
		System.out.println("Всего " + count + " букв");
		System.out.println("--=< КОНЕЦ ПРОГРАММЫ >=--");
		scanner.close();
	}
}
