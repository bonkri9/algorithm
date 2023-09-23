import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int[] sel, nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N+1];
		sel = new int[M];
		for(int i=1;i<nums.length;i++) {
			nums[i] = i;
		}
//		System.out.println(Arrays.toString(nums));
		
		combi(0,0);
	}
	
	public static void combi(int idx, int sidx) {
		//기저
		if(sidx == M) {
			for(int i=0;i<sel.length;i++) {
				System.out.print(sel[i]+" ");
			}System.out.println();
			return;
		}
		if(idx == N) return;
		
		//재귀
		sel[sidx] = nums[idx+1];
		combi(idx+1,sidx+1);
		combi(idx+1,sidx);
	}
}