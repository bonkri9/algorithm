import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int N = sc.nextInt();

		int cnt = 1;
		for (int i = 0; i < N; i++) {
			int idx = sc.nextInt();
			list.add(list.size() - idx, cnt++);
		}
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}// main
}
