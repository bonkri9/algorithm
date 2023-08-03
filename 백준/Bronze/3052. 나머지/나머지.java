import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt()%42;
		}
		
		int cnt =0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					arr[j]=-1;
				}
			}
		}
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i] != -1)
				cnt++;
		}System.out.println(cnt);
		
		

	}

}