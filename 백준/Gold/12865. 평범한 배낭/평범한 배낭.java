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
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<N+1;i++) {
			for(int w=0;w<K+1;w++) {
				if(weight[i] <= w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i]]+value[i]);
				}else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}

		br.close();
		bw.append(String.valueOf(dp[N][K]));
		bw.flush();
		bw.close();

	}
}