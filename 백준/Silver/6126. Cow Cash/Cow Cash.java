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
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] value = new int[V];

		long[] dp = new long[N + 1];
		dp[0] = 1;

		for (int i = 0; i < V; i++) {
			value[i] = Integer.parseInt(br.readLine());
			for (int j = value[i]; j < dp.length; j++) {
				dp[j] = dp[j] + dp[j - value[i]];
			}
		}
		
//		System.out.println(Arrays.toString(dp));

		br.close();
		bw.append(String.valueOf(dp[N]));
		bw.flush();
		bw.close();

	}
}