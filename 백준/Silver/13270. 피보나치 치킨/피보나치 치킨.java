
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[10000][2];

		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1987654321;
		}

		int prev = 1;
		int now = 2;

		while (now <= N) {
			for (int i = now; i <= N; i++) {
				dp[i][0] = Math.min(dp[i][0], dp[i - now][0] + prev);
				dp[i][1] = Math.max(dp[i][1], dp[i - now][1] + prev);
			}
			now += prev;
			prev = now - prev;
		}

		sb.append(dp[N][0] + " " + dp[N][1]);
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
	}

}
