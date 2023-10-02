import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int[] dp = new int[11];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			for (int i = 4; i < dp.length; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}

			sb.append(dp[N] + "\n");

		} // tc

		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();

	}
}