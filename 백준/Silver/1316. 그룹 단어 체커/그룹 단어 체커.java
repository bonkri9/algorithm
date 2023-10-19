
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
//문자열 1316 그룹 단어 체커
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); //총 단어의 갯수
		int cnt = 0; //그룹 단어의 갯수
		
		for (int i = 0; i < N; i++) { //단어 갯수만큼 반복문 실행
			String str = br.readLine(); //단어 입력
			String[] arrStr = str.split(""); //단어를 낱말마다 쪼개서 배열에 저장
			boolean[] alphabet = new boolean[26]; //알파벳 갯수만큼의 boolean 배열
			alphabet[str.charAt(0) - 'a'] = true; //가장 첫 낱말은 true로 표시

			if (str.length() == 1) //만약 단어의 낱말 갯수가 1개라면 아래의 반복문 돌지 않게 되지만
				cnt++;             //그룹단어 조건에 만족하므로 단어갯수 +1

			for (int j = 1; j < str.length(); j++) { //단어의 낱말 갯수가 2 이상인 것만 반복문 실행
				int idx = str.charAt(j) - 'a'; //낱말에 해당하는 알파벳 자리를 idx에 저장
				if (!alphabet[idx]) { //만약 해당 알파벳이 아직 방문하지 않아 false라면
					alphabet[idx] = true; //true로 방문 처리
				} else if (arrStr[j].equals(arrStr[j - 1])) { //방문한 것중 직전 낱말과 같은 낱말이라면
					if (j == str.length() - 1) //게다가 그 낱말이 마지막 낱말이라면, 다음 반복문은 돌지 않는다
						cnt++; //갯수 추가
					continue; //직전 낱말과 같은 낱말이면 패스
				} else if (!(arrStr[j].equals(arrStr[j - 1]))) { //방문한 낱말인데, 직전 낱말과 다른 낱말이면
					break; //그룹단어 조건에 만족하지 않으므로 반복문 그만 돌기
				}
				if (j == str.length() - 1) { //마지막 낱말이라면
					cnt++; //반복문 안전하게 모두 돈 것이므로 단어 갯수 추가
				}

			}

		}

		br.close();
		bw.append(String.valueOf(cnt)); //그룹 단어 조건에 만족하는 단어 갯수 출력
		bw.flush();
		bw.close();

	}

}
