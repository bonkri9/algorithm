import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt, nr, nc;
	static int[][] planet;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	static boolean[][] visit;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N][M];
		planet = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				planet[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]&&planet[i][j] == 0) {
					BFS(i, j);
				}
			}
		}

		br.close();
		bw.append(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}// main

	public static void BFS(int r, int c) {
		cnt++;
		queue = new LinkedList<>();
		int[] currloc = { r, c };
		queue.add(currloc);
		visit[r][c] = true;
		while (!queue.isEmpty()) {
			int currR = queue.peek()[0];
			int currC = queue.peek()[1];
			queue.poll();
			for (int i = 0; i < 4; i++) {
				nr = currR + dr[i];
				if (nr < 0 || nr >= N) {
					nr = Math.abs(Math.abs(nr) - N);
				}

				nc = currC + dc[i];
				if (nc < 0 || nc >= M) {
					nc = Math.abs(Math.abs(nc) - M);
				}
				if (!visit[nr][nc] && planet[nr][nc] == 0) {
					int[] nextLoc = { nr, nc };
					queue.add(nextLoc);
					visit[nr][nc] = true;
				}
			}
		}
	}

}
