import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		String[] arr1 = str.split("");
		String[] arr2 = arr1.clone();
		
		for(int i=0; i<arr1.length/2;i++) {
			String tmp = arr1[arr1.length-i-1];
			arr1[arr1.length-i-1] = arr1[i];
			arr1[i] = tmp;
		}
		
		
		if(Arrays.equals(arr1, arr2)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}