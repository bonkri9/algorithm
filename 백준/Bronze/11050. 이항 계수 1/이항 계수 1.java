
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int a = 1, b = 1;
		
		for(int i = 0; i < K; i++) {
			a *= N;
			N--;
		}
		
		for(int i = 1; i <= K; i++) {
			b *= i;
		}
		
		System.out.println(a / b);
		
	}

}
