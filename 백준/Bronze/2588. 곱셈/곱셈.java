import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int one = B-(B/10)*10;
		int ten = (B/10)-(B/100)*10;
		int hund = B/100;
		
		System.out.println(A*one);
		System.out.println(A*ten);
		System.out.println(A*hund);
		System.out.println(A*B);
	}
}