import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Arrays.sort(scoville);
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            foods.offer(scoville[i]);
        }

        int cnt = 0;
        int newScoville = -1;

        while (foods.peek() < K) {
            newScoville = foods.poll() + (foods.poll() * 2);
            cnt++;
            foods.offer(newScoville);

            if(foods.size() < 2) break;
        }



        int answer = (foods.peek() >= K) ? cnt : -1;
        return answer;
    }
}