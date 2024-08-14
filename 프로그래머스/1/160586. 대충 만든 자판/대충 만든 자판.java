import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<keymap.length;i++){
            String[] str = keymap[i].split("");
            for(int j=0;j<str.length;j++){
                map.put(str[j], map.containsKey(str[j]) ? Math.min(map.get(str[j]), j+1) : j+1);
            }
        }

        int targetsLen = targets.length;
        int[] answer = new int[targetsLen];
        for(int i=0;i<targetsLen;i++){
            int cnt =0;
            String[] target = targets[i].split("");
            for(int j=0;j<target.length;j++){
                if(!map.containsKey(target[j])){
                    answer[i] = -1;
                    break;
                }

                cnt += map.get(target[j]);
                if(j==target.length - 1) answer[i] = cnt;
            }

        }
        return answer;
    }
}