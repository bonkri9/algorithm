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
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			double N = Double.parseDouble(st.nextToken()); // M개 중 N개 뽑기
			double M = Double.parseDouble(st.nextToken());

			double ans = 0; // 정답 초기화
			double upNum = 1; // 분자
			double downNum = 1; // 분모

			for (double i = M; i > M - N; i--) { // combination의 분자 식
				upNum *= i;
			}

			for (double i = N; i > 0; i--) { // combination의 분모 식
				downNum *= i;
			}

			ans = upNum / downNum;
			sb.append(Math.round(ans) + "\n");// 정답 쌓기
		}

		br.close();
		bw.append(sb); 
		bw.flush();
		bw.close();

	}
}