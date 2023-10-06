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
	static boolean[] visit;
	static int N, sumOper,ans, max, min;
	static String[] result, operator;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		 nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int multiple = Integer.parseInt(st.nextToken());
		int divide = Integer.parseInt(st.nextToken());
		
		sumOper = plus + minus+multiple+divide;
		operator = new String[sumOper];
		visit = new boolean[sumOper];
		result = new String[sumOper];
		
		for(int i=0;i<plus;i++) {
			operator[i] = "+";
		}
		for(int i=plus;i<minus+plus;i++) {
			operator[i] = "-";
		}
		for(int i=minus+plus;i<minus+plus+multiple;i++) {
			operator[i] = "*";
		}
		for(int i=minus+plus+multiple;i<sumOper;i++) {
			operator[i] = "/";
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		perm(0);
		
		sb.append(max+"\n"+min);
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
		
	}
	
	public static String[] perm(int idx) {
		if(idx==sumOper) {
			ans = nums[0];
			
			for(int i=0;i<N-1;i++) {
				if(result[i].equals("+")) {
					ans += nums[i+1];
				}else if(result[i].equals("-")) {
					ans -= nums[i+1];
				}else if(result[i].equals("*")) {
					ans *= nums[i+1];
				}else if(result[i].equals("/")) {
					ans /= nums[i+1];
				}
			}
			if(max<ans) max=ans;
			if(min>ans) min=ans;
			
			return result;
		}
		for(int i=0;i<sumOper;i++) {
			if(visit[i]) continue;
			
			result[idx] = operator[i];
			visit[i] = true;
			perm(idx+1);
			visit[i] = false;
		}
		return operator;
	}
}
