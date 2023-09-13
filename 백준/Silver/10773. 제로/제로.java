import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			if (M == 0) {
				stack.pop();
			} else {
				stack.add(M);
			}

		}
		int sum = 0;
		int K = stack.size();
		for (int i = 0; i < K; i++) {
			sum += stack.pop();
		}
		bw.write(String.valueOf(sum));
		br.close();
		bw.flush();
		bw.close();
	}
}
