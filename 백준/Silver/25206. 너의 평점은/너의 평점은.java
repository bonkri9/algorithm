import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		double res = 0; // 전공 평점 합
		double sum = 0; // 이수 과목 학점의 총합
		String str; // 등급

		for (int i = 0; i < 20; i++) {
			double credit = 0; // 수강 학점
			double grade = 0; // 등급 성적

			st = new StringTokenizer(br.readLine());

			String arrStr[] = new String[3];

			for (int j = 0; j < 3; j++) { //입력 순으로, 과목명, 수강학점, 수강등급
				arrStr[j] = st.nextToken();
			}

			credit += Double.parseDouble(arrStr[1]); //수강학점 저장
			str = arrStr[2]; //등급을 저장

			switch (str) { //등급 성적을 grade에 더하기
			case "A+":
				grade += 4.5;
				break;
			case "A0":
				grade += 4.0;
				break;
			case "B+":
				grade += 3.5;
				break;
			case "B0":
				grade += 3.0;
				break;
			case "C+":
				grade += 2.5;
				break;
			case "C0":
				grade += 2.0;
				break;
			case "D+":
				grade += 1.5;
				break;
			case "D0":
				grade += 1.0;
				break;
			case "F":
				grade += 0;
				break;
			case "P":
				grade += 0;
				credit = 0;
				break;
			}
			sum += credit; //수강 학점 더하기
			res += credit * grade; //수강학점 * 등급성적
		}
		br.close();
		System.out.println(res / sum); //결과 출력
		bw.flush();
		bw.close();
	}
}