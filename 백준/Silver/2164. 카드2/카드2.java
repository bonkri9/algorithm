import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> card = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			card.add(i);
		}
		
		boolean flag = true;
		while(card.size()>1) {
			if(flag) {
				card.remove();
				flag = false;
			}else {
				card.add(card.peek());
				card.remove();
				flag = true;
			}
		}
		System.out.println(card.peek());
	}// main
}
