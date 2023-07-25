
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if ((B + C) >= 60) {
			A = A + ((B + C) / 60);
			B = (B + C) - 60;
			if (B % 60 == 0) {
				B = 0;
			} else {
				B = B - (B/60)*60; 
			}
			
			if (A >= 24) {
				A = A - 24;
			} else {
			}
			
			System.out.println(A + " " + B);
			
		} else {
			B = B + C;
			System.out.println(A + " " + B);
		}
	}
}
