
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 좌표 클래스
class point {
	int x;
	int y;

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N; // 도시 크기
	static int M; // 최대 수익 치킨집 수
	static int[][] map; // 도시 정보
	static point[] chicken; // 치킨집 정보 담을 배열
//	static point[] chic; // 치킨집 정보 담을 배열
//	static int min; // 각 집의 치킨거리 최솟값
	static int smin; // 도시의 치킨거리 최솟값
	static boolean[] visited;
	static point[] choice; // 치킨집 조합 넣을 배열
	static int sum; // 도시의 치킨거리 합
	static int c; // 치킨집 수
	static ArrayList<point> house;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 도시의 크기
		M = Integer.parseInt(st.nextToken()); // 최대 수익 치킨집 수

		map = new int[N][N];
		chicken = new point[13]; // 최대 치킨집 수 13개
		c = 0;
		house = new ArrayList<point>();

		// 도시 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chicken[c] = new point(i, j);
					c++;
					map[i][j] = 0; // 추후에 치킨집 다시 세울거임
				}
				if (map[i][j] == 1) {
					house.add(new point(i, j));
				}
			}
		}

		visited = new boolean[c];
		choice = new point[M];
		smin = Integer.MAX_VALUE;

		combi(0, 0);

//		System.out.println(smin);
		bw.write(String.valueOf(smin));
		
		br.close();
		bw.close();

	} // main

	// 치킨집 고르는 함수
	public static void combi(int idx, int sidx) {

		if (sidx == M) {
			sum = 0;
			road();
			smin = Math.min(smin, sum);
			// 치킨거리 구하는 함수
			// 도시의 치킨거리 미니멈
			return;
		}

		for (int i = idx; i <= c - M + sidx; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				choice[sidx] = chicken[i];
				combi(idx + 1, sidx + 1);
				visited[i] = false;
			}
		} // for i
	} // combi

	// 치킨거리 구하기
	public static void road() {

		int[][] copy = new int[N][N];
		copy = map;
		for (int i = 0; i < M; i++) {
			copy[choice[i].x][choice[i].y] = 2; // 선택한 치킨집
		}

		for (int i = 0; i < house.size(); i++) {
			int min = Integer.MAX_VALUE; // 각 집의 치킨거리 최솟값
			for (int k = 0; k < M; k++) {
				int len = Math.abs(house.get(i).x - choice[k].x) + Math.abs(house.get(i).y - choice[k].y);
				min = Math.min(min, len);
			} // k
			sum += min;
		} // i
	} // road

} // class
