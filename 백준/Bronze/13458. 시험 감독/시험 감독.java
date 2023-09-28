import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long ans = N;
		for (int i = 0; i < N; i++) {
			if (arr[i] - B <= 0) {
				continue;
			}
			ans += (arr[i] - B) / C;
			if ((arr[i] - B) % C != 0) {
				ans += 1;
			}
		}
		System.out.println(ans);
	}
}