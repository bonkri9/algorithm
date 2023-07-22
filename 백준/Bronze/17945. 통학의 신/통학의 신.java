import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int ans1 = (int)(- a - Math.sqrt(a*a-b));
		int ans2 = (int)(- a + Math.sqrt(a*a-b));

		if(ans1 == ans2) {
			System.out.println(ans1);
		}	
		else {
			System.out.println(ans1);
			System.out.println(ans2);
		}
	}
}