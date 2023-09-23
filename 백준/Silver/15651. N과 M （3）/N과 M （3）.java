import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] nums,result;
	static boolean[] sel;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N+1];
		result = new int[M];
		sel = new boolean[N+1];
		
		for(int i=1;i<N+1;i++) {
			nums[i] = i;
		}
//		System.out.println(Arrays.toString(nums));
		powerset(0);
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
		
		
	}//main
	
	public static void powerset(int idx) {
		//기저
		if(idx==M) {
			for(int i=0;i<result.length;i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//재귀
		for(int i=1;i<nums.length;i++) {
			result[idx] = nums[i];
			powerset(idx+1);
		}
	}
}