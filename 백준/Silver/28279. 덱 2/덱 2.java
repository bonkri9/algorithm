import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			if (M == 1) {
				deque.addFirst(Integer.parseInt(st.nextToken()));
			} else if (M == 2) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			} else if (M == 3) {
				if (deque.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(deque.peekFirst()).append("\n");
					deque.pollFirst();
				}
			} else if (M == 4) {
				if (deque.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(deque.peekLast()).append("\n");
					deque.pollLast();
				}
			} else if (M == 5) {
				sb.append(deque.size()).append("\n");
			} else if (M == 6) {
				if (deque.isEmpty()) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
			} else if (M == 7) {
				if (deque.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(deque.peekFirst()).append("\n");
				}
			} else if (M == 8) {
				if (deque.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(deque.peekLast()).append("\n");
				}
			}

		}
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();

	}
}