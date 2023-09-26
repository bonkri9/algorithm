import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map.put(Integer.parseInt(st.nextToken()), 0);
		}

		int M = map.size();
		int[] nums = new int[M];
		int cnt = 0;
		
		for (Integer i : map.keySet()) {
			nums[cnt] = i;
			cnt++;
		}
		
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length;i++) {
			sb.append(nums[i]+" ");
		}
		
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
	}
}
