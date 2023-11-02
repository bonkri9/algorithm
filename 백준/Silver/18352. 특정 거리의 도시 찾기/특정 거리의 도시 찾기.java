
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
		return Integer.compare(this.cost, o.cost);
	}

}

public class Main {
	static final int INF = Integer.MAX_VALUE; // 정수 중 가장 최댓값
	static ArrayList<Node>[] graph;
	static int[] dist;
	static int N, M, K, X;
	static int[] ans;

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
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시 정보

		graph = new ArrayList[N + 1]; // graph[출발정점].Node(도착정점, 가중치)
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 시작점
			int b = Integer.parseInt(st.nextToken()); // 도착점
			int c = 1; // 가중치

			graph[a].add(new Node(b, c)); // 유향 그래프이므로 두 줄 작성

		}

		dijkstra(N, X); // 다익스트라 (정점 갯수, 출발도시)

		ans = new int[N + 1]; // 거리 정보에 맞는 도착 도시의 값이 들어갈 정답 배열
		int idx = 0; // ans의 인덱스
		boolean flag = false; // ans 배열안에 뭔가 들어가면 true로 만들어줄 것

		for (int i = 1; i < dist.length; i++) { // 정점의 갯수만큼 반복문 실행
			if (dist[i] == K) { // 거리 정보에 맞는 가중치 합이라면
				ans[idx] = i; // 도착 도시를 정답 배열에 저장
				flag = true; // 뭔가 들어갔으니 true로 바꿔줌
			}
			idx++; // 인덱스 1추가
		}

		Arrays.sort(ans); // 정답 배열을 오름차순으로 정렬

		if (!flag) { // 안에 아무것도 없으면
			sb.append(-1); // -1 출력
		} else { // 뭔가 있다면
			for (int i = 0; i < ans.length; i++) { // 정답 배열만큼 반복문 실행
				if (ans[i] != 0) { // 0이 아니라면
					sb.append(ans[i] + "\n"); // 도착 도시를 출력
				}
			}
		}

		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
	}

}
