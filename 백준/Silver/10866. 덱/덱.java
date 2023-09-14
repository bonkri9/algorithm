import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new LinkedList<Integer>();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String M = st.nextToken();
			if (M.equals("push_front")) {
				int K = Integer.parseInt(st.nextToken());
				deque.addFirst(K);
			} else if (M.equals("push_back")) {
				int K = Integer.parseInt(st.nextToken());
				deque.addLast(K);
			} else if (M.equals("pop_front")) {
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peekFirst()).append("\n");
					deque.pollFirst();
				}
			} else if (M.equals("pop_back")) {
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peekLast()).append("\n");
					deque.pollLast();
				}
			} else if (M.equals("size")) {
				sb.append(deque.size()).append("\n");
			} else if (M.equals("empty")) {
				if (deque.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (M.equals("front")) {
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peekFirst()).append("\n");
				}
			} else if (M.equals("back")) {
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peekLast()).append("\n");
				}
			}
		}
		br.close();
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();

	}
}
