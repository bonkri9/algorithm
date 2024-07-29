import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 최종 답안을 잠시 넣을 tmp 
        ArrayList<Integer> tmp = new ArrayList<>();
        
        // 기능마다의 작업 수행 기간을 담을 queue
        Queue<Integer> qDuration = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            int duration = (100 - progresses[i]) / speeds[i];
            int rest = (100 - progresses[i]) % speeds[i];
            
            // 나누어떨어지지 않으면 1일 추가 
            if(rest != 0){
                qDuration.add(duration + 1);
            }else{
                qDuration.add(duration);
            }
        }
        
        // 배포마다의 기능 갯수
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
        tmp.add(serviceCnt); // 마지막 서비스 갯수 추가 

        int[] answer = new int[tmp.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = tmp.get(i);
        }

        return answer;
    }
}