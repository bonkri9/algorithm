import java.util.*;
class Solution {
    public long solution(long n) {
        String answer = "";
        String nStr = String.valueOf(n);
        String[] arrStr = nStr.split("");
        long[] arrNum = new long[arrStr.length];
        Arrays.sort(arrStr);
        for(int i=0;i<arrStr.length;i++){
            arrNum[i] = Long.parseLong(arrStr[i]);
        }
        Arrays.sort(arrNum);
        for(int i=0;i<arrStr.length;i++){
            answer += arrNum[i];
        }
        return Long.parseLong(answer);
    }
}