import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum =0;
		for(int i=0;i<9;i++) {
			int M = sc.nextInt();
			sum +=M;
		}
		System.out.println(N-sum);
	}
	
}