import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 문자열 기준으로 정렬
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++){
            String curr = phone_book[i];
            String next = phone_book[i + 1];
            
            // 뒷 문자열이 앞 문자열로 시작한다면 
            if(next.startsWith(curr)){
                answer = false;
            }            
        }
        
        return answer;
    }
}