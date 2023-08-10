import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] chess = new int[8][8];
		
		for(int i=0;i<8;i++) {
			String str = sc.next();
			for(int j=0;j<8;j++) {
				chess[i][j] = str.charAt(j);
			}
		}
		
		int cnt=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(chess[i][j]==70&&i%2==0&&j%2==0) {
					cnt++;
				}
				if(chess[i][j]==70&&i%2==1&&j%2==1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}

}