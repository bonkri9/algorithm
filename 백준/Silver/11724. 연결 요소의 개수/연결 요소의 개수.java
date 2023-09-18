import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static List<Integer>[] adjList;
	static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();            //정점의 개수
		int M = sc.nextInt();            //간선의 개수

		visited = new boolean[N + 1];          //방명록 제작
		adjList = new ArrayList[N + 1];        //인접리스트 생성

		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<Integer>();  //인접리스트 디폴트 값인 null없애려고 숫자 인덱스 부여해
		}

		for (int i = 0; i < M; i++) {    //노드들 입력받아 
			int u = sc.nextInt();
			int v = sc.nextInt();

			adjList[u].add(v);          //무향 이니까 역지사지해서 둘 다 넣어줘
			adjList[v].add(u);
		}

		cnt = 0;                       //연결 요소의 개수가 곧 DFS 돌린 횟수야
		for (int i = 1; i < N+1; i++) {
			if(!visited[i]) {            //안들렸던 곳이라 false면 DFS 돌리자
				cnt++;
				DFS(i);
			}
		}

		System.out.println(cnt);
	}// main

	public static void DFS(int v) {  //깊이우선탐색 
		if (visited[v]) {          //만약 visited가 들렸던 곳이라 true라면 그만해~
			return;
		}

		visited[v] = true;        //일단 visited했으니까 디폴트값인 false값을 true로 돌려~
		for (int i : adjList[v]) {  
			if (!visited[i]) {    //만약 visited가 안들렸던 곳이라 false면 DFS재귀 계속 돌려돌려
				DFS(i);
			}
		}
	}
}
