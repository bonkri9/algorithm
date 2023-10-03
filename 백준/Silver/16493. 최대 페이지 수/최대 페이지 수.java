import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 반납까지 남은 기간 N일
		int M = Integer.parseInt(st.nextToken()); // 챕터의 수 M

		int[] period = new int[M + 1]; // 각 챕터마다 읽는데 걸리는 기간
		int[] pages = new int[M + 1]; // 각 챕터 당 페이지 수
		int[][] dp = new int[M + 1][N + 1]; // 행은 챕터 번호만큼, 열은 반납기간만큼

		for (int i = 1; i < period.length; i++) {
			st = new StringTokenizer(br.readLine());
			period[i] = Integer.parseInt(st.nextToken());
			pages[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		for (int i = 1; i < M + 1; i++) { // 행- 챕터번호
			for (int j = 1; j < N + 1; j++) { // 열- 반납기간
				if (period[i] <= j) { // 반납기간을 초과하지 않으면
					// 그 전 행의 페이지 VS 새로운 챕터 페이지 더한 것
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - period[i]] + pages[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		br.close();
		bw.append(String.valueOf(dp[M][N]));
		bw.flush();
		bw.close();

	}
}