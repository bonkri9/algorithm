import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> makdaegi = new Stack<>();
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			makdaegi.add(sc.nextInt());
		}
//		System.out.println(makdaegi);
		int height = 0;
		for (int i = 0; i < N; i++) {
			if (height < makdaegi.peek()) {
				height = makdaegi.peek();
			}
			makdaegi.pop();
			if (!makdaegi.isEmpty()) {
				if (makdaegi.peek() > height) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
