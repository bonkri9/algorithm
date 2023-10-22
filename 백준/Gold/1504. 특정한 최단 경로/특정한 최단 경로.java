
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{ //노드를 생성한다
	int index, cost; //도착 예정 정점과 가중치

	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) { //가중치에 따른 비교 정렬
		return Integer.compare(this.cost, o.cost);
	}
	
}

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int V1, V2, from1toV1, from1toV2, fromV1toV2, fromV2toV1, fromV1toN, fromV2toN;
	static ArrayList<Node>[] graph;
	static int[] dist;
	
	public static void dijkstra(int n, int start) { //다익스트라(정점의 수, 시작정점)
		boolean[] check = new boolean[n+1]; //방문배열
		dist = new int[n+1]; //최단거리 배열
		int INF = Integer.MAX_VALUE; //정수 중 가장 큰 수
		
		Arrays.fill(dist, INF); //INF를 최단거리 배열에 모두 대입
		dist[start] = 0; //시작 정점 인덱스는 시작 정점부터 시작 정점까지의 최단거리 이므로 0
		
		PriorityQueue<Node> pq = new PriorityQueue<>(); //우선순위 큐 이용
		pq.offer(new Node(start, 0)); //시작정점, 가중치0을 노드로 생성해서 큐에 삽입
		
		while(!pq.isEmpty()) { //큐가 빌때까지 반복문 실행
			int nowVortex = pq.poll().index; //현재 위치 인덱스를 큐에서 빼내서 저장
			
			if(check[nowVortex]) continue; //현재 위치가 방문한 곳이라면 반복문 패스
			check[nowVortex] = true; //아니라면 방문 처리
			
			for(Node next : graph[nowVortex]) { //정점과 가중치 정보가 있는 graph배열에서 현재위치에 대한 정보를 모두 조회 반복
				if(dist[next.index] > dist[nowVortex] + next.cost) { //다음 위치의 최단거리가 (현재위치의 최단거리+다음위치의 가중치)보다 크다면, 
					dist[next.index] = dist[nowVortex] + next.cost; //더 작은 값으로 갱신
					pq.offer(new Node(next.index, dist[next.index])); //갱신 후 다음위치의 도착정점과 최단거리를 큐에 삽입
				}
			}
		}
//		System.out.println(Arrays.toString(dist));
		
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점의 수
		int E = Integer.parseInt(st.nextToken()); //간선의 수
		
		
		graph = new ArrayList[N+1]; //간선과 정점에 대한 정보가 들어갈 배열 생성 및 초기화
		for(int i=0;i<N+1;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //출발 정점
			int b = Integer.parseInt(st.nextToken()); //도착 정점
			int c = Integer.parseInt(st.nextToken()); //가중치
			
			graph[a].add(new Node(b,c)); //무향 그래프 이므로 a,b를 바꿔서 둘 다 삽입 해준다. 
			graph[b].add(new Node(a,c));
			
		}
		
		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken()); //반드시 거쳐야하는 서로 다른 정점1
		V2 = Integer.parseInt(st.nextToken()); //반드시 거쳐야하는 서로 다른 정점2
		
		
		dijkstra(N, 1); //시작 정점이 1일 때 다익스트라 진행
		from1toV1 = dist[V1]; //1->V1 최단거리
		from1toV2 = dist[V2]; //1->V2 최단거리
		
		dijkstra(N, V1); //시작 정점이 V1일 때 다익스트라 진행
		fromV1toV2 = dist[V2]; //V1->V2 최단거리
		fromV1toN = dist[N]; //V1->N 최단거리
		
		dijkstra(N, V2); //시작 정점이 V2일 때 다익스트라 진행
		fromV2toV1 = dist[V1]; //V2->V1 최단거리
		fromV2toN = dist[N]; //V2->N 최단거리
		
		int ans = 0; //최종답
		int ans1 =0; //1->V1->V2->N인 경우 최단거리
		int ans2 =0; //1->V2->V1->N인 경우 최단거리
		
		if(from1toV1 == INF || fromV1toV2 == INF || fromV2toN == INF) { //세 값 중 하나라도 연결이 되어있지 않아서 INF그대로 나오면
			ans1 = -1; //경로가 없으므로 -1 대입
		}else {
			ans1 = from1toV1 + fromV1toV2 + fromV2toN; //그게 아니라면 세 값을 더하기
		}
		
		if(from1toV2 == INF || fromV2toV1 == INF || fromV1toN == INF) { //세 값 중 하나라도 연결이 되어있지 않아서 INF그대로 나오면
			ans2 = -1;  //경로가 없으므로 -1 대입
		}else {
			ans2 = from1toV2 + fromV2toV1 + fromV1toN; //그게 아니라면 세 값을 더하기
		}
		
		if(ans1 != -1 && ans2 != -1) { //둘다 경로가 있으면
			ans = Math.min(ans1, ans2); //더 작은 값으로 최종답에 대입
		}else if(ans1 == -1 && ans2 == -1) { //둘다 경로가 없으면
			ans = -1; //정답은 -1
		}else if(ans1 == -1) { //ans1가 경로 없다면
			ans = ans2; //ans2가 최종답
		}else {
			ans = ans1;  //그게 아니라면 ans1가 최종답
		}
		
		
		br.close();
		bw.append(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

}
