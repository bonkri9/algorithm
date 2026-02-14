import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long V = Long.parseLong(st.nextToken());

        long days = (V - A) / (A - B);
        if ((V - A) % (A - B) != 0) days++;

        System.out.println(days + 1);
    }
}
