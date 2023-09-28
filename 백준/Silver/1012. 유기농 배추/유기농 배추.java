import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] farm;
	static boolean[][] visit;
	static int[] dr = { 0, 1, 0, -1 }; // 우하좌상
	static int[] dc = { 1, 0, -1, 0 };
	static int nr, nc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로 길이(열)
			N = Integer.parseInt(st.nextToken()); // 세로 길이(행)
			K = Integer.parseInt(st.nextToken()); // 배추 위치 개수

			farm = new int[N][M]; //밭을 생성
			visit = new boolean[N][M]; //방문처리 배열 생성

			for (int i = 0; i < K; i++) { //배추 위치 개수 만큼 반복
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken()); // 열
				int Y = Integer.parseInt(st.nextToken()); // 행

				farm[Y][X] = 1; //배추가 있다면 1 삽입

			} // 입력 끝

			int cnt = 0;  //필요한 최소 배추 흰 지렁이 수는 곧 DFS를 돌린 횟수와 동일
			for (int i = 0; i < N; i++) { // 행
				for (int j = 0; j < M; j++) { // 열

					if (!visit[i][j] && farm[i][j] == 1) { //방문하지 않았고, 배추가 있다면
						cnt++; //지렁이 1 올리고
						DFS(i, j); //좌표값을 가지고 깊이 우선 탐색 시작 
					}
				}
			}
			sb.append(cnt + "\n"); //필요한 최소 배추흰지렁이
		} // tc
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
	}// main

	public static void DFS(int r, int c) { //깊이 우선 탐색
		visit[r][c] = true; //방문했다면 true 표시
		for (int i = 0; i < 4; i++) { //델타
			nr = r + dr[i]; //바뀐 위치 갱신, 행
			nc = c + dc[i]; //바뀐 위치 갱신, 열
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc] && farm[nr][nc] == 1) {
				DFS(nr, nc); //경계 범위 안에 있으며, 방문하지 않았고, 배추가 있다면 갱신된 행과 열을 다시 DFS 재귀
			}
		}
	}
}