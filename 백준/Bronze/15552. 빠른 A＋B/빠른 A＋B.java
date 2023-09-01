import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException { // IOException 예외처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br 만드는법
		
		int T = Integer.parseInt(br.readLine()); // int형 입력시 선언과 동시에 형변환 가능
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // bw 만드는법
		
		for (int i=0; i<T; i++) {
			String str = br.readLine(); // str로 한줄을 다 읽어주고
			StringTokenizer st = new StringTokenizer(str); // st로 잘라준다.
			int A = Integer.parseInt(st.nextToken()); // 잘라준 토큰을 하나씩 받아서
			int B = Integer.parseInt(st.nextToken());
			int sum = A+B; // 더해주면
			
			bw.write(sum+"\n"); // bw.write으로 출력 가능, 개행은 "\n"로
		}
		bw.flush(); // 남은 데이터 모두 출력
		bw.close(); // 스트림 닫음
	}
}