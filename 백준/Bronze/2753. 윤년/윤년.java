
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N % 400 == 0 || (N % 4 == 0 && N % 100 != 0)) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
	}

}
