import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int max = 0;
        for(int i=0;i<tangerine.length;i++){
            if(max < tangerine[i]) max = tangerine[i];
        }
        int[] numOfSize = new int[max+1];
        
        for(int i=0;i<tangerine.length;i++){
            numOfSize[tangerine[i]]++;
        }
        
        Arrays.sort(numOfSize);
        
        int num =0;
        for(int i=numOfSize.length-1;i>=1;i--){
            num += numOfSize[i];
            answer++;
            if(num >= k) break;
        }
        
        return answer;
    }
}