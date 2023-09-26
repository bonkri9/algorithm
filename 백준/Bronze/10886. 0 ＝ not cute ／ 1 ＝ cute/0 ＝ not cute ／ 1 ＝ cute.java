import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] vote = new int[2];
		
		for(int i=0;i<N;i++) {
			int M = sc.nextInt();
			if(M ==0) {
				vote[0]++;
			}else {
				vote[1]++;
			}
		}
		
		if(vote[0] > vote[1]) {
			System.out.println("Junhee is not cute!");
		}else {
			System.out.println("Junhee is cute!");
		}
	}
}
