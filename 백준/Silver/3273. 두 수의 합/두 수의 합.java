import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arrN = new int[N];
		for (int i = 0; i < N; i++) {
			arrN[i] = sc.nextInt();
		}
		int X = sc.nextInt();
		Arrays.sort(arrN);
//		System.out.println(Arrays.toString(arrN));

		int cnt = 0;
		int mid;
		int M;
		for (int i = 0; i < N; i++) {
			int ed = N - 1;
			int st = 0;
			M = X - arrN[i];
			while (st <= ed) {
				mid = (st + ed) / 2;
				if (M == arrN[mid]) {
					cnt++;
					break;
				}
				if (M < arrN[mid]) {
					ed = mid - 1;
				} else if (M > arrN[mid]) {
					st = mid + 1;
				}
			}
		}
		System.out.println(cnt/2);
	}
}