import java.util.*;
import java.io.*;

public class Main {
    public static int k;
    public static String[] signs;
    public static boolean[] used = new boolean[10];
    public static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        signs = new String[k];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            signs[i] = st.nextToken();
        } // 입력 끝

        dfs("", 0);
        
        // 결과 배열 정렬 후 최댓값과 최솟값 출력 
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1) + "\n" + result.get(0));

    }// main

    public static void dfs(String num, int depth) {
        if(depth == k + 1){
            result.add(num);
            return;
        }

        for(int i = 0; i < 10; i++){
            // 아직 사용하지 않은 숫자라면, 
            if(!used[i]){
                // 첫 비교이거나, 비교가 올바르다면, 
                if(depth == 0 || compareNums(num.charAt(depth - 1) - '0', i, signs[depth - 1])){
                    used[i] = true; // 방문처리
                    dfs(num + i, depth + 1);
                    used[i] = false; // 방문취소
                }
            }
        }

    }
    
    // 숫자 비교 
    public static boolean compareNums(int a, int b, String sign){
        if(sign.equals("<")){
            return a < b;
        } else {
            return a > b;
        }
    }
}