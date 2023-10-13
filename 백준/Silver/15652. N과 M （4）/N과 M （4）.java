

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
//조합 
public class Main{
	static int N,M;
	static boolean[] visit;
	static int[] res;
	static int[] nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		res = new int[M];
		dfs(1,0);
	}
	
	public static void dfs(int idx, int depth) {
		if(depth==M) {
			for(int i=0;i<M;i++) {
				System.out.print(res[i]+" ");
			}System.out.println();
			return;
		}
		
		for(int i=idx;i<N+1;i++) {
			res[depth] = i;
			dfs(i,depth+1);
		}
	}
}