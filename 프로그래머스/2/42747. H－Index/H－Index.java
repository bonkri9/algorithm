import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 오름차순 정렬
        Arrays.sort(citations);
        int arrLen = citations.length;
        
        // 논문 인용수 배열 길이만큼 반복
        for(int i = 0; i < arrLen; i++){
            // 현재 인용수보다 큰 인용수를 가진 논문 수
            int h = arrLen - i;
            
            // 현재 인용수가 크면 H-Index 반환
            if(citations[i] >= h){
                return h;
            }
        }
        
        // 모두 순회했는데 반환되지 않았다면
        // H-Index가 0
        return 0;
    }
}