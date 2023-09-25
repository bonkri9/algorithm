import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] degree, height;
	static boolean[] visited;
	static Stack<Integer> stack;
	static List<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		// 위상정렬 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 총 학생 수
		M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수

		// 인접행렬 생성
//		adjArr = new int[N + 1][N + 1]; // 문제에서 1번 정점부터 시작해서 V번까지 가므로 V아닌 V+1
		degree = new int[N + 1]; // 진입차수 저장 배열
		visited = new boolean[N + 1];
		adjList = new ArrayList[N + 1];
		height = new int[N + 1];

		stack = new Stack<>(); // 스택 새로 생성
		for (int i = 1; i < N + 1; i++) {
			height[i] = i;
		}

		for (int i = 0; i < N + 1; i++) { // 리스트 초기화
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) { // 비교횟수에 따른 반복문 실행
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 앞에 서는 학생
			int B = Integer.parseInt(st.nextToken()); // 뒤에 서는 학생

			// 유향그래프이므로 A->B로만 저장하면 된다.
			adjList[A].add(B);

			// 진입차수를 증가
			degree[B]++; // 진입이라서 A->B 방향이므로 B를 증가시킨다.
		} // 입력 끝

		// 작업이 들어갈 큐 준비 (degree가 0인 친구들만 들어갈 수 있음)
		Queue<Integer> queue = new LinkedList<>();

		// 반복문 돌면서 제일 처음 degree가 0인 정점을 queue삽입
		// 초기에 진입차수가 0인 (재료구매, 양념장, 밥하기 같은 선작업이 없는 정점을 모두 넣는다
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) { // degree의 i번째 진입차수가 0이라면
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) { // queue가 빌 때까지 반복문 실행
			int work = queue.poll(); // 현재 할 수 있는 작업 하나를 꺼낸다.

			sb.append(work).append(" "); // 뽑혀져 나온 것을 sb에 쌓아올린다.

			for (int i = 0; i < adjList[work].size(); i++) { // 리스트만큼 반복 실행
				int next = adjList[work].get(i); // 리스트가 가진 뒤에 서는 학생을 next에 넣고
				degree[next]--; // 뒤에 서는 학생과 연결된 진입차수를 줄인다
				if (degree[next] == 0) { // 진입차수가 0이 된다면
					queue.add(next); // 큐에 추가시킨다.
				}
			}
		}

		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();

	}

}
