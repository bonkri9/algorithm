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

		int N = Integer.parseInt(br.readLine()); //사람 수 N

		int[] minusHP = new int[N + 1]; //인사 하면 읽는 체력
		int[] getDelight = new int[N + 1]; //인사 하면 얻는 기쁨
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < minusHP.length; i++) {
			minusHP[i] = Integer.parseInt(st.nextToken());
		} // 잃는 체력 입력 끝
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < getDelight.length; i++) {
			getDelight[i] = Integer.parseInt(st.nextToken());
		} // 얻는 기쁨 입력 끝

		int[][] dp = new int[N + 1][100]; //행은 사람수+1, 열은 체력 100(0부터 99까지)

		for (int i = 1; i < N + 1; i++) { //사람 1번부터 N번까지 반복
			for (int j = 1; j < 100; j++) { //체력 1번부터 99까지. 100을 잃으면 기쁨이 0이니 99까지 돌림
				if (minusHP[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - minusHP[i]] + getDelight[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		br.close();
		bw.append(String.valueOf(dp[N][99]));
		bw.flush();
		bw.close();

	}
}