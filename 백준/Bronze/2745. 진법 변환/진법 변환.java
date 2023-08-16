import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String N = sc.next();
		int B = sc.nextInt();

		int ten = 0;
		for (int i = 0; i < N.length(); i++) {
			if (N.charAt(i) >= '0' && N.charAt(i) <= '9') {
				ten += Math.pow(B, N.length()-i-1) * (N.charAt(i)-'0');
			} else {
				ten += Math.pow(B, N.length()-i-1) * (N.charAt(i) - 'A' + 10);
			}

		}
		System.out.println(ten);

	}
}