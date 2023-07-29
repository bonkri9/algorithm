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

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[6];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (i == 0 || i == 1) {
				arr[i] = 1 - arr[i];
			} else if (i == 5) {
				arr[i] = 8 - arr[i];
			} else {
				arr[i] = 2 - arr[i];
			}
			System.out.print(arr[i]+" ");
		}

	}

}