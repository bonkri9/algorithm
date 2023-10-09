import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 지폐의 금액 T
		int K = Integer.parseInt(br.readLine()); // 동전의 가짓수 K
		
		int[][] money = new int[K][2]; // 동전을 담을 2차원 배열 money 생성 
		
		for(int i=0;i<K;i++) { //K번 반복문 실행
			st = new StringTokenizer(br.readLine());
			money[i][0] = Integer.parseInt(st.nextToken()); //[i][0]에는 동전의 금액
			money[i][1] = Integer.parseInt(st.nextToken()); //[i][1]에는 동전의 갯수 저장
		} //입력 끝
		
		int[] dp = new int[T+1]; //1차원 배열 dp를 지폐 금액수 T까지 만들어야하므로 T+1 만큼 생성
		dp[0] = 1; //첫 요소 dp[0]는 1가지 가능하다고 값 입력, T>0조건이 있어서 어차피 T=0이다. 
		
		for(int i=0;i<K;i++) { //동전의 가짓수만큼 반복문 실행
			int coinSet = money[i][0]; //해당 동전의 기준을 coinSet에 저장
			for(int j=T;j>=coinSet;j--) {  //지폐 금액부터 동전 기준까지 감소시키며 반복문 실행
				for(int p=1;p<=money[i][1];p++) { //각 동전은 동전갯수만큼 반복문 실행 
					if(j-coinSet*p<0) { //만약 지폐금액보다 동전기준*동전갯수가 더 큰 금액이면 
						break; //음수가 되어 말이 안되니까 반복문 멈추기
					}
					dp[j] += dp[j-coinSet*p]; //그게 아니라면 해당 경우의 수 누적합
				}
//				System.out.println(Arrays.toString(dp));
			}
		}
		
		br.close();
		bw.append(String.valueOf(dp[T])); //지폐금액에 해당하는 경우의 수 출력
		bw.flush();
		bw.close();
		
	}
}