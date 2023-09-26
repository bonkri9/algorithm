import java.util.Scanner;

public class Main {
	static long n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(fibo(sc.nextLong()));
	}

	public static long[] memo = new long[100];
	static {
		memo[0] = 0;
		memo[1] = 1;
	}

	public static long fibo(long n) {
		if (n >= 2 && memo[(int) n] == 0) {
			memo[(int) n] = fibo(n - 1) + fibo(n - 2);
		}

		return memo[(int) n];
	}
}