import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int[][] dp = new int[41][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			fibo(N);
			sb.append(dp[N][0] + " " + dp[N][1] + "\n");
		}
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();

	}// main

	public static int[] fibo(int n) {

		if (dp[n][0] == -1 || dp[n][1] == -1) {
			dp[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
			dp[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
		}
		return dp[n];
	}
}