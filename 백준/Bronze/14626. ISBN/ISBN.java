import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();

        int starIdx = -1;
        int knowSum = 0;
        for (int i = 0; i < 12; i++) {
            char c = isbn.charAt(i);
            if (c == '*'){
                starIdx = i;
                continue;
            }

            int digit = c - '0';
            int weight = (i % 2 == 0) ? 1 : 3;
            knowSum += weight * digit;
        }

        int checkDigit = isbn.charAt(12) - '0';
        int starWeight = (starIdx % 2 == 0) ? 1 : 3;

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            if ((knowSum + starWeight * i + checkDigit) % 10 == 0) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);

    }
}
