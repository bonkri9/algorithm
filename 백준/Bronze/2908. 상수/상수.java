import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int reverse1 = 0;
		int reverse2 = 0;
		int namuji1 = 0;
		int namuji2 = 0;
		
		while(true) {
			if(num1==0) {
				break;
			}
			namuji1 = num1 % 10;
			reverse1 = reverse1 * 10 + namuji1;
			num1 = num1 / 10;
		}
		
		while(true) {
			if(num2==0) {
				break;
			}
			namuji2 = num2 % 10;
			reverse2 = reverse2 * 10 + namuji2;
			num2 = num2 / 10;
		}
		
		if(reverse1>reverse2) {
			System.out.println(reverse1);
		}else System.out.println(reverse2);
	}
}