import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[3];

		while (true) {

			for (int i = 0; i < 3; i++) {
				arr[i] = sc.nextInt();
			}

			if (arr[2] == 0 && arr[1] == 0 && arr[0] == 0) {
				break;
			} else if (arr[2] - arr[1] == arr[1] - arr[0]) {
				int A = arr[2] * 2 - arr[1];
				System.out.println("AP " + A);
			} else if (arr[2] / arr[1] == arr[1] / arr[0]) {
				int B = arr[2] * arr[2] / arr[1];
				System.out.println("GP " + B);
			}

		}

	}

}