import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		List<Integer>[] adjList = new ArrayList[N + 1];
//		boolean[] visit = new boolean[N+1];
		int[] cnt = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adjList[u].add(v);
			adjList[v].add(u);

		} // 입력 끝

		for (int i = 0; i <N+1 ; i++) {
			Collections.sort(adjList[i]);
		}

//		System.out.println(Arrays.deepToString(adjList));
		Queue<Integer> queue = new LinkedList<>();

		queue.add(R);
//		cnt[R] =1;
		int visit = 1;
		cnt[R] = visit;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int i = 0; i < adjList[curr].size(); i++) {
				int next = adjList[curr].get(i);

				if (cnt[next] != 0) {
					continue;
				}

				queue.add(next);
				visit++;
				cnt[next] = visit;

			}
		}

//		System.out.println(Arrays.toString(cnt));
		for (int i = 1; i < cnt.length; i++) {
			sb.append(cnt[i] + "\n");
		}

		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();

	}
}