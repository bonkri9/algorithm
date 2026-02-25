
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			boolean isValid = true;
			
			for(char c : s.toCharArray()) {
				if(c == '(') {
					stack.push(c);
				} else {
					if(stack.isEmpty()) {
						isValid = false;
						break;
					}
					stack.pop();
				}
			}
			
			if(!stack.isEmpty()) isValid = false;
			
			System.out.println((isValid) ? "YES" : "NO");
		}
	}

}
