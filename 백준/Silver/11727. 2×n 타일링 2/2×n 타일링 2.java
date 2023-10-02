import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1001];
		dp[1] =1;
		dp[2] = 3;
		for(int i=3;i<dp.length;i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		br.close();
		bw.append(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
		
	}
}