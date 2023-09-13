import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<ArrayList<Integer>> nearList = new ArrayList<>();
	static boolean[] node;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		node = new boolean[N+1];
		for(int i = 0; i<=N; i++) {
			nearList.add(new ArrayList<>());
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			nearList.get(x).add(y);
			nearList.get(y).add(x);
		}
		
		int count = 0;
		for(int i = 1; i<=N; i++) {
			if(!node[i]) {
				BFS(i);
				count++;
			}
		}

		System.out.println(count);
	}
	
	static void BFS(int value) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(value);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			int size = nearList.get(num).size();
			
			for(int i = 0; i<size; i++) {
				int newVal = nearList.get(num).get(i);
				
				if(!node[newVal]) {
					q.offer(newVal);
					node[newVal] = true;
				}
			}
		}
	}
}
