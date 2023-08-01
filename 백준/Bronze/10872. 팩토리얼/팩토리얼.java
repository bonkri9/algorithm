import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		int multi = 1;
		
		for(int i=1; i<=N; i++) {
			multi = i*multi;
		}
		System.out.println(multi);
		
		
	}	
}