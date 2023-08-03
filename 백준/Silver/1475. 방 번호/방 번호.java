
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		String[] arr = N.split("");
		
		int[] cnt = new int[10];
		
		for(int i=0;i<arr.length;i++) {
			int k = Integer.parseInt(arr[i]);
			
			cnt[k]++;
		}
		
		int m=0;
		if((cnt[6]+cnt[9])%2==1) {
			m=(cnt[6]+cnt[9])/2+1;
		}else if((cnt[6]+cnt[9])%2==0) {
			m=(cnt[6]+cnt[9])/2;
		}
		cnt[6]=m;
		cnt[9]=m;
		
		Arrays.sort(cnt);
		System.out.println(cnt[9]);
	}

}