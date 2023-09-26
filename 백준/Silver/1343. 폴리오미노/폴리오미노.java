import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		String[] board = new String[str.length()];
		board = str.split("");

		int cnt = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i].equals(".")) {
				cnt = 0;
				continue;
			} else if (board[i].equals("X")) {
				cnt++;
				if (cnt == 4) {
					board[i - 3] = "A";
					board[i - 2] = "A";
					board[i - 1] = "A";
					board[i] = "A";
					cnt = 0;
				} else if (cnt == 2) {
					board[i] = "B";
					board[i - 1] = "B";
				}
			}
		}

		boolean flag = true;
		for (int i = 0; i < board.length; i++) {
			sb.append(board[i]);
			if (board[i].equals("X")) {
				flag = false;
			}
		}

		br.close();
		if (flag) {
			bw.append(sb);
		} else {
			bw.append("-1");
		}
		bw.flush();
		bw.close();
	}
}
