
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
		
		int N = Integer.parseInt(br.readLine()); //도시의 수
		int M = Integer.parseInt(br.readLine()); //버스의 수
		
		graph = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //출발 도시
			int b = Integer.parseInt(st.nextToken()); //도착 도시
			int c = Integer.parseInt(st.nextToken()); //버스 비용 
			
			graph[a].add(new Node(b,c));
			
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); //출발지
		int end = Integer.parseInt(st.nextToken()); //도착지
		
		int busFee =0;
		dijkstra(N, start);
		busFee = dist[end];
		
		br.close();
		bw.append(String.valueOf(busFee));
		bw.flush();
		bw.close();
	}

}
