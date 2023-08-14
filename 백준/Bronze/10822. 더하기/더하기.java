import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		String[] arrStr = N.split(",");

		int sum = 0;
		for (int i = 0; i < arrStr.length; i++) {
			sum += Integer.valueOf(arrStr[i]);
		}

		System.out.println(sum);

	}
}