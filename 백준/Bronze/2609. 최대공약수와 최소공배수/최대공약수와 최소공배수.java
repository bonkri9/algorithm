import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int multi = A*B;
		
		while(B !=0) {
			int temp = A%B;
			A = B;
			B = temp;
		}
		int gcd = A;
		System.out.println(gcd);
		System.out.println(multi/gcd);
		
	}

}