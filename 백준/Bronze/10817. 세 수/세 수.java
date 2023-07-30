
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if (A >= B) {
			if (B >= C) {
				System.out.println(B);
			} else if (C >= B) {
				if (A >= C) {
					System.out.println(C);
				} else if (C >= A) {
					System.out.println(A);
				}
			}

		} else if (B >= A) {
			if (A >= C) {
				System.out.println(A);
			} else if (C >= A) {
				if (B >= C) {
					System.out.println(C);
				} else if (C >= B) {
					System.out.println(B);
				}
			}

		}
	}
}