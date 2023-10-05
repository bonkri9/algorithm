import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, nr, nc,cnt;
	static String[][] floor;
	static boolean[][] visit;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		floor = new String[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			floor[i] = str.split("");
		}
		
		cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visit[i][j]) {
					DFS(i,j);
					cnt++;
				}
			}
		}
		br.close();
		bw.append(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int r, int c) {
		visit[r][c] = true;
		if(floor[r][c].equals("-")) {
			for(int i=0;i<2;i++) {
				nr = r+dr[i];
				nc = c+dc[i];
				if(range()&&!visit[nr][nc]&&floor[nr][nc].equals("-")) {
					DFS(nr,nc);
				}
			}
		}
		if(floor[r][c].equals("|")) {
			for(int i=2;i<4;i++) {
				nr = r+dr[i];
				nc = c+dc[i];
				if(range()&&!visit[nr][nc]&&floor[nr][nc].equals("|")) {
					DFS(nr,nc);
				}
			}
		}
	}
	
	public static boolean range() {
		return (nr>=0&&nr<N&&nc>=0&&nc<M);
	}
}