import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new LinkedList<>();
		for(int i=1; i<N+1;i++) {
			deque.add(i);
		}
		
		int cnt =1;
		sb.append("<");
		while(!deque.isEmpty()) {
			if(cnt%K==0) {
				sb.append(deque.poll());
				if(!deque.isEmpty()) {
					sb.append(", ");
				}
			}else {
				int tmp = deque.poll();
				deque.add(tmp);
			}
			cnt++;
		}
		sb.append(">");
		
		
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();

	}
}