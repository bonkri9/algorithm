import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			int A = sc.nextInt();
			int[] arrA = new int[A];
			for (int j = 0; j < A; j++)
				arrA[j] = sc.nextInt();

			int B = sc.nextInt();
			int[] arrB = new int[B];
			for (int j = 0; j < B; j++)
				arrB[j] = sc.nextInt();

			int draw = 0;
			for (int j = 4; j > 0; j--) {
				int cntA = 0;
				int cntB = 0;

				for (int k = 0; k < A; k++)
					if (arrA[k] == j)
						cntA++;

				for (int k = 0; k < B; k++)
					if (arrB[k] == j)
						cntB++;

				if (cntA == cntB) {
					draw++;
					continue;
				}

				if (cntA > cntB) {
					System.out.println("A");
					break;
				} else {
					System.out.println("B");
					break;
				}
			}
			if (draw == 4)
				System.out.println("D");
		}
	}
}