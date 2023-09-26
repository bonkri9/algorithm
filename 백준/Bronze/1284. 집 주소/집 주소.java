import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();

			if (!str.equals("0")) {
				int sum = 0;

				String[] nums = new String[str.length()];
				nums = str.split("");

				sum += nums.length + 1;

				for (int i = 0; i < nums.length; i++) {
					String N = nums[i];

					if (N.equals("1")) {
						sum += 2;
					} else if (N.equals("0")) {
						sum += 4;
					} else {
						sum += 3;
					}
				}
				System.out.println(sum);

			} else {
				break;
			}
		}
		br.close();
	}
}
