
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] rank = new int[N];
		int[][] people = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			people[i][0] = weight;
			people[i][1] = height;
		}
		
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for(int j = 0; j < N; j++) {
				if (i == j ) continue;
				
				if(people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
					cnt++;
				}
			}
			
			rank[i] = cnt;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(rank[0]);  
		for (int i = 1; i < N; i++) {
		    sb.append(" ").append(rank[i]);  
		}
		
		System.out.println(sb);
	}

}
