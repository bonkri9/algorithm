import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		
		if(X>R) {
			System.out.println(R);
		}else if(L>X) {
			System.out.println(L);
		}else {
			System.out.println(X);
		}

	}

}
