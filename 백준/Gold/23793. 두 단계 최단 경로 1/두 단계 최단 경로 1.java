
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{ //노드를 정의한다.
	int index, cost;  //index는 도착정점, cost는 가중치

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
	static int Y, Z, noY, fromXtoY, fromYtoZ, yesY;
	static ArrayList<Node>[] graph;
	static int[] dist;
	
	public static void dijkstraYesY(int n, int start) { //Y를 거쳐서 가는 다익스트라
		boolean[] check = new boolean[n+1]; //방문배열 생성
		dist = new int[n+1]; //최단거리를 저장할 배열
		int INF = Integer.MAX_VALUE; //정수 범위 중 최고 숫자
		
		Arrays.fill(dist, INF); //최고숫자를 최단거리 배열에 모두 삽입
		dist[start] = 0; //시작 정점부터 시작 정점까지의 거리는 0 이므로.
		
		PriorityQueue<Node> pq = new PriorityQueue<>(); //우선순위 큐 이용
		pq.offer(new Node(start, 0)); //시작정점과 그때의 거리는 0 이므로 이렇게 노드를 생성해 우선순위 큐에 삽입
		
		while(!pq.isEmpty()) { //큐가 빌 때까지 반복문 실행
			int nowVortex = pq.poll().index; //현재 위치(도착 예정인 정점)는 큐에서 뽑아낸 노드에서의 도착 정점
			
			if(check[nowVortex]) continue; //현재위치가 방문한 위치라면 반복문 패스
			check[nowVortex] = true; //방문하지 않았다면 방문처리
			
			for(Node next : graph[nowVortex]) { //graph배열의 현재위치를 next 노드라고 하고 반복 조회 실행
				if(dist[next.index] > dist[nowVortex] + next.cost) { //다음 위치에서의 최단거리가 현재위치의 최단거리+다음위치의 가중치보다 크다면, 
					dist[next.index] = dist[nowVortex] + next.cost; //값을 더 작은 값으로 갱신
					pq.offer(new Node(next.index, dist[next.index])); //그리고 다음 위치에 대한 정보를 큐에 삽입
				}
			}
		}
		
	}
	
	public static void dijkstraNoY(int n, int start) { //Y를 거치지 않는 다익스트라 진행 , 위와 거의 동일
		boolean[] check = new boolean[n+1];
		dist = new int[n+1];
		
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int nowVortex = pq.poll().index;
			
			if(nowVortex==Y) continue;  //Y를 거치지 않아야하므로 현재위치가 Y라면 반복문 패스
			
			if(check[nowVortex]) continue;
			check[nowVortex] = true;
			
			for(Node next : graph[nowVortex]) {
				if(dist[next.index] > dist[nowVortex] + next.cost) {
					dist[next.index] = dist[nowVortex] + next.cost;
					pq.offer(new Node(next.index, dist[next.index]));
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
		int N = Integer.parseInt(st.nextToken()); //정점의 수
		int M = Integer.parseInt(st.nextToken()); //간선의 수
		
		
		graph = new ArrayList[N+1]; //도착 도시와 가중치가 들어갈 배열 생성 및 초기화
		for(int i=0;i<N+1;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken()); //시작 도시
			int V = Integer.parseInt(st.nextToken()); //도착 도시
			int W = Integer.parseInt(st.nextToken()); //도시 간 가중치
			
			graph[U].add(new Node(V,W)); //시작정점 인덱스에 Node(도착정점, 가중치)를 생성 후 삽입
			
		}
		
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken()); //출발 정점
		Y = Integer.parseInt(st.nextToken()); //중간 정점
		Z = Integer.parseInt(st.nextToken()); //도착 정점
		
		fromXtoY =0; //X->Y 최단거리
		fromYtoZ =0; //Y->Z 최단거리
		noY = 0; //Y를 거치지 않는 최단거리
		yesY =0; //Y를 거치는 최단거리
		
		dijkstraYesY(N, X); //시작 정점을 X로 하고 다익스트라 진행
		fromXtoY = dist[Y]; //X->Y 최단거리
		dijkstraYesY(N, Y); //시작 정점을 Y로 하고 다익스트라 진행
		fromYtoZ = dist[Z]; //Y->Z 최단거리
		
		dijkstraNoY(N, X); //시작정점을 X로 하고 Y를 거치지 않는 다익스트라 진행
		noY = dist[Z]; //Y를 거치지 않는 X->Z의 최단거리
		
		if(fromXtoY == INF || fromYtoZ == INF) { //둘 중 하나라도 연결이 되어있지 않아서 INF가 나온다면
			yesY =-1; //도달할 수 없으므로 -1 대입
		}else {
			yesY = fromXtoY + fromYtoZ; //도달 할 수 있다면 두 최단거리 값을 더해서 대입
		}
		
		if(noY == INF) noY =-1; //INF그대로 나온다면 -1 대입, 아니면 말고
		
		sb.append(yesY + " "+ noY);
		
		br.close();
		bw.append(sb); //출력
		bw.flush();
		bw.close();
	}

}
