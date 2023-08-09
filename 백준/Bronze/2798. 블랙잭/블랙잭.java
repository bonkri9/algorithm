import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arrCard = new int[N];
		
		for(int i=0;i<N;i++) {
			arrCard[i] = sc.nextInt();
		}
		
		int[] arrSum = new int[N*(N-1)*(N-2)/6];
		int a=0;
		
		for(int i=0;i<N-2;i++) {
			for(int j=i+1;j<N-1;j++) {
				for(int k=j+1;k<N;k++) {
					
					arrSum[a] = arrCard[i]+arrCard[j]+arrCard[k];
					a++;
				}
			}
		}
		
		int diff = 300001;
		int min = 300001;
		for(int i=0;i<arrSum.length;i++) {
			if(diff>=M-arrSum[i]&&M>=arrSum[i]) {
				diff = M-arrSum[i];
				min = arrSum[i];
			}
		}
		System.out.println(min);

	}

}
