import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static int[][] adjArr;
	static boolean[] visited;

	static Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐 생성
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점 번호

		adjArr = new int[N + 1][N + 1]; // 정점이 1번부터 시작하므로 N이 아닌 N+1 크기로 생성
		visited = new boolean[N + 1]; // 방문배열 생성

		for (int i = 0; i < M; i++) { // 간선 수 만큼 반복 실행
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 시작 정점
			int B = Integer.parseInt(st.nextToken()); // 끝 정점

			adjArr[A][B] = adjArr[B][A] = 1; // 무향 그래프라서 역지사지
		}

		DFS(V); // 깊이 우선 탐색 실행

		sb.append("\n"); // 엔터치고
		visited = new boolean[N + 1]; // 방문 배열 초기화

		BFS(V); // 너비 우선 탐색 실행

		System.out.println(sb); // 출력

	}

	public static void DFS(int v) { // 깊이 우선 탐색

		visited[v] = true; // 방문 표시

		sb.append(v + " "); // 방문한 곳 출력

		for (int i = 0; i <= N; i++) { // 정점 수 만큼 반복 실행
			if (adjArr[v][i] == 1 && !visited[i]) // 간선이 연결되어있고, 방문하지 않은 곳이라면
				DFS(i); // 재귀
		}

	}

	public static void BFS(int v) { // 너비우선탐색
		queue.add(v); // 큐에 일단 넣고

		visited[v] = true; // 방문 표시

		while (!queue.isEmpty()) { // 큐기 빌 때까지 반복 실행
			v = queue.poll(); // 큐에 넣은거 뽑아내
			sb.append(v + " "); // 방문한 곳 출력

			for (int i = 1; i <= N; i++) { // 정점 수만큼 반복 실행
				if (adjArr[v][i] == 1 && !visited[i]) { // 연결되어있고, 방문하지 않은 곳이라면
					queue.add(i); // 큐에 넣어
					visited[i] = true; // 방문표시
				}
			}
		}

	}

}