
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
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String[] arrStr = str.split("");
			boolean[] alphabet = new boolean[26];
			alphabet[str.charAt(0) - 'a'] = true;

//			System.out.println(Arrays.toString(alphabet));
//			System.out.println(Arrays.toString(arrStr));

			if (str.length() == 1)
				cnt++;

			for (int j = 1; j < str.length(); j++) {
				int idx = str.charAt(j) - 'a';
				if (!alphabet[idx]) {
					alphabet[idx] = true;
				} else if (arrStr[j].equals(arrStr[j - 1])) {
					if (j == str.length() - 1)
						cnt++;
					continue;
				} else if (!(arrStr[j].equals(arrStr[j - 1]))) {
					break;
				}
				if (j == str.length() - 1) {
					cnt++;
				}

//				System.out.println(idx);
//				System.out.println(Arrays.toString(alphabet));

			}

		}
//		System.out.println(cnt);
		br.close();
		bw.append(String.valueOf(cnt));
		bw.flush();
		bw.close();

	}

}
