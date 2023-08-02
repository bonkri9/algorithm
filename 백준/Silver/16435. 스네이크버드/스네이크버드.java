import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int fruit = sc.nextInt();
		int birdLength = sc.nextInt();
		int[] arr = new int[fruit];

		for (int i = 0; i < fruit; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			if (birdLength >= arr[i]) {
				birdLength++;
			}else break;
		}
		System.out.println(birdLength);
	}

}