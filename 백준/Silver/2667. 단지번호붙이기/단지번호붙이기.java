import java.util.*;
import java.io.*;

public class Main {
	static int N, r, c, cnt;
	static String[][] map;
	static boolean[][] visit;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[] group;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 지도의 한 변

		map = new String[N][N]; // 지도 생성
		visit = new boolean[N][N]; // 방문 배열 생성

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.split(""); // 띄어쓰기가 없으므로 split으로 입력
		} // 입력 끝

		List<Integer> list = new ArrayList<>(); // 단지가 담길 리스트 생성

		for (int i = 0; i < N; i++) { // 행
			for (int j = 0; j < N; j++) { // 열
				cnt = 0; // 한 단지 내 가구 수
				if (!visit[i][j] && map[i][j].equals("1")) { // 방문하지 않았고, 아파트가 있다면
					DFS(i, j); // 깊이 우선 탐색(행,열)
					list.add(cnt); // 단지 내 가구 수를 리스트에 입력
				}
			}
		}

		Collections.sort(list); // 리스트 오름차순 정렬

		sb.append(list.size() + "\n"); // 리스트 사이즈가 곧 총 단지 수
		for (int i = 0; i < list.size(); i++) { // 한 단지 내 가구 수 출력
			sb.append(list.get(i) + "\n");
		}

		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();

	}// main

	public static void DFS(int r, int c) { // r은 행, c는 열
		visit[r][c] = true; // 방문 한 곳을 표시
		cnt++; // 한 가구수 표시
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i]; // 델타로 위치 갱신 , 행
			int nc = c + dc[i]; // 델타로 위치 갱신 , 열
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc] && map[nr][nc].equals("1")) {
				DFS(nr, nc); // 경계 안에 있고, 방문하지 않았고, 아파트가 있다면
				// 다시 DFS 재귀
			}
		}
	}
}