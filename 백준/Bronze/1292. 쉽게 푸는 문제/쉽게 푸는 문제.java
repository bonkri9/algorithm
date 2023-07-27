import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int[] arr = new int[1001];
		int count = 1;
		
		for(int i =1; i<=1000 ;i++) {
			for(int j=0;j<i;j++) {
				if(count==1001) {
					break;
				}
				arr[count] = i;
				count++;
			}
		}
		int sum = 0;
		for(int k=start; k<=end;k++) {
			sum += arr[k];
		}System.out.println(sum);
	}
}
