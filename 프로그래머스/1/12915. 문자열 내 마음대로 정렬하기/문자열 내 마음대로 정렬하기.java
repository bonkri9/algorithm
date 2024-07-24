import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        int stringsArrLen = strings.length;
        
        Arrays.sort(strings);
        
        ArrayList<String>[] arr = new ArrayList[26];
        
        for(int i=0;i<26;i++){
            arr[i] = new ArrayList<String>();
        }
        
        for(int i=0;i<stringsArrLen;i++){
            int stdNum = strings[i].charAt(n) - 'a';
            arr[stdNum].add(strings[i]);
        }
        
        
        String[] answer = new String[stringsArrLen];
        int idx =0;
        
        for(int i=0;i<26;i++){
            for(int j=0;j<arr[i].size();j++){
                answer[idx++] = arr[i].get(j);
            }
        }
        return answer;
    }
}