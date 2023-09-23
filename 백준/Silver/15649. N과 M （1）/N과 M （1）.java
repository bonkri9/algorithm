import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static boolean[] visited;
	static int[] result, nums;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N+1];
		visited = new boolean[N+1];
		result = new int[M];
		
		for(int i=1;i<nums.length;i++) {
			nums[i] = i;
		}
//		System.out.println(Arrays.toString(nums));
		
		perm(0);
		
	}
	
	public static void perm(int idx) {
		if(idx == M) {
//			System.out.println(Arrays.toString(result));
			for(int i=0;i<result.length;i++) {
				System.out.print(result[i]+" ");
			}System.out.println();
			return;
		}
		
		for(int i=1;i<nums.length;i++) {
			if(visited[i]) continue;
			result[idx] = nums[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
	}
}