
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		if(A==B&&B==C&&A+B+C==180) {
			System.out.println("Equilateral");
		}else if(A+B+C!=180) {
			System.out.println("Error");
		}else if(A+B+C==180&&A!=B&&B!=C&&C!=A) {
			System.out.println("Scalene");
		}else {
			System.out.println("Isosceles");
		}
		
	}
}
