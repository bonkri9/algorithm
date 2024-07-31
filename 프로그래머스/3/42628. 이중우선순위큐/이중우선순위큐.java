import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        int commandCnt = operations.length;
        String[] command = new String[2];
        for(int i=0;i<commandCnt;i++){
            command = operations[i].split(" ");
            if(command[0].equals("I")){
                minPq.offer(Integer.parseInt(command[1]));
                maxPq.offer(Integer.parseInt(command[1]));
            }else{
                if(command[1].equals("1") && !maxPq.isEmpty()){
                    int max = maxPq.poll();
                    minPq.remove(max);
                }else if(command[1].equals("-1") && !minPq.isEmpty()){
                    int min = minPq.poll();
                    maxPq.remove(min);
                }
            }

        }

        int[] answer = new int[2];
        answer[0] = !maxPq.isEmpty() ? maxPq.poll() : 0;
        answer[1] = !minPq.isEmpty() ? minPq.poll() : 0;


        return answer;
    }
}