
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			
			int R = sc.nextInt();
			
			String str = sc.next();
			String[] arr = str.split("");
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<R;k++) {
					System.out.print(arr[j]);
				}
			}
			System.out.println("");
			
			
		}
		
		
	}

}