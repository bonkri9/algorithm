import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt, nr, nc;
	static String[][] paint;
	static boolean[][] visit;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		paint = new String[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			paint[i] = str.split("");
		}
//		System.out.println(Arrays.deepToString(paint));

		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && paint[i][j].equals("R")) {
					cnt++;
					notRG(i, j);
				}
				if (!visit[i][j] && paint[i][j].equals("G")) {
					cnt++;
					notRG(i, j);
				}
				if (!visit[i][j] && paint[i][j].equals("B")) {
					cnt++;
					notRG(i, j);
				}
			}
		}
		sb.append(cnt + " ");

		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (paint[i][j].equals("G")) {
					paint[i][j] = "R";
				}
			}
		}

		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && paint[i][j].equals("R")) {
					cnt++;
					notRG(i, j);
				}
				if (!visit[i][j] && paint[i][j].equals("B")) {
					cnt++;
					notRG(i, j);
				}
			}
		}
		sb.append(cnt);

		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();

	}

	public static void notRG(int r, int c) {
		visit[r][c] = true;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (range() && !visit[nr][nc] && paint[nr][nc].equals(paint[r][c])) {
				RG(nr, nc);
			}
		}

	}

	public static void RG(int r, int c) {
		visit[r][c] = true;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (range() && !visit[nr][nc] && paint[nr][nc].equals(paint[r][c])) {
				RG(nr, nc);
			}
		}
	}

	public static boolean range() {
		return (nr >= 0 && nr < N && nc >= 0 && nc < N);
	} // 경계 확인
}