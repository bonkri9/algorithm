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
		Arrays.fill(dp, 987654321);
		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			for (int j = coin[i]; j < dp.length; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]]+1);
			}
		}

		br.close();
		if (dp[K] == 987654321) {
			bw.append("-1");
		} else {
			bw.append(String.valueOf(dp[K]));
		}
		bw.flush();
		bw.close();

	}
}