
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int multi = 1;

		for (int i = 0; i < 3; i++) {
			multi *= sc.nextInt();
		}
		
		int[] arr = new int[10];

		while (multi > 0) {
			int num = multi % 10;

			for (int i = 0; i < 10; i++) {
				if (num == i) {
					arr[i]++;
				}
			}

			multi = multi / 10;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}