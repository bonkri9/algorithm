import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();

		if (M >= 45) {
			M = M - 45;
			System.out.println(H + " " + M);
		} else if (M < 45) {
			M = 60 + (M - 45);
			if (H == 0) {
				H = 23;
				System.out.println(H + " " + M);
			} else {
				H = H - 1;
				System.out.println(H + " " + M);
			}
		} else {
			System.out.println("@@");
		}

	}
}