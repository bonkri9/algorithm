import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[][] stu = new int[2][6];

		int room = 0;

		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt() - 1;

			stu[S][Y]++;

		}

		for (int i = 0; i < stu.length; i++) {
			for (int j = 0; j < stu[i].length; j++) {
				if (stu[i][j] > K) {
					room += stu[i][j] / K + 1;
				} else if (stu[i][j] > 0) {
					room++;
				} else {

				}
			}
		}

		System.out.println(room);
	}
}
