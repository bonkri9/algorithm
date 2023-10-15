import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); //숫자의 갯수
		int[] arrA = new int[N]; //A 배열
		Integer[] arrB = new Integer[N]; //B 배열

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken()); //A배열 입력
		}
		Arrays.sort(arrA); //A 배열 오름차순 정렬
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { //B배열 입력
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrB, Collections.reverseOrder()); //B배열 내림차순 정렬
		
		int ans = 0; //정답 초기화
		for(int i=0;i<N;i++) {
			ans += arrA[i] * arrB[i]; //대응되는 배열값을 곱해서 누적합
		}

		br.close();
		bw.write(String.valueOf(ans)); //최솟값 출력
		bw.flush();
		bw.close();

	}

}