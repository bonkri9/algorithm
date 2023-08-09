
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			String N = sc.next();
			String[] nums = N.split("");
			String[] temp = nums.clone();
			int M = nums.length;
			
			if(N.equals("0")) {
				break;
			}
			
			for(int i=0;i<M/2;i++) {
				String tmp = nums[i];
				nums[i] = nums[M-i-1];
				nums[M-i-1] = tmp;
			}
			
			if(Arrays.equals(nums, temp)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
			
			
			
		}
		
	}
}