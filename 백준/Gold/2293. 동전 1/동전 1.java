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
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N];
		int[] dp = new int[K + 1];
		dp[0] = 1;

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			for (int j = coin[i]; j < dp.length; j++) {
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}

		br.close();
		bw.append(String.valueOf(dp[K]));
		bw.flush();
		bw.close();

	}
}