import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	//MST 문제로 Prim Algorithm을 적용한다
	static final int INF = Integer.MAX_VALUE; //아주 큰 값을 INF에 저장
	
	static class Edge implements Comparable<Edge>{
		int st, ed, w;

		public Edge(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}
		
		//정렬하기 
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());  //정점의 개수
		int E = Integer.parseInt(st.nextToken());  //간선의 개수
		
		List<Edge>[] adjList = new ArrayList[V+1];
		
		for(int i=1;i<V+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {  //간선 개수만큼 반복문 돌린다
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); //시작 정점
			int B = Integer.parseInt(st.nextToken()); //끝 정점
			int C = Integer.parseInt(st.nextToken()); //가중치 
			
			adjList[A].add(new Edge(A,B,C));
			adjList[B].add(new Edge(B,A,C));
		} //입력 끝
		
		boolean[] visited = new boolean[V+1]; //방문배열 생성
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(); //우선순위큐를 활용한다
		
		visited[1] = true; //1번이 뽑혔다고 세팅 
		
		pq.addAll(adjList[1]); //Edge를 pq에 삽입 
		
		int pick = 1; //이미 1번을 뽑았다고 세팅했으므로!
		int ans =0; //정답 ans 초기화
		
		while(pick != V) { //뽑은 개수가 V가 될 때까지 반복
			Edge e = pq.poll(); //pq에서 뽑은걸 Edge e에 저장
			
			if(visited[e.ed]) continue; //만약 방문한 끝 정점이라면 패스
			
			ans += e.w;  //뽑은 간선의 가중치를 누적합
			pq.addAll(adjList[e.ed]); //
			visited[e.ed] = true; //끝정점을 방문했다고 표시
			pick++; //하나 뽑았다고 체크 
		}
		
		br.close();
		bw.append(String.valueOf(ans)); //정답 출력
		bw.flush();
		bw.close();
		
	}
			
}