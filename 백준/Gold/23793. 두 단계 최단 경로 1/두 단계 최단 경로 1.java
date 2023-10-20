
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
	static int Y, Z, noY, fromXtoY, fromYtoZ, yesY;
	static ArrayList<Node>[] graph;
	static int[] dist;
	
	public static void dijkstraYesY(int n, int start) {
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
	
	public static void dijkstraNoY(int n, int start) {
		boolean[] check = new boolean[n+1];
		dist = new int[n+1];
		
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int nowVortex = pq.poll().index;
			
			if(nowVortex==Y) continue;
			
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
		int N = Integer.parseInt(st.nextToken()); //정점의 수
		int M = Integer.parseInt(st.nextToken()); //간선의 수
		
		
		graph = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken()); //시작 도시
			int V = Integer.parseInt(st.nextToken()); //도착 도시
			int W = Integer.parseInt(st.nextToken()); //도시 간 가중치
			
			graph[U].add(new Node(V,W));
			
		}
		
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken()); //출발 정점
		Y = Integer.parseInt(st.nextToken()); //중간 정점
		Z = Integer.parseInt(st.nextToken()); //도착 정점
		
		fromXtoY =0;
		fromYtoZ =0;
		noY = 0;
		yesY =0;
		
		dijkstraYesY(N, X);
		fromXtoY = dist[Y];
		dijkstraYesY(N, Y);
		fromYtoZ = dist[Z];
		
		dijkstraNoY(N, X);
		noY += dist[Z];
		
		if(fromXtoY == INF || fromYtoZ == INF) {
			yesY =-1;
		}else {
			yesY = fromXtoY + fromYtoZ;
		}
		
		if(noY == INF) noY =-1;
		
//		System.out.println(yesY+" "+noY);
		sb.append(yesY + " "+ noY);
		
		
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
	}

}
