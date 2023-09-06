import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		loop:
		for(int t = 1; t<=T; t++) {
			// 덱 선언
			Deque<Integer> dq = new LinkedList<>();
			
			// 입력 부
			String func = br.readLine();
			int n = Integer.parseInt(br.readLine());
			int Arr[] = new int[n];
			
			// 덱 값 입력
			st = new StringTokenizer(br.readLine(), "[,]");
			for(int i = 0; i<n; i++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			
			int reverse = 0;
			for(int i = 0; i<func.length(); i++) {
				if(func.charAt(i) == 'R') {
					reverse++;
				}
				else {
					if(dq.isEmpty()) {
						sb.append("error").append("\n");
						continue loop;
					}
					// 함수가 D일때 빼주기
					if(reverse%2 ==0) {
						dq.removeFirst();
					}
					else {
						dq.removeLast();
					}
					
				}
			}
			int num = dq.size();
			if(reverse%2 ==0) {
				sb.append("[");
				for(int j = 0; j<num; j++) {
					sb.append(dq.removeFirst());
					if(j == num-1) break;
					sb.append(",");
				}
				sb.append("]");
			}
			else {
				sb.append("[");
				for(int j = 0; j<num; j++) {
					sb.append(dq.removeLast());
					if(j == num-1) break;
					sb.append(",");
				}
				sb.append("]");
			}
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
