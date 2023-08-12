import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] nums = new int[T];
		for (int i = 0; i < T; i++) {
			nums[i] = sc.nextInt();
		}

		for (int i = 0; i < T; i++) {
			for (int j = i+1; j < T; j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}

		for (

				int i = 0; i < T; i++) {
			System.out.println(nums[i]);
		}

	}

}