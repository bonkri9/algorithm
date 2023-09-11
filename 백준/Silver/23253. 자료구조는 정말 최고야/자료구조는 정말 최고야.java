import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean flag = true;
		
		out : for(int i=0;i<M;i++) {
			int K = sc.nextInt();
			int J = sc.nextInt();
			for(int j=0;j<K-1;j++) {
				int T = sc.nextInt();
				if(J<T) {
					flag = false;
					break out;
				}else {
					J=T;
				}
			}
			
		}
		if(flag) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}