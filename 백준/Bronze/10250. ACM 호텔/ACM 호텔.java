
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int floor = N % H;
			if (floor == 0) floor = H;
			
			int room = (N - 1) / H + 1;
			
			sb.append(floor);
			if(room < 10) sb.append('0');
			sb.append(room).append("\n");
		}
		
		System.out.println(sb);
	}

}
