import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();

        int starIdx = -1;
        for(int i = 0; i < 12; i++){
            char c = isbn.charAt(i);
            if(c=='*') starIdx = i;
        }

        int m = isbn.charAt(12) - '0';

        int knowSum = 0;
        for(int i = 0; i < 12; i++){
            if(i == starIdx) continue;
            if(i % 2 == 0) knowSum += isbn.charAt(i) - '0';
            else knowSum += 3 * (isbn.charAt(i) - '0');
        }

        int w = (starIdx % 2 == 0) ? 1 : 3;
        int ans = 0;
        for(int i = 0; i < 10; i++){
            if((knowSum + w * i + m) % 10 == 0){
                ans = i;
                break;
            }
        }

        System.out.println(ans);

    }
}
