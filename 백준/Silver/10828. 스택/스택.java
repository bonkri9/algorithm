import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<>();
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < N; tc++) {
			String menu = sc.next();
			if (menu.equals("push")) {
				String M = sc.next();
				stack.push(M);
			} else if (menu.equals("pop")) {
				if (!stack.isEmpty()) {
					sb.append(stack.peek()).append("\n");
					stack.pop();
				} else {
					sb.append("-1").append("\n");
				}

			} else if (menu.equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if (menu.equals("empty")) {
				if (stack.isEmpty()) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
			} else if (menu.equals("top")) {
				if (!stack.isEmpty()) {
					sb.append(stack.peek()).append("\n");
				} else {
					sb.append("-1").append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}