import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[5];
		for(int i=0;i<nums.length;i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		int sum=0;
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
		}
		System.out.println(sum/nums.length);
		System.out.println(nums[2]);
	}
}