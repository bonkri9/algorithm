
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
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[1000001];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for (int i = 4; i < N + 1; i++) {
				dp[i] = (dp[i - 1]) % 1_000_000_009 + (dp[i - 2]) % 1_000_000_009 + (dp[i - 3]) % 1_000_000_009;
			}
			sb.append((dp[N] % 1_000_000_009) + "\n");
//			System.out.println(Arrays.toString(dp));

		}
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
	}
}
