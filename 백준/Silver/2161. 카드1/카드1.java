import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		
		int i =0;
		while(!queue.isEmpty()) {
			if(i%2==0) {
				sb.append(queue.peek()+" ");
				queue.remove();
			}else if(i%2==1) {
				int card = queue.peek();
				queue.remove();
				queue.add(card);
			}
			i++;
		}
		System.out.println(sb);
	}
}