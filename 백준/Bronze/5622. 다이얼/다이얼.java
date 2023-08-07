import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int[] arr = new int[8];
		int time=0;
		int sumOfTime = 0;

		for (int i = 0; i < str.length(); i++) {
			int tmp = str.charAt(i) - 'A';

			if (tmp >= 0 && tmp < 3) {
				time = 3;
			} else if (tmp >= 3 && tmp < 6) {
				time = 4;
			} else if (tmp >= 6 && tmp < 9) {
				time = 5;
			} else if (tmp >= 9 && tmp < 12) {
				time = 6;
			} else if (tmp >= 12 && tmp < 15) {
				time = 7;
			} else if (tmp >= 15 && tmp < 19) {
				time = 8;
			} else if (tmp >= 19 && tmp < 22) {
				time = 9;
			} else if (tmp >= 22 && tmp < 26) {
				time = 10;
			}
			sumOfTime += time;
		}
		System.out.println(sumOfTime);
		
	}

}
