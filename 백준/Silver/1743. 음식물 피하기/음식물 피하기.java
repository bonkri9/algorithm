import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] path;
	static boolean[][] visit;
	static int[] dr = { 0, 0, 1, -1 }; // 우좌하상, 행
	static int[] dc = { 1, -1, 0, 0 }; // 우좌하상, 열
	static int r, c, max, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로길이
		M = Integer.parseInt(st.nextToken()); // 가로길이
		K = Integer.parseInt(st.nextToken()); // 쓰레기 개수

		path = new int[N][M]; // 통로 초기화
		visit = new boolean[N][M]; // 방문배열 초기화

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1; // 배열 인덱스가 0부터이므로 1 뺀 행
			c = Integer.parseInt(st.nextToken()) - 1; // 이하 동일, 열

			path[r][c] = 1; // 쓰레기 있으면 1 넣기

		}

		max = 0; // 최대 쓰레기 크기

		for (int i = 0; i < N; i++) { // 행
			for (int j = 0; j < M; j++) { // 열
				cnt = 0; // 쓰레기 크기
				if (path[i][j] == 1) {
					DFS(i, j); // 깊이 우선탐색 (행, 열)
					if (max < cnt) { // 가장 큰 쓰레기를 저장
						max = cnt;
					}
				}
			}
		}
		br.close();
		bw.append(String.valueOf(max)); // 가장 큰거 출력
		bw.flush();
		bw.close();

	}// main

	public static void DFS(int r, int c) { // 깊이 우선탐색
		visit[r][c] = true; // 방문

		cnt++;// 쓰레기 개수 1올리고

		for (int i = 0; i < 4; i++) { // 상하좌우 탐색
			int nr = r + dr[i]; // 새로운 행
			int nc = c + dc[i]; // 새로운 열

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc] && path[nr][nc] == 1) {
				// 경계를 벗어나지 않고, 방문하지 않았고, 쓰레기가 있다면
				DFS(nr, nc); // 갱신된 위치로 다시 DFS 재귀
			}
		}
	}
}