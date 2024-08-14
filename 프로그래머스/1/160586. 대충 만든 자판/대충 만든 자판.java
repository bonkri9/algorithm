import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < keymap.length; i++){
            String[] str = keymap[i].split("");
            
            for(int j = 0; j < str.length; j++){
                
                // 해당 알파벳과 누른 횟수를 저장
                // 만약 해당 알파벳이 이미 저장되어 있다면
                // 저장된 값과 현재 누른 횟수 중 최솟값을 저장
                // 새로운 알파벳이라면 누른 횟수 그대로 저장
                
                map.put(str[j], map.containsKey(str[j]) ? Math.min(map.get(str[j]), j + 1) : j + 1);
            }
        }

        int targetsLen = targets.length;
        int[] answer = new int[targetsLen];
        
        for(int i = 0; i < targetsLen; i++){
            int cnt = 0; // 총 누른 횟수의 최솟값
            String[] target = targets[i].split("");
            
            for(int j = 0; j < target.length; j++){
                // map 안에 알파벳이 저장되어 있지 않으면
                // 바로 -1 넣고 반복문 탈출
                if(!map.containsKey(target[j])){
                    answer[i] = -1;
                    break;
                }
                
                // 누른 횟수들을 cnt에 저장하고
                // target 끝까지 가면 answer에 총 횟수 저장
                cnt += map.get(target[j]);
                if(j == target.length - 1) answer[i] = cnt;
            }
        }
        
        return answer;
    }
}