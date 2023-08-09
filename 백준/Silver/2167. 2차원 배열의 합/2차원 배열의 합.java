import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int K = sc.nextInt();
		int sum =0;
		for(int l=0;l<K;l++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int p = i-1;p<x;p++) {
				for(int q=j-1;q<y;q++) {
					sum += arr[p][q];
				}
			}
			
			System.out.println(sum);
			sum=0;
		}
		
	}
}