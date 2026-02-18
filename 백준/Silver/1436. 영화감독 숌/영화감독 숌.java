
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int num = 666;
		int cnt = 0;
		int ans = 0;
		while (cnt < N) {
			String str = String.valueOf(num);
			
			if (str.contains("666")) {
				cnt++;
				ans = num;
			}
			num++;
		}
		
		System.out.println(ans);
		
	}

}
