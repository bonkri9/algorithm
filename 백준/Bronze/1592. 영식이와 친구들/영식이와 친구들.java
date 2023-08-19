import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		int[] nums = new int[N];

		int cycle = 0;
		int cnt = 0;
		int i = 0;
		while (nums[i] <= M) {
			if (nums[i] % 2 == 1) {

				if (i+L < N) {
					i += L;
					nums[i]++;
				}else if(i+L>=N) {
					i = i+L-N;
					nums[i]++;
				}
			} else if (nums[i]%2==0) {
				if (i-L >=0) {
					i -= L;
					nums[i]++;
				}else if(i-L<0) {
					i = N+(i-L);
					nums[i]++;
				}
			}
			if(nums[i]==M) {
				break;
			}
			cycle++;
		}

		System.out.println(cycle);

	}
}
