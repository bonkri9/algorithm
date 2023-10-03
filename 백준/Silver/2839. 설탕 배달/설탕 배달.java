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
		int[] dp = new int[N + 1];

		for (int i = 1; i < dp.length; i++) {
			int min = 987654321;
			if (i >= 3) {
				min = Math.min(min, dp[i - 3] + 1);
			}
			if (i >= 5) {
				min = Math.min(min, dp[i - 5] + 1);
			}
			dp[i] = min;
		}

//		System.out.println(Arrays.toString(dp));

		br.close();
		if (dp[N] == 987654321) {
			bw.append("-1");
		} else {
			bw.append(String.valueOf(dp[N]));
		}
		bw.flush();
		bw.close();

	}
}