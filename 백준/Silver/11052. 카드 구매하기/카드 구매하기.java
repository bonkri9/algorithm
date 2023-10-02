import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] pay = new int[N + 1];
		int[] dp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < pay.length; i++) {
			pay[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < i + 1; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + pay[j]);
			}
		}

		br.close();
		bw.append(String.valueOf(dp[N]));
		bw.flush();
		bw.close();

	}
}