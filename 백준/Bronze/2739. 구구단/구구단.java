import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int i;
		for(i=1; i<=9; i++) {
			System.out.print(a);
			System.out.print(" * ");
			System.out.print(i);
			System.out.print(" = ");
			System.out.println(a*i);
			
		}
	}
}
