import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			if (N - i * i >= 0) {
				for (int j = i; j <= N; j++) {
					if (N - i * j >= 0) {

						cnt++;
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}
		System.out.println(cnt);
	}
}