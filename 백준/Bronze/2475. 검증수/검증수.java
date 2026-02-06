
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int sum = 0;
		while (st.hasMoreTokens() ) {
			int a = Integer.parseInt(st.nextToken());
			sum += a * a;
		}
		
		System.out.println(sum % 10);
	}

}
