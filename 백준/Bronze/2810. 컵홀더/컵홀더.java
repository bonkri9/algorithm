import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] seat = sc.next().split("");

		int cntC = 0;
		int cntL = 0;

		for (int i = 0; i < seat.length; i++) {
			if (seat[i].equals("S")) {
				cntC++;
			}
			if (seat[i].equals("L")) {
				cntL++;
			}
		}
		if (cntL == 0) {
			System.out.println(cntC);
		} else {
			System.out.println(cntC + (cntL / 2) + 1);
		}
	}

}