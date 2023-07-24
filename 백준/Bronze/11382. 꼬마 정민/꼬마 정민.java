import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger sum = new BigInteger("0");
		BigInteger num = new BigInteger("0");
		
		for(int i=0; i<3; i++) {
			num = sc.nextBigInteger();
			sum = sum.add(num);
		}System.out.println(sum);
	}
}
