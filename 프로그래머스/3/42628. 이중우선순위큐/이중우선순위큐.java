import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        
        // 최솟값 우선순위 minPq , 최댓값 우선순위 maxPq
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        int commandCnt = operations.length; // 명령 횟수
        String[] command = new String[2]; // 명령이 띄어쓰기로 담길 배열
        
        for(int i = 0; i < commandCnt; i++){
            
            command = operations[i].split(" ");
            
            if(command[0].equals("I")){ // 삽입 명령
                
                minPq.offer(Integer.parseInt(command[1]));
                maxPq.offer(Integer.parseInt(command[1]));
                
            }else{ // 제거 명령
                
                if(command[1].equals("1") && !maxPq.isEmpty()){
                    int max = maxPq.poll();
                    minPq.remove(max);
                }else if(command[1].equals("-1") && !minPq.isEmpty()){
                    int min = minPq.poll();
                    maxPq.remove(min);
                }
                
            }

        }
        
        // 최댓값, 최솟값 순으로 담길 answer 배열
        int[] answer = new int[2];
        answer[0] = !maxPq.isEmpty() ? maxPq.poll() : 0;
        answer[1] = !minPq.isEmpty() ? minPq.poll() : 0;

        return answer;
    }
}