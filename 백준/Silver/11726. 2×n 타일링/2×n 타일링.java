

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}

		br.close();
		bw.append(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
	}
}
