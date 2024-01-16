import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String numStr = String.valueOf(n);
        String[] num = numStr.split("");
        for(int i=0;i<num.length;i++){
            answer += Integer.parseInt(num[i]);
        }

        return answer;
    }
}