
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<List<String>> buckets = new ArrayList<>();
		for (int i = 0; i <= 200; i++) {
		    buckets.add(new ArrayList<>());
		}
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			buckets.get(age).add(name);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int age = 1;age <=200; age++) {
			for(String name : buckets.get(age)) {
				sb.append(age).append(" ").append(name).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
