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

		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][10];

		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}

//		System.out.println(Arrays.deepToString(dp));

		for (int i = 2; i < dp.length; i++) {
			dp[i][0] = dp[i-1][1]%1_000_000_000;
			for (int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])%1_000_000_000;
			}
			dp[i][9] = dp[i - 1][8]%1_000_000_000;
		}

//		System.out.println(Arrays.deepToString(dp));
		long sum = 0;
		for (int i = 1; i < 10; i++) {
			sum += dp[N][i];
		}

		br.close();
		bw.append(String.valueOf(sum%1_000_000_000));
		bw.flush();
		bw.close();

	}
}