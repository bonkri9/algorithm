import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//그래프 16953 A->B
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int cnt = 1;
		while (A != B) {
			if (A > B) {
				cnt = -1;
				break;
			}
			if (B % 10 != 1 && B % 2 == 1) {
				cnt = -1;
				break;
			}

			if (B % 2 == 0) {
				B = B / 2;
			} else {
				B = B/10;
			}
			
			cnt++;

		}

		br.close();
		bw.append(String.valueOf(cnt));
		bw.flush();
		bw.close();

	}

}