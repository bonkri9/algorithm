import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{ //노드 생성
	int index, cost; //도착 정점, 가중치

	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) { //비교 정렬
		return Integer.compare(this.cost, o.cost);
	}
	
}

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] graph;
	static int[] dist;
	
	public static void dijkstra(int n, int start) { //다익스트라(정점의 수 , 시작 정점)
		boolean[] check = new boolean[n+1]; //방문 배열 생성
		dist = new int[n+1]; //최단거리 저장 배열 생성
		int INF = Integer.MAX_VALUE; //정수 중 가장 큰 수
		
		Arrays.fill(dist, INF); //최단거리 배열에 INF 모두 삽입
		dist[start] = 0; //시작정점의 최단거리는 시작정점부터 시작정점까지의 최단거리이므로 0
		
		PriorityQueue<Node> pq = new PriorityQueue<>(); //우선순위 큐 활용
		pq.offer(new Node(start, 0)); //큐에 (시작정점, 가중치0)인 노드를 삽입
		
		while(!pq.isEmpty()) { //큐가 빌 때까지 반복문 실행
			int nowVortex = pq.poll().index; //현재 위치를 nowVortex에 저장
			
			if(check[nowVortex]) continue; //현재 위치가 이미 방문한 상태면 반복문 패스
			check[nowVortex] = true; //방문 안햇으면 방문처리
			
			for(Node next : graph[nowVortex]) { //도착정점과 가중치 정보가 노드로 존재하는 graph배열에 현재 위치에 대한 정보를 조회 
				if(dist[next.index] > dist[nowVortex] + next.cost) { //다음 위치의 최단거리가 (현재위치의 최단거리+다음위치의 가중치)보다 크다면
					dist[next.index] = dist[nowVortex] + next.cost; //더 작은 값으로 갱신
					pq.offer(new Node(next.index, dist[next.index])); //큐에 다음 위치와 갱신된 다음위치까지의 최단거리 삽입
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
		int N = Integer.parseInt(st.nextToken()); //마을, 정점의 수
		int M = Integer.parseInt(st.nextToken()); //도로, 간선의 수
		int X = Integer.parseInt(st.nextToken()); //파티를 하는 마을
		
		graph = new ArrayList[N+1]; //간선과 정점의 정보가 담길 배열 생성 및 초기화 
		for(int i=0;i<N+1;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //시작 마을
			int b = Integer.parseInt(st.nextToken()); //도착 마을
			int c = Integer.parseInt(st.nextToken()); //마을 간 소요 시간 , 가중치
			
			graph[a].add(new Node(b,c)); //단방향 도로이므로 이 한 줄만 작성해서 도착 마을과 소요시간 저장
			
		}
		
		int goToParty =0; //파티에 가는 시간
		int comeBackHome =0; //집에 돌아가는 시간
		int total =0; //총 걸리는 시간
		int ans = 0; //최종 답
		
		for(int i=1;i<N+1;i++) { //학생 수만큼 반복문 실행
			if(i==X) continue; //집->파티, 파티->집 시간을 따로 구할 것이므로 집->집 경로를 피하기 위해 출발 마을과 도착 마을이 같은 경우면 반복문 패스
			total =0; //총 시간 0으로 초기화
			dijkstra(N, i); //출발 마을이 i일때 다익스트라 진행
			goToParty = dist[X]; //파티하는 마을까지의 최단경로 저장
			dijkstra(N, X); //출발 마을이 파티하는 마을로 다익스트라 진행
			comeBackHome = dist[i]; //집에 다시 돌아와야 하므로 해당 학생 마을이 도착 마을까지의 최단 경로 저장 
			
			total = goToParty + comeBackHome; //두 시간을 더한게 총 소요 시간
		 	
			ans = Math.max(ans, total); //최종 답에는 소요시간이 가장 큰 값이 들어가게 한다. 
			
		}
		
		br.close();
		bw.append(String.valueOf(ans)); //최종답 출력
		bw.flush();
		bw.close();
	}

}