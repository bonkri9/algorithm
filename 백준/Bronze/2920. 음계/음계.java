import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] piano = new int[8];
		for (int i = 0; i < 8; i++) {
			piano[i] = sc.nextInt();
		}

		int updown = 0;
		for (int i = 0; i < 8; i++) {
			if (i + 1 == piano[i]) {
				updown++;
			} else if (8 - i == piano[i]) {
				updown --;
			} else {
				break;
			}
		}

		if (updown == -8) {
			System.out.println("descending");
		} else if (updown == 8) {
			System.out.println("ascending");
		} else {
			System.out.println("mixed");
		}
	}
}
