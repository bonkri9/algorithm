import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[6];
		for (int i=0;i<arr.length;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		long T = Long.parseLong(st.nextToken());
		long P = Long.parseLong(st.nextToken());
		
		
		long shirts = 0;
		for (long x : arr) {
			shirts += (x + T - 1) / T;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(shirts).append("\n").append(N / P).append(" ").append(N % P);
		System.out.println(sb);
		
	}

}
