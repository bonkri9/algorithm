import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] button = new int[N];
		for (int i = 0; i < N; i++) {
			button[i] = sc.nextInt();
		}

		int stu = sc.nextInt();
		for (int i = 0; i < stu; i++) {
			int gender = sc.nextInt();
			int rule = sc.nextInt();
			if (gender == 1) {
				for (int j = 0; j < button.length; j++) {
					if ((j + 1) % rule == 0) {
						if (button[j] == 1) {
							button[j] = 0;
						} else if (button[j] == 0) {
							button[j] = 1;
						}
					}
				}
			} else if (gender == 2) {
				if (button[rule - 1] == 1) {
					button[rule - 1] = 0;
				} else if (button[rule - 1] == 0) {
					button[rule - 1] = 1;
				}
				for (int j = 1; j <= button.length / 2; j++) {
					if (rule - 1 - j < 0 || rule - 1 + j >= button.length) {
						break;
					}
					if (button[rule - 1 - j] == button[rule - 1 + j]) {
						if (button[rule - 1 - j] == 0) {
							button[rule - 1 - j] = 1;
						} else if (button[rule - 1 - j] == 1) {
							button[rule - 1 - j] = 0;
						}
						if (button[rule - 1 + j] == 0) {
							button[rule - 1 + j] = 1;
						} else if (button[rule - 1 + j] == 1) {
							button[rule - 1 + j] = 0;
						}
					} else {
						break;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if(i!=N-1) {
				System.out.print(button[i] + " ");
			}else if(i==N-1) {
				System.out.print(button[i]);
			}
			if((i+1)%20 ==0) {
				System.out.println();
			}
		}
		
	}
}