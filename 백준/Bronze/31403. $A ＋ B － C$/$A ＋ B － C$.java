
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strA = br.readLine();
		String strB = br.readLine();
		int a = Integer.parseInt(strA);
		int b = Integer.parseInt(strB);
		int c = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		sb.append(a + b - c).append("\n").append(Integer.parseInt(strA + strB) - c);
		System.out.println(sb);
	}

}
