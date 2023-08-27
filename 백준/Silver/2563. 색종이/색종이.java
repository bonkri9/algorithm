import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int area = 0;
		boolean[][] check = new boolean[101][101];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = y; j < y + 10; j++) {
				for (int k = x; k < x + 10; k++) {
					check[j][k] = true;
				}
			}
		}

		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (check[i][j]) {
					area++;
				}
			}
		}
		System.out.println(area);
	}
}