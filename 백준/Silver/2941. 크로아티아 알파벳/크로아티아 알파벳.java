import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			arr[str.length() - i - 1] = str.charAt(i);
		}
//		System.out.println(Arrays.toString(arr));
		int cnt = 0;
		out: for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				break out;
			} else if (arr[i] == '-') {
				if (i < arr.length - 1 && arr[i + 1] == 'c') {
					cnt++;
					i++;
					continue;
				} else if (i < arr.length - 1 && arr[i + 1] == 'd') {
					cnt++;
					i++;
					continue;
				} else {
					cnt++;
				}
			} else if (arr[i] == '=') {
				if (i < arr.length - 1 && arr[i + 1] == 'z') {
					if (i < arr.length - 2 && arr[i + 2] == 'd') {
						cnt++;
						i += 2;
						continue;
					} else {
						cnt++;
						i++;
						continue;
					}
				} else if (i < arr.length - 1 && arr[i + 1] == 'c') {
					cnt++;
					i++;
					continue;
				} else if (i < arr.length - 1 && arr[i + 1] == 's') {
					cnt++;
					i++;
					continue;
				} else {
					cnt++;
				}

			} else if (arr[i] == 'j') {
				if (i < arr.length - 1 && arr[i + 1] == 'l') {
					cnt++;
					i++;
					continue;
				} else if (i < arr.length - 1 && arr[i + 1] == 'n') {
					cnt++;
					i++;
					continue;
				} else {
					cnt++;
				}
			} else {
				cnt++;
			}
//			System.out.println(cnt);
		}
		System.out.println(cnt);
	}// main
}