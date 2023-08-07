import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int[] arr = new int[26];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			int tmp = str.charAt(i) - 'a';

			if (arr[tmp] == -1) {
				arr[tmp] = i;
			}

		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
