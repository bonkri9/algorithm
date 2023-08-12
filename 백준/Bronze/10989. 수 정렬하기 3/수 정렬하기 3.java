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
		String str = br.readLine();
		int T = Integer.parseInt(str);
		int[] nums = new int[T];
		for (int i = 0; i < T; i++) {
			String num = br.readLine();
			StringTokenizer st = new StringTokenizer(num);
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		for (int i = 0; i < T; i++) {
			bw.write(String.valueOf(nums[i]) + "\n");
		}
		bw.flush();
		bw.close();
	}

}