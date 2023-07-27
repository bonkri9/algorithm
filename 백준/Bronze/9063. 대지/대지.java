import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int maxX = -10001;
		int minX = 10001;
		int maxY = -10001;
		int minY = 10001;

		if (N > 1) {
			for (int i = 0; i < N; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();

				if (maxX < A) {
					maxX = A;
				} 
				if (minX > A) {
					minX = A;
				}
				if (maxY < B) {
					maxY = B;
				} 
				if (minY > B) {
					minY = B;
				}
			}
			System.out.println((maxX - minX) * (maxY - minY));
		} else {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println(0);
		}

	}

}