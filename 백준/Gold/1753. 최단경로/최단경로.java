
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> { // 노드 생성
	int index, cost; // 도착 정점과 가중치

	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) { // 비교 정렬
		if(this.cost>o.cost) return 1;
		else return -1;
	}
//	@Override
//	public int compareTo(Node o) { // 비교 정렬
//		return Integer.compare(this.cost, o.cost);
//	}

}

public class Main {
//	static final int INF = Integer.MAX_VALUE; //정수 중 가장 최댓값
	static final int INF = 200001; //정수 중 가장 최댓값
	static ArrayList<Node>[] graph;
	static int[] dist;

	public static void dijkstra(int n, int start) { // 다익스크라(정점개수, 출발정점)
		boolean[] check = new boolean[n + 1]; // 방문배열 생성
		dist = new int[n + 1]; // 최단경로의 경로값이 저장될 배열

		Arrays.fill(dist, INF); // 최단 경로 배열에 가장 큰 값으로 초기화
		dist[start] = 0; // 출발 정점부터 출발 점점까지의 가중치는 0

		PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐 생성
		pq.offer(new Node(start, 0)); // 큐에 (도착정점(출발정점은 이미 다익스크라 시작할때 적어줌), 가중치 0 )을 넣는다

		while (!pq.isEmpty()) { // 큐가 빌 때까지 반복문 실행
			int nowVortex = pq.poll().index; // 현재 위치 인덱스 저장

			if (check[nowVortex]) // 현재 위치가 이미 방문한 곳이라면
				continue; // 반복문 패스
			check[nowVortex] = true; // 방문하지 않았다면 방문처리

			for (Node next : graph[nowVortex]) { // 현재위치가 가진 연결된 도착정점과 가중치에 대한 정보를 훑는다
				// 기존에 저장된 다음 위치의 가중치가 (기존에 저장된 현재위치의 가중치+다음위치까지의 가중치)보다 크다면
				if (dist[next.index] > dist[nowVortex] + next.cost) {
					dist[next.index] = dist[nowVortex] + next.cost; // 더 작은 값으로 갱신
					pq.offer(new Node(next.index, dist[next.index])); // 다음위치에 대한 정보를 큐에 저장
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점의 수
		int E = Integer.parseInt(st.nextToken()); // 간선의 수

		int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

		graph = new ArrayList[V + 1]; // graph[출발정점].Node(도착정점, 가중치)
		for (int i = 0; i < V + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 시작점
			int v = Integer.parseInt(st.nextToken()); // 도착점
			int w = Integer.parseInt(st.nextToken()); // 가중치

			graph[u].add(new Node(v, w)); // 유향 그래프이므로 한줄만 작성

		}

		dijkstra(V, K);
		for (int i = 1; i < V + 1; i++) { // 출발정점은 K이고 K부터 각 도착정점에 대한 최단경로의 가중치 합을 계산
			if (dist[i] == INF) { // 갱신이 되지 않아 INF 값이 그대로 있다면
				sb.append("INF\n"); // INF를 출력하자
			} else {
				sb.append(dist[i] + "\n"); // 그게 아니면 최소 가중치 출력
			}
		}

		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
	}

}
