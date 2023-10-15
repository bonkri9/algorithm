import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	// 자료구조, 수학 9375 패션왕 신해빈
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트케이스의 수
		for (int tc = 1; tc <= T; tc++) { // 테케 수 만큼 반복
			int N = Integer.parseInt(br.readLine()); // 의상의 갯수
			Map<String, Integer> fashion = new HashMap<>(); // 뒤에 나오는 의상 category, wear의 갯수

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String wear = st.nextToken(); // 사실상 필요없는 데이터
				String category = st.nextToken(); // 카테고리

				// fashion 맵에 category를 키로 갖는 곳에,
				// 기존에 category에 있다면 value값에 +1해서 값 넣음.
				// 없으면 새로운 category와 value =0 으로 넣음
				fashion.put(category, fashion.getOrDefault(category, 0) + 1);
			}

			int ans = 1; // 누적곱을 할 것이라 1로 초기화
			for (int cat : fashion.values()) {
				ans *= cat + 1; // wear의 갯수 +1해서 누적곱 해준다.
			}
			sb.append(ans - 1 + "\n"); // 누적곱에서 알몸인 상태를 1 뺀다.

		}
		br.close();
		bw.append(sb); // 출력
		bw.flush();
		bw.close();
	}
}