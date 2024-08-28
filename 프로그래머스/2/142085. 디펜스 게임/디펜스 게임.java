import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        // 최대 힙을 구현하기 위해 음수를 저장하는 PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sumEnemy = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);  // 현재 라운드의 적 수를 추가
            sumEnemy += enemy[i]; // 현재 라운드까지의 적 총합
            
            // 병사 수가 현재까지의 적 총합보다 작다면, 
            if (sumEnemy > n) {
                // 무적관이 있으면 가장 큰 적을 무적권으로 방어
                if (k > 0) {
                    sumEnemy -= pq.poll();
                    k--; 
                } else {
                    return i; // 무적권 없으면 현재 라운드 반환
                }
            }
        }
        
        // 모든 라운드를 막을 수 있는 경우
        return enemy.length;
    }
}
