import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arrA = new int[N];
		for (int i = 0; i < N; i++) {
			arrA[i] = sc.nextInt();
		}

		Arrays.sort(arrA);

		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int st = 0;
			int ed = N - 1;
			int search = sc.nextInt();
			while (st <= ed) {
				int mid = (st + ed) / 2;
				if (arrA[mid] == search) {
					sb.append(1 + " ");
					break;
				}
				if (arrA[mid] > search) {
					ed = mid - 1;
				} else {
					st = mid + 1;
				}
				if (st > ed) {
					sb.append(0 + " ");
					break;
				}
			}
		}
		System.out.print(sb.toString());
	}// main
}