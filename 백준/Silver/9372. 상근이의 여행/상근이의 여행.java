import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	static int[][] flight;
	static int N, M, minFlight;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			minFlight = 0;     //최소 비행 수 초기화
			N = sc.nextInt(); // 국가의 수 = 정점 개수
			M = sc.nextInt(); // 비행기의 수 = 간선의 수

			visited = new boolean[N + 1];  //방문배열 선언
			flight = new int[N + 1][N + 1]; //비행 가능 유무 배열 선언

			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();  //시작 국가
				int B = sc.nextInt();  // 끝 국가

				flight[A][B] = flight[B][A] = 1;  //두 국가가 연결되어있다면 1 대입

			}
			BFS(1);
			System.out.println(minFlight-1);

		} // tc

	}// main

	static void BFS(int v) {   //BFS는 최소 거리를 구할 때 주로 사용
		queue.add(v);

		visited[v] = true;     //방문했다고 표시

		while (!queue.isEmpty()) {  //큐가 비어있을 때까지 반복하자 
			minFlight++;            //최소 비행기 ++
			int t = queue.poll();   //큐 맨 앞에 있는걸 내보내고 저장

			for (int i = 1; i < N + 1; i++) {
				if (!visited[i] && flight[t][i] == 1) { //방문하지 않았고, 연결되었다면 
					queue.add(i);                       //시작 국가 큐에 추가
					visited[i] = true;                  //방문했다고 표시
				}
			}
		}
	}

}