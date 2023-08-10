import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		
		long M = 12*N-3;
		double sqrt = Math.sqrt(M);
		
		double beeDou = (3+sqrt)/6;
		long beeInt = (long) ((3+sqrt)/6);
		
		
		if(beeDou-beeInt!=0) {
			System.out.println(beeInt+1);
		}else {
			System.out.println(beeInt);
		}
	}

}
