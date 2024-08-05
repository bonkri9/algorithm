import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] ars) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int key = Integer.parseInt(st.nextToken());
            
            // hashMap의 key에 해당하는 value를 다음 값으로 넣어라
            // key와 맵핑된 value 값을 반환하고 없으면 기본값 0을 반환
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int target = Integer.parseInt(st.nextToken());
            
            // target에 맵핑된 value 값을 반환하고, 없으면 0 반환 
            sb.append(hashMap.getOrDefault(target, 0)).append(" ");
        }

        System.out.print(sb.toString());
    }
}