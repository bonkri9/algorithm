import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N != 0) {
			String str = sc.next();
			String[] nums = str.split(",");
			
			System.out.println(Integer.parseInt(nums[0])+Integer.parseInt(nums[1]));
			N--;
		}
	}
}