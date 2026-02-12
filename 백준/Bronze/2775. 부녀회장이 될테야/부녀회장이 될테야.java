
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[15][15];
		for (int i = 1; i <= 14; i++) arr[0][i] = i;
		
		for (int i = 1; i <= 14; i++) {
			for(int j = 1; j <= 14; j++) {
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int num = arr[k][n];
			
			sb.append(num).append("\n");
		}
		
		System.out.println(sb);
	}

}
