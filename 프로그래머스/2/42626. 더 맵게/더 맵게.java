import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        // Heap 자료구조를 이용한 우선순위 큐 생성
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            foods.offer(scoville[i]);
        }
        
        int cnt = 0; // 섞는 횟수
        int newScoville = -1; // 섞은 후 스코빌 지수 
        
        // 가장 스코빌 지수가 낮은 음식이 K 보다 크거나 같으면
        // 모든 음식의 스코빌 지수는 K 보다 크거나 같다
        while (foods.peek() < K) {
            newScoville = foods.poll() + (foods.poll() * 2);
            cnt++;
            foods.offer(newScoville);
            
            // 모두 섞어서 남은 음식이 1개라면 멈춘다
            if(foods.size() < 2) break;
        }

        // 가장 스코빌 지수가 낮은 음식이 K 보다 크거나 같으면 cnt 반환
        int answer = (foods.peek() >= K) ? cnt : -1;
        
        return answer;
    }
}