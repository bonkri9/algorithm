import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<>();
		StringTokenizer st;
		
		int N = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			st = new StringTokenizer(str);
			
			while (st.hasMoreTokens()) {
				stack.add(st.nextToken());
			}
			System.out.print("Case #" + (i + 1) + ": ");
			
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
		}
	}
}
