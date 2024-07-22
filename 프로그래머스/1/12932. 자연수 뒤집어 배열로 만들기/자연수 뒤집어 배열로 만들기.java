import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        
        String[] arr = new String[str.length()];
        
        arr = str.split("");
        
        int[] answer = new int[arr.length];
        for(int i=arr.length - 1;i>=0;i--){
            answer[arr.length - i - 1] = Integer.parseInt(arr[i]);
        }
        return answer;
    }
}