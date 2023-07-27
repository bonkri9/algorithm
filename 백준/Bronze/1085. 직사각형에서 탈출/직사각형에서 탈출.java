
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int min = 1001;
		int[] arr = new int[] {x,y,w-x,h-y};
		
		for(int i=0;i<4;i++) {
			
			if(min>arr[i]) {
				min = arr[i];
			}
		}System.out.println(min);

	}
}
