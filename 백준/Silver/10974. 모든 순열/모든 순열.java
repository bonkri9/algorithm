import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] visit;
	static int[] nums;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		result = new int[N];
		visit = new boolean[N];
		
		for(int i=0;i<N;i++) {
			nums[i] = i+1;
		}
		
		perm(0);
		
		br.close();
	}
	
	public static void perm(int v) {
		//기저 
		if(v==N) {
			for(int i=0;i<N;i++) {
				System.out.print(result[i]+" ");
			}System.out.println();
			return;
		}
		
		//재귀
		for(int i=0;i<N;i++) {
			if(visit[i]) continue;
			result[v] = nums[i];
			visit[i] = true;
			perm(v+1);
			visit[i] = false;
		}
		
	}
}
