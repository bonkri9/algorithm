import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = sc.next();
		}
		
		long[] nums = new long[2];
		nums[0] = Long.parseLong(arr[0]+arr[1]);
		nums[1] = Long.parseLong(arr[2]+arr[3]);
		
		System.out.println(nums[0]+nums[1]);
		sc.close();
	}

}