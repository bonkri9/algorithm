import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> tmp = new ArrayList<>();
        
        Queue<Integer> qDuration = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            int duration = (100 - progresses[i]) / speeds[i];
            int rest = (100 - progresses[i]) % speeds[i];

            if(rest != 0){
                qDuration.add(duration + 1);
            }else{
                qDuration.add(duration);
            }
        }

        int serviceCnt = 1;
        int curr = qDuration.poll();

        while(!qDuration.isEmpty()){
            if(curr >= qDuration.peek()){
                serviceCnt++;
                qDuration.poll();
            }else{
                tmp.add(serviceCnt);
                serviceCnt = 1;
                curr = qDuration.poll();
            }
            
            
            
        }
        tmp.add(serviceCnt);

        int[] answer = new int[tmp.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = tmp.get(i);
        }

        return answer;
    }
}