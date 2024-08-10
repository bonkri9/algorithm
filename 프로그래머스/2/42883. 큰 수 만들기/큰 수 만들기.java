import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        // 모든 원소를 stack에 넣어가면서
        // 현재 넣는 원소보다 stack의 맨 위 원소가 작을 경우 stack의 맨 위 원소 제거
        for(char num : number.toCharArray()){

            while (!stack.empty() && stack.peek() < num && k > 0){
                stack.pop();
                k--;
            }

            stack.add(num);
        }
        
        // stack의 원소를 result에 옮기고
        for(int i=0; i<result.length; i++){
            result[i] = stack.get(i);
        }
        
        // String으로 변환 후 반환
        return new String(result);
    }
}