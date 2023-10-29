import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] nums, res;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개의 자연수
		M = Integer.parseInt(st.nextToken()); // 길이가 M인 수열 출력

		nums = new int[N]; // N개의 숫자가 들어갈 배열
		res = new int[N]; // 결과 배열
		visit = new boolean[N]; // 방문 배열

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); // N개의 숫자를 배열에 저장
		}

		Arrays.sort(nums); // 정렬

		DFS(0, 0); // 깊이 우선 탐색 실행

		br.close();
		bw.append(sb); // 결과 출력
		bw.flush();
		bw.close();
	}

	static void DFS(int idx, int depth) {
		// 한번 앞에 온 숫자를 못 오게 하기 위한 장치로 idx(idx번째 이후 숫자부터 나오게만든다)
		// 뽑은 숫자의 갯수(몇번째 숫자를 뽑을건지) depth
		if (depth == M) { // 전부 뽑았다면
			for (int i = 0; i < M; i++) {
				sb.append(res[i] + " "); // 결과 배열에 넣은 숫자 출력
			}
			sb.append("\n"); // 한줄 엔터
			return;
		}

		for (int i = idx; i < N; i++) { // idx부터 숫자 실행, N개의 자연수만큼 반복문 실행
			if (!visit[i]) { // 방문하지 않았다면
				visit[i] = true; // 방문처리
				res[depth] = nums[i]; // 결과 배열에 뽑은 숫자를 저장
				DFS(i, depth + 1); // 깊이우선탐색 재귀
				visit[i] = false; // 방문 취소
			}
		}
	}
}