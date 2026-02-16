import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		
		for(int i = 0; i < 3; i++) {
			String tmp = br.readLine();
			if(!(tmp.equals("Fizz") || tmp.equals("Buzz") || tmp.equals("FizzBuzz"))) {
				ans = Integer.parseInt(tmp) + (3 - i);
				break;
			}
		}
		
		if (ans % 15 == 0) {
			System.out.println("FizzBuzz");
		} else if (ans % 3 == 0) {
			System.out.println("Fizz");
		} else if (ans % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(ans);
		}
		
	}

}
