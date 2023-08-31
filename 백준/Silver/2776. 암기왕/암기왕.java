import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb  = new StringBuilder();
			int N = sc.nextInt();
			int[] noteOne = new int[N];
			for (int i = 0; i < N; i++) {
				noteOne[i] = sc.nextInt();
			}
			Arrays.sort(noteOne);

			int M = sc.nextInt();
			for (int i = 0; i < M; i++) {
				int num = sc.nextInt();
				int st = 0;
				int ed = noteOne.length - 1;
				int mid;
				boolean flag = true;
				while (st <= ed) {
					mid = st + (ed - st) / 2;
					if (num == noteOne[mid]) {
						flag = false;
						break;
					} else if (num < noteOne[mid]) {
						ed = mid - 1;
					} else if (num > noteOne[mid]) {
						st = mid + 1;
					}
				}
					sb.append(flag? 0:1).append("\n");
			}
			System.out.print(sb);
		}

	}
}