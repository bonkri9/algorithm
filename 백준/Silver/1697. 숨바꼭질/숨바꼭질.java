import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, nr;
	static int[] visit = new int[100001];
	static int[] dr = { -1, 0, 1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
		K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치

		if (N == K) { // 같이 있다면
			sb.append(0); // 0 출력
		} else {
			BFS(N); // 떨어져있다면 너비우선탐색 시작
		}

		br.close();
		bw.append(sb); // 답 출력
		bw.flush();
		bw.close();
	}

	public static void BFS(int idx) { // 수빈이의 위치를 담은 idx
		Queue<Integer> queue = new LinkedList<>(); // 큐 생성
		queue.add(idx); // 현재 위치 큐에 담기
		visit[idx] = 1; // 현재 방문 위치 시간이 1

		while (!queue.isEmpty()) { // 큐가 빌 때까지 반복문 실행
			int tmp = queue.poll(); // 현재 위치를 tmp에 저장

			for (int i = 0; i < 3; i++) { // 델타의 길이가 3
				int nr; // 다음 위치 nr

				if (i == 1) { // dr[1] = 0 일때는
					nr = tmp * 2; // 다음위치는 현재 위치의 2배
				} else {
					nr = tmp + dr[i]; // 그게 아니라면 1 더하거나 빼주기
				}

				if (nr == K) { // 동생이 있는 위치에 도착하면
					sb.append(visit[tmp]); // 시간을 저장
					return; // 벗어나오기
				}

				if (nr >= 0 && nr < visit.length && visit[nr] == 0) { // 경계 안에 있고, 다음 위치가 방문하지 않아서 0이라면
					queue.add(nr); // 다음 위치를 저장
					visit[nr] = visit[tmp] + 1; // 다음 위치는 현재위치보다 1초 지난 상황
				}
			}
		}
	}

//	public static boolean rangeCheck() { // 경계 처리
//		return (nr >= 0 && nr < visit.length);
//	}
}