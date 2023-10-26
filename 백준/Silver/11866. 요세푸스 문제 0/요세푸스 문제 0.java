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
		int N = Integer.parseInt(st.nextToken()); //총 숫자
		int K = Integer.parseInt(st.nextToken()); //해당 번째 숫자를 출력

		Deque<Integer> deque = new LinkedList<>(); //deque 생성
		for (int i = 1; i < N + 1; i++) { //1부터 N까지 삽입
			deque.add(i);
		}

		int cnt = 1;
		sb.append("<");
		while (!deque.isEmpty()) { //deque가 빌 때까지 반복 실행
			if (cnt % K == 0) { //만약 cnt가 K번째면 
				sb.append(deque.poll()); //뱉어내서 sb에 저장
				if (!deque.isEmpty()) { //앞으로 뱉어낼 숫자가 더 있다면
					sb.append(", "); //쉼표 넣기
				}
			} else { //K번째 숫자가 아니라면
				int tmp = deque.poll();
				deque.add(tmp); //그 숫자를 뒤로 보내기
			}
			cnt++; //cnt번째 1 증가
		}
		sb.append(">");

		br.close();
		bw.append(sb); //출력
		bw.flush();
		bw.close();

	}
}