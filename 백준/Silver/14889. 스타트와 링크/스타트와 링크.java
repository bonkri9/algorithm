import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int min = 987654321;
	static int[][] synergy;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 사람 수
		synergy = new int[N][N]; // 시너지 배열
		visit = new boolean[N]; // 방문 배열

		for (int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for (int j = 0; str.hasMoreTokens(); j++) {
				synergy[i][j] = Integer.parseInt(str.nextToken());
			}
		} // 입력 끝

		DFS(0, 0); //깊이우선탐색 시작

		br.close();
		bw.append(String.valueOf(min));
		bw.flush();
		bw.close();
	}

	public static void DFS(int depth, int idx) { //dep
		//기저파트
		if (depth == N / 2) {
			int start = 0;
			int link = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visit[i] == true && visit[j] == true) {
						start += synergy[i][j];
						start += synergy[j][i];
					} else if (visit[i] == false && visit[j] == false) {
						link += synergy[i][j];
						link += synergy[j][i];
					}

				}
			}

			int val = Math.abs(start - link);

			min = Math.min(min, val);
			return;
		}
		
		//재귀 파트
		for (int i = idx; i < N; i++) {
			visit[i] = true; //방문체크
			DFS(depth + 1, i + 1); //재귀 깊이우선탐색
			visit[i] = false; //방문 취소
		}
	}

}