
import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[] primeChecker(int num) {
		boolean[] isPrime = new boolean[num + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for (int i = 0; i * i <= num; i++) {
			if (!isPrime[i]) continue;
			for (int j = i * i; j <= num; j += i) {
				isPrime[j] = false;
			}
		}
		
		return isPrime;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean[] isPrime = primeChecker(1000);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (isPrime[num]) cnt++;
		}
		
		System.out.println(cnt);
	}

}
