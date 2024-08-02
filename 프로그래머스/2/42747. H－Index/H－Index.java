import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < citations.length; i++) {
            int count = 0;
            for (int citation : citations) {
                if (citation >= i + 1) {
                    count++;
                }
            }
            if (count >= i + 1) {
                list.add(i + 1);
            }
        }
        
        if (!list.isEmpty()) {
            answer = list.get(list.size() - 1);
        }
        
        return answer;
    }
}