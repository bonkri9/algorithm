import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] email = str.toCharArray();
		int N = email.length;
		int r = 0;
		int c = 0;
		int maxi = 0;
		for (int i = 1; i < N + 1; i++) {

			if (N % i == 0) {
				int j = N / i;
				if (i <= j && maxi < i) {
					maxi = i;
					r = maxi;
					c = j;
				}
			}
		}

		char[][] pwd = new char[r][c];
		int k = 0;
		while (k < email.length) {
			for (int j = 0; j < c; j++) {
				for (int i = 0; i < r; i++) {
					pwd[i][j] = email[k];
					k++;
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(pwd[i][j]);
			}
		}
	}

}