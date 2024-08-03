import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] ars) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int start = 0;
            int end = n - 1;

            int target = Integer.parseInt(st.nextToken());

            while(start <= end){
                int mid = (start + end) / 2;
                if(cards[mid] == target){
                    sb.append(1 + " ");
                    break;
                }

                if(cards[mid] > target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }

                if(start > end){
                    sb.append(0 + " ");
                    break;
                }
            }
        }

        System.out.print(sb.toString());
    }
}