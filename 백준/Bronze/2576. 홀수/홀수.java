import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] oddNum = new int[7];

		for (int i = 0; i < 7; i++) {
			int N = Integer.parseInt(br.readLine());
			if (N % 2 == 1) {
				oddNum[i] = N;
			}
		}
		int sum = 0;
		int min = 100;
		for (int i = 0; i < 7; i++) {
			sum += oddNum[i];
			if (oddNum[i] != 0) {
				min = Math.min(min, oddNum[i]);
			}
		}
		if (min == 100) {
			sb.append(-1);
		} else {
			sb.append(sum + "\n" + min);
		}

		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();

	}
}