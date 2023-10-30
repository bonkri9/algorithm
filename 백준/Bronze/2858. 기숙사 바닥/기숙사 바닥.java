import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken()); //빨간색 타일
		int B = Integer.parseInt(st.nextToken()); //갈색 타일
		
		int L = 0; //방의 가로
		int W = 0; //방의 세로, 항상 가로 >= 세로
		
		for (int i = 1; i < R; i++) { //항상 빨간색 타일이 많아야한다. 
			for (int j = 1; j < R; j++) { //그래서 R만큼 둘다 반복문 실행
				if (R == i * 2 + (j - 2) * 2 && B == (i - 2) * (j - 2)) { 
					//빨간색 타일의 갯수와 갈색 타일의 갯수를 이차방정식을 통해 정리해서 조건식을 구성
					if(i>=j) { //가로가 항상 크므로
						L = i; //큰 값이 가로
						W = j; //작은 값이 세로
					}
				}
			}
		}
		sb.append(L + " " + W); // 출력 형식에 맞춰 저장

		br.close();
		bw.append(sb); //출력
		bw.flush();
		bw.close();
	}
}