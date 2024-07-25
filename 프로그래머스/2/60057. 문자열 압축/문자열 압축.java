import java.util.*;
import java.io.*;

class Solution {
    public static String compressor(String str, int unit){
        StringBuilder sb = new StringBuilder();
        
        // 잘려진 문자가 먼저 나가는게 FIFO 인 Queue가 적합하다고 판단 
        Queue<String> q = new LinkedList<>();
        
        // 자르는 단위를 토대로 substring의 끝 인덱스를 지정
        // 자른 뒤 Queue에 넣기 
        for(int i = 0; i < str.length(); i += unit){
            int endIdx = Math.min(i + unit, str.length());
            q.offer(str.substring(i, endIdx));
        }
        
        while(!q.isEmpty()){
            int cnt = 1;
            String curr = q.poll();
            
            // 잘려진 현재 문자열과 같다면 cnt 1 증가 및 queue에서 버리기 
            while(!q.isEmpty() && q.peek().equals(curr)){
                q.poll();
                cnt++;
            }
            
            // 한번만 나타난 경우는 1을 생략하고 문자열 붙이기 
            if(cnt > 1){
                sb.append(cnt).append(curr);
            }else{
                sb.append(curr);
            }
            
        }
        
        return sb.toString();
    }
    
    public int solution(String s) {
        // 주어진 문자열의 길이 저장 및 최소 길이 초기화
        int sLen = s.length();
        int minLen = sLen;
        
        // 자르는 단위 i는 1글자부터 최대 (문자열 길이) / 2 이어야 유의미
        for(int i = 1; i <= sLen / 2; i++){
            String compStr = compressor(s, i);
            minLen = Math.min(minLen, compStr.length());
        }
        
        int answer = minLen;
        return answer;
    }
    
}