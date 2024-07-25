import java.util.*;
import java.io.*;

class Solution {
    public static String compressor(String str, int unit){
        StringBuilder sb = new StringBuilder();
        Queue<String> q = new LinkedList<>();
        
        for(int i=0;i<str.length();i+=unit){
            int endIdx = Math.min(i+unit, str.length());
            q.offer(str.substring(i, endIdx));
        }
        
        while(!q.isEmpty()){
            int cnt = 1;
            String curr = q.poll();
            
            while(!q.isEmpty() && q.peek().equals(curr)){
                q.poll();
                cnt++;
            }
            
            if(cnt > 1){
                sb.append(cnt).append(curr);
            }else{
                sb.append(curr);
            }
            
        }
        
        return sb.toString();
    }
    
    public int solution(String s) {
        int sLen = s.length();
        int minLen = sLen;
        
        for(int i = 1; i <= sLen/2; i++){
            String compStr = compressor(s, i);
            minLen = Math.min(minLen, compStr.length());
        }
        
        int answer = minLen;
        return answer;
    }
    
}