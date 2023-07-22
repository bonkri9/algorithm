import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int a = 0; a < num; a++) {
			for (int b = 0; b < 2; b++) {

				for (int c = 0; c < num; c++) {
					System.out.print("@");
				}
				for (int d = 0; d < num; d++) {
					System.out.print("   ");
				}
				for (int e = 0; e < num; e++) {
					System.out.print("@");
				}
				System.out.println("");
			}
		}
		for (int f = 0; f < num; f++) {
			for (int g = 0; g < 5; g++) {
				for (int h = 0; h < num; h++) {
					System.out.print("@");
				}
			}
			System.out.println("");
		}
		for (int a = 0; a < num; a++) {

			for (int c = 0; c < num; c++) {
				System.out.print("@");
			}
			for (int d = 0; d < num; d++) {
				System.out.print("   ");
			}
			for (int e = 0; e < num; e++) {
				System.out.print("@");
			}
			System.out.println("");

		}
		for (int f = 0; f < num; f++) {
			for (int g = 0; g < 5; g++) {
				for (int h = 0; h < num; h++) {
					System.out.print("@");
				}
			}
			System.out.println("");
		}

	}

}