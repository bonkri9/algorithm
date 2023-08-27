import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] time = new int[N];
		
		for(int i=0;i<N;i++) {
			time[i] = sc.nextInt();
		}
		
		int sum =0;
		Arrays.sort(time);
		for(int i=0;i<N;i++) {
			int T = (N-i)*time[i];
			sum += T;
		}
		
		System.out.println(sum);
	}
}