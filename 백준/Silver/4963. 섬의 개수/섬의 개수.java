import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int W, H, cnt;
	static boolean[][] visit;
	static int[] dr = { 0, 0, -1, 1, 1, 1, -1, -1 }; // 8방탐색
	static int[] dc = { -1, 1, 0, 0, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken()); // 너비 열
			H = Integer.parseInt(st.nextToken()); // 높이 행

			if (W == 0 && H == 0)
				break;

			map = new int[H][W];
			visit = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			System.out.println(Arrays.deepToString(map));

			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!visit[i][j] && map[i][j] == 1) {
						cnt++;
						DFS(i, j);
					}
				}
			}
			System.out.println(cnt);
		} // while 문

	}// main

	public static void DFS(int r, int c) {
		visit[r][c] = true;
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visit[nr][nc] && map[nr][nc] == 1) {
				DFS(nr, nc);
			}
		}

	}

}