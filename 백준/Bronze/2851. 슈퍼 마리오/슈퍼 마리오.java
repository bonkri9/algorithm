import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tmp = 0;
		int sum = 0;
		
		for(int i=0; i<10; i++) {
			tmp = sc.nextInt();
			sum += tmp;
			
			if (sum >= 100) {
				break;
			}
		}
		
		int bef = sum - tmp;
		
		if ( 100-bef < sum-100 ) {
			sum = bef;
		}
		System.out.println(sum);
	}
}