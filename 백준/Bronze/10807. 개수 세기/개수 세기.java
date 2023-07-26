
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
			
		}
		int b = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			if(arr[i]==b) {
				count++;
			}
		}
		System.out.println(count);
		
	}	
}