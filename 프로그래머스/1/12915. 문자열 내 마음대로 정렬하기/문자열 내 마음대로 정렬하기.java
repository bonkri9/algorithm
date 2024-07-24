import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        int stringsArrLen = strings.length;
        
        /* 
        마지막에 인덱스 n의 문자가 같은 문자열이 여럿 일 경우
        문자열이 사전순으로 정렬되어야 하므로
        미리 전체를 사전순으로 정렬
        */
        Arrays.sort(strings);
        
        // 알파벳 갯수는 26개 , ArrayList 생성 및 초기화
        ArrayList<String>[] arr = new ArrayList[26];
        for(int i = 0; i < 26; i++){
            arr[i] = new ArrayList<String>();
        }
        
        // 기준이 되는 인덱스 n의 문자를 삽입
        for(int i = 0; i < stringsArrLen; i++){
            int stdNum = strings[i].charAt(n) - 'a';
            arr[stdNum].add(strings[i]);
        }
        
        String[] answer = new String[stringsArrLen];
        int idx = 0;
        
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < arr[i].size(); j++){
                answer[idx++] = arr[i].get(j);
            }
        }
        
        return answer;
    }
}