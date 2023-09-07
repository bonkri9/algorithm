import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] NArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			NArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> s = new Stack<>();
		Stack<Integer> ans = new Stack<>();
		loop:
		for(int i = 1; i<=N; i++) {
			int tmp = NArr[N-i];
			// 뒤에서 첫번째 값 조회했을때 조건
			if(s.isEmpty()) {
				ans.push(-1);
				s.push(tmp);
				continue;
			}
			
			while(s.peek() <= tmp) { 
				// 스택이 비어있거나
				// 스택 안에 있는 값보다 조회하고 있는 값이 더 크거나 같다면
				s.pop();
				if(s.isEmpty()) {
					ans.push(-1);
					s.push(tmp);
					
					continue loop;
				}
			}
			
			ans.push(s.peek());
			s.push(tmp);
		}
		
		for(int i = 0; i<N; i++) {
			sb.append(ans.pop());
			if(i == N-1) break;
			sb.append(" ");
		}
		
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
