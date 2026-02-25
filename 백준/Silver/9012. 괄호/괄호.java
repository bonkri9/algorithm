
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			
			int cnt = 0;
			boolean isValid = true;
			
			for (char c : s.toCharArray()) {
				if (c == '(') cnt++;
				else cnt--;
				
				if (cnt < 0) {
					isValid = false;
					break;
				}
			}
			
			if (cnt != 0) isValid = false;
			
			System.out.println((isValid) ? "YES" : "NO");
		}
	}

}
