import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			
			String str = sc.next();
			
			String[] arr = str.split("");
			
			System.out.println(arr[0]+arr[arr.length-1]);
			
			
			
			
		}
	}

}
