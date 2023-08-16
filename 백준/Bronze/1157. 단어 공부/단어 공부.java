import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] alpha = new int[26];
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				alpha[str.charAt(i) - 'A']++;
			} else if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
				alpha[str.charAt(i) - 'a']++;
			}
		}

		int max = -1;
		int maxIdx = -1;
		for (int i = 0; i < alpha.length; i++) {
			if (max < alpha[i]) {
				max = alpha[i];
				maxIdx = i;
			}
		}

		Arrays.sort(alpha);
		if (alpha[25] == alpha[24]) {
			System.out.println("?");
		} else {
			System.out.println((char) (maxIdx + 'A'));
		}

	}
}