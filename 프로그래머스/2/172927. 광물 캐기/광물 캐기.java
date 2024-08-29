import java.util.*;

class Solution {
    // 피로도 표
    static int[][] fatigueTable = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        List<int[]> fatigueList = new ArrayList<>();
        
        // 곡괭이의 총 개수 계산
        int pickSum = 0;
        for (int pick : picks) {
            pickSum += pick;
        }

        // 광물 피로도 계산
        for (int i = 0; i < minerals.length; i += 5) {
            if (pickSum == 0) break;
            
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                switch (minerals[j]) {
                    case "diamond": 
                        dia += fatigueTable[0][0]; 
                        iron += fatigueTable[1][0]; 
                        stone += fatigueTable[2][0]; 
                        break;
                    case "iron": 
                        dia += fatigueTable[0][1]; 
                        iron += fatigueTable[1][1]; 
                        stone += fatigueTable[2][1]; 
                        break;
                    case "stone": 
                        dia += fatigueTable[0][2]; 
                        iron += fatigueTable[1][2]; 
                        stone += fatigueTable[2][2]; 
                        break;
                }
            }
            
            fatigueList.add(new int[]{dia, iron, stone});
            pickSum--;
        }
        
        // 피로도를 최소화하기 위해 피로도가 많은 묶음부터 처리
        // 돌 피로도 기준으로 내림차순 정렬
        fatigueList.sort((a, b) -> Integer.compare(b[2], a[2])); 
        
        // 곡괭이의 피로도 소모 계산
        for (int[] fatigue : fatigueList) {
            if (picks[0] > 0) { // 다이아몬드 곡괭이 사용
                answer += fatigue[0];
                picks[0]--;
            } else if (picks[1] > 0) { // 철 곡괭이 사용
                answer += fatigue[1];
                picks[1]--;
            } else if (picks[2] > 0) { // 돌 곡괭이 사용
                answer += fatigue[2];
                picks[2]--;
            } else {
                break; // 사용할 곡괭이가 없으면 종료
            }
        }
        
        return answer;
    }
}
