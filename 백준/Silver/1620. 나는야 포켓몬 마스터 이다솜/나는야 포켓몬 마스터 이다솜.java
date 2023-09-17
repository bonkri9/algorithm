import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Map<String, String> map = new HashMap<>();
		
		for(int i=0; i<N;i++) {
			String pkMon = sc.next();
			String num = Integer.toString(i+1);
			map.put(pkMon, num);
			map.put(num, pkMon);
		}
		
		for(int i=0;i<M;i++) {
			sb.append(map.get(sc.next())).append("\n");
		}
		
		System.out.println(sb);
	}
}