
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
			boolean flag = false;
			if(arr[i] < 2) continue;
			
			for(int j=2;j<=Math.sqrt(arr[i]);j++) {
				if(arr[i] % j == 0) {
					flag = true;
					break;
				};
			}
			
			if(!flag) cnt++;
		}
		
		System.out.println(cnt);
	}

}
