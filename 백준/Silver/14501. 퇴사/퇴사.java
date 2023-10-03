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

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 2]; // 조건이 한개(상담 기간)라 1차원으로 가능, N일까지 근무, N+1일부터 회사에 없음
		int[] consulting = new int[N + 1]; // 각 상담 마다의 상담 기간 저장 배열
		int[] pay = new int[N + 1]; // 각 상담에 따른 비용

		for (int i = 1; i < N + 1; i++) { // 상담기간과 상담비용 입력 1번부터 N번까지 반복
			st = new StringTokenizer(br.readLine());
			consulting[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		for (int i = 1; i < N + 1; i++) {// dp배열을 0부터 마지막 근무까지 반복
			if (i + consulting[i] <= N + 1) { // 현재 날짜(i)+상담기간(consulting[i])이 근무 마지막날을 넘어서면 안된다.
				// 대신 N일(마지막 근무)에 상담기간이 1일인건 가능해서 <=N+1 인 것이다.
				// 작거나 같으면, dp의 현재날짜+상담기간 위치에 아래 둘 중에 큰 상담비용을 저장
				// 기존에 적힌 dp의 현재 날짜+상담기간에 있는 상담비용 VS (기존 dp의 현재날짜의 상담비용 + 현재날짜의 상담비용)
				dp[i + consulting[i]] = Math.max(dp[i + consulting[i]], dp[i] + pay[i]);
			}
			// 다음 날짜에는 아래 둘 중에 큰 상담 비용을 저장
			// dp의 이미 저장된 다음날의 상담비용 VS dp의 이미 저장된 현재 날짜의 상담비용
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);

		}

//		System.out.println(Arrays.toString(pay));
//		System.out.println(Arrays.toString(consulting));
//		System.out.println(Arrays.toString(dp));

		br.close();
		bw.append(String.valueOf(dp[N + 1]));
		bw.flush();
		bw.close();

	}
}