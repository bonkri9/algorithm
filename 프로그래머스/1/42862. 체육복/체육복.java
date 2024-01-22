import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] all = new int[n+1];
        for(int i=1;i<all.length;i++){
            all[i] = 1;
        }
        
        for(int i=0;i<reserve.length;i++){
            all[reserve[i]] = 2;
        }
        
        for(int i=0;i<lost.length;i++){
            all[lost[i]] -= 1;
        }
        System.out.print(Arrays.toString(all));
        
        for(int i=1;i<all.length;i++){
            if(all[i]==2){
                if((i-1)>0 && all[i-1]==0){
                    all[i-1] = 1;
                    all[i] = 1;
                }else if((i+1)<all.length && all[i+1]==0){
                    all[i+1] = 1;
                    all[i] = 1;
                }
            }
        }
        System.out.print(Arrays.toString(all));
        
        
        for(int i=1;i<all.length;i++){
            if(all[i]>=1) answer++;
        }
        return answer;
    }
}