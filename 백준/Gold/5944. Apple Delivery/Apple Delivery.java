
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
	int index, cost;

	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
	
}

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int V1, V2, from1toV1, from1toV2, fromV1toV2, fromV2toV1;
	static ArrayList<Node>[] graph;
	static int[] dist;
	
	public static void dijkstra(int n, int start) {
		boolean[] check = new boolean[n+1];
		dist = new int[n+1];
		int INF = Integer.MAX_VALUE;
		
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int nowVortex = pq.poll().index;
			
			if(check[nowVortex]) continue;
			check[nowVortex] = true;
			
			for(Node next : graph[nowVortex]) {
				if(dist[next.index] > dist[nowVortex] + next.cost) {
					dist[next.index] = dist[nowVortex] + next.cost;
					pq.offer(new Node(next.index, dist[next.index]));
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
		int E = Integer.parseInt(st.nextToken()); //간선의 수
		int N = Integer.parseInt(st.nextToken()); //정점의 수
		int PB = Integer.parseInt(st.nextToken()); //시작 정점
		V1 = Integer.parseInt(st.nextToken()); //반드시 거쳐야하는 서로 다른 정점1
		V2 = Integer.parseInt(st.nextToken()); //반드시 거쳐야하는 서로 다른 정점2
		
		
		
		graph = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //시작 도시
			int b = Integer.parseInt(st.nextToken()); //도착 도시
			int c = Integer.parseInt(st.nextToken()); //도시 간 가중치
			
			graph[a].add(new Node(b,c));
			graph[b].add(new Node(a,c));
			
		}
		
//		st = new StringTokenizer(br.readLine());
		
		
		dijkstra(N, PB);
		from1toV1 = dist[V1];
		from1toV2 = dist[V2];
		
		dijkstra(N, V1);
		fromV1toV2 = dist[V2];
		
		dijkstra(N, V2);
		fromV2toV1 = dist[V1];
		
		int ans = 0;
		int ans1 =0;
		int ans2 =0;
		
		if(from1toV1 == INF || fromV1toV2 == INF ) {
			ans1 = -1;
		}else {
			ans1 = from1toV1 + fromV1toV2;
		}
		
		if(from1toV2 == INF || fromV2toV1 == INF ) {
			ans2 = -1;
		}else {
			ans2 = from1toV2 + fromV2toV1;
		}
		
//		System.out.println(ans1+" "+ans2);
		
		if(ans1 != -1 && ans2 != -1) {
			ans = Math.min(ans1, ans2);
		}else if(ans1 == -1 && ans2 == -1) {
			ans = -1;
		}else if(ans1 == -1) {
			ans = ans2;
		}else {
			ans = ans1;
		}
		
		
		br.close();
		bw.append(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

}
